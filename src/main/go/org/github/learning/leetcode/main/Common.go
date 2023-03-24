/*
*
@author: jiangpeiheng
@date: 2023/3/13
*/
package main

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

type BasicCompareable interface {
	~int | ~float32 | ~float64
}

func max[T BasicCompareable](a, b T) T {
	if a > b {
		return a
	}
	return b
}
