package main.codility;


import java.util.Arrays;

public class counters {

    public static void main(String[] args) {

        counters counters = new counters();
        int[] s1 = new int[]{6,6,6,6,6};
        int[] solution = counters.solution(5, s1);

        for (int i : solution) {
            System.out.println(i);
        }

    }

    public  int[] solution(int N, int[] A) {
        // write your code in Java SE 8

        int[] res = new int[N];

        int max = 0;

        for (int x=0;x<A.length;x++) {

            while (x<A.length && A[x] == N+1) {
                x++;
            }

            if(x-1>0 && A[x-1] == N+1){
                Arrays.fill(res,max);
            }

            if(x<A.length){
                int cv = res[A[x]-1];
                if(cv+1 > max){
                    max = cv+1;
                }
                res[A[x]-1] = cv +1;
            }




        }

        return res;
    }



}