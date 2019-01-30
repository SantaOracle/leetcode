package org.github.learning.leetcode;

/**
 * <a href="https://leetcode.com/problems/palindrome-number/"></a>
 * Status: AC
 * Runtime: 81 ms, faster than 55.68%
 * @author peiheng.jiang create on 2019/01/30
 */
public class Title9 {

    /**
     * My solution
     * @param x
     * @return
     */
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        if (x != 0 && x % 10 == 0) return false;
        String str = String.valueOf(x);
        boolean result = true;
        int highIndex = str.length() - 1;
        int lowIndex = 0;
        if (highIndex == -1) return true;
        while (highIndex >= lowIndex) {
            if (str.charAt(highIndex) != str.charAt(lowIndex)) return false;
            highIndex--;
            lowIndex++;
        }
        return true;
    }

    /**
     * Best solution
     * Runtime: 70 ms
     * @param x
     * @return
     */
    public boolean isPalindromeBest(int x) {
        if(x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }
        int revertedNumber = 0;
        while(x > revertedNumber) {
            revertedNumber = revertedNumber * 10 + x % 10;
            x /= 10;
        }
        return x == revertedNumber || x == revertedNumber/10;
    }

    public static void main(String[] args) {
        Title9 title9 = new Title9();
        System.out.println(title9.isPalindrome(-121));
    }
}
