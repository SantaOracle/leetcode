package com.shijx5514.leetcode;


/**
 * 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式
 * lc 43
 * <p>
 */
public class multiply43 {

    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        int length1 = num1.length();
        int length2 = num2.length();
        StringBuilder str = new StringBuilder();

        int[] arrayInt = new int[length1 + length2];

        for (int i = length1 - 1; i >= 0; i--) {
            for (int z = length2 - 1; z >= 0; z--) {
                int number1 = num1.charAt(i) - 48;
                int number2 = num2.charAt(z) - 48;
                arrayInt[i + z] += number1 * number2;
                if (arrayInt[i + z] >= 10 && (i + z) != 0) {
                    arrayInt[i + z - 1] += arrayInt[i + z] / 10;
                    arrayInt[i + z] = arrayInt[i + z] % 10;
                }
            }
        }

        for (int i = 0; i <= length1 + length2 - 2; i++) {
            str.append(arrayInt[i]);
        }

        return str.toString();
    }
}
