package org.github.learning.leetcode;

import org.github.learning.leetcode.data.structure.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Objects;

/**
 * <a href="https://leetcode.cn/problems/binary-tree-level-order-traversal/"></a>
 * Status:  AC
 * Runtime: 1 ms, faster than 60.19%
 *
 * @author jiangpeiheng create on 2023/2/9
 */
public class Title102 {

    public static void main(String[] args) {
        TreeNode node0 = new TreeNode(3);
        TreeNode node1 = new TreeNode(9);
        TreeNode node2 = new TreeNode(20);
        TreeNode node3 = new TreeNode(15);
        TreeNode node4 = new TreeNode(7);

        node0.left = node1;
        node0.right = node2;
        node2.left = node3;
        node2.right = node4;

        Title102 t = new Title102();
        List<List<Integer>> r = t.levelOrder(node0);

        System.out.println(r);
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        Deque<TreeNode> scanning = new ArrayDeque<>();
        List<List<Integer>> res = new ArrayList<>();
        if (Objects.nonNull(root)) {
            scanning.add(root);
        }
        levelScan(scanning, res);
        return res;
    }

    private void levelScan(Deque<TreeNode> scanning, List<List<Integer>> res) {
        if (scanning.isEmpty()) {
            return;
        }

        List<TreeNode> levelNodes = new ArrayList<>();
        List<Integer> levelVal = new ArrayList<>();
        while (!scanning.isEmpty()) {
            TreeNode n = scanning.pop();
            levelNodes.add(n);
            levelVal.add(n.val);
        }

        res.add(levelVal);

        for (TreeNode node : levelNodes) {
            if (node.left != null) scanning.add(node.left);
            if (node.right != null) scanning.add(node.right);
        }

        levelScan(scanning, res);
    }
}
