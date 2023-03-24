/**
https://leetcode.cn/problems/fei-bo-na-qi-shu-lie-lcof/
Status:		AC
Runtime:	0 ms, faster than 100%

@author: jiangpeiheng
@date: 2023/3/23
*/
package main

import "fmt"

func main() {
	fmt.Println(fib(45))
}

func fib(n int) int {
	if n == 0 {
		return 0
	}

	if n == 1 {
		return 1
	}
	n1 := 0
	n2 := 1
	for i := 2; i <= n; i++ {
		n1, n2 = n2, (n1+n2)%1000000007
	}
	return n2
}
