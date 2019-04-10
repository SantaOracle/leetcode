package org.github.learning.leetcode;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/validate-binary-search-tree/"></>
 * Status:  AC
 * Runtime: 1 ms, faster than 34.99%
 * @author peiheng.jiang create on 2019/04/10
 */
public class Title98 {

    /**
     * My Solution
     * 中序遍历是从小到大有序序列
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {
        List<Integer> resList = new ArrayList<>();
        initResList(root, resList);
        return isListSorted(resList);
    }

    private void initResList(TreeNode node, List<Integer> resList) {
        if (node == null) {
            return;
        }
        initResList(node.left, resList);
        resList.add(node.val);
        initResList(node.right, resList);
    }

    private boolean isListSorted(List<Integer> resList) {
        if (resList == null || resList.size() == 0 || resList.size() == 1) {
            return true;
        }
        for (int index = 0; index < resList.size() - 1; index++) {
            if (resList.get(index) >= resList.get(index + 1)) {
                return false;
            }
        }
        return true;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {val = x;}
    }
}
