package org.github.learning.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * <a href="https://leetcode.com/problems/roman-to-integer/submissions/"></a>
 * Status: AC
 * Runtime: 45 ms, faster than 34.2%
 * @author peiheng.jiang create on 2019/01/30
 */
public class Title13 {

    private static final Set<Character> SP_CHAR_SET;
    private static final Set<String> SP_NUM_SET;

    static {
        SP_CHAR_SET = new HashSet<>();
        SP_CHAR_SET.add('I');
        SP_CHAR_SET.add('X');
        SP_CHAR_SET.add('C');
        SP_NUM_SET = new HashSet<>();
        SP_NUM_SET.add("IV");
        SP_NUM_SET.add("IX");
        SP_NUM_SET.add("XL");
        SP_NUM_SET.add("XC");
        SP_NUM_SET.add("CD");
        SP_NUM_SET.add("CM");
    }

    public int romanToInt(String s) {
        int index = 0;
        int sum = 0;
        while (index < s.length()) {
            char indexChar = s.charAt(index);
            if (SP_CHAR_SET.contains(indexChar) && index < s.length() - 1) {
                String spNum = String.valueOf(indexChar) + String.valueOf(s.charAt(index+1));
                if (SP_NUM_SET.contains(spNum)) {
                    sum += RomanSpNum.valueOf(spNum).num;
                    index += 2;
                    continue;
                }
            }
            sum += RomanNum.getByDoc(s.charAt(index)).num;
            index++;
        }
        return sum;
    }

    private enum RomanNum {
        I(1, 'I'),
        V(5, 'V'),
        X(10, 'X'),
        L(50, 'L'),
        C(100, 'C'),
        D(500, 'D'),
        M(1000, 'M');

        int num;
        char doc;

        RomanNum(int num, char doc) {
            this.num = num;
            this.doc = doc;
        }

        static RomanNum getByDoc(char doc) {
            for (RomanNum romanNum : RomanNum.values()) {
                if (romanNum.doc == doc) return romanNum;
            }
            return null;
        }
    }

    private enum RomanSpNum {
        IV(4),
        IX(9),
        XL(40),
        XC(90),
        CD(400),
        CM(900);

        int num;

        RomanSpNum(int num) {
            this.num = num;
        }
    }

    /**
     * Best solution
     * Rumtime: 33 ms
     * @param s
     * @return
     */
    public int romanToIntBest(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int res = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            switch (c) {
                case 'I':
                    res += res < 5 ? 1 : -1;
                    break;
                case 'V':
                    res += 5;
                    break;
                case 'X':
                    res += res < 50 ? 10 : -10;
                    break;
                case 'L':
                    res += 50;
                    break;
                case 'C':
                    res += res < 500 ? 100 : -100;
                    break;
                case 'D':
                    res += 500;
                    break;
                case 'M':
                    res += 1000;
            }
        }
        return res;
    }


    public static void main(String[] args) {
        Title13 title13 = new Title13();
        System.out.println(title13.romanToInt("IX"));
    }
}
