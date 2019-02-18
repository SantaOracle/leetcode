package org.github.learning.leetcode;

import java.util.List;

/**
 * <a href="https://leetcode.com/problems/word-break/"></a>
 * Status:  AC
 * Runtime: 6 ms, faster than 83.81%
 * @author peiheng.jiang create on 2019/02/18
 */
public class Title139 {

    /**
     * 逐步找出可切割的点
     * @param s
     * @param wordDict
     * @return
     */
    public boolean wordBreak(String s, List<String> wordDict) {
        int length = s.length();
        boolean couldSplit[] = new boolean[length + 1]; // couldSplit[i] 代表前i-1个字符组成的字符串是否可被切割
        couldSplit[0] = true;
        for (int splitIndex=1; splitIndex<=length; splitIndex++) {
            for (int startIndex=0; startIndex<splitIndex; startIndex++) {
                if (couldSplit[startIndex] && wordDict.contains(s.substring(startIndex, splitIndex))) {
                    couldSplit[splitIndex] = true;
                }
            }
        }
        return couldSplit[length];
    }
}
