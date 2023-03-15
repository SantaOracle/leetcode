/*
*
https://leetcode.cn/problems/length-of-last-word/
Status:		AC
Runtime:	0 ms, faster than 100%

@author: jiangpeiheng
@date: 2023/3/15
*/
package main

import "fmt"

func main() {
	fmt.Println(lengthOfLastWord("   fly me   to   the moon  "))
}

func lengthOfLastWord(s string) int {
	length := 0
	for i, c := range s {
		if i > 0 && string(s[i-1]) == " " && string(c) != " " {
			length = 1
			continue
		}

		if string(c) != " " {
			length++
		}
	}
	return length
}
