package org.github.learning.leetcode;

import com.sun.deploy.util.ArrayUtil;

import java.util.*;

/**
 * <a href="https://leetcode.com/problems/3sum/"></a>
 * Status: AC
 * Runtime: 46 ms, faster than 73.18%
 * @author peiheng.jiang create on 2019/1/31
 */
public class Title15 {

    /**
     * My solution
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length == 0) {
            return Collections.emptyList();
        }
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int index1=0; index1<nums.length; index1++) {
            int target = 0 - nums[index1];
            int index2 = index1 + 1;
            int index3 = nums.length - 1;
            while (index2 < index3) {
                if (nums[index2] + nums[index3] == target) {
                    List<Integer> subResList = new ArrayList<>();
                    subResList.add(nums[index1]);
                    subResList.add(nums[index2]);
                    subResList.add(nums[index3]);
                    result.add(subResList);
                    while (index2 != nums.length - 1 && nums[index2] == nums[index2+1]) index2++;
                    while (index3 != 0 && nums[index3] == nums[index3-1]) index3--;
                }
                if (nums[index2] + nums[index3] <= target) {
                    index2++;
                } else {
                    index3--;
                }
            }
            while (index1 != nums.length - 1 && nums[index1] == nums[index1+1]) index1++;
        }
        return result;
    }

    /**
     * Best solution
     * Runtime: 41 ms
     * @param num
     * @return
     */
    public List<List<Integer>> threeSumBest(int[] num) {
        Arrays.sort(num);
        List<List<Integer>> res = new LinkedList<>();
        for (int i = 0; i < num.length-2; i++) {
            if (i == 0 || (i > 0 && num[i] != num[i-1])) {
                int lo = i+1, hi = num.length-1, sum = 0 - num[i];
                while (lo < hi) {
                    if (num[lo] + num[hi] == sum) {
                        res.add(Arrays.asList(num[i], num[lo], num[hi]));
                        while (lo < hi && num[lo] == num[lo+1]) lo++;
                        while (lo < hi && num[hi] == num[hi-1]) hi--;
                        lo++; hi--;
                    } else if (num[lo] + num[hi] < sum) lo++;
                    else hi--;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Title15 title15 = new Title15();
        int nums[] = new int[]{-2, 0, 1, 1, 2};
        List<List<Integer>> result = title15.threeSum(nums);
        result.forEach(list -> {
            list.forEach(num -> {
                System.out.print(num + " ");
            });
            System.out.println();
        });
    }
}
