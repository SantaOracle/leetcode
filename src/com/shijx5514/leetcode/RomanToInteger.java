package com.shijx5514.leetcode;


import java.util.HashMap;
import java.util.Map;

/**
 * leetcode13
 * @author shijiaxin02
 * @date 201901/31
 */
public class RomanToInteger {


    public static int romanToInt(String s) {
        if(s.length() == 0){
            return 0;
        }

        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int count = 0;
        int prev = 0;
        for(char c : s.toCharArray()){
            int value = map.get(c);

               if(c != 'I' && prev < value){
                int rem = value - prev;
                count = count - prev;
                count += rem;
            }else{
                count += value;
            }

            prev = value;
        }
        return count;
    }

    public static void main(String[] args) {
        String roman = "MCMXCIV";
        System.out.print(romanToInt(roman));
    }
}
