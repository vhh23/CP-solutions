package main.codility;

import java.util.Arrays;

public class frog {

    public static void main(String[] args) {

        int x = 5;
        int[] a = new int[]{1, 3, 1, 4, 2, 3, 5, 4};
        System.out.println(solution(x, a));



    }

    public static int solution(int X, int[] A) {
        // write your code in Java SE 8

        char[] s = new char[X+1];
        char[] r = new char[X+1];
        Arrays.fill(s,'0');
        Arrays.fill(r,'1');
        s[0] = '1';


        int index = -1;
        for (int p = 0;p<A.length;p++){
            if(A[p]<=X){
                {
                    s[A[p]] = '1';
                    if(new String(r).equals(new String(s))){
                       index = p;
                       break;
                    }
                }
            }
        }

        return index;
    }
}
