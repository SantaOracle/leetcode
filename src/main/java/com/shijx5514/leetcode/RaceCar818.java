package com.shijx5514.leetcode;

/**
 * leetcode 818
 * @author shijiaxin
 *你的赛车可以从位置 0 开始，并且速度为 +1 ，在一条无限长的数轴上行驶。赛车也可以向负方向行驶。赛车可以按照由加速指令 'A' 和倒车指令 'R' 组成的指令序列自动行驶。
 * 当收到指令 'A' 时，赛车这样行驶：
 * position += speed
 * speed *= 2
 * 当收到指令 'R' 时，赛车这样行驶：
 * 如果速度为正数，那么speed = -1
 * 否则 speed = 1
 * 当前所处位置不变。
 * 例如，在执行指令 "AAR" 后，赛车位置变化为 0 --> 1 --> 3 --> 3 ，速度变化为 1 --> 2 --> 4 --> -1 。
 *
 * 给你一个目标位置 target ，返回能到达目标位置的最短指令序列的长度。
 *
 * 输入：target = 6
 * 输出：5
 * 解释：
 * 最短指令序列是 "AAARA" 。
 * 位置变化 0 --> 1 --> 3 --> 7 --> 7 --> 6 。
 * 1 <= target <= 10的4次幂
 *
 * 思路：
 *
 */
public class RaceCar818 {
    public int raceCar(int target) {

        if (target == 0) {
            return 0;
        }

        if
        return 0;
    }
    public static void main(String[] args) {
        RaceCar818 raceCar818 = new RaceCar818();
        System.out.println(raceCar818.generateParenthesis(10));
    }
}
