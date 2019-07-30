package org.github.learning.leetcode;

/**
 * <a href="https://leetcode.com/problems/sort-colors/"></a>
 * Status:  AC
 * Runtime: 0 ms, faster than 100.00%
 * create by peiheng.jiang on 2019/7/30
 */
public class Title75 {

    public void sortColors(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }
        int p0 = 0;
        int p2 = nums.length - 1;
        int curt = 0;
        while (curt <= p2) {
            if (nums[curt] == 0) {
                swap(nums, curt, p0);
                p0++;
                curt++;
            } else if (nums[curt] == 2) {
                swap(nums, curt, p2);
                p2--;
            } else {
                curt++;
            }
        }
    }

    private void swap(int[] nums, int index1, int index2) {
        int tmp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = tmp;
    }

    public static void main(String[] args) {
        Title75 title75 = new Title75();
        int[] nums = new int[]{1, 2, 0};
        title75.sortColors(nums);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }


}
