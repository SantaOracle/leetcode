package com.yw.leetcode;

/**
 * @author yuanwei on 2019/8/23
 **/
public class T_12 {

    private static final int[] BASE = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    private static final String[] ELEMS = new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V",
            "IV", "I"};

    public static void main(String[] args) {
        T_12 t_12 = new T_12();
        System.out.println(t_12.intToRoman(3));
        System.out.println(t_12.intToRoman(4));
        System.out.println(t_12.intToRoman(9));
        System.out.println(t_12.intToRoman(49));
        System.out.println(t_12.intToRoman(58));
        System.out.println(t_12.intToRoman(128));
        System.out.println(t_12.intToRoman(1994));
    }

    public String intToRoman(int num) {
        StringBuilder builder = new StringBuilder();
        int length = BASE.length;
        for (int i = 0; i < length; i++) {
            int len = num / BASE[i];
            for (int j = 0; j < len; j++) {
                builder.append(ELEMS[i]);
            }
            num = num % BASE[i];
        }
        return builder.toString();
    }
}
