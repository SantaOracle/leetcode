package org.github.learning.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/longest-substring-without-repeating-characters/"></a>
 * Status:  AC
 * Runtime: 7 ms, faster than 82.41%
 * create by peiheng.jiang on 2019/7/22
 */
public class Title3 {

    public int lengthOfLongestSubstring(String s) {
        if (s == null || "".equals(s)) {
            return 0;
        }
        int max = 0;
        int left = 0;
        // 存储字符串当中的字符，以及该字符最近一次出现的位置
        Map<Character, Integer> nearlyIndexMap = new HashMap<>(s.length());
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (nearlyIndexMap.containsKey(c)) {
                left = Math.max(left, nearlyIndexMap.get(s.charAt(i)) + 1);
            }
            nearlyIndexMap.put(c, i);
            max = Math.max(max, i - left + 1);
        }
        return max;
    }
}
