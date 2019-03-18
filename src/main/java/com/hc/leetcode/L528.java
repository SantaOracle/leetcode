package com.hc.leetcode;

import java.util.Random;

public class L528 {

    private int[] addWeight;
    private int sum;
    private Random random = new Random();
    public L528(int[] w) {
        this.addWeight = new int[w.length];
        for(int index = 0; index < w.length; index ++){
            sum = sum + w[index];
            addWeight[index] = sum;
        }
    }

    public int pickIndex() {
        int value = random.nextInt(sum) + 1;
        return bs(value);
    }

    /**
     * 二分查找，查找一个闭开区间。
     * @param value
     * @return
     */
    private int bs(int value) {
        if(value <= addWeight[0]){
            return 0;
        }

        int begin = 0;
        int end = addWeight.length - 1;
        while(end - begin > 1){
            int middle = begin + (end - begin) /2;
            int weight = addWeight[middle];
            if(weight == value){
                return middle;
            }else if(weight > value){
                end = middle;
            }else{
                begin = middle;
            }
        }

        return end;
    }
}
