package org.github.learning.leetcode;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * <a href="https://leetcode-cn.com/problems/relative-sort-array/"></a>
 *
 * @author jiangpeiheng create on 2020/7/31
 */
public class Title1122 {

    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        if (arr1 == null || arr1.length == 0) {
            return new int[]{};
        }
        // arr1 计数
        Map<Integer, Integer> arrCounts = new HashMap<>();
        for (int i : arr1) {
            incr(i, arrCounts);
        }

        // sort ele in arr2
        Map<Integer, Integer> arrLinkCounts = new LinkedHashMap<>();
        for (int i : arr2) {
            Integer cnt = arrCounts.get(i);
            if (cnt == null) {
                continue;
            }
            arrLinkCounts.put(i, cnt);
            arrCounts.remove(i);
        }

        // sort ele not in arr2
        arrCounts.entrySet().stream()
                .sorted(Comparator.comparing(Map.Entry::getKey))
                .forEach(e -> arrLinkCounts.put(e.getKey(), e.getValue()));

        // transform
        return transform(arrLinkCounts, arr1.length);
    }

    private void incr(int key, Map<Integer, Integer> arrCounts) {
        Integer value = arrCounts.get(key);
        if (value == null) {
            value = 0;
        }
        arrCounts.put(key, value + 1);
    }

    private int[] transform(Map<Integer, Integer> arrLinkCounts, int eleCounts) {
        int[] res = new int[eleCounts];
        int index = 0;

        for (Map.Entry<Integer, Integer> entry : arrLinkCounts.entrySet()) {
            for (int i=0; i<entry.getValue(); i++) {
                res[index] = entry.getKey();
                index++;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] arr1 = {2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19};
        int[] arr2 = {2, 1, 4, 3, 9, 6};

        Title1122 t = new Title1122();
        int[] res = t.relativeSortArray(arr1, arr2);
        print(res);
    }

    private static void print(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
