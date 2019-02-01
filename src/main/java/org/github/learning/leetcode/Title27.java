package org.github.learning.leetcode;

/**
 * <a href="https://leetcode.com/problems/remove-element/"></a>
 * Status: 4 ms, faster than 100%
 * Runtime: None
 * @author peiheng.jiang create on 2019/2/1
 */
public class Title27 {

    public int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1 && val == nums[0]) {
            return 0;
        }
        int validIndex = -1;
        int index = 0;
        while (index < nums.length) {
            if (nums[index] != val) {
                nums[++validIndex] = nums[index];
            }
            index++;
        }
        if (validIndex == -1) {
            return 0;
        }
        return ++validIndex;
    }

    public static void main(String[] args) {
        Title27 title27 = new Title27();
        System.out.println(title27.removeElement(new int[]{3, 2, 2, 3}, 3));
        System.out.println(title27.removeElement(new int[]{}, 3));
        System.out.println(title27.removeElement(new int[]{3}, 3));
        System.out.println(title27.removeElement(new int[]{3, 3}, 3));
    }
}
