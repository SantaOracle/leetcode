package org.github.learning.leetcode;

import java.util.*;

/**
 * <a href="https://leetcode.com/problems/group-anagrams/"></a>
 * Status:  AC
 * Runtime: 10 ms, faster than 89.48%
 * @author peiheng.jiang create on 2019/04/08
 */
public class Title49 {

    private static final Map<Character, Integer> PRIME_CACHE;

    static {
        Map<Character, Integer> cache = new HashMap<>(35);
        cache.put('a', 2);
        cache.put('b', 3);
        cache.put('c', 5);
        cache.put('d', 7);
        cache.put('e', 11);
        cache.put('f', 13);
        cache.put('g', 17);
        cache.put('h', 19);
        cache.put('i', 23);
        cache.put('j', 29);
        cache.put('k', 31);
        cache.put('l', 37);
        cache.put('m', 41);
        cache.put('n', 43);
        cache.put('o', 47);
        cache.put('p', 53);
        cache.put('q', 59);
        cache.put('r', 61);
        cache.put('s', 67);
        cache.put('t', 71);
        cache.put('u', 73);
        cache.put('v', 79);
        cache.put('w', 83);
        cache.put('x', 89);
        cache.put('y', 97);
        cache.put('z', 101);
        PRIME_CACHE = cache;
    }

    /**
     * My solution
     * 26个英文字母用质数进行标记
     * 遍历每一个字符串时，hash策略为，对每一个字符对应的质数进行相乘
     * 把hash值和字符串存到一个map里
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) {
            return Collections.emptyList();
        }
        Map<Integer, List<String>> resMap = new HashMap<>();
        for (String s : strs) {
            int hash = hash(s);
            List<String> list = resMap.get(hash);
            if (list == null) {
                list = new ArrayList<>();
            }
            list.add(s);
            resMap.put(hash, list);
        }
        return new ArrayList<>(resMap.values());
    }

    private int hash(String s) {
        int bucket = 1;
        for (int index = 0; index < s.length(); index++) {
            char c = s.charAt(index);
            bucket *= PRIME_CACHE.get(c);
        }
        return bucket;
    }

    public static void main(String[] args) {
        Title49 title49 = new Title49();
        List<List<String>> res = title49.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
        System.out.println(res);
    }
}
