package com.hc.leetcode;

public class L96 {
    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Unique Binary Search Trees.
     * Memory Usage: 34.5 MB, less than 20.20% of Java online submissions for Unique Binary Search Trees.
     * @param n
     * @return
     */
    public int numTrees(int n) {
        int[] memo = new int[n + 1];
        memo[0] = 1;
        memo[1] = 1;
        for(int i = 2; i <= n; i ++){
            int num = 0;
            for(int m = 0; m <i; m++){
                num = num + memo[m] * memo[i - m - 1];
            }
            memo[i] = num;
        }
        return memo[n];
    }
}
