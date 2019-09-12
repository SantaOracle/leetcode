package org.github.learning.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * <a href="https://leetcode-cn.com/problems/valid-sudoku/"></a>
 * Stauts:  AC
 * Runtime: 22ms faster than 5.5%
 * Create by peiheng.jiang on 2019/9/12
 */
public class Title36 {

    private Map<Integer, Set<Character>> rowMap = new HashMap<>(9);
    private Map<Integer, Set<Character>> columnMap = new HashMap<>(9);
    private Map<Integer, Set<Character>> boxMap = new HashMap<>(9);

    public boolean isValidSudoku(char[][] board) {
        if (board == null || board.length == 0 || !validColumn(board)) {
            return false;
        }
        for (int row = 0; row < board.length; row++) {
            char[] columnArr = board[row];
            for (int column = 0; column < columnArr.length; column++) {
                if (!isCurrentIndexValid(board, row, column)) {
                    return false;
                }
                addCurrentEleIntoMap(board, row, column);
            }
        }
        return true;
    }

    /**
     * 根据当前行和列，判断数独是否有效
     * @param row
     * @param column
     * @return
     */
    private boolean isCurrentIndexValid(char[][] board, int row, int column) {
        char c = board[row][column];
        if (c == '.') {
            return true;
        }
        if (rowMap.get(row) != null && rowMap.get(row).contains(c)) {
            return false;
        }
        if (columnMap.get(column) != null && columnMap.get(column).contains(c)) {
            return false;
        }
        int boxIndex = getBoxIndex(row, column);
        if (boxMap.get(boxIndex) != null && boxMap.get(boxIndex).contains(c)) {
            return false;
        }
        return true;
    }

    private void addCurrentEleIntoMap(char[][] board, int row, int column) {
        char c = board[row][column];
        if (c == '.') {
            return;
        }
        addToSingleMap(rowMap, row, c);
        addToSingleMap(columnMap, column, c);
        addToSingleMap(boxMap, getBoxIndex(row, column), c);
    }

    private void addToSingleMap(Map<Integer, Set<Character>> map, int key, char value) {
        Set<Character> charSet = map.get(key);
        if (charSet == null) {
            charSet = new HashSet<>();
        }
        charSet.add(value);
        map.put(key, charSet);
    }

    private boolean validColumn(char[][] board) {
        for (char[] charArray : board) {
            if (charArray.length == 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * 获取子数独下标
     * @param row
     * @param column
     * @return
     */
    private int getBoxIndex(int row, int column) {
        return (row / 3) * 3 + column / 3;
    }
}
