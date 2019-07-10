package org.github.learning.leetcode;

import org.github.learning.leetcode.data.structure.TreeNode;

import java.util.*;

/**
 * <a href="https://leetcode.com/problems/binary-tree-preorder-traversal/"></a>
 * Status:  AC
 * Runtime: 1 ms, faster than 57.33%
 * create by peiheng.jiang on 2019/7/4
 */
public class Title144 {

    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        Deque<TreeNode> deque = new ArrayDeque<>();
        List<Integer> res = new LinkedList<>();
        deque.addLast(root);
        while (!deque.isEmpty()) {
            TreeNode node = deque.pollLast();
            if (node != null) {     // for sonar
                res.add(node.val);
                if (node.right != null) {
                    deque.addLast(node.right);
                }
                if (node.left != null) {
                    deque.addLast(node.left);
                }
            }
        }

        return res;
    }
}
