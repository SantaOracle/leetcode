package org.github.learning.leetcode;

/**
 * <a href="https://leetcode.com/problems/string-to-integer-atoi/"></a>
 * Status:  AC
 * Runtime: 3 ms, faster than 24.70%
 * create by peiheng.jiang on 2019/7/10
 */
public class Title8 {

    private static final int MAX_LENGTH = 10;
    private static final int MAX_VALUE_HEAD = 214748364;
    private static final int MAX_POS_VALUE_TAIL = 7;
    private static final int MAX_NAG_VALUE_TAIL = 8;
    private static final int INVALID_NUMBER = 0;
    private static final String INVALID_NUMBER_STRING = "0";

    private static final char POS_SIGN = '+';
    private static final char NAG_SIGN = '-';

    private boolean isNagtive = false;

    public int myAtoi(String str) {
        if (str == null || "".equals(str.trim())) {
            return INVALID_NUMBER;
        }
        // 1.整理前后空格
        str = str.trim();

        // 2.提取数字部分
        String numberStr = substractAbsNumber(str);
        numberStr = decreaseZero(numberStr);
        if (INVALID_NUMBER_STRING.equals(numberStr)) {
            return INVALID_NUMBER;
        }

        // 3.判断是否越界
        boolean isOutOfBound = isOutOfBound(numberStr);

        // 4.类型转换
        return transformToInt(numberStr, isOutOfBound);
    }

    /**
     * 提取字符串当中的数字部分，不包含符号
     * @param str
     * @return  0 或者提取到的数字
     */
    private String substractAbsNumber(String str) {
        boolean startSubstract = false;
        StringBuilder builder = new StringBuilder();
        for (int index=0; index<str.length(); index++) {
            char c = str.charAt(index);
            if (!startSubstract) {
                if (POS_SIGN == c) {
                    // 遇到的第一个字符是 +
                    startSubstract = true;
                } else if (NAG_SIGN == c) {
                    // 遇到的第一个字符是 -
                    isNagtive = true;
                    startSubstract = true;
                } else if (Character.isDigit(c)) {
                    // 遇到的第一个字符是数字
                    builder.append(c);
                    startSubstract = true;
                } else {
                    return INVALID_NUMBER_STRING;
                }
            } else {
                if (Character.isDigit(c)) {
                    builder.append(c);
                } else {
                    break;
                }
            }
        }
        String res = builder.toString();
        return "".equals(res) ? INVALID_NUMBER_STRING : res;
    }

    /**
     * 删除数字前的一坨0
     * @param numberStr
     * @return
     */
    private String decreaseZero(String numberStr) {
        if (INVALID_NUMBER_STRING.equals(numberStr)) {
            return numberStr;
        }
        int substringStartIndex = 0;
        while (substringStartIndex < numberStr.length()
                && '0' == numberStr.charAt(substringStartIndex)) {
            substringStartIndex++;
        }
        return substringStartIndex >= numberStr.length() ?
                INVALID_NUMBER_STRING : numberStr.substring(substringStartIndex);
    }

    /**
     * 判断是否越界
     * @param numberStr
     * @return
     */
    private boolean isOutOfBound(String numberStr) {
        if (numberStr.length() > MAX_LENGTH) {
            // 截取的数字，整体长度大于Integer.MAX的长度
            return true;
        }
        if (numberStr.length() == MAX_LENGTH) {
            // 截取的数字，整体长度等于Integer.MAX的长度
            int head = Integer.valueOf(numberStr.substring(0, numberStr.length() - 1));
            int tail = Integer.valueOf(numberStr.substring(numberStr.length() - 1));

            if (head > MAX_VALUE_HEAD) {
                // 头部部分大于214748364
                return true;
            } else if (head == MAX_VALUE_HEAD) {
                // 头部部分等于214748364
                if (!isNagtive && tail > MAX_POS_VALUE_TAIL) return true;
                if (isNagtive && tail > MAX_NAG_VALUE_TAIL) return true;
            }
        }
        return false;
    }

    /**
     * 转化成int
     * @param numberStr
     * @param isOutOfBound
     * @return
     */
    private int transformToInt(String numberStr, boolean isOutOfBound) {
        if (isOutOfBound) {
            if (!isNagtive) return Integer.MAX_VALUE;
            else return Integer.MIN_VALUE;
        }
        if (isNagtive) {
            return Integer.valueOf("-" + numberStr);
        } else {
            return Integer.valueOf(numberStr);
        }
    }

    public static void main(String[] args) {
        Title8 title8 = new Title8();
        System.out.println(title8.myAtoi("    0000000000000   "));
    }
}
