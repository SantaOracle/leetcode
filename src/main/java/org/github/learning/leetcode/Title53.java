package org.github.learning.leetcode;

/**
 * <a href="https://leetcode.com/problems/maximum-subarray/"></>
 * Status: AC
 * Runtime: 7 ms, faster than 77.4%
 * @author peiheng.jiang create on 2019/02/12
 */
public class Title53 {

    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        // 状态转移方程 f[i] = Max{ f[i-1], f[i-1] + nums[i]}
        int res = nums[0];  // 记录的max
        int sum = 0;    // f[i-1]
        for (int num : nums) {
            if (sum > 0) {
                // 如果f[i-1]大于零，那么加上nums[i]，一定大于nums[i]
                // 这里是暗中做了一层比较
                sum += num;
            } else {
                // 如果f[i-1]小于零，那么加上nums[i]后一定小于nums[i]，直接取nums[i]
                sum = num;
            }
            // 状态转移方程 f[i] = Max{ f[i-1], f[i-1] + nums[i]}
            // sum -- f[i-1]+nums[i], res -- f[i-1]
            res = Math.max(sum, res);
        }
        return res;
    }
}
