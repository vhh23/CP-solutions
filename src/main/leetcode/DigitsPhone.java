package main.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DigitsPhone {

    public static void main(String[] args) {

        String digits = "23";

        System.out.println(new DigitsPhone().solution(digits));


    }

    public List<String> solution(String digits){
        List<String> l1 = new ArrayList<String>();
        List<String> l2 = new ArrayList<String>();


        Map<Character, String> map = new HashMap<>();
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");map.put('9',"wxyz");


        if(digits.length() == 0){
            return new ArrayList<>();
        }
        String first = map.get(digits.charAt(0));
        for(char x: first.toCharArray()){
            l1.add(x+"");
        }


        for(int i = 1;i<digits.length();i++){


            String temp = map.get(digits.charAt(i));
            for(char x: temp.toCharArray()){

                if(i % 2 == 0){
                    for(String y: l2){
                        l1.add(y+x);
                    }

                }else{
                    for(String y: l1){
                        l2.add(y+x);
                    }

                }

            }

            if(i%2 != 0){
                l1 = new ArrayList<>();
            }else{
                l2 = new ArrayList<>();
            }


        }

        if(digits.length() % 2 == 0){
            return l2;
        }else{
            return l1;
        }


    }
}
