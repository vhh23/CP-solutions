package main.toptal;

import java.util.HashMap;
import java.util.Map;

public class Holiday2Pt {
    public static void main(String[] args) {

        System.out.println(new Holiday2Pt().solution(new int[]{2,1,1,3,2,1,1,3}));
        System.out.println(new Holiday2Pt().solution(new int[]{7,5,2,7,2,7,4,7}));
        System.out.println(new Holiday2Pt().solution(new int[]{7,3,7,3,1,3,4,1}));
        System.out.println(new Holiday2Pt().solution(new int[]{7,3,7,3,1,3,4,1}));
        System.out.println(new Holiday2Pt().solution(new int[]{7,3,4,7,9,8,1,2,3,4,5,6,7,8,8,9,9,4,1,2,6,9,4,5,2,5,6,3,4,6,6,7,7,9,9}));
        System.out.println(new Holiday2Pt().solution(new int[]{}));

    }


    public int solution(int[] A) {

        if(A == null || A.length == 0){
            return 0;
        }
        int min = Integer.MAX_VALUE;

        Map<Integer, Integer > lookup = new HashMap<>();
        for(int x: A){
            if(!lookup.containsKey(x)){
                lookup.put(x,0);
            }
        }
        int p1 = 0;


        for(int i = 0;i<A.length;i++){

            int x = A[i];
            if(lookup.containsKey(x)){
                lookup.put(x,lookup.get(x)+1);
            }else{
                lookup.put(x,1);
            }

            if(checkIf(lookup)){
                min = Math.min(min,i-p1+1);
            }

            while (p1>=0 && p1!= i){
                int candidate = A[p1];
                int canV = lookup.get(candidate);
                if(canV > 1){
                    lookup.put(candidate,canV-1);
                    if(checkIf(lookup)){
                        p1++;
                        min = Math.min(min,i-p1+1);
                    }else{
                        lookup.put(candidate,canV);
                        break;
                    }
                }else{
                    break;
                }

            }



        }

        return min;


    }


    private boolean checkIf(Map<Integer, Integer > lookup){
        return lookup.values().stream().noneMatch(x-> x == 0);
    }


}
