/*
*
https://leetcode.cn/problems/strong-password-checker-ii/
Status:		AC
Runtime:	0 ms, faster than 100%

@author: jiangpeiheng
@date: 2023/3/13
*/
package main

import (
	"fmt"
	"strings"
	"unicode"
	"unicode/utf8"
)

func main() {
	fmt.Println(strongPasswordCheckerII("IloveLe3tcode!"))
}

func strongPasswordCheckerII(password string) bool {
	// 校验长度大于8
	if utf8.RuneCountInString(password) < 8 {
		return false
	}

	// 校验其他内容，仅遍历一轮
	var lowerCase, upperCase, number, specialChar, sameChars bool
	for i, c := range password {
		if unicode.IsLower(c) {
			lowerCase = true
		} else if unicode.IsUpper(c) {
			upperCase = true
		} else if unicode.IsNumber(c) {
			number = true
		} else if strings.ContainsRune("!@#$%^&*()-+", c) {
			specialChar = true
		}

		if i != 0 && password[i] == password[i-1] {
			sameChars = true
		}
	}
	return lowerCase && upperCase && number && specialChar && !sameChars
}
