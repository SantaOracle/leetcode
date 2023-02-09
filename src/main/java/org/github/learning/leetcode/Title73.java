package org.github.learning.leetcode;

import javafx.util.Pair;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * <a href="https://leetcode.cn/problems/set-matrix-zeroes/"></a>
 * Status:  AC
 * Runtime: 2 ms, faster than 12.53%
 *
 * @author jiangpeiheng create on 2023/2/9
 */
public class Title73 {

    public void setZeroes(int[][] matrix) {
        Pair<Set<Integer>, Set<Integer>> locations = locate(matrix);
        change(matrix, locations);
    }

    private Pair<Set<Integer>, Set<Integer>> locate(int[][] matrix) {
        Set<Integer> linePos = new HashSet<>();
        Set<Integer> rowPos = new HashSet<>();
        for (int lineIndex = 0; lineIndex < matrix.length; lineIndex++) {
            int[] line = matrix[lineIndex];
            for (int rowIndex = 0; rowIndex < line.length; rowIndex++) {
                if (matrix[lineIndex][rowIndex] == 0) {
                    linePos.add(lineIndex);
                    rowPos.add(rowIndex);
                }
            }
        }
        
        return new Pair<>(linePos, rowPos);
    }

    private void change(int[][] matrix, Pair<Set<Integer>, Set<Integer>> locations) {
        Set<Integer> linePos = locations.getKey();
        Set<Integer> rowPos = locations.getValue();

        for (Integer lineIndex : linePos) {
            Arrays.fill(matrix[lineIndex], 0);
        }

        for (Integer rowIndex : rowPos) {
            for (int lineIndex = 0; lineIndex < matrix.length; lineIndex++) {
                matrix[lineIndex][rowIndex] = 0;
            }
        }
    }
}
