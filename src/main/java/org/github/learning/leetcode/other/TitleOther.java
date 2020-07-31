package org.github.learning.leetcode.other;

import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.IntStream;

public class TitleOther {

    private static Random ran = new Random();

    private static final DecimalFormat FLOAT_FORMATTER = new DecimalFormat(".00");

    /**
     * 计算终点是第n个点时最长路径
     *
     * @param n
     * @return
     */
    private static int calLongest(int n, int[][] map, Map<Integer, Integer> record) {  // 假设n = 5
        // 如果之前计算过，直接取就可以了
        Integer path = record.get(n);
        if (path != null) {
            return path;
        }

        // 没有计算过，看下这个点是不是孤立的
        List<Integer> startList = new ArrayList<>(n);
        for (int start = 1; start <= n; start++) {
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
    private static int[][] genMap(int n, float p, float[][] templateMap) {
        int[][] map = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i >= j) {
                    map[i][j] = 0;
                } else {
                    map[i][j] = templateMap[i][j] > p ?
                            0 : 1;
                }
            }
        }
        return map;
    }

    /**
     * 生成模板映射表
     *
     * @param n     矩阵阶数
     * @param size  样本数量，决定了模板数字的精度
     * @return
     */
    private static float[][] genTemplateMap(int n, int size) {
        float[][] templateMap = new float[n+1][n+1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                templateMap[i][j] = ((float) ran.nextInt(size)) / size;
            }
        }
        return templateMap;
    }

    private static void printMap(int[][] map) {
        int n = map.length - 1;
        IntStream.rangeClosed(1, n).forEach(i -> {
            IntStream.rangeClosed(1, n).forEach(j -> {
                System.out.print(map[i][j]);
                System.out.print(" ");
            });
            System.out.println();
        });
    }

    private static void printMap(float[][] map) {
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
        int n = 20;
        int t = 1;
        int size = 100;

        // init map[][]
        float[][] templateMap = genTemplateMap(n, size);

        IntStream.rangeClosed(1, size).forEach(indexp -> {
            float p = ((float) indexp) / size;
//            System.out.println(String.format("p=Ts", p));

//            System.out.println("----------tem map start---------");
//            printMap(templateMap);
//            System.out.println("----------tem map end---------");
            int[][] map = genMap(n, p, templateMap);
            Map<Integer, Integer> record = new HashMap<>();
//            printMap(map);

            // calculate longest
            int max = 0;
            for (int index = 1; index <= n; index++) {
                max = Math.max(calLongest(index, map, record), max);
            }

            float target = calTarget(n, t, record);

            System.out.println(String.format("%s %s %s %s %s %s"
                    , t, n, p, record.get(t), max, target));
        });
    }
}