package org.github.learning.leetcode;

import java.util.*;

/**
 *  <a href="https://leetcode.com/problems/substring-with-concatenation-of-all-words/"></a>
 * Status: AC
 * Runtime: 55 ms, faster than 69.18%
 * @author peiheng.jiang create on 2019/04/12
 */
public class Title30 {

    List<Integer> res;
    Map<String, Integer> cache;

    public List<Integer> findSubstring(String s, String[] words) {
        // validate params
        if (s == null || s.length() == 0 || words == null || words.length == 0) {
            return Collections.emptyList();
        }
        // init
        res = new ArrayList<>();
        cache = new HashMap<>();
        for (String word : words) {
            Integer cnt = cache.get(word);
            if (cnt == null) {
                cnt = 0;
            }
            cache.put(word, ++cnt);
        }
        // init cal params
        int wordLength = words[0].length();
        int matchLength = words.length * wordLength;
        Map<Integer, String> stringForMatch = new HashMap<>();
        int loopIndex = 0;
        while (loopIndex + matchLength <= s.length()) {
            String subString = s.substring(loopIndex, loopIndex + wordLength);
            if (cache.get(subString) != null) {
                stringForMatch.put(loopIndex, s.substring(loopIndex, loopIndex + matchLength));
            }
            loopIndex++;
        }
        // start cal
        List<Integer> res = new ArrayList<>();
        for (Map.Entry<Integer, String> entry : stringForMatch.entrySet()) {
            if (isMatch(entry.getValue(), wordLength)) {
                res.add(entry.getKey());
            }
        }
        return res;
    }

    private Map<String, Integer> resetCache() {
        return new HashMap<>(cache);
    }

    private boolean isMatch(String forMatch, int wordLength) {
        Map<String, Integer> cacheCopy = resetCache();
        int index = 0;
        while (index + wordLength <= forMatch.length()) {
            String subWord = forMatch.substring(index, index + wordLength);
            Integer cnt = cacheCopy.get(subWord);
            if (cnt == null || cnt == 0) {
                return false;
            }
            cacheCopy.put(subWord, --cnt);
            index += wordLength;
        }
        return true;
    }

    public static void main(String[] args) {
        Title30 title30 = new Title30();
        String s = "aaaaaaaa";
        String[] words = new String[]{"aa","aa","aa"};
        List<Integer> res = title30.findSubstring(s, words);
        res.forEach(index -> System.out.println(index));
    }
}
