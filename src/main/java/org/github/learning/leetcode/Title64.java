package org.github.learning.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <a href="https://leetcode.cn/problems/minimum-path-sum/"></a>
 * Status:  AC
 * Runtime: 73 ms, faster than 2.42%
 *
 * @author jiangpeiheng create on 2023/2/9
 */
public class Title64 {

    private static Map<String, Integer> RECORDER = new HashMap<>();

    /**
     * TODO. 直接用Map<String, Integer> 耗时可能会有点长，如果一定要用的话可以考虑初始化Map的容量，避免rehash。
     * TODO. 也可以直接用一个int[][]做记录。不过用二维数组的话可能会消耗不必要的空间
     *
     * @param grid
     * @return
     */
    public int minPathSum(int[][] grid) {
        RECORDER = new HashMap<>();
        return minPathSum(grid, grid.length - 1, grid[0].length - 1);
    }

    private int minPathSum(int[][] grid, int lineIndex, int rowIndex) {
        if (lineIndex == 0 && rowIndex == 0) {
            return grid[0][0];
        }

        String cacheKey = cacheKey(lineIndex, rowIndex);
        Integer cached = RECORDER.get(cacheKey);
        if (Objects.nonNull(cached)) {
            return cached;
        }

        if (lineIndex == 0) {
            return minPathSum(grid, lineIndex, rowIndex - 1) + grid[lineIndex][rowIndex];
        }

        if (rowIndex == 0) {
            return minPathSum(grid, lineIndex - 1, rowIndex) + grid[lineIndex][rowIndex];
        }

        int res =  Math.min(minPathSum(grid, lineIndex, rowIndex - 1) + grid[lineIndex][rowIndex],
                minPathSum(grid, lineIndex - 1, rowIndex) + grid[lineIndex][rowIndex]);
        RECORDER.put(cacheKey, res);
        return res;
    }

    private String cacheKey(int line, int row) {
        return String.format("%s_%s", line, row);
    }
}
