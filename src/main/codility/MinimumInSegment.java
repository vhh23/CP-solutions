package main.codility;

import java.util.ArrayList;
import java.util.Arrays;

public class MinimumInSegment {
    public static void main(String[] args) {

        System.out.println(Arrays.toString(solution2("CAGCCTA", new int[]{2, 5, 0}, new int[]{4, 5, 6})));

    }


    public static int[] solution(String S, int[] P, int[] Q) {
        // write your code in Java SE 8

        int[] arr = new int[S.length()];
        for (int i = 0; i < arr.length; i++) {
            if (S.charAt(i) == 'A')
                arr[i] = 1;
            if (S.charAt(i) == 'C')
                arr[i] = 2;
            if (S.charAt(i) == 'G')
                arr[i] = 3;
            if (S.charAt(i) == 'T')
                arr[i] = 4;
        }

        //preprocess
        int[][] table = new int[arr.length][arr.length];
        for (int i = 0; i < arr.length; i++) {
            table[i][i] = i;
        }

        for (int i = 0; i < arr.length; i++)
            for (int j = i + 1; j < arr.length; j++) {

                if (arr[table[i][j - 1]] < arr[j])
                    table[i][j] = table[i][j - 1];
                else
                    table[i][j] = j;

            }

        int[] res = new int[Q.length];
        for (int i = 0; i < Q.length; i++) {
            res[i] = arr[table[P[i]][Q[i]]];
        }

        return res;
    }
    public static int[] solution2(String S, int[] P, int[] Q) {

        int n = S.length();
        int[] arr = new int[n];
        for(int i = 0;i<arr.length;i++){
            if(S.charAt(i) == 'A')
                arr[i] = 1;
            if(S.charAt(i) == 'C')
                arr[i] = 2;
            if(S.charAt(i) == 'G')
                arr[i] = 3;
            if(S.charAt(i) == 'T')
                arr[i] = 4;
        }

        int[] res = new int[Q.length];

        int rn = (int) Math.sqrt(n);

        // initiating block pointer
        int blk_idx = -1;
        int[] table = new int[(n/rn)+1];
        Arrays.fill(table,Integer.MAX_VALUE);

        for (int i = 0; i < n; i++)
        {
            if (i % rn == 0)
            {
                blk_idx++;
            }
            table[blk_idx] = Math.min(arr[i],table[blk_idx]);
        }

        for (int i = 0; i < Q.length; i++) {


            int l = P[i];
            int r = Q[i];
            if(l == r){
                res[i] = arr[l];
            }else {
                int temp = Integer.MAX_VALUE;
                for(int z = l/rn;z<=r/rn;z++){
                    temp = Math.min(temp,table[z]);
                }
                res[i] = temp;
            }


        }

        return res;
    }
}



