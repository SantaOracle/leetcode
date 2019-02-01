package org.github.learning.leetcode;

/**
 * <a href="https://leetcode.com/problems/implement-strstr/"></a>
 * Status: AC
 * Runtime: 4 ms, faster than 72.54%
 * @author peiheng.jiang create on 2019/2/1
 */
public class Title28 {

    private static final String EMPTY_STRING = "";

    /**
     * My solution
     * @param haystack
     * @param needle
     * @return
     */
    public int strStr(String haystack, String needle) {
        if (needle == null || EMPTY_STRING.equals(needle)) {
            return 0;
        }
        if (haystack == null || EMPTY_STRING.equals(haystack)) {
            return -1;
        }
        for (int index = 0; index <= haystack.length() - needle.length(); index++) {
            if (contains(haystack, needle, index)) {
                return index;
            }
        }
        return -1;
    }

    private boolean contains(String haystack, String needle, int startIndex) {
        for (int scanIndex = 0; scanIndex < needle.length(); scanIndex++) {
            if (needle.charAt(scanIndex) != haystack.charAt(scanIndex + startIndex)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Best solution
     * Runtime: 3 ms
     * @param haystack
     * @param needle
     * @return
     */
    public int strStrBest(String haystack, String needle) {
        int n = needle.length();
        int m = haystack.length();
        if (n > m) return -1;
        for (int i = 0; i < m - n + 1; i++) {
            if (haystack.substring(i, n+i).equals(needle)) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Title28 title28 = new Title28();
        System.out.println(title28.strStr("a", "a"));
    }
}
