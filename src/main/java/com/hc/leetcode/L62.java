package com.hc.leetcode;

public class L62 {
    /**
     * p(m,n) = p(m-1,n) + p(m,n-1)
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths(int m, int n) {
        if(m == 1){
            return 1;
        }

        if(n == 1){
            return 1;
        }

        return uniquePaths(m-1,n) + uniquePaths(m,n-1);

    }

    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Unique Paths.
     * Memory Usage: 34.4 MB, less than 100.00% of Java online submissions for Unique Paths.
     * 下次优化内存使用
     * @param m
     * @param n
     * @return
     */
    public int uniquePathsV2(int m, int n){
        int[][] memo = new int[m][n];

        for(int i = 1; i <= m ; i ++){
            for(int l =1; l <= n; l ++){
                if(i < 2 || l < 2){
                    memo[i-1][l-1] = 1;
                    continue;
                }
                memo[i-1][l-1] = memo[i-1][l-2] + memo[i-2][l-1];
            }
        }
        return memo[m-1][n-1];
    }
}
