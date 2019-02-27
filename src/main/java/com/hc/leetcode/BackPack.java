package com.hc.leetcode;

public class BackPack {
    /**
     * 有多个物品，物品存在两个维度（重量和价值），在一个维度有约束的情况下（重量），求一个组合，使得第二个维度有极限值。
     * 状态转移所抽取的维度为物品个数和约束条件。
     * 先写状态转移方程，状态是两个维度所确定的。
     * 然后根据条件转移方程求出基础状态，比如背包问题的基础状态为某一个值和极限值。
     *
     * 设f[i][v] 为有i个物品，约束条件为v的情况下，第二个维度的极限值。
     * f[i][v] = max(f[i-1][v],f[i-1]f[v-w[i]] + v[i])
     */
    public int backpack01(int[] w, int[] v, int C){
        int size = w.length;
        if (size == 0) {
            return 0;
        }
        //size个物品，C个重量。
        int[][] dp = new int[size][C];
        //初始化第一行
        //仅考虑容量为C的背包放第0个物品的情况
        //将第一个物品放入所有重量小于等于C的背包
        for (int i = 0; i <= C; i++) {
            dp[0][i] = w[0] <= i ? v[0] : 0;
        }

        //填充其他行和列
        for (int i = 1; i < size; i++) {
            for (int j = 0; j < C; j++) {
                if (w[i] <= j) {
                    dp[i][j] = Math.max(dp[i - 1][j], v[i] + dp[i - 1][j - w[i]]);
                }
            }
        }

        return dp[size - 1][C-1];
    }
}
