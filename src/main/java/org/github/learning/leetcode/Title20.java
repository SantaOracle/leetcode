package org.github.learning.leetcode;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * <a href="https://leetcode.com/problems/valid-parentheses/"></a>
 *  Status: AC
 *  Runtime: 8 ms, faster than 13.95%
 * @author peiheng.jiang create on 2019/01/30
 */
public class Title20 {

    private Stack<Character> signStack;
    private static final Set<Character> LEFT_SIGN_SET;
    private static final Set<Character> RIGHT_SIGN_SET;

    static {
        LEFT_SIGN_SET = new HashSet<>();
        LEFT_SIGN_SET.add('(');
        LEFT_SIGN_SET.add('[');
        LEFT_SIGN_SET.add('{');
        RIGHT_SIGN_SET = new HashSet<>();
        RIGHT_SIGN_SET.add(')');
        RIGHT_SIGN_SET.add(']');
        RIGHT_SIGN_SET.add('}');
    }

    /**
     * My solution
     * @param s
     * @return
     */
    public boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        signStack = new Stack<>();
        for (int i=0; i<s.length(); i++) {
            if (!isSignValid(s.charAt(i))) {
                return false;
            }
        }
        return signStack.empty();
    }

    private boolean isSignValid(char sign) {
        if (LEFT_SIGN_SET.contains(sign)) {
            signStack.push(sign);
            return true;
        }
        if (RIGHT_SIGN_SET.contains(sign)) {
            if (signStack.empty()) {
                return false;
            }
            return signStack.pop() == SignPair.getCorresponding(sign);
        }
        return true;
    }

    private enum SignPair {
        L1('(', ')'),
        L2('[', ']'),
        L3('{', '}');

        char left;
        char right;

        SignPair(char left, char right) {
            this.left = left;
            this.right = right;
        }

        public static char getCorresponding(char right) {
            for (SignPair pair : SignPair.values()) {
                if (pair.right == right) {
                    return pair.left;
                }
            }
            return '\0';
        }
    }

    /**
     * Best solution
     * Runtime: 3 ms
     * @param s
     * @return
     */
    public boolean isValidBest(String s) {
        boolean isValid = true;

        char[] characters = s.toCharArray();

        int stackSize = 0;
        char[] stack = new char[characters.length];

        for (int index = 0; isValid && (index < characters.length); ++index) {
            char thisChar = s.charAt(index);

            if (thisChar == ')') {
                //  case ')':
                if ((stackSize > 0) && (stack[stackSize-1] == '(')) {
                    --stackSize;
                } else {
                    isValid = false;
                }
                //  break;
            }else if(thisChar == '}')  {
                if ((stackSize > 0) && (stack[stackSize-1] == '{')) {
                    --stackSize;
                } else {
                    isValid = false;
                }
                // break;
            } else if(thisChar == ']'){
                if ((stackSize > 0) && (stack[stackSize-1] == '[')) {
                    --stackSize;
                } else {
                    isValid = false;
                }
                //   break;
            }else{
                stack[stackSize++] = thisChar;
                //  break;
            }
            // case '}':

            //  case ']':

            // default:

            // }
        }

        return isValid && (stackSize == 0);
    }

    public static void main(String[] args) {
        Title20 title20 = new Title20();
        String s = "([)]";
        System.out.println(title20.isValid(s));
    }
}
