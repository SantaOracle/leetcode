package com.yw.leetcode;

/**
 * @author yuanwei on 2019/8/13
 **/
public class T_4 {
    /**
     * 题目要求O(log(m+n))，此解法是O(m+n)，不满足
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int len = len1 + len2;
        int[] nums = new int[len];
        int p = 0;
        int p1 = 0;
        int p2 = 0;
        while (p1 < len1 && p2 < len2) {
            int v1 = nums1[p1];
            int v2 = nums2[p2];
            if (v1 < v2) {
                nums[p++] = v1;
                p1++;
            } else {
                nums[p++] = v2;
                p2++;
            }
        }
        while (p1 < len1) {
            nums[p++] = nums1[p1++];
        }
        while (p2 < len2) {
            nums[p++] = nums2[p2++];
        }
        if (nums.length == 1) {
            return nums[0];
        }
        return (nums[(int) Math.ceil((len-1) / 2.0)] + nums[(int) Math.floor((len-1) / 2.0)]) / 2.0;
    }
}
