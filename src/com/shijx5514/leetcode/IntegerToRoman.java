package com.shijx5514.leetcode;


/**
 * leetcode12
 * @author shijiaxin02
 * @date 2019/1/30
 */
public class IntegerToRoman {
    public static String intToRoman(int num) {
        StringBuilder sb=new StringBuilder();
        StringBuilder sb1= compute(num,sb);
        return sb1.toString();
    }
    public static StringBuilder compute(int n,StringBuilder sb) {
        if(n/1000>0)
        {  sb.append("M"); n-=1000;
            return compute(n,sb);
        } else if(n/100>0) {
            if(n/100==9) {
                sb.append("CM"); n%=100;
            }
            else if(n/100==4) {
                sb.append("CD"); n%=100;
            }
            else if(n/100>=5) {

                sb.append("D"); n-=500;
            }
            else {
                sb.append("C"); n-=100;
            }
            return compute(n,sb);
        }
        else if(n/10>0) {
            if(n/10==9) {
                sb.append("XC"); n%=10;
            } else if (n/10==4) {
                sb.append("XL"); n%=10;
            } else if (n/10>=5) {
                sb.append("L"); n-=50;
            } else {
                sb.append("X"); n-=10;
            }
            return compute(n,sb);
        }
        else if (n>0) {
            if(n==9) {
                sb.append("IX"); n/=10;
            } else if(n==4) {
                sb.append("IV"); n/=10;
            } else if(n>=5) {
                sb.append("V"); n-=5;
            } else {
                sb.append("I"); n--;
            }
            return compute(n,sb);
        }
        return sb;
    }

    public static void main(String[] args) {
        int testInt = 1995;
        System.out.print(intToRoman(testInt));
    }
}
