package com.shijx5514.leetcode;


/**
 * lc35
 * @author shijiaxin02
 * @date 2017/07/02
 *
 * 给定排序数组和目标值，如果找到目标，则返回索引。如果没有，请返回索引按顺序插入的索引。
 *
 * 可以假设数组中没有重复项。
 */
public class SearchInsertPosition35 {
    public int searchInsert(int[] nums, int target) {
        if(nums == null) {return -1;}
        if(nums.length == 0) {return 0;}
        return search(nums, target, 0, nums.length-1);
    }

    public int search(int[] nums, int target, int start, int end) {
        if (target < nums[start]) {
            return start;
        } /*if target is smaller than the first element, it should sit at the start*/
        if (target > nums[end]) {
            return end + 1;
        } /*if target is larger than the last element, it should sit next to end*/

        int mid = (start + end) / 2;
        if (target == nums[mid]) {
            return mid;
        } /*return the index if target is found*/ else if (target > nums[mid]) {
            return search(nums, target, mid + 1, end); /*search right half if target greater than mid*/
        } else {
            return search(nums, target, start, mid - 1); /*search left half if target smaller than mid*/
        }
    }

    public static void main(String[] args) {
        SearchInsertPosition35 f = new SearchInsertPosition35();
        int[] nums = new int[]{1,1,3,4,5,5,5,5,5};int target = 3;
        int[] nums1 = new int[]{3,5,7,9,10};int target1 = 8;
        int result = f.searchInsert(nums1 ,target1);
        System.out.println(result);
    }
}
