package main.codility;

import java.util.*;
import java.util.stream.Collectors;

public class Dominator {


    public static void main(String[] args) {

        System.out.println(new Dominator().solution(new int[]{1,-4,41,1,1,1,1,1,1,1,3,3,3,3,5,6,3,3,3}));

    }

    public int solution(int[] A){

        Map<Integer,pair> map  = new HashMap<>();
        for(int i = 0;i<A.length;i++){

            if(map.containsKey(A[i])){
                pair pair = map.get(A[i]);
                pair.c++;
            }else {
                map.put(A[i],new pair(A[i],1,i));
            }
        }
      for(pair x: map.values()){

          if(x.c > A.length/2)
              return x.i;

      }
      return -1;

    }
    class pair  {
        int v;
        int c;
        int i;

        public pair(int v, int c, int i) {
            this.v = v;
            this.c = c;
            this.i = i;
        }
    }
}
