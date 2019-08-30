package com.yw.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yuanwei on 2019/8/29
 **/
public class T_13 {

    public static void main(String[] args) {
        T_13 t_13 = new T_13();
        System.out.println(t_13.romanToInt("III"));
        System.out.println(t_13.romanToInt("IV"));
        System.out.println(t_13.romanToInt("IX"));
        System.out.println(t_13.romanToInt("LVIII"));
        System.out.println(t_13.romanToInt("MCMXCIV"));
    }

    private static final Map<String, Integer> MAP = new HashMap<>();

    static {
        MAP.put("M", 1000);
        MAP.put("CM", 900);
        MAP.put("D", 500);
        MAP.put("CD", 400);
        MAP.put("C", 100);
        MAP.put("XC", 90);
        MAP.put("L", 50);
        MAP.put("XL", 40);
        MAP.put("X", 10);
        MAP.put("IX", 9);
        MAP.put("V", 5);
        MAP.put("IV", 4);
        MAP.put("I", 1);
    }

    public int romanToInt(String s) {
        int sum = 0;
        int length = s.length();
        String cur;
        String next;
        int curVal;
        int nextVal;
        int i = 0;
        while (i < length) {
            if (i == length - 1) {
                sum += MAP.get(s.substring(i, i + 1));
                i++;
            } else {
                cur = s.substring(i, i + 1);
                next = s.substring(i + 1, i + 2);
                curVal = MAP.get(cur);
                nextVal = MAP.get(next);
                if (curVal < nextVal) {
                    sum -= curVal;
                    sum += nextVal;
                    i = i + 2;
                } else {
                    sum += curVal;
                    i++;
                }
            }
        }
        return sum;
    }
}
