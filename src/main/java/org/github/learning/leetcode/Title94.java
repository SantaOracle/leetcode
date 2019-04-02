package org.github.learning.leetcode;

import java.util.*;

/**
 * <a href="https://leetcode.com/problems/binary-tree-inorder-traversal/"></a>
 * Status: AC
 * Runtime: 1 ms, faster than 30.56%
 * @author peiheng.jiang create on 2019/04/02
 */
public class Title94 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> deque = new ArrayDeque<>();
        TreeNode node = root;
        while (node != null || !deque.isEmpty()) {
            if (node != null) {
                deque.push(node);
                node = node.left;
            } else {
                node = deque.pop();
                res.add(node.val);
                node = node.right;
            }
        }
        return res;
    }
}
