package main.java.com.shijx5514.leetcode;


/**
 * @author shijiaxin02
 * @date 2019/06/19
 * 位运算实现除法
 */
public class DivideTwoIntegers29 {
    public int divide(int dividend, int divisor) {
        //被除数为0
        if(dividend == 0) {
            return 0;
        }
        //
        int ans = 0;
        //确定符号位
        int sign = (dividend < 0 ^ divisor < 0) ? -1 : 1;

        //除数为1
        if (divisor == 1) {
            return dividend;
        }
        //除数是Integer.MIN_VALUE
        else if (divisor == Integer.MIN_VALUE) {
            return dividend == Integer.MIN_VALUE ? 1 : 0;
        }
        //被除数是Integer.MIN_VALUE
        if (dividend == Integer.MIN_VALUE) {
            if (divisor == -1) {
                return Integer.MAX_VALUE;
            } else {
                dividend = Integer.MAX_VALUE - Math.abs(divisor) + 1;
                ans ++;
            }
        }
        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);

        //位运算计算
        while (dividend >= divisor) {
            int temp = divisor, shift = 0;
            // in case that the temp will overflow
            while (temp <= Integer.MAX_VALUE >> 1 && temp << 1 <= dividend) {
                temp = (temp << 1);
                shift ++;
            }
            ans += (1 << shift);
            dividend -= temp;
        }
        return sign * ans;
    }
}
