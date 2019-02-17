package org.github.learning.leetcode;

/**
 * <a href="https://leetcode.com/problems/longest-palindromic-substring/"></a>
 * Status:  AC
 * Runtime: 10 ms, faster than 94.11%
 * @author peiheng.jiang create on 2019/2/17
 */
public class Title5 {

    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        int start = 0;
        int end = 0;
        // 遍历中心
        for (int mid=0; mid < s.length(); mid++) {
            // 计算类似于aba这样的回文串长度
            int singleMidLength = calculatePalindromeLength(s, mid, mid);
            // 计算类似于abba这样的回文串长度
            int doubleMidLength = calculatePalindromeLength(s, mid, mid + 1);
            // 取最长的长度
            int length = Math.max(singleMidLength, doubleMidLength);
            // 更新最长长度
            if (length > end - start) {
                start = mid - (length - 1) / 2;
                end = mid + length / 2;
            }
        }
        // 由于substring方法是截取[start, end)，所以截取的时候需要多截一位
        return s.substring(start, end + 1);
    }

    /**
     * 计算以leftMidIndex和rightMidIndex为中心，最长回文串的长度
     *      类似于abba，其中心在第一个b和第二个b之间，此时
     *      leftMidIndex = 1
     *      rightMidIndex = 2
     * @param s
     * @param leftMidIndex
     * @param rightMidIndex
     * @return
     */
    private int calculatePalindromeLength(String s, int leftMidIndex, int rightMidIndex) {
        while (leftMidIndex >= 0 && rightMidIndex < s.length() && s.charAt(leftMidIndex) == s.charAt(rightMidIndex)) {
            leftMidIndex--;
            rightMidIndex++;
        }
        return rightMidIndex - leftMidIndex - 1;
    }

    public static void main(String[] args) {
        Title5 title5 = new Title5();
        System.out.println(title5.longestPalindrome("cbbd"));
    }
}
