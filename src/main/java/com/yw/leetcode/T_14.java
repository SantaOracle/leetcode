package com.yw.leetcode;

/**
 * @author yuanwei on 2019/8/29
 **/
public class T_14 {

    public static void main(String[] args) {
        T_14 t_14 = new T_14();
        System.out.println(t_14.longestCommonPrefix1(new String[]{"flower", "flow", "flight"}));
        System.out.println(t_14.longestCommonPrefix1(new String[]{"dog", "racecar", "car"}));
        System.out.println(t_14.longestCommonPrefix1(new String[]{"c", "c"}));
    }

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0 || strs[0] == null || strs[0].length() == 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }

        int i = 0;
        String pre = "";
        while (true) {
            if (i >= strs[0].length()) {
                return pre;
            }
            String s = strs[0].substring(0, i + 1);
            for (String str : strs) {
                if (str == null || str.length() == 0) {
                    return "";
                } else if (i >= str.length()) {
                    return str;
                } else {
                    if (!str.substring(0, i + 1).equals(s)) {
                        return pre;
                    }
                }
            }
            pre = s;
            i++;
        }
    }

    public String longestCommonPrefix1(String[] strs) {
        if (strs == null || strs.length == 0 || strs[0] == null || strs[0].length() == 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }
        String temp = strs[0];

        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(temp) != 0) {
                temp = temp.substring(0, temp.length() - 1);
                if (temp.isEmpty()) {
                    return "";
                }
            }
        }
        return temp;
    }
}
