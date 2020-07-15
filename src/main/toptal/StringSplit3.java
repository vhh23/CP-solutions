package main.toptal;

import java.util.HashMap;
import java.util.Map;

public class StringSplit3 {

    public static void main(String[] args) {

        System.out.println(new StringSplit3().splitString3("ababa"));
        System.out.println(new StringSplit3().splitString3("babaa"));
        System.out.println(new StringSplit3().splitString3("ababababbaaabbbaa"));


    }


    public int splitString3(String s){


        Map<Integer,Integer> map = new HashMap<>();
        int i = 0;
        int max = 0;
        for(char x: s.toCharArray()){
            if(x == 'a'){
                i++;
                max = Math.max(max,i);
            }
            if(map.containsKey(i)){
                map.put(i,map.get(i)+1);
            }else{
                map.put(i,1);
            }
        }

        int res = 0;
        for(int x: map.keySet()){

            if(map.containsKey(x*2) && max - (2*x) == (2*x) - x ){
                 int xP = map.get(x);
                 int yP = map.get(2*x);

                 res = res + (xP*yP);

            }

        }

        return res;

    }
}
