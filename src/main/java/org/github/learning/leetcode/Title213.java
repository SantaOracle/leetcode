package org.github.learning.leetcode;

/**
 * <a href="https://leetcode.cn/problems/house-robber-ii/"></a>
 * Status:  AC
 * Runtime: 0 ms, faster than 100%
 *
 * @author jiangpeiheng create on 2023/2/16
 */
public class Title213 {

    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        return Math.max(calMaxVal(nums, 0, nums.length - 2), calMaxVal(nums, 1, nums.length - 1));
    }

    /**
     * f1 = dp(i-2)
     * f2 = dp(i-1)
     * 循环到最后，f1 = dp(n-1), f2 = dp(n)
     * 用递归 + Map缓存也可以，但是需要额外的空间
     *
     * @param nums
     * @param start
     * @param end
     * @return
     */
    private int calMaxVal(int[] nums, int start, int end) {
        int f1 = nums[start];
        int f2 = Math.max(nums[start], nums[start + 1]);
        for (int i = start + 2; i <= end; i++) {
            int t = f2;
            f2 = Math.max(f1 + nums[i], f2);
            f1 = t;
        }
        return f2;
    }
}
