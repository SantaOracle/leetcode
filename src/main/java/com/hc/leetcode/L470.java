package com.hc.leetcode;

/**
 * Runtime: 5 ms, faster than 87.48% of Java online submissions for Implement Rand10() Using Rand7().
    Memory Usage: 39.3 MB, less than 32.50% of Java online submissions for Implement Rand10() Using Rand7().
 * Created by congcong.han on 2019/3/10.
 */
public class L470 {
    /**
     * 拒绝采样方法
     * @return
     */
    public int rand10() {
        while(true) {
            int v1 = rand7()-1;
            int v2 = rand7()-1;
            int v3 = v1 * 7 + v2;
            if (v3 >= 40) {
                continue;
            }else{
                return v3 % 10 +1;
            }
        }

    }
}
