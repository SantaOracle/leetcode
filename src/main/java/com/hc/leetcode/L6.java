package com.hc.leetcode;

/**
 * 区间双指针
 * Runtime: 3 ms, faster than 99.30% of Java online submissions for ZigZag Conversion.
 Memory Usage: 37.7 MB, less than 96.05% of Java online submissions for ZigZag Conversion.
 * Created by congcong.han on 2019/4/7.
 */
public class L6 {
    public String convert(String s, int numRows) {
        if(numRows <= 1 || s.length() == 1){
            return s;
        }
        StringBuilder builder = new StringBuilder();
        int interval = numRows * 2 - 2;
        int index = 0;
        while(index < s.length()){
            builder.append(s.charAt(index));
            index += interval;
        }
        int begin = 0;
        int end = begin + interval;
        begin ++;
        end --;

        while(begin <= end){
            int indexs = begin;
            int indexe = end;
            while(indexs < s.length()){
                builder.append(s.charAt(indexs));
                if(indexs != indexe && indexe < s.length()){
                    builder.append(s.charAt(indexe));
                }
                indexs = indexs + interval;
                indexe = indexe + interval;
            }
            begin++;
            end--;
        }

        return builder.toString();
    }
}
