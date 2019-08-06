package org.github.learning.leetcode;

/**
 * <a href="https://leetcode.com/problems/search-in-rotated-sorted-array/"></>
 * Status:  AC
 * Runtime: 0 ms, faster than 100.00%
 * Create by peiheng.jiang on 2019/8/6
 */
public class Title33 {

    /**
     * My Solution
     * 右比较法
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;

            if (nums[mid] > nums[right]) {
                // 左侧有序
                if (nums[left] <= target && target <= nums[mid]) {
                    // target在mid左侧，包括mid
                    right = mid;
                } else {
                    // target在mid右侧，不包括mid
                    left = mid + 1;
                }
            } else {
                // 右侧有序
                if (nums[mid] < target && target <= nums[right]) {
                    // target在mid右侧，包括mid
                    left = mid + 1;
                } else {
                    // target在mid左侧，不包括mid
                    right = mid;
                }
            }
        }
        return nums[left] == target ? left : -1;
    }

    public static void main(String[] args) {
        Title33 title33 = new Title33();
        System.out.println(title33.search(new int[]{1, 3}, 2));
    }
}
