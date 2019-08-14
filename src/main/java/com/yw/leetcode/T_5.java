package com.yw.leetcode;

import com.yw.util.Timing;

/**
 * @author yuanwei on 2019/8/13
 **/
public class T_5 {

    public static void main(String[] args) {
        T_5 t_5 = new T_5();
        String str = "ac";
        System.out.println(Timing.run(() -> t_5.longestPalindrome1(str)));
    }

    /**
     * 动态规划
     * 针对长度为n的字符串s，定义其最大回文子串为 F(1,n)，
     * 那么 F(1,n)=max{F(1,n-1), F(2,n)}
     */
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 1) {
            return s;
        }

        int length = s.length();
        String[][] memo = new String[length + 1][length + 1];

        return find(s, 0, length, memo);
    }

    private String find(String s, int l, int r, String[][] memo) {
        String m = memo[l][r];
        if (m != null) {
            return m;
        } else {
            String temp = s.substring(l, r);
            if (isPalindrome(temp)) {
                memo[l][r] = temp;
                return temp;
            } else {
                String s1 = find(s, l, r - 1, memo);
                memo[l][r - 1] = s1;
                String s2 = find(s, l + 1, r, memo);
                memo[l + 1][r] = s2;
                if (s1.length() < s2.length()) {
                    return s2;
                } else {
                    return s1;
                }
            }
        }
    }

    private boolean isPalindrome(String s) {
        if (s == null) {
            return false;
        }
        int length = s.length();
        if (length == 1) {
            return true;
        }
        int l = 0;
        int h = length - 1;
        while (l <= h) {
            if (s.charAt(l) != s.charAt(h)) {
                return false;
            }
            l++;
            h--;
        }
        return true;
    }

    public String longestPalindrome1(String s) {
        if (s == null || s.length() == 1) {
            return s;
        }

        int length = s.length();
        String maxStr = "";
        for (int i = 0; i < length - 1; i++) {
            String s1 = palindrome(s, i, i);
            String s2 = palindrome(s, i, i + 1);
            if (s1.length() >= s2.length() && s1.length() > maxStr.length()) {
                maxStr = s1;
            }
            if (s2.length() > s1.length() && s2.length() > maxStr.length()) {
                maxStr = s2;
            }
        }

        return maxStr;
    }

    private String palindrome(String s, int i, int j) {
        int length = s.length();
        while (i >= 0 && j >= 0 && i < length - 1 && j < length) {
            char c1 = s.charAt(i);
            char c2 = s.charAt(j);
            if (c1 == c2) {
                i--;
                j++;
            } else {
                break;
            }
        }
        if (i == j) {
            return String.valueOf(s.charAt(i));
        }
        if (j - i == 1) {
            return String.valueOf(s.charAt(i));
        }
        return s.substring(i + 1, j);
    }
}
