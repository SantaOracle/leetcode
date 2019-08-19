package com.yw.leetcode;

/**
 * @author yuanwei on 2019/8/19
 **/
public class T_11 {

    public static void main(String[] args) {
        T_11 t_11 = new T_11();
        System.out.println(t_11.maxArea1(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
    }

    public int maxArea(int[] height) {
        int max = 0;
        for (int i = 0; i < height.length - 1; i++) {
            for (int j = i + 1; j < height.length; j++) {
                max = Math.max(max, Math.min(height[i], height[j]) * (j - i));
            }
        }
        return max;
    }

    /**
     * 双指针法，从两端，每次移动较短边，使其与长边靠近
     */
    public int maxArea1(int[] height) {
        int max = 0;
        int i = 0;
        int j = height.length - 1;
        while (i < j) {
            max = Math.max(max, Math.min(height[i], height[j]) * (j - i));
            if (height[i] < height[j]) {
                i++;
            } else {
                j--;
            }
        }
        return max;
    }
}
