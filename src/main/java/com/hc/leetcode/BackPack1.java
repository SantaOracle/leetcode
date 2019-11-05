package com.hc.leetcode;

/**
 * 2版本
 * @author han.congcong
 * @date 2019/11/5
 */

public class BackPack1 {
    /**
     * 我们有n种物品，物品j的重量为wj，价格为pj。
     * 我们假定所有物品的重量和价格都是非负的。背包所能承受的最大重量为W。
     * 如果限定每种物品只能选择0个或1个.
     * 求背包能够存放物品的最大值
     * 设i为有多少个物品，w为最大值，ws(i)为第i个物品的重量
     * 状态转移方程为 f(i,w) = max(f[i-1][w], f[i-1][w-w[i]] + v[i])
     * 语言化表述为 有i个物品，背包承重最大值为w的情况下，背包的最大值为i-1个物品的最大值或者i-1个物品的最大值加上第i个物品的价值，即第i个物品要么放进去，要么不放进去。
     * 循环的开始为：假设只有一个物品，在不同上限下能够达到的价值。为什么只能是根据物品维度走呢？是因为物品维度是公式内唯一可以递增的，重量维度不可以递增，即[w - wi]
     * 后续有两个物品，在不通上限下达到的最大值，放两个可以根据放一个的值算出来，减少了计算量。
     * @return 最大值
     */
    public int backPack01(int[] weights, int[] values, int maxWeight){
        int size = weights.length;
        if(size == 0){
            return 0;
        }
        int[][] memo = new int[weights.length][maxWeight+1];
        for(int i = 1; i < maxWeight; i++){
            memo[0][i] = weights[0] <= i ? values[0] : 0;
        }
        for(int i = 1; i < size ; i++){
            for(int w = 1; w <= maxWeight; i++){
                if(weights[w] < w){
                    int av = memo[i-1][w];
                    int bv = memo[i-1][w-weights[i]] + values[i];
                    memo[i][w] = Math.max(av,bv);
                }
            }
        }
        return memo[size-1][maxWeight];
    }
}
