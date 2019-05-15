package com.hc.leetcode;

import java.util.ArrayList;
import java.util.List;

public class L144 {
    public List<Integer> preorderTraversal(TreeNode root) {
        if(root ==  null){
            return new ArrayList<>();
        }
        List<Integer> values = new ArrayList<>();
        doPreorderTraversal(values,root);
        return values;
    }

    private void doPreorderTraversal(List<Integer> values, TreeNode root) {
        values.add(root.val);
        if(root.left != null){
            doPreorderTraversal(values,root.left);
        }
        if(root.right != null){
            doPreorderTraversal(values,root.right);
        }
    }

    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
}
