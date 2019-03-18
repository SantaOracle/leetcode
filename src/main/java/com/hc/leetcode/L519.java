package com.hc.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * 使用map记录转换的节点
 */
public class L519 {
    Map<Integer,Integer> map = new HashMap<>();
    int total;
    Random random = new Random();
    int n_rows;
    int n_cols;
    public L519(int n_rows, int n_cols) {
        total = n_rows * n_cols;
        this.n_rows = n_rows;
        this.n_cols = n_cols;
    }

    public int[] flip() {
        int r = random.nextInt(total);
        int v = map.getOrDefault(r,r);
        map.put(r,map.getOrDefault(total-1,total -1));
        total --;
        return new int[]{v / n_cols, v % n_cols};
    }

    public void reset() {
        total = n_cols * n_rows;
        map.clear();
    }

}
