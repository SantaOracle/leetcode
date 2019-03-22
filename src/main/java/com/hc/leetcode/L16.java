package com.hc.leetcode;

import java.util.Arrays;

public class L16 {

    /**
     * Runtime: 8 ms, faster than 91.35% of Java online submissions for 3Sum Closest.
     * Memory Usage: 39.7 MB, less than 19.93% of Java online submissions for 3Sum Closest.
     * @param nums
     * @param target
     * @return
     */
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int diff = Integer.MAX_VALUE;
        int sum = 0;
        for(int i = 0; i < nums.length - 2; i ++ ){
            int high = nums.length - 1;
            int low = i + 1;

            while(high > low){
                int t = nums[i] + nums[high] + nums[low];
                int d = target - t;
                if(d > 0){
                    low++;
                }else if (d < 0){
                    high--;
                }else{
                    return t;
                }
                if(Math.abs(d) < Math.abs(diff)){
                    diff = Math.abs(d);
                    sum = t;
                }
            }
        }
        return sum;
    }

    public static void main(String[] args){
        int[] a = new int[]{-1,2,1,-4};
        new L16().threeSumClosest(a,1);
    }
}
