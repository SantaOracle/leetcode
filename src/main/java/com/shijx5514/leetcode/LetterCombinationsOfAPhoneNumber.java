package com.shijx5514.leetcode;


import java.util.LinkedList;
import java.util.List;

/**
 * lc 17
 * @author shijiaxin02
 * @date 2019/2/2
 * 说实话，完全没看明白这题的点在哪儿
 */
public class LetterCombinationsOfAPhoneNumber {
    public List<String> letterCombinations(String digits) {
        List<String> list=new LinkedList<>();
        if(digits.length()==0||digits==null)return list;
        String[] str={"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        for(int i=0;i<digits.length();i++){
            int len=list.size();
            if(((int)digits.charAt(i)-48)<2||((int)digits.charAt(i)-48)>9)continue;
            if(i==0){
                for(int j=0;j<str[(int)digits.charAt(i)-48].length();j++){
                    list.add(""+str[(int)digits.charAt(i)-48].charAt(j));
                }
            }
            else{
                for(int j=0;j<len;j++){
                    String st=list.get(0);
                    for(int k=0;k<str[(int)digits.charAt(i)-48].length();k++){
                        list.add(st+str[(int)digits.charAt(i)-48].charAt(k)+"");
                    }
                    list.remove(0);
                }
            }
        }
        return list;
    }
}
