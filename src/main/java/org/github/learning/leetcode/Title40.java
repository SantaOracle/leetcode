package org.github.learning.leetcode;

import java.util.*;

/**
 * <a href="https://leetcode.com/problems/combination-sum-ii/"></a>
 * Status:  AC
 * Runtime: 10 ms, faster than 17.85%
 * Create by peiheng.jiang on 2019/8/20
 */
public class Title40 {

    private static Set<List<Integer>> resultSet;

    /**
     * My solution
     * 可以考虑从大到小排序，这样应该可以剪枝不少
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0) {
            return Collections.emptyList();
        }
        List<List<Integer>> result = new ArrayList<>();
        resultSet = new HashSet<>();
        Arrays.sort(candidates);
        if (candidates[0] > target) {
            return Collections.emptyList();
        }
        if (candidates[0] == target) {
            List<Integer> innerRes = new ArrayList<>();
            innerRes.add(target);
            result.add(innerRes);
            return result;
        }
        Deque<Integer> deque = new ArrayDeque<>(candidates.length);
        recrusiveCombine(candidates, 0, deque, 0, target);
        result.addAll(resultSet);
        return result;
    }

    private void recrusiveCombine(int[] candidates, int startIndex, Deque<Integer> curtDeque, int curtSum, int target) {
        if (startIndex >= candidates.length || curtSum + candidates[startIndex] > target) {
            return;
        }

        for (int index = startIndex; index < candidates.length; index++) {
            curtDeque.addLast(candidates[index]);
            curtSum += candidates[index];

            if (curtSum == target) {
                injectResult(curtDeque);
            } else {
                recrusiveCombine(candidates, index + 1, curtDeque, curtSum, target);
            }

            curtDeque.pollLast();
            curtSum -= candidates[index];
        }

    }

    private void injectResult(Deque<Integer> deque) {
        List<Integer> innerRes = new ArrayList<>(deque);
        resultSet.add(innerRes);
    }

    public static void main(String[] args) {
        Title40 title40 = new Title40();
        System.out.println(title40.combinationSum2(new int[]{2, 5, 2, 1, 2}, 5));
    }
}
