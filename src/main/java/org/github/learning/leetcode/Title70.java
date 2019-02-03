package org.github.learning.leetcode;

/**
 * <a href="https://leetcode-cn.com/problems/climbing-stairs/"></a>
 * Status: AC
 * Runtime: 2 ms, faster than 100%
 * @author peiheng.jiang create on 2019/2/3
 */
public class Title70 {

    public int climbStairs(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        int arr[] = new int[n+1];
        arr[1] = 1;
        arr[2] = 2;
        for (int i=3; i<=n; i++) {
            arr[i] = arr[i-1] + arr[i-2];
        }
        return arr[n];
    }

    public static void main(String[] args) {
        Title70 title70 = new Title70();
        System.out.println(title70.climbStairs(45));
    }
}
