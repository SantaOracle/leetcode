package com.hc.leetcode;

public class L121 {


    // p(j) = max( p(j-1) , aj - min(a0...aj-1) )
    public int maxProfit(int[] prices) {
        if(prices.length == 0 || prices.length == 1){
            return 0;
        }

        int minPrice = Integer.MAX_VALUE;
        int max = 0;

        for(int price : prices){
            int maxTmp = price - minPrice;
            max = max > maxTmp ? max : maxTmp;

            minPrice = price < minPrice ? price : minPrice;
        }

        return max;
    }
}
