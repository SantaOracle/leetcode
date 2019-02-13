package org.github.learning.leetcode;

/**
 * <a href="https://leetcode.com/problems/best-time-to-buy-and-sell-stock/"></a>
 * Status: AC
 * Runtime: 1 ms, faster than 99.88%
 * @author peiheng.jiang create on 2019/02/13
 */
public class Title121 {

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0 || prices.length == 1) {
            return 0;
        }
        // 状态转移方程 f[i] = Max{ f[i-1], prices[i] - min{ prices[0]..prices[i-1]}}
        int res = 0;
        int minPrice = prices[0];   // 前i-1天，价格最小值
        for (int price : prices) {
            // 计算prices[i] - min{ prices[0]..prices[i-1]}
            int profit = price - minPrice;
            // 计算f[i]
            res = Math.max(profit, res);
            // 更新minPrice
            if (price < minPrice) minPrice = price;
        }
        return res;
    }
}
