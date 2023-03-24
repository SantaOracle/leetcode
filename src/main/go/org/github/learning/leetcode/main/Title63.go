/**
https://leetcode.cn/problems/unique-paths-ii/
Status:		AC
Runtime:	0 ms, faster than 100%

@author: jiangpeiheng
@date: 2023/3/24
*/
package main

import (
	"fmt"
	"strconv"
)

func main() {
	grid := [][]int{}
	grid = append(grid, []int{0, 0, 0})
	grid = append(grid, []int{0, 1, 0})
	grid = append(grid, []int{0, 0, 0})

	fmt.Println(uniquePathsWithObstacles(grid))
}

func uniquePathsWithObstacles(obstacleGrid [][]int) int {
	m := len(obstacleGrid)
	n := len(obstacleGrid[0])

	if obstacleGrid[m-1][n-1] == 1 {
		return 0
	}
	cache := make(map[string]int)

	return dpPath(0, 0, m, n, obstacleGrid, &cache)
}

func dpPath(x, y int, m, n int, obstacleGrid [][]int, cache *map[string]int) int {
	if x == m-1 && y == n-1 {
		return 1
	}

	if obstacleGrid[x][y] == 1 {
		return 0
	}

	key := cacheKey(x, y)
	if v, ok := (*cache)[key]; ok {
		return v
	}

	res := 0
	if x+1 < m {
		res += dpPath(x+1, y, m, n, obstacleGrid, cache)
	}
	if y+1 < n {
		res += dpPath(x, y+1, m, n, obstacleGrid, cache)
	}

	(*cache)[key] = res
	return res
}

func cacheKey(x, y int) string {
	return strconv.Itoa(x) + "_" + strconv.Itoa(y)
}
