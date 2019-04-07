package com.hc.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * TODO:将树的三个遍历的stack形式全写出来
 * Created by congcong.han on 2019/4/7.
 */
public class L94 {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        //代表栈
        Stack<TreeNode> stack = new Stack<>();
        //代表方法体内正在执行的那个值
        TreeNode cur = root;
        while(cur != null || !stack.isEmpty()){
            while(cur != null){
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            ret.add(cur.val);
            cur = cur.right;
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
