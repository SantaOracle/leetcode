package org.github.learning.leetcode;

/**
 * <a href="https://leetcode.com/problems/merge-sorted-array/"></a>
 * Status:  AC
 * Runtime: 0 ms, faster than 100.00%
 * @author peiheng.jiang create on 2019/8/21
 */
public class Title88 {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (nums1 == null || nums1.length == 0
                || nums2 == null || nums2.length == 0
                || n == 0) {
            return;
        }

        int index1 = m - 1;
        int index2 = n - 1;
        int swapIndex = n + m - 1;

        while (swapIndex >= 0) {
            if (index1 == -1) {
                for (int fillIndex = swapIndex; fillIndex >= 0; fillIndex--) {
                    nums1[swapIndex] = nums2[index2];
                    index2--;
                    swapIndex--;
                }
                continue;
            }
            if (index2 == -1) {
                for (int fillIndex = swapIndex; fillIndex >= 0; fillIndex--) {
                    nums1[swapIndex] = nums1[index1];
                    index1--;
                    swapIndex--;
                }
                continue;
            }
            if (nums1[index1] >= nums2[index2]) {
                nums1[swapIndex] = nums1[index1];
                index1--;
            } else {
                nums1[swapIndex] = nums2[index2];
                index2--;
            }
            swapIndex--;
        }
    }

    public static void main(String[] args) {
        Title88 title88 = new Title88();
        int[] num1 = new int[]{1, 2, 3, 0, 0, 0};
        title88.merge(num1, 3, new int[]{2, 5, 6}, 3);
        for (int i : num1) {
            System.out.print(i + " ");
        }
    }
}
