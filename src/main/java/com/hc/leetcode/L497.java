package com.hc.leetcode;

import java.util.Random;

public class L497 {
    //面积
    int[] ranges;
    int[] addRange;
    Random random = new Random();
    int sum = 0;
    private int[][] rects;
    public L497(int[][] rects) {
        this.ranges = new int[rects.length];
        for(int i = 0; i < rects.length; i ++){
            int[] rect = rects[i];
            //注意这个地方面积的计算
            int width = rect[2] - rect[0] + 1 ;
            int high = rect[3] - rect[1] + 1;
            ranges[i] = width * high;
        }
        addRange = new int[ranges.length];
        sum = 0;
        for(int i = 0; i < ranges.length; i ++){
            sum = sum + ranges[i];
            addRange[i] = sum;
        }

        this.rects = rects;
    }

    public int[] pick() {
        int random = this.random.nextInt(sum)+1;
        int index = bs(random);
        int[] rect = rects[index];
        int width = rect[2] - rect[0];
        int high = rect[3] - rect[1];
        int x = rect[0] +  this.random.nextInt(width +1);
        int y = rect[1] + this.random.nextInt(high + 1);
        return new int[]{x,y};
    }

    private int bs(int random) {
        if(random <= addRange[0]){
            return 0;
        }
        int begin = 0;
        int end = addRange.length;
        while(end - begin > 1){
            int middle = begin + (end - begin) / 2;
            int midValue = addRange[middle];
            if(midValue == random){
                return middle;
            }else if(midValue > random){
                end = middle;
            }else{
                begin = middle;
            }
        }
        return end;
    }
}
