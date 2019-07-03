package org.github.learning.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <a href="https://leetcode.com/problems/simplify-path/"></a>
 * Status:  AC
 * Runtime: 4 ms, faster than 89.08%
 * create by peiheng.jiang on 2019/7/3
 */
public class Title71 {

    private static final String DIR_PATH = "/";

    public String simplifyPath(String path) {
        String[] dirs = path.split(DIR_PATH);
        Deque<String> pathDeque = new ArrayDeque<>();
        for (String dir : dirs) {
            if (dir.equals("") || dir.equals(".")) {
                continue;
            }
            if (dir.equals("..")) {
                pathDeque.pollLast();
                continue;
            }
            pathDeque.addLast(dir);
        }
        String res;
        if (pathDeque.isEmpty()) {
            res = "/";
        } else {
            StringBuilder pathBuilder = new StringBuilder();
            while (!pathDeque.isEmpty()) {
                String currentDir = pathDeque.pollFirst();
                pathBuilder.append(DIR_PATH).append(currentDir);
            }
            res = pathBuilder.toString();
        }
        return res;
    }

    public static void main(String[] args) {
        String s= "/a/../../b/../c//.//";
        Title71 title71 = new Title71();
        System.out.println(title71.simplifyPath(s));
    }
}
