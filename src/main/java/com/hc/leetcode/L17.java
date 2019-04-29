package com.hc.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Runtime: 1 ms, faster than 87.93% of Java online submissions for Letter Combinations of a Phone Number.
 * Memory Usage: 37.1 MB, less than 84.95% of Java online submissions for Letter Combinations of a Phone Number.
 */
public class L17 {
    char[][] dMap = new char[10][4];
    L17(){
        dMap[2] = new char[]{'a', 'b', 'c'};
        dMap[3] = new char[]{'d','e','f'};
        dMap[4] = new char[]{'g','h','i'};
        dMap[5] = new char[]{'j','k','l'};
        dMap[6] = new char[]{'m','n','o'};
        dMap[7] = new char[]{'p','q','r','s'};
        dMap[8] = new char[]{'t','u','v'};
        dMap[9] = new char[]{'w','x','y','z'};
    }
    public List<String> letterCombinations(String digits) {
        List<String> ret = new ArrayList<>();
        if(digits.length() == 0){
            return ret;
        }
        doLetterCombinations(digits, 0, ret,new StringBuilder());
        return ret;
    }

    private void doLetterCombinations(String digits, int i,List<String> ret, StringBuilder builder) {
        char index = digits.charAt(i);
        int ci = Integer.parseInt(index + "");
        char[] d = dMap[ci];
        for (int i1 = 0; i1 < d.length; i1++) {
            char toAppend = d[i1];
            builder.append(toAppend);
            if(i == digits.length() - 1){
                ret.add(builder.toString());
                builder.deleteCharAt(builder.length() - 1);
            }else{
                int nexti = i + 1;
                doLetterCombinations(digits,nexti,ret,builder);
                builder.deleteCharAt(builder.length() - 1);
            }
        }

    }

    public static void main(String[] args){
        String d = "24687";
        List<String> ret = new L17().letterCombinations(d);
        for(String r : ret){
            System.out.println(r);
        }
    }
}
