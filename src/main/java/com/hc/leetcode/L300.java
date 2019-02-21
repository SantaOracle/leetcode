package com.hc.leetcode;


public class L300 {
    /**
     * dp(i) = max(dp(j) + 1) 0<=j<i
     * dp(i)为到i这个index的节点的值 则s(i)正好是这个最长序列的最大值，然后比较就是了。
     * 找状态方程的规律
     * 1 先用暴力循环的方式，将题搞定
     * 2 在这个基础上，找到dp方程
     * @param nums
     * @return
     */
    public int lengthOfLIS(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        if(nums.length == 1){
            return 1;
        }
        int[] memo = new int[nums.length];
        memo[0] = 1;
        int ret = 0;
        for(int m = 1; m < nums.length; m++){
            int max = 0;
            int middle = nums[m];
            for(int n = 0; n < m; n++){
                if(middle > nums[n]){
                    if(max < memo[n]){
                        max = memo[n];
                    }
                }
            }
            memo[m] = max+1;
            if(max + 1 > ret){
                ret = max + 1;
            }
        }
        return ret;
    }
}
