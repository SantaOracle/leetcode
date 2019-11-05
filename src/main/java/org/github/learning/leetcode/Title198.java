package org.github.learning.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode-cn.com/problems/house-robber/"></a>
 * Status:  AC
 * Runtime: 2 ms, 在所有 java 提交中击败了5.94%的用户
 * @author peiheng.jiang create on 2019/11/4
 */
public class Title198 {

    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        Map<Integer, Integer> maxPriceMap = new HashMap<>();
        return Math.max(maxPrice(nums, 0, maxPriceMap), maxPrice(nums, 1, maxPriceMap));
    }

    private int maxPrice(int[] nums, int startIndex, Map<Integer, Integer> maxPriceMap) {
        Integer maxPrice = maxPriceMap.get(startIndex);
        if (maxPrice != null) {
            return maxPrice;
        }
        if (startIndex >= nums.length - 2) {
            maxPrice = nums[startIndex];
        } else {
            maxPrice = Integer.MIN_VALUE;
            for (int i = startIndex + 2; i < nums.length; i++) {
                maxPrice = Math.max(maxPrice, nums[startIndex] + maxPrice(nums, i, maxPriceMap));
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
