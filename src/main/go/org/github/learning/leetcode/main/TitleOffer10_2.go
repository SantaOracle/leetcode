/**
https://leetcode.cn/problems/qing-wa-tiao-tai-jie-wen-ti-lcof/
Status:		AC
Runtime:	0 ms, faster than 100%

@author: jiangpeiheng
@date: 2023/3/23
*/
package main

import "fmt"

func main() {
	fmt.Println(numWays(7))
}

func numWays(n int) int {
	if n == 0 {
		return 1
	}
	if n == 1 {
		return 1
	}
	if n == 2 {
		return 2
	}
	n1 := 1
	n2 := 2
	for i := 3; i <= n; i++ {
		n1, n2 = n2, (n1+n2)%1000000007
	}
	return n2
}
