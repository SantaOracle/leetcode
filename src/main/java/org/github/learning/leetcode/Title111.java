package org.github.learning.leetcode;

import org.github.learning.leetcode.data.structure.TreeNode;

/**
 * <a href="https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/"></a>
 * Status: AC
 * Runtime: 0 ms, faster than 100%
 * @author jiangpeiheng create on 2020/7/9
 */
public class Title111 {

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        int leftCount = root.left == null ?
                Integer.MAX_VALUE : minDepth(root.left, 2);
        int rightCount = root.right == null ?
                Integer.MAX_VALUE : minDepth(root.right, 2);
        return Math.min(leftCount, rightCount);
    }

    private int minDepth(TreeNode node, int count) {
        if (node.left == null && node.right == null) {
            return count;
        }
        int leftCount = node.left == null ?
                Integer.MAX_VALUE : minDepth(node.left, count + 1);
        int rightCount = node.right == null ?
                Integer.MAX_VALUE : minDepth(node.right, count + 1);
        return Math.min(leftCount, rightCount);
    }
}
