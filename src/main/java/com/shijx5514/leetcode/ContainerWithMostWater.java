package com.shijx5514.leetcode;



/**
 * leetcode 11
 * @author shijiaxin
 * 在一个木板高度不同的容器里装下最多的水
 */
public class ContainerWithMostWater {

    /**
     * 计算最大体积
     * @param height 木板高度数组
     * @return 装水体积
     */
    public static int maxArea(int[] height) {
        int v = 0;
        for(int i = 0 ; i < height.length ; i++) {
            //设左侧偏移量为k
            for(int k = 0 ; k <= i ; k++) {
                //设右侧偏移量为i-k
                if((Math.min(height[k],height[height.length - i + k - 1])) * (height.length - i - 1) > v) {
                    v = (Math.min(height[k],height[height.length - i + k - 1])) * (height.length - i - 1);
                }
            }
        }
        return v;
    }

    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        System.out.print(maxArea(height));
    }
}
