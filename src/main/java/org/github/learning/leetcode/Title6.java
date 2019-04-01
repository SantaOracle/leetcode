package org.github.learning.leetcode;

/**
 * <a href="https://leetcode.com/problems/zigzag-conversion/"></a>
 * Status:  AC
 * Runtime: 5 ms, faster than 98.19%
 * @author peiheng.jiang create on 2019/04/01
 */
public class Title6 {

    /**
     * My solution
     * 构造每行的StringBuilder
     * 遍历一遍字符串，把每个字符填到指定行的StringBuilder里
     * @param s
     * @param numRows
     * @return
     */
    public String convert(String s, int numRows) {
        if (s == null || s.length() == 0 || numRows <= 0) {
            return "";
        }
        if (numRows == 1) {
            return s;
        }
        // init each line string builder
        StringBuilder[] builders = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            builders[i] = new StringBuilder();
        }
        // fill each line's string builder
        int index = 0;
        while (index < s.length()) {
            for (int line = 0; line < numRows && index < s.length(); line++) {
                builders[line] = builders[line].append(s.charAt(index++));
            }
            for (int line = numRows - 2; line >= 1 && index < s.length(); line--) {
                builders[line] = builders[line].append(s.charAt(index++));
            }
        }
        // concat result
        StringBuilder resBuilder = new StringBuilder();
        for (int line = 0; line < numRows; line++) {
            resBuilder.append(builders[line]);
        }
        return resBuilder.toString();
    }

    public static void main(String[] args) {
        Title6 title6 = new Title6();
        System.out.println(title6.convert("LEETCODEISHIRING", 4));
    }
}
