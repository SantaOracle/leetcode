package com.shijx5514.leetcode;

/**
 * @author shijiaxin02
 * @date 2019/7/4
 *
 * lc 55 跳跃游戏
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 *
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 *
 * 判断你是否能够到达最后一个位置。
 *
 * ex：
 * 输入: [2,3,1,1,4]
 * 输出: true
 * 解释: 从位置 0 到 1 跳 1 步, 然后跳 3 步到达最后一个位置。
 */
public class CanJump55 {
    public boolean canJump(int[] nums) {
        int temp = nums.length - 1;
        //从右到左进行一次遍历，遍历是否能到达
        for(int i=nums.length-1; i>=0 ; i--) {
            if(i + nums[i] >= temp) {
                temp = i;
            }
        }
        return temp == 0;
    }
}
