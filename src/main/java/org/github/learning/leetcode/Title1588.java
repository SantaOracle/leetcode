package org.github.learning.leetcode;

/**
 * <a href="https://leetcode.cn/problems/sum-of-all-odd-length-subarrays/"></a>
 * Status:  AC
 * Runtime: 2 ms, faster than 44.72%
 *
 * @author jiangpeiheng create on 2023/2/9
 */
public class Title1588 {

    /**
     * TODO. 只要找到每个位置元素应该出现的次数k(i)，就可以直接用sum(arr[i] * k(i))解，时间复杂度直接降到O(n)
     *
     * @param arr
     * @return
     */
    public int sumOddLengthSubarrays(int[] arr) {
        int range = 1;
        int maxRange = arr.length % 2 == 0 ?
                arr.length - 1 : arr.length;
        int total = 0;
        while (range <= maxRange) {
            total += cal(arr, range);
            range += 2;
        }
        return total;
    }

    private int cal(int[] arr, int range) {
        int res = 0;
        for (int i = 0; i < arr.length - range + 1; i++) {
            for (int j = 0; j < range; j++) {
                res += arr[i + j];
            }
        }
        return res;
    }
}
