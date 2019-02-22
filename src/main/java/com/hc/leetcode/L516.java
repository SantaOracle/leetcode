package com.hc.leetcode;

import java.util.ArrayList;
import java.util.List;

public class L516 {

    public static void main(String[] args){
        String abcd = "abcdefg";
        char[] chars = abcd.toCharArray();
        List<String> list = new ArrayList<>();
        list.add(chars[0]+"");
        for(int m = 1; m < chars.length; m++){
            //首先输出自身
            System.out.println(chars[m]);
            List<String> copy = new ArrayList<>(list);
            for(String s : copy){
                System.out.println(s +chars[m]);
                list.add(s+chars[m]);
            }
            list.add(chars[m]+"");
        }
    }

    /**
     *
     * 对于任意字符串，如果头尾字符相同，那么字符串的最长子序列等于去掉首尾的字符串的最长子序列加上首尾；如果首尾字符不同，
     * 则最长子序列等于去掉头的字符串的最长子序列和去掉尾的字符串的最长子序列的较大者。
     * 设字符串为str，长度为n，p[i][j]表示第i到第j个字符间的子序列的个数（i<=j），则：
     *
     * 状态初始条件：dp[i][i]=1 （i=0：n-1）
     *
     * 状态转移方程：dp[i][j]=dp[i+1][j-1] + 2  if（str[i]==str[j]）
     *
     *             dp[i][j]=max(dp[i+1][j],dp[i][j-1])  if （str[i]!=str[j]）
     *
     * 双变量的可以想象成一个正方形或者长方形。
     * 三个变量的可以想象成正方体或者长方体。
     * 正方体的双变量
     *
     * ---------------------
     * | x |   |   |   |   |
     * ---------------------
     * | 1 | x |   |   |   |
     * ---------------------
     * | 2 | 1 | x |   |   |
     * ---------------------
     * | 3 | 2 | 1 | x |   |
     * ---------------------
     * | 4 | 3 | 2 | 1 | x |
     * ---------------------
     *
     * 问题：index 从0数和从1数
     * @param s
     * @return
     */

    public int longestPalindromeSubseq(String s) {

        int[][] memo = new int[s.length()][s.length()];

        //各个中心点找到
        for (int i = 0; i < s.length(); i++) {
            memo[i][i] = 1;
        }
        //步长
        for (int l = 1; l < s.length(); l++) {
            //起点
            for (int i = 0; i <= s.length() - l; i++) {
                //终点
                int j = i + l ;
                //是否相等
                if (s.charAt(i) == s.charAt(j)) {
                    memo[i][j] = memo[i + 1][j - 1] + 2;
                } else {
                    memo[i][j] = Math.max(memo[i][j - 1], memo[i + 1][j]);
                }
            }

        }
        return memo[0][s.length() - 1];
    }
}
