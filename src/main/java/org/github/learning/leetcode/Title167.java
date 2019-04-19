package org.github.learning.leetcode;

/**
 * <a href="https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/"></a>
 * Status:  AC
 * Runtime: 1 ms, faster than 48.59%
 * @author peiheng.jiang create on 2019/04/19
 */
public class Title167 {

    public int[] twoSum(int[] numbers, int target) {
        if (numbers == null || numbers.length < 2) {
            return new int[]{};
        }
        // point crash loop
        int lo = 0;
        int hi = numbers.length - 1;
        while (lo < hi) {
            if (numbers[lo] + numbers[hi] == target) {
                return new int[]{lo + 1, hi + 1};
            }
            if (numbers[lo] + numbers[hi] < target) {
                lo++;
            } else {
                hi--;
            }
        }
        throw new RuntimeException("No suitable number combinations!");
    }
}
