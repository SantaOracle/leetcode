package com.hc.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Runtime: 1 ms, faster than 75.69% of Java online submissions for Binary Tree Level Order Traversal.
 * Memory Usage: 37.2 MB, less than 83.47% of Java online submissions for Binary Tree Level Order Traversal.
 */
public class L102 {
    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> ret = new ArrayList<>();
        if(root == null){
            return ret;
        }
        List<TreeNode> list = new ArrayList<>();
        list.add(root);
        while(!list.isEmpty()){
            List<Integer> mid = new ArrayList<>();
            List<TreeNode> newList = new ArrayList<>();
            for(TreeNode node : list){
                mid.add(node.val);
                if(node.left != null){
                    newList.add(node.left);
                }
                if(node.right != null){
                    newList.add(node.right);
                }
            }
            ret.add(mid);
            list = newList;
        }
        return ret;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
