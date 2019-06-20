package main.java.com.shijx5514.leetcode;


/**
 * @author shijiaxin02
 * @date 2019/06/19
 */
public class ImplementStrStr28 {
    public int strStr(String haystack, String needle) {
        if (needle.length() == 0) {
            return 0;
        }
        int i = 0, j = needle.length(), needleHash = needle.hashCode();
        while (j <= haystack.length()) {
            String substr = haystack.substring(i, j);
            if (substr.hashCode() == needleHash) {
                return i;
            } else {
                ++i;
                ++j;
            }
        }
        return -1;
    }

}
