package com.hc.leetcode;

/**
 * Runtime: 1 ms, faster than 20.01% of Java online submissions for Unique Paths II.
 * Memory Usage: 40.2 MB, less than 5.18% of Java online submissions for Unique Paths II.
 * TODO:优化
 */
public class L63 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid.length == 1 && obstacleGrid[0].length == 1 && obstacleGrid[0][0] == 1){
            return 0;
        }
        int[][] memo = new int[obstacleGrid.length][obstacleGrid[0].length];
        memo[0][0] = 1;
        for(int i = 0; i < obstacleGrid.length; i++){
            for(int m = 0; m < obstacleGrid[0].length; m++){
                if(i == 0 && m == 0){
                    continue;
                }
                int left = 0;//当m==0或者grid 阻碍
                if(m != 0 && obstacleGrid[i][m-1] != 1){
                    left = memo[i][m-1];
                }

                int up = 0; //当i==0或者grid 阻碍
                if(i != 0 && obstacleGrid[i-1][m] != 1){
                    up = memo[i-1][m];
                }

                memo[i][m] = left + up;
            }
        }
        return obstacleGrid[obstacleGrid.length][obstacleGrid[0].length] == 1 ?
                0 :memo[obstacleGrid.length-1][obstacleGrid[0].length-1];
    }

    public static void main(String[] args){
        int[][] test = new int[][]{{0,0,0},{0,1,0},{0,0,0}};
        new L63().uniquePathsWithObstacles(test);
    }
}
