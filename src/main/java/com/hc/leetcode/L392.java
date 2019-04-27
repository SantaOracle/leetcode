package com.hc.leetcode;

/**
 * TODO:FASTER WAY
 * Runtime: 24 ms, faster than 32.76% of Java online submissions for Is Subsequence.
 * Memory Usage: 49.9 MB, less than 92.73% of Java online submissions for Is Subsequence.
 * Created by congcong.han on 2019/4/27.
 */
public class L392 {
    public boolean isSubsequence(String s, String t) {
        int index = 0;
        int count = 0;
        for(int i = 0; i < s.length(); i++){
            char find = s.charAt(i);
            boolean finded = false;
            for(int m = index; m < t.length(); m++){
                char to = t.charAt(m);
                if(to == find){
                    index = m+1;
                    count ++;
                    finded = true;
                    break;
                }
            }
            if(!finded){
                return false;
            }
        }

        if(count == s.length()){
            return true;
        }
        return false;
    }
}
