/**
https://leetcode.cn/problems/convert-the-temperature/
Status:		AC
Runtime:	40 ms, faster than 59.18%

@author: jiangpeiheng
@date: 2023/3/23
*/
package main

import (
	"fmt"
	"sort"
)

func bestTeamScore(scores []int, ages []int) int {
	// 边界情况
	if len(scores) == 0 {
		return 0
	}
	if len(scores) == 1 {
		return scores[0]
	}

	// 常规情况
	n := len(scores)
	people := make([][]int, n)
	for i := range scores {
		people[i] = []int{scores[i], ages[i]}
	}
	// 按照score, age升序排序
	sort.Slice(people, func(i, j int) bool {
		if people[i][0] < people[j][0] {
			return true
		} else if people[i][0] > people[j][0] {
			return false
		}
		return people[i][1] < people[j][1]
	})
	// dp[i] —— 当队伍里一定选择了第i个位置的球员，则从第0 ~ i计算出的最大无矛盾球队得分最大值，记为dp[i]
	// 通过make构造数组，默认会给0值
	dp := make([]int, n)
	res := 0
	for i := 0; i < n; i++ {
		for j := 0; j < i; j++ {
			// 处理j球员年龄不大于i球员年龄的情况
			if people[j][1] <= people[i][1] {
				dp[i] = max(dp[i], dp[j])
			}
		}
		// 上述计算完后，dp[i]应该是截止到i之前，在可选第i个球员的条件成立下，得分最大值
		// 此时应该把第i个球员的得分加上
		dp[i] += people[i][0]
		// 最终结果应该取更大的值
		res = max(res, dp[i])
	}
	return res
}

func main() {
	scores := []int{1, 3, 5, 10, 15}
	ages := []int{1, 2, 3, 4, 5}
	fmt.Println(bestTeamScore(scores, ages))
}
