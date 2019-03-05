package com.hc.leetcode;

public class L64 {
    /**
     * f(r,c) = min(f(r,c-1) + s[r][c],f(r-1,c) + s[r][c])
     *
     * Runtime: 4 ms, faster than 97.51% of Java online submissions for Minimum Path Sum.
     * Memory Usage: 47 MB, less than 5.27% of Java online submissions for Minimum Path Sum.
     * @param grid
     * @return
     */
    public int minPathSum(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int[][] memo = new int[row][col];
        memo[0][0] = grid[0][0];


        for(int r = 0; r < row; r++){

            for(int c = 0; c < col; c++){
                if(r == 0 && c == 0){
                    continue;
                }
                if(r == 0){
                    memo[r][c] = memo[r][c-1] + grid[r][c];
                    continue;
                }
                if(c == 0){
                    memo[r][c] = memo[r-1][c] + grid[r][c];
                    continue;
                }

                memo[r][c] = Math.min(memo[r-1][c] + grid[r][c], memo[r][c-1] + grid[r][c]);
            }
        }
        return memo[row-1][col-1];
    }

    public static void main(String[] args){
        int[][] test = new int[][]{{1,3,1},{1,5,1},{4,2,1}};
        new L64().minPathSum(test);
    }
}
