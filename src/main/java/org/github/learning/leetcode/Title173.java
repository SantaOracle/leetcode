package org.github.learning.leetcode;

import org.github.learning.leetcode.data.structure.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * <a href="https://leetcode.com/problems/binary-search-tree-iterator/"></a>
 * Status:  AC
 * Runtime: 56 ms, faster than 99.73%
 * create by peiheng.jiang on 2019/7/9
 */
public class Title173 {

    public static class BSTIterator {

        private Deque<TreeNode> deque = new LinkedList();

        public BSTIterator(TreeNode root) {
            if (root == null) {
                return;
            }
            initDeque(root);
        }

        private void initDeque(TreeNode node) {
            if (node == null) {
                return;
            }
            initDeque(node.left);
            deque.addLast(node);
            initDeque(node.right);
        }

        /** @return the next smallest number */
        public int next() {
            if (deque.isEmpty()) {
                return 0;
            } else {
                return deque.pollFirst().val;
            }
        }

        /** @return whether we have a next smallest number */
        public boolean hasNext() {
            return !deque.isEmpty();
        }
    }
}
