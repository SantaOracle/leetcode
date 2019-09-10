package com.shijx5514.leetcode;



import java.util.*;

/**
 * lc 49
 *
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 */
public class GroupAnagrams49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> resultMap = new HashMap<>();
        for(int i=0 ; i< strs.length; i++) {
            char[] value = strs[i].toCharArray();
            Arrays.sort(value);
            String key = String.valueOf(value);
            if(resultMap.get(key) == null) {
                List<String> temp = new ArrayList<>();
                temp.add(strs[i]);
                resultMap.put(key, temp);
            } else {
                resultMap.get(key).add(strs[i]);
            }
        }
        List<List<String>> resultList = new ArrayList<>();
        for(String key : resultMap.keySet()) {

            resultList.add(resultMap.get(key));
        }
        return resultList;
    }

    public static void main(String[] args) {
        String[] arrays = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        GroupAnagrams49 groupAnagrams49 = new GroupAnagrams49();
        System.out.println(groupAnagrams49.groupAnagrams(arrays));
    }
}
