package com.hc.leetcode;

/**
 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Validate Binary Search Tree.
 Memory Usage: 40.2 MB, less than 5.64% of Java online submissions for Validate Binary Search Tree.
 * Created by congcong.han on 2019/4/20.
 */
public class L98 {
    public boolean isValidBST(TreeNode root) {
        return judge(root,null,null);
    }

    private boolean judge(TreeNode node, Integer high, Integer low) {
        if(node == null){
            return true;
        }

        if((high != null && node.val >= high) ){
            return false;
        }else if(low != null && node.val <= low){
            return false;
        }else{
            if(!judge(node.left,node.val,low)){
                return false;
            }
            if(!judge(node.right,high,node.val)){
                return false;
            }
        }
        return true;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
