package com.shijx5514.leetcode;


/**
 * lc 53
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * 最大和子序列
 */
public class MaxSubArray53 {
    public int maxSubArray(int[] nums) {

        //维护一个记录最大子序列和的变量
        int result = nums[0];
        //维护一个记录当前和的变量
        int sum = 0;
        for(int num : nums) {
            if(sum > 0) {
                sum += num;
            } else {
                sum = num;
            }
            result = Math.max(result, sum);
        }
        return result;
    }
}
