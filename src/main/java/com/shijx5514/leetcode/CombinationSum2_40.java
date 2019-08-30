package com.shijx5514.leetcode;


import java.lang.reflect.Array;
import java.util.*;

/**
 * lc 40
 * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的每个数字在每个组合中只能使用一次。
 *
 * 说明：
 *
 * 所有数字（包括目标数）都是正整数。
 * 解集不能包含重复的组合。 
 *
 * 基本思路：1。动态规划，从小到大，维护一个包含所有整数的组合方法，最后求出target的多有组合方法，在将其一一分解即可
 * 2。回溯+剪枝，维护一棵树，根节点是target，从根节点向下分别是所有可能的组合。
 * (1,2,3,4,7)
 *             7
 *             |
 *       1   2   3    4
 *       |   |   |    |
 *       6   5   4    3
 *       |   |   |    |
 *             4 0(剪掉，成功)    0(剪掉，成功)
 */
public class CombinationSum2_40 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        int len = candidates.length;
        List<List<Integer>> res = new ArrayList<>();
        if(len == 0) {
            return res;
        }
        //排序
        Arrays.sort(candidates);
        //回溯+剪枝
        findCombinationSum2(candidates, 0, len, target, new Stack<>(), res);
        return res;
    }

    private void findCombinationSum2(int[] candidates, int begin, int len, int residue, Stack<Integer> stack, List<List<Integer>> res) {
        if (residue == 0) {
            res.add(new ArrayList<>(stack));
            return;
        }
        for (int i = begin; i < len; i++) {
            // 为了避免将负数传递到下一个分支，这里剪枝
            if (residue - candidates[i] < 0) {
                break;
            }

            // 相同部分剪枝
            if (i > begin && candidates[i] == candidates[i - 1]) {
                continue;
            }

            stack.add(candidates[i]);
            findCombinationSum2(candidates, i + 1, len, residue - candidates[i], stack, res);
            stack.pop();
        }
    }

}
