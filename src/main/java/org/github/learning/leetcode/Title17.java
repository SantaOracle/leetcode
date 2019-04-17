package org.github.learning.leetcode;

import javafx.util.Pair;

import java.util.*;

/**
 * <a href="https://leetcode.com/problems/letter-combinations-of-a-phone-number/"></a>
 * Status: AC
 * Runtime: 2 ms, faster than 46.97%
 * @author peiheng.jiang create on 2019/04/17
 */
public class Title17 {

    List<String> result;
    String originDigits;
    LinkedList<Character> charLinks;

    /**
     * My Solution
     * @param digits
     * @return
     */
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return Collections.emptyList();
        }
        // init
        result = new ArrayList<>();
        originDigits = digits;
        charLinks = new LinkedList<>();
        // recursion
        recursion(0);
        return result;
    }

    private void recursion(int recursionDepth) {
        if (recursionDepth == originDigits.length()) {
            // record result
            recordResult();
        } else {
            Character[] chars = getChars(originDigits.charAt(recursionDepth));
            for (Character c : chars) {
                charLinks.add(c);
                recursion(recursionDepth + 1);
            }
        }

        // clean resource
        if (!charLinks.isEmpty()) {
            charLinks.removeLast();
        }
    }

    private void recordResult() {
        StringBuilder sb = new StringBuilder(charLinks.size());
        for (Character c : charLinks) {
            sb.append(c);
        }
        result.add(sb.toString());
    }

    private Character[] getChars(char num) {
        switch (num) {
            case '2':
                return new Character[]{'a', 'b', 'c'};
            case '3':
                return new Character[]{'d', 'e', 'f'};
            case '4':
                return new Character[]{'g', 'h', 'i'};
            case '5':
                return new Character[]{'j', 'k', 'l'};
            case '6':
                return new Character[]{'m', 'n', 'o'};
            case '7':
                return new Character[]{'p', 'q', 'r', 's'};
            case '8':
                return new Character[]{'t', 'u', 'v'};
            case '9':
                return new Character[]{'w', 'x', 'y', 'z'};
            default:
                return new Character[0];
        }
    }

    /***************** better solution ******************/

    String [] keypad = {" ","*","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    List<String> output = new ArrayList<>();

    /**
     * Better Solution
     * @param digits
     * @return
     */
    public List<String> letterCombinationsBetter(String digits) {
        if(digits.equals("") ){
            return output;
        }
        if(digits.equals("0") || digits.equals("1")){
            return Arrays.asList(keypad[Integer.valueOf(digits)]);
        }

        combine("",digits);
        return output;
    }
    //currentString =""     //nextDigits =23
    private void combine(String currentString, String nextDigits){
        if(nextDigits.length() == 0){
            output.add(currentString);
            return ;
        }
        int digit=Integer.valueOf(nextDigits.substring(0,1)); //2
        String s = keypad[digit]; //s = abc
        char[] chars = s.toCharArray(); //{a,b,c}

        for(char c : chars){ //c=a
            String temp = currentString+c; //a
            //backtrack using the current char and charset from next String
            //temp=a  //nextDigits =3
            combine(temp , nextDigits.substring(1));
        }
    }
}
