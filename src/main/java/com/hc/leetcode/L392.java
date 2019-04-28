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
    //9 ms	51.2 MB	java
    public boolean isSubsequence1(String s, String t) {
        int index = 0;
        for(int i = 0; i < s.length(); i++){
            char find = s.charAt(i);
            boolean finded = false;
            for(int m = index; m < t.length(); m++){
                char to = t.charAt(m);
                if(to == find){
                    index = m+1;
                    finded = true;
                    break;
                }
            }
            if(!finded){
                return false;
            }
        }

        return true;
    }
    /**
    Runtime: 14 ms, faster than 70.10% of Java online submissions for Is Subsequence.
    Memory Usage: 51.1 MB, less than 25.00% of Java online submissions for Is Subsequence.
     **/
    public boolean isSubsequence3(String s, String t) {
        int index = 0;
        boolean finded = false;
        for(int i = 0; i < s.length(); i++){
            char find = s.charAt(i);

            for(int m = index; m < t.length(); m++){
                char to = t.charAt(m);
                if(to == find){
                    index = m+1;
                    finded = true;
                    break;
                }
            }
            if(!finded){
                return false;
            }else{
                finded = false;
            }
        }

        return true;
    }
}
