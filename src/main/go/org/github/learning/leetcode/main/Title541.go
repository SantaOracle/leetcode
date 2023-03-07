/*
*
https://leetcode.cn/problems/reverse-string-ii/
Status:		AC
Runtime:	0 ms, faster than 100%

@author: jiangpeiheng
@date: 2023/3/7
*/
package main

func reverseStr(s string, k int) string {
	if len(s) == 0 {
		return ""
	}

	t := []byte(s)
	for i := 0; i < len(s); i += 2 * k {
		sub := t[i:min(i+k, len(s))]
		for j, n := 0, len(sub); j < n/2; j++ {
			sub[j], sub[n-1-j] = sub[n-1-j], sub[j]
		}
	}
	return string(t)
}

func min(a int, b int) int {
	min := a
	if b < min {
		min = b
	}
	return min
}

func main() {

}
