package org.github.learning.leetcode;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/3sum-closest/"></a>
 * Status:  AC
 * Runtime: 9 ms, faster than 80.73%
 * @author peiheng.jiang create on 2019/03/18
 */
public class Title16 {

    public int threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length < 3) {
            return 0;
        }
        // 1.排序
        Arrays.sort(nums);
        // 2.初始化
        int result = Integer.MAX_VALUE;
        int diff = Integer.MAX_VALUE;
        int index = 0;
        // 3.二重循环找最小差值
        while (index < nums.length) {
            int lo = index + 1;
            int hi = nums.length - 1;
            while (lo < hi) {
                int localSum = nums[index] + nums[lo] + nums[hi];
                int localDiff = localSum - target;
                if (localDiff == 0) {
                    return localSum;
                }
                int localDiffAbs = Math.abs(localDiff);
                if (localDiffAbs < diff) {
                    diff = localDiffAbs;
                    result = localSum;
                }
                if (localDiff < 0) {
                    lo = getNextIndex(nums, lo, true);
                } else {
                    hi = getNextIndex(nums, hi, false);
                }
            }
            index = getNextIndex(nums, index, true);
        }
        return result;
    }

    /**
     * 获取下一个下标位置
     * 主要为了跨过数组中重复的部分
     * 最后返回的下标可能为-1 或者 nums.length() + 1
     * @param nums      排好序的数组
     * @param index     当前下标
     * @param toRight   下标是否右移
     * @return
     */
    private int getNextIndex(int[] nums, int index, boolean toRight) {
        while (toRight && index != nums.length - 1 && nums[index] == nums[index+1]) {
            index++;
        }
        while (!toRight && index != 0 && nums[index] == nums[index-1]) {
            index--;
        }
        if (toRight) {
            index++;
        } else {
            index--;
        }
        return index;
    }

    public static void main(String[] args) {
        Title16 title16 = new Title16();
        System.out.println(title16.threeSumClosest(new int[]{0, 2, 1, -3}, 1));
//        System.out.println(title16.getNextIndex(new int[]{-4, -4, -4, -4, -1, -1, 0 , 1}, 7, true));
    }
}
