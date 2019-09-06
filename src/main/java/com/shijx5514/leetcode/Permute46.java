package com.shijx5514.leetcode;


import com.google.common.collect.Lists;

import java.lang.reflect.Array;
import java.util.*;

/**
 * lc 46
 * 给定一个没有重复数字的序列，返回其所有可能的全排列。
 * 回溯法
 */
public class Permute46 {
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> resultList = new ArrayList<>();
        List<Integer> input = new ArrayList<>();
        for(int i=0 ; i<nums.length; i++) {
            input.add(nums[i]);
        }
        int n = nums.length;
        calculate(input, 0, n, resultList);
        return resultList;
    }

    /**
     * 计算
     */
    private static void calculate(List<Integer> nums, int first, int n, List<List<Integer>> resultList) {
        if(first == n) {
            resultList.add(new ArrayList<>(nums));
        }
        for(int i = first; i < n; i++) {
            //first与i做一次交换，交换之后的新字符串继续递归
            Collections.swap(nums, first, i);
            calculate(nums,first + 1, n, resultList);
            //回溯，将回溯的结果计入循环继续虚幻
            Collections.swap(nums, first, i);
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3};
        System.out.println(permute(nums));
    }
}
