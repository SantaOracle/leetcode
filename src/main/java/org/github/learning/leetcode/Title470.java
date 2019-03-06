package org.github.learning.leetcode;

import java.util.Random;

/**
 *  <a href="https://leetcode.com/problems/implement-rand10-using-rand7/"></a>
 *  Status: AC
 *  Runtime: 5 ms, faster than 88.89%
 * @author peiheng.jiang create on 2019/03/06
 */
public class Title470 {

    private static final Random random = new Random();

    private int rand7() {
        return Math.abs(random.nextInt() % 7) + 1;
    }

    public int rand10() {
        int a = rand7();
        int b = rand7();
        if (a > 4 && b < 4) {
            return rand10();
        }
        return (a + b) % 10 + 1;
    }

    public static void main(String[] args) {
        Title470 title470 = new Title470();
        System.out.println(title470.rand10());
    }
}
