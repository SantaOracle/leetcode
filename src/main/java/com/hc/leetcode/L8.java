package com.hc.leetcode;

public class L8 {
    public int myAtoi(String str) {
        long ret = 0;
        boolean haveNum = false;
        boolean neg = false;
        char[] chars = str.toCharArray();
        for(int i = 0; i< chars.length; i++){
            char c = chars[i];
            if(!haveNum){
                if(isDigit(c)) {
                    ret = ret * 10 + (int)c - (int)'0';
                    haveNum = true;
                }else if(c == '-' && i < chars.length -1 && isDigit(chars[i + 1])){
                    neg = true;
                    continue;
                }else if(c == '+' && i < chars.length -1 && isDigit(chars[i + 1])){
                    continue;
                }else if(c == ' '){
                    continue;
                }else{
                    break;
                }
            }else{
                if(!isDigit(c)){
                    break;
                }else{
                    ret = ret * 10 + (int)c - (int)'0';
                    if(ret > Integer.MAX_VALUE){
                        if(neg){
                            return Integer.MIN_VALUE;
                        }else{
                            return Integer.MAX_VALUE;
                        }
                    }else{
                        continue;
                    }
                }
            }
        }
        if(neg){
            ret = - ret;
        }
        return (int)ret;
    }

    private boolean isDigit(char c){
        int r =  (int)c - (int)'0';
        return  r < 10 && r >=0;
    }

    public static void main(String[] args){
        String a = "4193";
        System.out.println(new L8().myAtoi(a));
    }


}
