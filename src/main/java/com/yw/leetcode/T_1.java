package com.yw.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yuanwei on 2019/8/12
 **/
public class T_1 {
    public int[] twoSum(int[] nums, int target) {
        return doTwoSum3(nums, target);
    }

    /**
     * 必须要求nums是有序的，时间复杂度 logN
     */
    private int[] doTwoSum1(int[] nums, int from, int to, int target) {
        if (to - from == 2) {
            if (nums[from] + nums[to - 1] == target) {
                return new int[]{from, to - 1};
            } else {
                return new int[0];
            }
        } else {
            int midIndex = (from + to) / 2;
            int mid = nums[midIndex];
            int mid2 = mid + nums[midIndex + 1];
            if (target > mid2) {
                return doTwoSum1(nums, midIndex, to, target);
            } else if (target < mid2) {
                return doTwoSum1(nums, 0, midIndex, target);
            } else {
                return new int[]{midIndex, midIndex + 1};
            }
        }
    }

    /**
     * 时间复杂度 N^2
     */
    private int[] doTwoSum2(int[] nums, int target) {
        int length = nums.length;
        for (int i = 0; i < length - 1; i++) {
            for (int j = i + 1; j < length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[0];
    }

    /**
     * 时间复杂度 n
     */
    private int[] doTwoSum3(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                return new int[]{map.get(nums[i]), i};
            } else {
                map.put(target - nums[i], i);
            }
        }
        return new int[0];
    }
}
