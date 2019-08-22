package org.github.learning.leetcode;

/**
 * <a href="https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/"></a>
 * Status:  AC
 * Runtime: 1 ms, faster than 74.33%
 * @author peiheng.jiang create on 2019/8/22
 */
public class Title80 {

    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return 1;
        }
        int finalIndex = 0;
        int iteratorIndex = 0;
        while (true) {
            iteratorIndex++;
            if (iteratorIndex >= nums.length) {
                break;
            }
            if (finalIndex > 0 && nums[finalIndex] == nums[finalIndex - 1] && nums[finalIndex] == nums[iteratorIndex]) {
                continue;
            }
            finalIndex++;
            nums[finalIndex] = nums[iteratorIndex];
        }

        return finalIndex + 1;
    }

    public static void main(String[] args) {
        Title80 title80 = new Title80();
        System.out.println(title80.removeDuplicates(new int[]{1, 1, 1, 2, 2, 5}));
    }
}
