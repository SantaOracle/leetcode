package com.hc.leetcode;

/**
 * 还有另外一种方法，还需要做
 * dp 方法
 * Runtime: 54 ms, faster than 41.31% of Java online submissions for Longest Palindromic Substring.
 */
public class L5 {
    /**
     *
     * i 到 j 区间是回文
     * p(i,j) = p(i+1,j-1)  when p(i) = p (j)
     * p(i,j) = 0 when p(i) != p(j)
     * 问题：输入字符串为ac时问题。
     */

    public String longestPalindrome(String s) {
        if(s.length() == 0)
            return "";
        if(s.length() == 1)
            return s;
        int len = s.length();
        int maxlen = 1, start = 0;
        int[][] dp = new int[s.length()][s.length()];
        //先找中心基点
        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = 1;
            if(i < len -1 && s.charAt(i) == s.charAt(i+1)) {
                dp[i][i+1] = 1;
                start = i;
                maxlen = 2;
            }
        }

        for (int length = 3; length <= len; length ++) { //字串长度从3开始

            for (int j = 0; j <= len - length ; j++) { //子串开始地址
                int last = j + length -1;
                if(dp[j+1][last-1] == 1 && s.charAt(last) == s.charAt(j)) {
                    dp[j][last] = 1;
                    maxlen = length;
                    start = j;
                }
            }
        }
        return s.substring(start,start + maxlen );
    }

    public static void main(String[] args){
        String test = "babad";
        System.out.println(new L5().longestPalindrome(test));
    }
}
