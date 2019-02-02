package com.shijx5514.leetcode;


import java.util.Stack;

/**
 * leetcode20
 * @author shijiaxin02
 * @date 2019/02/02
 */
public class ValidParentheses {
    public boolean isValid(String s) {
        Stack<Integer> a = new Stack();

        for(int  i = 0; i<s.length();i++) {
            if(s.charAt(i) == '{') {
                a.push(1);
            }
            if(s.charAt(i) == '(') {
                a.push(2);
            }
            if(s.charAt(i) == '[') {
                a.push(3);
            }
            if(s.charAt(i) == '}') {
                if(a.isEmpty()) {
                    return false;
                }
                Integer k = a.pop();
                if(!k.equals(1)) {
                    return false;
                }
            }
            if(s.charAt(i) == ')') {
                if(a.isEmpty()) {
                    return false;
                }
                Integer k = a.pop();
                if(!k.equals(2)) {
                    return false;
                }
            }
            if(s.charAt(i) == ']') {
                if(a.isEmpty()) {
                    return false;
                }
                Integer k = a.pop();
                if(!k.equals(3)) {
                    return false;
                }
            }

        }
        if(!a.isEmpty()) {
            return false;
        }
        return true;
    }
}
