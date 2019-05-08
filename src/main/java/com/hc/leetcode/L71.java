package com.hc.leetcode;

import java.util.Stack;

/**
 * Runtime: 5 ms, faster than 87.01% of Java online submissions for Simplify Path.
 * Memory Usage: 37.5 MB, less than 91.27% of Java online submissions for Simplify Path.
 */

public class L71 {
    /**
     * /a//b////c/d//././/..
     * @param path
     * @return
     */
    public String simplifyPath(String path) {
        String[] strs = path.split("/");
        Stack<String> stack = new Stack<>();
        for(String str: strs){
            if(str.equals("")){
                continue;
            }
            if(str.equals(".")){
                continue;
            }
            if(str.equals("..")){
                if(!stack.isEmpty()) {
                    stack.pop();
                }
            }else{
                stack.push(str);
            }
        }
        String ret = "";
        while(!stack.isEmpty()){
            ret = '/' + stack.pop() + ret;
        }

        if(ret.equals("")){
            return "/";
        }
        return ret;
    }

    public static void main(String[] args){
        System.out.println(new L71().simplifyPath("/../"));
    }
}
