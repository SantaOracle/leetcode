package com.shijx5514.leetcode;


/**
 * @author shijiaxin02
 * @date 2019/07/01
 * lc 34
 */
public class FindFirstAndLastPositionOfElementInSortedArray {
    public int[] searchRange(int[] nums, int target) {
        int low = 0;
        int high = nums.length-1;
        if(nums.length == 0) {
            return new int[]{-1,-1};
        }
        if(nums.length == 1) {
            if(nums[0] != target) {
                return new int[]{-1, -1};
            } else {
                return new int[]{0, 0};
            }
        }

        return search(low, high, nums, target);

    }

    private static int[] search(int low, int high, int[] nums, int target) {
        int index = (low+high)/2;
        if(nums[index] < target) {
            low = index + 1;
            if(low == high -1 && nums[high]!=target && nums[low]!=target) {
                return new int[]{-1, -1};
            }
            if(low > high) {
                return new int[]{-1, -1};
            }
            return search(low, high, nums, target);
        }
        if(nums[index] > target) {
            high = index - 1;
            if(low == high -1 && nums[low]!=target && nums[high]!=target)  {
                return new int[]{-1, -1};
            }
            if(low > high) {
                return new int[]{-1, -1};
            }
            return search(low, high, nums, target);
        }
        if(nums[index] == target) {
            int indexh = 0;
            int indexl = 0;
            indexh = index;
            while(nums[indexh] == target) {
                indexh++;
                if(indexh == nums.length) {
                    break;
                }
            }
            indexl = index;
            while(nums[indexl] == target) {
                indexl--;
                if(indexl == -1) {
                    break;
                }
            }
            return new int[]{indexl+1, indexh-1};
        }
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        FindFirstAndLastPositionOfElementInSortedArray f = new FindFirstAndLastPositionOfElementInSortedArray();
        int[] nums = new int[]{1,1,3,4,5,5,5,5,5};int target = 3;
        int[] nums1 = new int[]{2,2};int target1 = 1;
        int[] result = f.searchRange(nums1 ,target1);
        System.out.println(result[0]);
        System.out.println(result[1]);
    }
}
