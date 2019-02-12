package com.hc.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LeetCode15 {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        List<Integer> bigger = new ArrayList<>();
        List<Integer> lower = new ArrayList<>();
        Set<Integer> biggerSet = new HashSet<>();
        Set<Integer> lowerSet = new HashSet<>();

        for (int num : nums) {
            if(num > 0){
                bigger.add(num);
                biggerSet.add(num);
            }else{
                lower.add(num);
                lowerSet.add(num);
            }
        }
        if(lowerSet.size() == 1 && lower.get(0) == 0 & bigger.size() == 0){
            List<Integer> list = new ArrayList<>();
            list.add(0);
            list.add(0);
            list.add(0);
            ret.add(list);
        }

        Set<String> middle = new HashSet<>();
        for (int i = 0; i < bigger.size(); i++) {

            for (int i1 = i + 1; i1 < bigger.size(); i1++) {
                int test = 0 - bigger.get(i) - bigger.get(i1);
                String m = bigger.get(i) > bigger.get(i1) ? "" + bigger.get(i) +  bigger.get(i1)
                        : "" + bigger.get(i1) +  bigger.get(i);
                if(middle.contains(m) ){
                    continue;
                }
                middle.add(m);
                if(lowerSet.contains(test)){
                    List<Integer> list = new ArrayList<>();
                    list.add(bigger.get(i));
                    list.add(bigger.get(i1));
                    list.add(test);
                    ret.add(list);
                }
            }
        }

        middle.clear();
        for (int i = 0; i < lower.size(); i++) {

            for (int i1 = i + 1 ; i1 < lower.size(); i1++) {
                int test = 0 - lower.get(i) - lower.get(i1);
                String m = lower.get(i) > lower.get(i1) ? "" + lower.get(i) +  lower.get(i1)
                        : "" + lower.get(i1) +  lower.get(i);
                if(middle.contains(m) ){
                    continue;
                }
                middle.add(m);
                if(biggerSet.contains(test)) {
                    List<Integer> list = new ArrayList<>();
                    list.add(lower.get(i));
                    list.add(lower.get(i1));
                    list.add(test);
                    ret.add(list);
                }
            }
        }

        return ret;
    }

    public static void main(String[] args){

        int[] nums = new int[]{-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6};
        List<List<Integer>> ret = new LeetCode15().threeSum(nums);
        System.out.println(ret);

    }
}
