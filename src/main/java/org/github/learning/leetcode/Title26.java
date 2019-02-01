package org.github.learning.leetcode;

/**
 * <a href="https://leetcode.com/problems/remove-duplicates-from-sorted-array/"></a>
 * Status: AC
 * AC: 6 ms, faster than 98.92%
 * @author peiheng.jiang create on 2019/2/1
 */
public class Title26 {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return 1;
        }
        int lenth = 1;
        int index = 0;
        int nextIndex = index + 1;
        while (nextIndex < nums.length) {
            if (nums[index] == nums[nextIndex]) {
                nextIndex++;
                continue;
            }
            lenth++;
            index++;
            nums[index] = nums[nextIndex];
            nextIndex++;
        }
        return lenth;
    }

    public static void main(String[] args) {
        Title26 title26 = new Title26();
        System.out.println(title26.removeDuplicates(new int[]{0, 0, 0, 1, 1, 2}));
        System.out.println(title26.removeDuplicates(new int[]{0}));
        System.out.println(title26.removeDuplicates(new int[]{0, 1}));
    }
}
