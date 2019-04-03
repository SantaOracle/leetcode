package org.github.learning.leetcode;

/**
 * <a href="https://leetcode.com/problems/unique-binary-search-trees/"></a>
 * Status:  AC
 * Runtime: 1460 ms, faster than 7.29%
 * @author peiheng.jiang create on 2019/04/03
 */
public class Title96 {

    private Integer[] cache;

    /**
     * My solution
     * 令n个节点的二叉搜索树有G(n)个
     * 1为根节点时，左子树节点数为0，右子树节点数为n-1
     * 则1为根节点时可以构成BST的数量为G(0) * G(n-1)
     *
     * 综上，G(n) = G(0) * G(n-1) + ... + G(n-1) * G(0)
     * @param n
     * @return
     */
    public int numTrees(int n) {
        // define boundaries' value
        if (n == 0 || n == 1) {
            return 1;
        }
        // init cache
        if (cache == null) {
            cache = new Integer[n];
            cache[0] = 1;
            cache[1] = 1;
        }
        // get from cache
        if (n < cache.length) {
            Integer cacheRes = cache[n];
            if (cacheRes != null) {
                return cacheRes;
            }
        }
        // recursive
        int res = 0;
        for (int index = 0; index < n; index++) {
            res += numTrees(index) * numTrees(n - 1 - index);
        }
        return res;
    }

    public static void main(String[] args) {
        Title96 title96 = new Title96();
        System.out.println(title96.numTrees(3));
    }
}
