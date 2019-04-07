package com.hc.leetcode;

import java.util.HashMap;
import java.util.Map;

public class L3 {
    public int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        Map<Character,Integer> map = new HashMap<>();
        int start = 0;
        int max = 0;
        int tmpMax = 0;
        for(int i = 0; i < chars.length; i ++){
            char c = chars[i];
            if(map.get(c) != null && map.get(c) >= start){
                if(tmpMax > max){
                    max = tmpMax;
                }
                tmpMax = i - map.get(c);
                start = map.get(c) + 1;
            }else{
                tmpMax++;
            }
            map.put(c,i);
        }
        if(tmpMax > max){
            max = tmpMax;
        }
        return max;
    }
}
