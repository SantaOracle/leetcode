package org.github.learning.leetcode;

/**
 * <a href="https://leetcode.com/problems/maximum-product-subarray/"></a>
 * Status:  AC
 * Runtime: 1 ms, faster than 98.19%
 * @author peiheng.jiang create on 2019/03/19
 */
public class Title152 {

    /**
     * My Solution
     * 定义：
     *      max[i] —— 前i个数，连成子序列结果最大值
     *      min[i] —— 前i个数，连成子序列结果最小值
     * 状态转移方程：
     *      max[i] = Max{Max{max[i-1] * nums[i], min[i-1] * nums[i]}, nums[i]}
     *      min[i] = Min{Min{max[i-1] * nums[i], min[i-1] * nums[i]}, nums[i]}
     * @param nums
     * @return
     */
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        // init
        int max = nums[0];
        int min = nums[0];
        int res = nums[0];
        // loop
        for (int index = 1; index < nums.length; index++) {
            int tmpMax = max;
            max = Math.max(Math.max(max * nums[index], min * nums[index]), nums[index]);
            min = Math.min(Math.min(tmpMax * nums[index], min * nums[index]), nums[index]);
            if (max > res) {
                res = max;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Title152 title152 = new Title152();
//        System.out.println(title152.maxProduct(new int[]{-2, 0, -1}));
        System.out.println(title152.maxProduct(new int[]{2, 3, -2, 4}));
    }
}
