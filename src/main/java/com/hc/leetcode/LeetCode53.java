package com.hc.leetcode;

public class LeetCode53 {
    /**
     * 状态转移方程为：sum(j) = max(sum(j-1) + aj, aj)
     * 即如果前面一个状态是负的，只取aj便可以，否则前面的相加
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int tmpMax = 0;


        /**
         * 第一步，计算到某一个位置的最大子序列的和
         * 第二部，看看他是否比以前的那些大
         * 前面的计算结果可以被后面的计算使用，从而降低重复计算量
         */
        for(int i  = 0; i < nums.length ; i ++) {

            int num = nums[i];

            tmpMax += num;

            if(tmpMax < num){
                tmpMax = num;
            }

            if (tmpMax > max) {
                max = tmpMax;
            }

        }
        return max;
    }
}
