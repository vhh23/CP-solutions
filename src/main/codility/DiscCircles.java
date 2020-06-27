package main.codility;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class DiscCircles {


    public static void main(String[] args) {


        System.out.println(new DiscCircles().discCircles(new int[]{0,0}));


    }

    private  int discCircles(int[] A) {

        List<pair> pairs = new ArrayList<>();
        for(int i = 0;i<A.length;i++){
            pairs.add(new pair(i-A[i],1));
            pairs.add(new pair(i+A[i],-1));
        }

        Collections.sort(pairs, new Comparator<pair>() {
            @Override
            public int compare(pair o1, pair o2) {
                if(o1.x == o2.x)
                    return o2.d - o1.d;
                else
                    return o1.x - o2.x;
            }
        });

        int ac = 0;
        int intsec = 0;


        for (pair pair : pairs) {
                intsec +=ac*(pair.d > 0?1:0);
                ac += pair.d;
        }

        return intsec;
    }

    class pair {
        int x;
        int d;

        public pair(int x, int d) {
            this.x = x;
            this.d = d;
        }


    }
}
