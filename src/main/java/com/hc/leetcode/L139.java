package com.hc.leetcode;

import java.util.*;

public class L139 {
    /**
     * 备忘录一般记录的是子问题的答案。
     * 子问题之间是有关联性的。
     * 递归解法 Time Limit Exceeded 超时
     * @param s
     * @param wordDict
     * @return
     */
    public boolean wordBreak(String s, List<String> wordDict) {

        Iterator<String> iterator = wordDict.iterator();
        while(iterator.hasNext()){
            String word = iterator.next();
            if(s.length() >= word.length() && s.substring(0,word.length()).equals(word)){
                if(s.substring(word.length()).equals("")){
                    return true;
                }
                if(wordBreak(s.substring(word.length()),wordDict)){
                    return true;
                }else{
                    continue;
                }
            }else{
                continue;
            }

        }
        return false;
    }

    /**
     * p(i) = p(i-h) && s(i-h,i)
     * 即从小的index开始，倒着看是否有word可以对应，再加个备忘录。
     * @param s
     * @param wordDict
     * @return
     */
    public boolean wordBreakDP(String s, List<String> wordDict){

        Set<String> sets = new HashSet<>(wordDict);
        boolean[] memo = new boolean[s.length() + 1];
        memo[0] = true;
        for(int i = 1; i < s.length() + 1; i++){
            for(int j = i -1 ; j >= 0; j-- ) {
                if (sets.contains(s.substring(j, i)) && memo[j]) {
                    memo[i] = true;
                }
            }

        }
        return memo[s.length()];

    }

    public static void main(String[] args){
        String[] dict = new String[]{"car","ca","rs"};
        List<String> wordDict = Arrays.asList(dict);
        String s = "cars";
        System.out.println(new L139().wordBreak(s,wordDict));
    }
}
