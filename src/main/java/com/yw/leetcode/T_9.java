package com.yw.leetcode;

/**
 * @author yuanwei on 2019/8/16
 **/
public class T_9 {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        if (x <= 9) {
            return true;
        }
        String s = String.valueOf(x);
        int length = s.length();
        int i = 0;
        int j = length - 1;
        while (i <= j) {
            if (s.charAt(i++) != s.charAt(j--)) {
                return false;
            }
        }
        return true;
    }
}
