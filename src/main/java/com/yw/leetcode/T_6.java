package com.yw.leetcode;

import com.yw.util.Timing;

/**
 * @author yuanwei on 2019/8/14
 **/
public class T_6 {

    public static void main(String[] args) {
        T_6 t_6 = new T_6();
        System.out.println(Timing.run(() -> t_6.convert("LEETCODEISHIRING", 4)));
        System.out.println("LDREOEIIECIHNTSG");
    }

    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        StringBuilder builder = new StringBuilder(s.length());
        for (int i = 0; i < numRows; i++) {
            boolean flag = true;
            for (int j = i; j < s.length(); ) {
                builder.append(s.charAt(j));
                if (i == 0 || i == numRows - 1) {
                    j = j + 2 * (numRows - 2) + 2;
                } else {
                    if (flag) {
                        j = j + 2 * (numRows - i - 2) + 2;
                        flag = false;
                    } else {
                        j = j + (i - 1) * 2 + 2;
                        flag = true;
                    }
                }
            }
        }
        return builder.toString();
    }
}
