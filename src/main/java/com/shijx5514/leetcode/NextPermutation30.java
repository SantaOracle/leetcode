package com.shijx5514.leetcode;


import java.util.Arrays;

/**
 * @author shijiaxin02
 * @date 2019/06/28
 *
 * lc30
 * 实现下一个list，它将数字重新排列到list上的下一个更大的数字之后。
 *
 * 如果这种排列排不了（没有比他大的了），则必须将其重新排列为尽可能低的顺序（即按升序排序）。
 *
 * 替换必须就地，并且仅使用常量级别的额外内存。
 *
 * 说句实话，这题我没太读懂，原本想用链表做，不过好像8太行 于是乎看了下discuss
 *
 *
 */
public class NextPermutation30 {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        //长度为1直接返回。
        if(n==1) {
            return;
        }
        //倒序循环每个数据
        for(int i=n-1;i>=0;i--) {
            int x = nums[i];
            //如果是最后一个数据或者比后面的数据大，跳过
            if(i==n-1 || x>=nums[i+1]) {
                continue;
            }

            // 寻找在他后面的比他大且（是最后一个数或者该书的后一个数比他小的）
            for(int k=i+1;k<n;k++) {
                if(nums[k]>x && (k==n-1 || nums[k+1]<=x)) {
                    //交换
                    int y = nums[k];
                    nums[k] = x;
                    nums[i] = y;
                    break;
                }
            }

            // 将nums[i+1..n-1]进行排序
            Arrays.sort(nums, i+1, n);
            return;
        }

        // 如果nums最初是降序，则按升序排序
        Arrays.sort(nums);
    }
}
