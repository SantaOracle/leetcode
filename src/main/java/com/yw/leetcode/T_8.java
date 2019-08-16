package com.yw.leetcode;

import com.yw.util.Timing;


/**
 * @author yuanwei on 2019/8/14
 **/
public class T_8 {


    public static void main(String[] args) {
        T_8 t_8 = new T_8();
        System.out.println(Timing.run(() -> t_8.myAtoi(" fg -4564")));
        System.out.println(Timing.run(() -> t_8.myAtoi(" -0000000000000000000004564")));
        System.out.println(Timing.run(() -> t_8.myAtoi(" -0000000000000000000")));
        System.out.println(Timing.run(() -> t_8.myAtoi(" -4564 wet")));
        System.out.println(Timing.run(() -> t_8.myAtoi("sadfa -4564")));
        System.out.println(Timing.run(() -> t_8.myAtoi("-45d64")));
        System.out.println(Timing.run(() -> t_8.myAtoi("4564")));
        System.out.println(Timing.run(() -> t_8.myAtoi("+4564")));
        System.out.println(Timing.run(() -> t_8.myAtoi("+ 4564")));
        System.out.println(Timing.run(() -> t_8.myAtoi("+ 4564 sdf")));
        System.out.println(Timing.run(() -> t_8.myAtoi("-6147483648")));
    }

    public int myAtoi(String str) {
        if (str == null) {
            return 0;
        }

        str = str.trim();
        int length = str.length();
        if (length == 0) {
            return 0;
        }

        boolean positive = true;
        // 第一位
        boolean firstPlace = true;
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < length; i++) {
            char c = str.charAt(i);
            if (firstPlace) {
                firstPlace = false;
                if (c == '+') {
                    positive = true;
                } else if (c == '-') {
                    positive = false;
                } else if (c >= '0' && c <= '9') {
                    positive = true;
                    builder.append(c);
                } else {
                    return 0;
                }
            } else {
                if (c >= '0' && c <= '9') {
                    builder.append(c);
                } else {
                    break;
                }
            }
        }
        String s = removeLeadingZeros(builder.toString());
        if (s.length() == 0) {
            return 0;
        }

        if (s.length() > String.valueOf(Integer.MIN_VALUE).length() + 1) {
            if (positive) {
                return Integer.MAX_VALUE;
            } else {
                return Integer.MIN_VALUE;
            }
        }

        s = positive ? s : "-" + s;
        long l = Long.parseLong(s);
        if (l >= Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        } else if (l <= Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        } else {
            return (int) l;
        }
    }

    private String removeLeadingZeros(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }

        int i = 0;
        while (i < s.length() && s.charAt(i) == '0') {
            i++;
        }

        return s.substring(i);
    }
}
