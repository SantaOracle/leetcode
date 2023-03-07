/*
*
https://leetcode.cn/problems/longest-common-prefix/
Status:		AC
Runtime:	4 ms, faster than 25.32%

@author: jiangpeiheng
@date: 2023/3/7
*/
package main

import "fmt"

func longestCommonPrefix(strs []string) string {
	if len(strs) == 0 {
		return ""
	}
	for i := 0; i < len(strs[0]); i++ {
		for j := 1; j < len(strs); j++ {
			if i == len(strs[j]) || strs[j][i] != strs[0][i] {
				return strs[0][:i]
			}
		}
	}
	return strs[0]
}

func main() {
	fmt.Println(longestCommonPrefix([]string{"leetcode", "leetgee", "le", "leee"}))
}
