package org.github.learning.leetcode;

/**
 * <a href="https://leetcode.com/problems/jump-game/"></a>
 *  Status:     AC
 *  Runtime:    1 ms, faster than 99.92%
 * @author peiheng.jiang create on 2019/04/28
 */
public class Title55 {

    /**
     * My solution
     * @param nums
     * @return
     */
    public boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int maxLength = 0;
        for (int i = 0; i < nums.length; i ++) {
            if (i <= maxLength) {
                maxLength = Math.max(maxLength, i + nums[i]);
            } else {
                return false;
            }
        }
        return true;
    }
}
