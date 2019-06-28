package com.shijx5514.leetcode;


/**
 * @author shijiaxin02
 * @date 2019/06/28
 * <p>
 * lc33
 * <p>
 * 假设按升序排序的数组在事先未知的中轴处旋转。
 * <p>
 * （即[0,1,2,4,5,6,7]可能变为[4,5,6,7,0,1,2]）。
 * <p>
 * 您将获得要搜索的目标值。如果在数组中找到则返回其索引，否则返回-1。
 * <p>
 * 您可以假设数组中不存在重复。
 * <p>
 * 算法的运行时复杂度必须为O（log n）。
 */
public class SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        int i = 0;
        int j = nums.length - 1;
        while (i <= j) {
            int middle = (i + j) / 2;
            if (nums[middle] == target) {
                return middle;
            }

            if ((nums[i] <= target && nums[middle] > target) || ((nums[i] > nums[middle] && (nums[i] <= target || nums[middle] >= target)))) {
                j = middle - 1;
            } else {
                i = middle + 1;
            }

        }

        return -1;
    }


    public static void main(String[] args) {
        SearchInRotatedSortedArray searchInRotatedSortedArray = new SearchInRotatedSortedArray();
        int[] nums = new int[]{4, 5, 6, 7, 0, 1, 2};
        System.out.println(searchInRotatedSortedArray.search(nums, 1));
    }
}
