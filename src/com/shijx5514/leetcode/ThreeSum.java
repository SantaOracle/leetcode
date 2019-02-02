package com.shijx5514.leetcode;


import java.util.*;
import com.google.common.collect.Lists;

/**
 * leetcode15 3SUM
 * @author shijiaxin02
 * @date 2018/2/1
 * 根本思想是将a+b+c = 0 装换位 a+b = c，然后用求一个数组中和为c的两个数的方式解题，使用hashmap。理论是复杂度为n2，但是下面的代码运行时超时，暂时不知道是为了什么
 */
public class ThreeSum {
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> resultList = new ArrayList<>();
        Set<List<Integer>> result = new HashSet<>();
        //a+b+c = 0 -> a+b = -c
        for(int i=0 ; i< nums.length ;i++) {
            result = twoSum(nums, nums[i],i);
            for(List<Integer> tempResult : result) {
                boolean flag = true;
                for(List list : resultList) {
                    if ((list.get(0) == (tempResult.get(0)) || list.get(1) == (tempResult.get(0)) || (list.get(2) == (tempResult.get(0))))) {
                        if((list.get(0) == (tempResult.get(0)))) {
                            if(list.get(1) == (tempResult.get(1)) || list.get(2) == (tempResult.get(1))) {
                                flag = false;
                            }
                        }
                        if((list.get(1) == (tempResult.get(0)))) {
                            if(list.get(0) == (tempResult.get(1)) || list.get(2) == (tempResult.get(1))) {
                                flag = false;
                            }
                        }
                        if((list.get(2) == (tempResult.get(0)))) {
                            if(list.get(1) == (tempResult.get(1)) || list.get(0) == (tempResult.get(1))) {
                                flag = false;
                            }
                        }
                    }
                }
                if(flag) {
                    resultList.add(tempResult);
                }
            }
        }

        return resultList;
    }

    private static Set<List<Integer>> twoSum(int[] nums, int k, int pos) {
        Set<List<Integer>> result = new HashSet<>();
        //先把数组中的值放入map中
        HashMap map = new HashMap();
        for(int i=0 ; i< nums.length ;i++) {
            map.put(nums[i], i);
        }
        for(int i=0 ; i<nums.length ;i++) {
            if(null != map.get(-(nums[i] + k)) && (int)map.get(-(nums[i] + k)) != pos  && (int)map.get(-(nums[i] + k)) != i && pos != i) {
                List<Integer> resultList = new ArrayList<>();
                resultList.add(nums[i]);
                resultList.add(k);
                resultList.add(-(nums[i] + k));
                result.add(resultList);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] strs = {-4,-2,1,-5,-4,-4,4,-2,0,4,0,-2,3,1,-5,0};
        System.out.print(threeSum(strs));
    }

}
