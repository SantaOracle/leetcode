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

    public static void main(String[] args) {
        Title22 title22 = new Title22();
        List<String> res = title22.generateParenthesis(3);
        System.out.println(JSON.toJSONString(res));
    }
}
