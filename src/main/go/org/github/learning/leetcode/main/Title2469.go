/**
https://leetcode.cn/problems/convert-the-temperature/
Status:		AC
Runtime:	0 ms, faster than 100%

@author: jiangpeiheng
@date: 2023/3/21
*/
package main

func convertTemperature(celsius float64) []float64 {
	return []float64{C2K(celsius), C2F(celsius)}
}

func C2K(celsius float64) float64 {
	return celsius + 273.15
}

func C2F(celsius float64) float64 {
	return celsius*1.8 + 32
}
