package com.hc.leetcode;

/**
 * Runtime: 343 ms, faster than 9.16% of Java online submissions for Container With Most Water.
 * Memory Usage: 39.6 MB, less than 88.11% of Java online submissions for Container With Most Water.
 * 9.16????
 * todo:继续优化 o(n)解法
 */
public class L11 {
    /**
     * 设index为i
     * s(i)为i和前面所有值相乘的最大区域
     * f(i) = max(f(i-1),s(i))
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        if(height.length == 1){
            return height[0];
        }
        int max = height[0] > height[1] ? height[1] : height[0];

        for(int index = 2; index < height.length; index ++){
            for(int m = 0; m < index; m ++){
                int width = index - m;
                int area = height[index] > height[m] ? height[m] * width : height[index] * width;
                if(area > max){
                    max = area;
                }
            }
        }
        return max;
    }
}
