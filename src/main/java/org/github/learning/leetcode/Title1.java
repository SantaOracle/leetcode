package org.github.learning.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author peiheng.jiang create on 2019/01/29
 */
public class Title1 {
    public static void main(String[] args) {
        Title1 title1 = new Title1();
        int nums[] = new int[]{2,7,11,15};
        int target = 9;
        int result[] = title1.twoSum(nums, target);
        for (int i : result) {
            System.out.print(i + " ");
        }
    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<nums.length; i++) {
            Integer targetIndex = map.get(nums[i]);
            if (targetIndex != null) {
                return new int[]{i, targetIndex};
            }
            map.put(target - nums[i], i);
        }
        throw new RuntimeException("None match!");
    }
}
