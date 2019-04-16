package main.java.com.shijx5514.leetcode;



/**
 * leetcode26 按对交换链表节点
 * @author shijiaxin02
 * @date 19/4/16
 */
public class RemoveDuplicatesfromSortedArray26 {

    public int removeDuplicates(int[] nums) {
        int i = 0;
        for (int n : nums) {
            if (i == 0 || n > nums[i - 1]) {
                nums[i++] = n;
            }
        }
        return i;
    }
}
