package com.hc.leetcode;

import java.util.Random;

/**
 * 478
 * Created by congcong.han on 2019/3/10.
 */
public class L478 {
    private double radius;
    private double x_center;
    private double y_center;
    private double area;
    private Random random = new Random();

    public L478(double radius, double x_center, double y_center) {
        this.radius = radius;
        this.x_center = x_center;
        this.y_center = y_center;
        this.area = Math.PI * radius * radius;
    }

    public double[] randPoint() {
        double jiaodu = random.nextDouble() * 360;
        double areaS = random.nextDouble() * area;
        double radiusS = Math.sqrt(areaS / Math.PI);
        //三角函数
        double x = Math.cos(jiaodu) * radiusS + x_center;
        double y = Math.sin(jiaodu) * radiusS + y_center;
        return new double[]{x,y};
    }
}
