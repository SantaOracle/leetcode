package org.github.learning.leetcode;

/**
 * <a href="https://leetcode.com/problems/container-with-most-water/"></a>
 * Status:  AC
 * Runtime: 4 ms, faster than 95.68%
 * @author peiheng.jiang create on 2019/03/14
 */
public class Title11 {

    /**
     * My solution
     *  遍历一遍即可
     *  面积 = 两个坐标距离 * 两个坐标对应较低的那个高度
     *  用DP
     *  f(i) = Max{f(i-1), (h[hi] - h[lo]) * Min{h[hi], h[lo]}}
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        if (height == null || height.length == 0) {
            return -1;
        }
        int lo = 0;
        int hi = height.length - 1;
        int res = 0;
        while (lo < hi) {
            int h = Math.min(height[lo], height[hi]);
            res = Math.max(res, h * (hi - lo));
            if (height[lo] <= height[hi]) {
                lo++;
            } else {
                hi--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Title11 title11 = new Title11();
        System.out.println(title11.maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
    }
}
