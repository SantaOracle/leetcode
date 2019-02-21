package org.github.learning.leetcode;

/**
 * <a href="https://leetcode.com/problems/longest-increasing-subsequence/"></a>
 * Status:  AC
 * Runtime: 0 ms, faster than 100%
 * @author peiheng.jiang create on 2019/02/21
 */
public class Title300 {

    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] stack = new int[nums.length];     // 定义一个上升序列的栈
        int stackSize = 0;
        for (int num : nums) {
            // 栈里没有元素，直接把当前元素置入
            if (stackSize == 0) {
                stack[stackSize] = num;
                stackSize++;
                continue;
            }
            // 将当前元素和栈顶元素作大小比较
            int top = stack[stackSize-1];
            if (num > top) {
                // 当前元素比栈顶元素大，直接塞进去
                stack[stackSize] = num;
                stackSize++;
                continue;
            }
            // 当前元素不大于栈顶元素，使用二分查找找到第一个比当前元素大的栈内元素，用当前元素替换掉它
            // 由于我们只需要输出最长上升子序列的长度，而不用完整输出序列，所以可以直接替换掉
            int exchangeIndex = binarySearch(stack, stackSize, num);
            stack[exchangeIndex] = num;
        }
        // 栈内的元素个数，就是最长上升子序列的长度
        return stackSize;
    }

    /**
     * 二分查找，找出第一个比target大的数字的下标
     * @param stack
     * @param stackSize
     * @param target
     * @return
     */
    private int binarySearch(int[] stack, int stackSize, int target) {
        int lo = 0;
        int hi = stackSize - 1;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (target > stack[mid]) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }

    public static void main(String[] args) {
        Title300 title300 = new Title300();
        System.out.println(title300.lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));
    }
}
