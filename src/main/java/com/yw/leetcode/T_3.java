package com.yw.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author yuanwei on 2019/8/12
 **/
public class T_3 {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int max = 1;
        int cur;
        char[] chars = s.toCharArray();
        int length = chars.length;
        for (int i = 0; i < length; i++) {
            Set<Character> set = new HashSet<>();
            set.add(chars[i]);
            for (int j = i + 1; j < length; j++) {
                if (!set.contains(chars[j])) {
                    set.add(chars[j]);
                    cur = j - i + 1;
                    if (cur > max) {
                        max = cur;
                    }
                } else {
                    break;
                }
            }
        }
        return max;
    }

    public int lengthOfLongestSubstring1(String s) {
        int n = s.length();
        int ans = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)) + 1, i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j);
        }
        return ans;
    }
}
