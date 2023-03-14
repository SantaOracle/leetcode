/*
*
https://leetcode.cn/problems/two-sum-iv-input-is-a-bst/
Status:		AC
Runtime:	20 ms, faster than 78.31%

@author: jiangpeiheng
@date: 2023/3/13
*/
package main

func findTarget(root *TreeNode, k int) bool {
	record := make(map[int]bool)
	var dfs func(*TreeNode) bool
	dfs = func(node *TreeNode) bool {
		if node == nil {
			return false
		}
		if _, ok := record[k-node.Val]; ok {
			return true
		}
		record[node.Val] = true
		return dfs(node.Left) || dfs(node.Right)
	}
	return dfs(root)
}
