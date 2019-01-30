package com.hc.leetcode;

/**
 * Runtime: 3 ms, faster than 100.00% of Java online submissions for Valid Parentheses.
 */
public class LeetCode20 {
    public boolean isValid(String s) {

        char[] stack = new char[s.length()];
        int head = -1;
        char[] charArray = s.toCharArray();
        for (char c : charArray) {
            switch (c){
                case '(':
                case '[':
                case '{':
                    stack[++ head] = c;
                    break;
                case ')':
                    if(head == -1){
                        return false;
                    }
                    if(stack[head] != '('){
                        return false;
                    }
                    head --;
                    break;
                case ']':
                    if(head == -1){
                        return false;
                    }
                    if(stack[head] != '['){
                        return false;
                    }
                    head --;
                    break;
                case '}':
                    if(head == -1){
                        return false;
                    }
                    if(stack[head] != '{'){
                        return false;
                    }
                    head --;
                    break;

            }
        }
        if(head == -1){
            return true;
        }

        return false;
    }
}
