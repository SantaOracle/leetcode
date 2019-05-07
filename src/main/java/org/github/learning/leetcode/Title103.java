package org.github.learning.leetcode;

import org.github.learning.leetcode.data.structure.TreeNode;

import java.util.*;

/**
 * <a href="https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/"></a>
 * Status:  AC
 * Runtime: 1 ms, faster than 75.66%
 * @author peiheng.jiang create on 2019/05/07
 */
public class Title103 {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        List<List<Integer>> result = new ArrayList<>();

        int level = 0;
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();

        stack1.push(root);
        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            if (!stack1.isEmpty()) {
                result.add(bfs(stack1, stack2, level % 2 == 0));
            } else {
                result.add(bfs(stack2, stack1, level % 2 == 0));
            }
            level++;
        }
        return result;
    }

    private List<Integer> bfs(Stack<TreeNode> from, Stack<TreeNode> to, boolean leftfirst) {
        List<Integer> res = new ArrayList<>();
        while (!from.isEmpty()) {
            TreeNode node = from.pop();
            res.add(node.val);
            if (leftfirst) {
                push(node.left, to);
                push(node.right, to);
            } else {
                push(node.right, to);
                push(node.left, to);
            }
        }
        return res;
    }

    private void push(TreeNode node, Stack<TreeNode> stack) {
        if (node == null) {
            return;
        }
        stack.push(node);
    }


}
