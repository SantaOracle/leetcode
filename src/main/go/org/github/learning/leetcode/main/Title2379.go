/*
*
https://leetcode.cn/problems/minimum-recolors-to-get-k-consecutive-black-blocks/
Status:		AC
Runtime:	0 ms, faster than 100%

@author: jiangpeiheng
@date: 2023/3/9
*/
package main

import (
	"fmt"
	"strings"
)

func main() {
	fmt.Println(minimumRecolors("WBBWWBBWBW", 7))
}

func minimumRecolors(blocks string, k int) int {
	if k == 0 {
		return 0
	}

	min := len(blocks)
	for i := 0; i <= len(blocks)-k; i++ {
		sub := blocks[i : i+k]
		cnt := strings.Count(sub, "W")
		if cnt < min {
			min = cnt
		}
	}

	return min
}
