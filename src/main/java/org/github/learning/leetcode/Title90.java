package org.github.learning.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/subsets-ii/"></a>
 * Status:  AC
 * Runtime: 1 ms, faster than 100.00%
 * Create by peiheng.jiang on 2019/8/26
 */
public class Title90 {

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        if (nums == null || nums.length == 0) {
            return Collections.emptyList();
        }
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        recrusiveGetResult(nums, 0, new ArrayList<>(), result);
        return result;
    }

    /**
     * 回溯获取结果
     * 每更深一层回溯，tmp当中的元素都会多一个
     * @param nums
     * @param start
     * @param tmp
     * @param result
     */
    private void recrusiveGetResult(int[] nums, int start, final ArrayList<Integer> tmp, final List<List<Integer>> result) {
        result.add(new ArrayList<>(tmp));
        for (int index = start; index < nums.length; index++) {
            if (index > start && nums[index] == nums[index - 1]) {
                // 当前元素和上一个元素相等时，跳过，避免插入重复的集合
                continue;
            }
            tmp.add(nums[index]);
            recrusiveGetResult(nums, index + 1, tmp, result);
            tmp.remove(tmp.size() - 1);
        }
    }

    public static void main(String[] args) {
        Title90 title90 = new Title90();
        System.out.println(title90.subsetsWithDup(new int[]{1, 2, 2}));
    }
}
