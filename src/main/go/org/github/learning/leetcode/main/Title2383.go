/*
*
https://leetcode.cn/problems/minimum-hours-of-training-to-win-a-competition/
Status:		AC
Runtime:	0 ms, faster than 100%

@author: jiangpeiheng
@date: 2023/3/13
*/
package main

import "fmt"

func main() {
	fmt.Println(minNumberOfHours(5, 3, []int{1, 4, 3, 2}, []int{2, 6, 3, 1}))
}

func minNumberOfHours(initialEnergy int, initialExperience int, energy []int, experience []int) int {
	trainingHours := 0
	trainingHours += trainingForEnergy(initialEnergy, energy)
	trainingHours += trainingForExperience(initialExperience, experience)
	return trainingHours
}

func trainingForEnergy(initialEnergy int, energy []int) int {
	total := 0
	for _, e := range energy {
		total += e
	}
	if initialEnergy > total {
		return 0
	}
	return total + 1 - initialEnergy
}

func trainingForExperience(initialExperience int, experience []int) int {
	total := 0
	selfExperience := initialExperience
	for _, e := range experience {
		if selfExperience <= e {
			total += e + 1 - selfExperience
			selfExperience = 2*e + 1
		} else {
			selfExperience = selfExperience + e
		}
	}
	return total
}
