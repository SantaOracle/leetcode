package org.github.learning.leetcode;

import java.util.*;

/**
 * <a href="https://leetcode.com/problems/unique-paths/"></a>
 * Status: AC
 * Runtime: 1 ms, faster than 17.27% （leetcode这帮人是魔鬼吧。。。）
 * @author peiheng.jiang create on 2019/2/17
 */
public class Title62 {

    /**
     * My solution
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths(int m, int n) {
        int total = m + n - 2;
        int select = m - 1;
        return calCombination(select, total);
    }

    /**
     * 计算C(m, n)
     * C(m, n)
     *      = A(m, n) / A(m, m)
     *      = n * (n-1) * .. * (n-m+1) / m * (m-1) * .. * 1
     * @return
     */
    private int calCombination(int m, int n) {
        // 避免越界第一步：C(m, n) = C(n-m, n)，谁小算谁
        m = Math.min(m, n-m);
        int start = n;
        int end = n - m + 1;
        int res = 1;
        // 求m * (m-1) * .. * 1的质因数集合
        List<Integer> modList = getModList(m);
        for (int mulNum=start; mulNum>=end; mulNum--) {
            int realMulNum = mulNum;
            // 避免越界第二步：直接在计算时乘上已经约分质因数的值
            Iterator<Integer> it = modList.iterator();
            while (it.hasNext()) {
                int modNum = it.next();
                if (realMulNum % modNum == 0) {
                    realMulNum /= modNum;
                    it.remove();
                }
            }
            res *= realMulNum;
        }
        return res;
    }

    /**
     * 求1~m，所有数的质因数，并放入集合
     * @param m
     * @return
     */
    private List<Integer> getModList(int m) {
        List<Integer> resList = new ArrayList<>();
        for (int i=1; i<=m; i++) {
            if (i == 1) {
                resList.add(1);
                continue;
            }
            int modNum = i;
            for (int k=2; k<=modNum/2; k++) {
                while (modNum != 1 && modNum % k == 0) {
                    resList.add(k);
                    modNum /= k;
                }
            }
            if (modNum != 1) {
                resList.add(modNum);
            }
        }
        return resList;
    }

    public static void main(String[] args) {
        Title62 title62 = new Title62();
        System.out.println(title62.uniquePaths(10, 10));
    }
}
