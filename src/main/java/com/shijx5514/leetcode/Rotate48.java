package com.shijx5514.leetcode;


/**
 * lc 49 原地反转矩阵
 * 给定一个 n × n 的二维矩阵表示一个图像。
 *
 * 将图像顺时针旋转 90 度。
 *
 * 说明：
 *
 * 你必须在原地旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要使用另一个矩阵来旋转图像。
 *
 * 示例 1:
 *
 * 给定 matrix =
 * [
 *   [1,2,3],
 *   [4,5,6],
 *   [7,8,9]
 * ],
 *
 * 原地旋转输入矩阵，使其变为:
 * [
 *   [7,4,1],
 *   [8,5,2],
 *   [9,6,3]
 * ]
 *
 * 先转置在每一行翻转
 */
public class Rotate48 {

    public void rotate(int[][] matrix) {
        /**
         * 转置
         */
        for(int i=0; i<matrix.length; i++) {
            for(int k=i; k<matrix.length; k++) {
                int temp = matrix[i][k];
                matrix[i][k] = matrix[k][i];
                matrix[k][i] = temp;
            }
        }

        for(int i=0; i<matrix.length; i++) {
            for(int k=0; k<matrix.length; k++) {
                System.out.println(matrix[i][k]);
            }
        }
        /**
         * 每行翻转
         */
        for(int i=0; i<matrix.length; i++) {
            for(int k=0; k<matrix.length/2; k++) {
                int tmp = matrix[i][k];
                matrix[i][k] = matrix[i][matrix.length - k - 1];
                matrix[i][matrix.length - k - 1] = tmp;
            }
        }
    }

    public static void main(String[] args) {
        int[][] martix = {{1,2,3},{4,5,6},{7,8,9}};
        Rotate48 rotate48 = new Rotate48();
        rotate48.rotate(martix);
    }
}
