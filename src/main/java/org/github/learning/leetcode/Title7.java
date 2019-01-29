package org.github.learning.leetcode;

/**
 * <a href="https://leetcode.com/problems/reverse-integer/"></a>
 * Status: AC
 * Runtime: 16 ms faster than 96.50%
 * @author peiheng.jiang create on 2019/01/29
 */
public class Title7 {

    private static final int POS_OVERFLOW = Integer.MAX_VALUE / 10;
    private static final int POS_OVERFLOW_UNIT = Integer.MAX_VALUE % 10;
    private static final int NAG_OVERFLOW = Integer.MIN_VALUE / 10;
    private static final int NAG_OVERFLOW_UNIT = Integer.MIN_VALUE % 10;

    public int reverse(int x) {
        int sum = 0;
        while (x != 0) {
            int unit = x % 10;
            if (willOverflow(sum, unit)) {
                sum = 0;
                break;
            }
            sum = sum * 10 + unit;
            x /= 10;
        }
        return sum;
    }

    private boolean willOverflow(int num, int unit) {
        if (num >= 0) {
            return (num > POS_OVERFLOW) || (num == POS_OVERFLOW && unit > POS_OVERFLOW_UNIT);
        }
        return (num < NAG_OVERFLOW) || (num == NAG_OVERFLOW && unit < NAG_OVERFLOW_UNIT);
    }

    public static void main(String[] args) {
        Title7 title7 = new Title7();
        System.out.println(title7.reverse(1534236469));
        System.out.println(title7.reverse(-2147483412));
    }
}
