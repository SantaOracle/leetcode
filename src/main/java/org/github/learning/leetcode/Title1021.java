package org.github.learning.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.stream.IntStream;

/**
 * <a href="https://leetcode-cn.com/problems/remove-outermost-parentheses/"></a>
 * Status: AC
 * Runtime: 5 ms, faster than 62.33%
 * @author jiangpeiheng create on 2020/6/30
 */
public class Title1021 {

    private static final char LEFT_BRACKET = '(';
    private static final char RIGHT_BRACKET = ')';

    public String removeOuterParentheses(String S) {
        if (S == null || S.equals("")) {
            return "";
        }

        StringBuilder builder = new StringBuilder(S.length());
        Deque<Character> stack = new ArrayDeque<>();

        IntStream.rangeClosed(0, S.length() - 1).forEach(index -> {
            char c = S.charAt(index);
            boolean append = true;
            if (c == LEFT_BRACKET) {
                if (stack.isEmpty()) {
                    append = false;
                }
                stack.push(c);
            } else {
                if (stack.size() == 1) {
                    append = false;
                }
                stack.pop();
            }
            if (append) builder.append(c);
        });

        return builder.toString();
    }

    public static void main(String[] args) {
        Title1021 t = new Title1021();
        System.out.println(t.removeOuterParentheses("(()())(())(()(()))"));
    }
}
