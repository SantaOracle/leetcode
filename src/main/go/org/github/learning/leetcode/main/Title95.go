/**
https://leetcode.cn/problems/unique-binary-search-trees-ii/
Status:		AC
Runtime:	0 ms, faster than 100%

@author: jiangpeiheng
@date: 2023/4/3
*/
package main

func generateTrees(n int) []*TreeNode {
	if n == 0 {
		return nil
	}
	return genTreeDp(1, n)
}

func genTreeDp(start, end int) []*TreeNode {
	if start > end {
		return []*TreeNode{nil}
	}
	allTrees := []*TreeNode{}
	for i := start; i <= end; i++ {
		left := genTreeDp(start, i-1)
		right := genTreeDp(i+1, end)
		for _, l := range left {
			for _, r := range right {
				current := &TreeNode{i, l, r}
				allTrees = append(allTrees, current)
			}
		}
	}
	return allTrees
}
