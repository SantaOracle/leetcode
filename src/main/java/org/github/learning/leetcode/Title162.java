package org.github.learning.leetcode;

/**
 * <a href="https://leetcode.com/problems/find-peak-element/"></a>
 * Status:  AC
 * Runtime: 0 ms, faster than 100.00%
 * @author peiheng.jiang create on 2019/9/11
 */
public class Title162 {

    public int findPeakElement(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
        return binarySearchTop(nums);
    }

    /**
     * 二分查找峰值
     * @param nums
     * @return
     */
    private int binarySearchTop(int[] nums) {
        int lo = 0;
        int hi = nums.length - 1;
        int mid = (lo + hi) / 2;
        while (lo <= hi) {
            mid = (lo + hi) / 2;
            if (isTop(nums, mid)) {
                return mid;
            }
            if (gtRight(nums, mid)) {
                hi = mid;   // 峰值可能是mid，也可能是mid左侧的元素
            } else {
                lo = mid + 1;   // 峰值一定在mid右侧
            }
        }
        return mid;
    }

    /**
     * 是否峰值元素
     * @param nums
     * @param index
     * @return
     */
    private boolean isTop(int[] nums, int index) {
        return gtLeft(nums, index) && gtRight(nums, index);
    }

    /**
     * 当前下标元素，是否大于右侧元素
     * @param nums
     * @param index
     * @return
     */
    private boolean gtRight(int[] nums, int index) {
        if (index == nums.length - 1) {
            return true;
        }
        return nums[index] > nums[index + 1];
    }

    /**
     * 当前下标元素，是否大于左侧元素
     * @param nums
     * @param index
     * @return
     */
    private boolean gtLeft(int[] nums, int index) {
        if (index == 0) {
            return true;
        }
        return nums[index] > nums[index - 1];
    }

    public static void main(String[] args) {
        Title162 title162 = new Title162();
        System.out.println(title162.findPeakElement(new int[]{1, 2}));
    }
}
