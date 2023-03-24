/**
https://leetcode.cn/problems/house-robber-iii/
Status:		AC
Runtime:	8 ms, faster than 51.02%

@author: jiangpeiheng
@date: 2023/3/23
*/
package main

func rob(root *TreeNode) int {
	if root == nil {
		return 0
	}
	rootVal := dfs(root)
	return max(rootVal[0], rootVal[1])
}

/**
@return: left - unSelect current node, right - select current node
*/
func dfs(node *TreeNode) []int {
	if node == nil {
		return []int{0, 0}
	}

	leftVal := dfs(node.Left)
	rightVale := dfs(node.Right)

	return []int{
		max(leftVal[0], leftVal[1]) + max(rightVale[0], rightVale[1]),
		node.Val + leftVal[0] + rightVale[0],
	}
}
