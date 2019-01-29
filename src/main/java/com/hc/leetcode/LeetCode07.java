package com.hc.leetcode;

public class LeetCode07 {
    public int reverse(int x) {
        int ret = 0;

        while(x != 0){
            long middle =  ret * 10l;
            if( middle > Integer.MAX_VALUE || middle < Integer.MIN_VALUE){
               return 0;
            }
            ret = ret * 10 + ( x % 10 );
            x = x / 10;
        }

        return ret;
    }

    public static void main(String[] args){
        int ret = new LeetCode07().reverse(-2147483648);
        System.out.println(ret);
        System.out.println(Integer.MAX_VALUE);
    }

}
