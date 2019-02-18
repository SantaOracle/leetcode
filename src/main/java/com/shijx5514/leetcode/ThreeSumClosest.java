package com.shijx5514.leetcode;


import java.util.Arrays;

/**
 * lc16，和lc15类似，把a+b+c = 0换成了，a+b+c 结果最近似于 target 的求解，因此两题做法可以通用，这里给出一种先拍讯，在计算2sum的方法
 * @author shijiaxin02
 * @date 2019/02/02
 */
public class ThreeSumClosest {
    public static int threeSumClosest(int[] nums, int target) {
        if (nums == null) {
            return 0;
        }
        int n = nums.length;
        if(n == 0) {
            return 0;
        }
        Arrays.sort(nums);
        int sum = nums[0] + nums[1] + nums[2];
        if (sum>=target) {
            return sum;
        }
        sum = nums[n - 3] + nums[n - 2] + nums[n - 1];
        if (sum <= target) {
            return sum;
        }
        for (int i = 0; i<n-2; i++) {
            if (i>0 && nums[i-1] == nums[i]) {
                continue;
            }
            if (target > nums[i] + nums[n - 2] + nums[n - 1]) {
                sum = nums[i] + nums[n - 2] + nums[n - 1];
                continue;
            }
            if (3 * nums[i] >= target) {
                int tmp = nums[i] + nums[i + 1] + nums[i + 2];
                return Math.abs(target - tmp) < Math.abs(target - sum) ? tmp : sum;
            }
            int lo = i + 1, hi = n - 1;
            while (lo < hi) {
                int tmp = nums[i] + nums[lo] + nums[hi];
                if (tmp == target) {
                    return target;
                } else if (tmp < target) {
                    while (lo < hi && nums[lo + 1] == nums[lo]) {
                        lo++;
                    }
                    lo++;
                } else {
                    while (lo < hi && nums[hi - 1] == nums[hi]) {
                        hi--;
                    }
                    hi--;
                }
                sum = Math.abs(target - sum) > Math.abs(target - tmp) ? tmp : sum;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] strs = {-4,-2,1,-5,-4,-4,4,-2,0,4,0,-2,3,1,-5,0};
        int target = 8;
        System.out.print(threeSumClosest(strs, target));
    }
}
