package com.hc.leetcode;

/**
 * Runtime: 1 ms, faster than 99.92% of Java online submissions for Jump Game.
 Memory Usage: 40.9 MB, less than 31.76% of Java online submissions for Jump Game.
 * Created by congcong.han on 2019/4/20.
 * todo:代码还可以精简
 */
public class L55 {
    public boolean canJump(int[] nums) {
        if(nums.length == 0){
            return false;
        }
        int jumpBegin = 0;
        int jumpEnd = nums[0];
        while(true){
            if(jumpEnd >= nums.length -1){
                return true;
            }
            if(jumpBegin == jumpEnd ){//跳不了了
                return false;
            }

            int end = jumpEnd;
            for(int i = jumpBegin + 1; i <= jumpEnd; i++ ){
                int tmp = i + nums[i];
                if(tmp > end){
                    end = tmp;
                }
            }
            jumpBegin = jumpEnd;
            jumpEnd = end;
        }
    }
}
