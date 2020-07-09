package org.github.learning.leetcode.other;

import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.IntStream;

/**
 * @author jiangpeiheng create on 2020/7/8
 */
public class TitleOther {

    private static Random ran = new Random();

    private static final DecimalFormat FLOAT_FORMATTER = new DecimalFormat(".00");

    /**
     * 计算终点是第n个点时最长路径
     *
     * @param n
     * @return
     */
    public static int calLongest(int n, int[][] map,  Map<Integer, Integer> record) {  // 假设n = 5
        // 如果之前计算过，直接取就可以了
        Integer path = record.get(n);
        if (path != null) {
            return path;
        }

        // 没有计算过，看下这个点是不是孤立的
        List<Integer> startList = new ArrayList<>(n);
        for (int start=1; start<=n; start++) {
            if (map[start][n] == 1) {
                startList.add(start);
            }
        }

        if (!startList.isEmpty()) {
            int max = 0;
            // 有其他点能抵达当前点
            for (int start : startList) {
                max = Math.max(max, calLongest(start, map, record) + 1);
            }
            record.put(n, max);
            return max;
        } else {
            // 没有其他点，可以直接抵达当前点，说明以当前点为终点的最长路径是0
            record.put(n, 0);
            return 0;
        }

    }

    /**
     * 生成矩阵
     *
     * @param n 点的个数
     * @param p 每条路径的生成概率, eg. 0.7
     */
    public static int[][] genMap(int n, float p) {
        int[][] map = new int[n+1][n+1];

        int thredshold = (int) (p * 100);

        for (int i=1; i<=n; i++) {
            for (int j=1; j<=n; j++) {
                if (i >= j) {
                    map[i][j] = 0;
                } else {
                    int g = ran.nextInt(100);
                    map[i][j] = g <= thredshold ? 1 : 0;
                }
            }
        }
        return map;
    }

    public static void printMap(int[][] map) {
        int n = map.length - 1;
        IntStream.rangeClosed(1, n).forEach(i -> {
            IntStream.rangeClosed(1, n).forEach(j -> {
                System.out.print(map[i][j]);
                System.out.print(" ");
            });
            System.out.println();
        });
    }


    // target=(longestN-longestT)/(n-T)

    private static float calTarget(int n, int t, Map<Integer, Integer> record) {
        int up = record.get(n) - record.get(t);
        int down = n - t;
        return ((float) up) / ((float) down);
    }

    public static void main(String[] args) {
        // input
        int n = 1200;
        int t = 100;

        int size = 1000;

        IntStream.rangeClosed(1, size).forEach(indexp -> {
            float p = ((float) indexp) / size;
//            System.out.println(String.format("p=Ts", p));

            // init map[][]
            int[][] map = genMap(n, p);
            Map<Integer, Integer> record = new HashMap<>();
//            printMap(map);

            // calculate longest
            int max = 0;
            for (int index=1; index<=n; index++) {
                max = Math.max(calLongest(index, map, record), max);
            }

            float target = calTarget(n, t, record);

            System.out.println(String.format("p=%s, path=%s, target=%s",
                    p, max, target));
        });
    }
}
