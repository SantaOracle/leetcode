package org.github.learning.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author peiheng.jiang create on 2019/11/4
 */
public class Title198 {

    private static Map<Integer, Integer> maxPriceMap = new HashMap<>();

    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        return Math.max(maxPrice(nums, 0), maxPrice(nums, 1));
    }

    private int maxPrice(int[] nums, int startIndex) {
        Integer maxPrice = maxPriceMap.get(startIndex);
        if (maxPrice != null) {
            return maxPrice;
        }
        if (startIndex >= nums.length - 2) {
            maxPrice = nums[startIndex];
        } else {
            maxPrice = Integer.MIN_VALUE;
            for (int i = startIndex + 2; i < nums.length; i++) {
                maxPrice = Math.max(maxPrice, nums[startIndex] + maxPrice(nums, i));
            }
        }
        maxPriceMap.putIfAbsent(startIndex, maxPrice);
        return maxPrice;
    }

    public static void main(String[] args) {
        Title198 title198 = new Title198();
        System.out.println(title198.rob(new int[]{2, 7, 9, 3, 1}));
    }
}
