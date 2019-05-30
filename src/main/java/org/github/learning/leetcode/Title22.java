package org.github.learning.leetcode;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/generate-parentheses/"></a>
 * Status:  AC
 * Runtime: 33 ms, faster than 5.03%
 * create by peiheng.jiang on 2019/5/30
 */
public class Title22 {

    private static final String LEFT_BRACKET = "(";
    private static final String RIGHT_BRACKET = ")";

    /**
     * My solution
     * @param n
     * @return
     */
    public List<String> generateParenthesis(int n) {
        if (n <= 0) {
            return Collections.emptyList();
        }
        List<String> res = new ArrayList<>();
        doGenerate(res, new ArrayList<>(), 0, 0, n);
        return res;
    }

    private void doGenerate(List<String> res, List<String> tmpCombine, int left, int right, int target) {
        if (left == target && right == target) {
            res.add(generateOneRes(tmpCombine));
            return;
        }
        if (left < target) {
            tmpCombine.add(LEFT_BRACKET);
            doGenerate(res, tmpCombine, left + 1, right, target);
            tmpCombine.remove(tmpCombine.size() - 1);
        }
        if (right < target && right < left) {
            tmpCombine.add(RIGHT_BRACKET);
            doGenerate(res, tmpCombine, left, right + 1, target);
            tmpCombine.remove(tmpCombine.size() - 1);
        }
    }

    private String generateOneRes(List<String> combine) {
        StringBuilder builder = new StringBuilder();
        combine.forEach(builder::append);
        return builder.toString();
    }

    /**
     * better solution
     * @param n
     * @return
     */
    private List<String> betterSolution(int n) {
        List<String> list = new ArrayList<>();
        char[] t = new char[2 * n];     //  init capacity, which will reduce array rebuild times
        generateParenthesis(n, t, 0, 0, 0, list);
        return list;
    }


    /**
     *
     * @param n     specific number of brackets
     * @param t     current bracket combination
     * @param i     current index of array
     * @param s     left bracket size
     * @param e     right bracket size
     * @param list  result list
     */
    private void generateParenthesis(int n, char[] t, int i, int s, int e, List<String> list) {
        if (s == e && s == n) {
            list.add(new String(t));        // generate res String directly
            return;
        }
        if (s < n) {
            t[i] = '(';
            generateParenthesis(n, t, i + 1, s + 1, e, list);
        }
        if (e < s) {
            t[i] = ')';
            generateParenthesis(n, t, i + 1, s, e + 1, list);
        }
    }

    public static void main(String[] args) {
        Title22 title22 = new Title22();
        List<String> res = title22.generateParenthesis(3);
        System.out.println(JSON.toJSONString(res));
    }
}
