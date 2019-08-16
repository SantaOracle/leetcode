package com.yw.leetcode;

import com.yw.util.Timing;

/**
 * @author yuanwei on 2019/8/14
 **/
public class T_7 {

    public static void main(String[] args) {
        T_7 t_7 = new T_7();
        System.out.println(Timing.run(() -> t_7.reverse(-2147483648)));
    }

    public int reverse(int x) {
        if (x < 10 && x > -10) {
            return x;
        }
        boolean negative = x < 0;
        StringBuilder builder = new StringBuilder();
        String s = String.valueOf(x);
        if (negative) {
            for (int i = s.length() - 1; i > 0; i--) {
                builder.append(s.charAt(i));
            }
            long l = Long.parseLong(builder.toString());
            if (l > (long) Math.pow(2, 31)) {
                return 0;
            } else {
                return (int) -l;
            }
        } else {
            for (int i = s.length() - 1; i >= 0; i--) {
                builder.append(s.charAt(i));
            }
            long l = Long.parseLong(builder.toString());
            if (l > (long) Math.pow(2, 31) - 1) {
                return 0;
            } else {
                return (int) l;
            }
        }
    }
}
