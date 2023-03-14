/*
*
https://leetcode.cn/problems/root-equals-sum-of-children/
Status:		AC
Runtime:	0 ms, faster than 100%

@author: jiangpeiheng
@date: 2023/3/13
*/
package main

func checkTree(root *TreeNode) bool {
	sum := root.Left.Val + root.Right.Val
	if sum == root.Val {
		return true
	}
	return false
}
