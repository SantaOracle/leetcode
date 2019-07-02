package org.github.learning.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <a href="https://leetcode.com/problems/trapping-rain-water/"></a>
 * Status:  AC
 * Runtime: 2 ms, faster than 22.7%
 * create by peiheng.jiang on 2019/7/2
 */
public class Title42 {

    /**
     * 用栈去计算雨水量
     * 入栈规则：
     *      1.无规则
     * 出栈规则：
     *      1.当前遍历的高度，大于栈顶下标对应的高度，出栈
     * @param height
     * @return
     */
    public int trap(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int res = 0;
        Deque<Integer> deque = new ArrayDeque<>(height.length);     // 存放数组下标
        for (int index=0; index<height.length; index++) {
            while (!deque.isEmpty() && height[index] > height[deque.peekLast()]) {
                // 栈非空，且当前遍历的高度，大于栈顶元素作为下标对应的数组当中对应元素的高度
                // 出栈
                int lastIndex = deque.pollLast();
                int lastHeight = height[lastIndex];     // bottom height
                if (deque.isEmpty()) {
                    break;
                }
                int distance = index - deque.peekLast() - 1;
                int minHeight = Math.min(height[deque.peekLast()], height[index]);
                res += distance * (minHeight - lastHeight);
            }
            deque.addLast(index);
        }

        return res;
    }

    public static void main(String[] args) {
        Title42 title42 = new Title42();
        System.out.println(title42.trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
    }
}
