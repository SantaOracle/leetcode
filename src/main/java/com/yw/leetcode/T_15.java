package com.yw.leetcode;

import java.util.*;

/**
 * @author yuanwei on 2019/8/30
 **/
public class T_15 {

    public static void main(String[] args) {
        T_15 t_15 = new T_15();
        System.out.println(t_15.threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
        System.out.println(t_15.threeSum(new int[]{1, 2, -2, -1}));
        System.out.println(t_15.threeSum(new int[]{0, 0, 0, 0, 0, 0}));
        System.out.println(t_15.threeSum(new int[]{-3, -2, -1, 0, 1, 2, 3}));
    }

    public List<List<Integer>> threeSum1(int[] nums) {
        int length = nums.length;
        Arrays.sort(nums);

        // 计算每个数字的所在范围
        Map<Integer, List<Integer>> map = new HashMap<>();
        int l = 0;
        while (l < length) {
            int lVal = nums[l];
            int r = l;
            while (r < length) {
                int rVal = nums[r];
                if (lVal == rVal) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(l);
                    temp.add(r++);
                    map.put(lVal, temp);
                } else {
                    break;
                }
            }
            l = r;
        }

        Set<Integer> possibleC = new HashSet<>();
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            int left = entry.getValue().get(0);
            int right = entry.getValue().get(1);
            if (left == right) {
                possibleC.add(left);
            } else {
                possibleC.add(left);
                possibleC.add(left + 1);
                possibleC.add(right);
                possibleC.add(right - 1);
            }
        }
        possibleC.remove(0);
        possibleC.remove(length - 1);

        ArrayList<Integer> integers = new ArrayList<>(possibleC);
        integers.sort(Comparator.comparing(Integer::intValue));


        Set<List<Integer>> set = new HashSet<>();
        for (int c : possibleC) {
            int cVal = nums[c];
            int i = c - 1;
            int j = c + 1;
            while (i >= 0 && j < length) {
                int iVal = nums[i];
                int jVal = nums[j];
                int sum = cVal + iVal + jVal;
                if (sum == 0) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(iVal);
                    temp.add(cVal);
                    temp.add(jVal);
                    set.add(temp);
                    i--;
                    j++;
                } else if (sum > 0) {
                    i--;
                } else {
                    j++;
                }
            }
        }
        return new ArrayList<>(set);
    }

    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length < 3) return new ArrayList<>();
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            int curVal = nums[i];
            if (curVal > 0) {
                break;
            }
            if (i > 0 && curVal == nums[i - 1]) {
                continue;
            }
            int left = i + 1;
            int right = length - 1;
            while (left < right) {
                int leftVal = nums[left];
                int rightVal = nums[right];
                int sum = curVal + leftVal + rightVal;
                if (sum == 0) {
                    list.add(Arrays.asList(curVal, leftVal, rightVal));
                    while (left < right && leftVal == nums[left + 1]) {
                        left++;
                    }
                    while (left < right && rightVal == nums[right - 1]) {
                        right--;
                    }
                    left++;
                    right--;
                } else if (sum > 0) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        return list;
    }
}
