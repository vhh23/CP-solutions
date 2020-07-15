package main.codechef.julycookoff;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class DRCHEF {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int T = 0;
        if(in.hasNextInt())
            T = in.nextInt();


        for(int i = 0;i<T;i++) {

            int N = in.nextInt();
            int x = in.nextInt();
            int[] ar = new int[N];
            for(int j = 0;j<N;j++){
                ar[j] = in.nextInt();
            }
            Arrays.sort(ar);
            int days = 0;
            int p = -1;

            for(int k = 0;k<ar.length;k++){
                if(ar[k] >= x){
                    p = k;
                    break;
                }
            }
            if(p == -1){
                System.out.println(ar.length);
                continue;
            }

            int cured = x;
            for(int k = p;k<ar.length;k++){

                int population = ar[k];
                while (ar[k] != 0){
                    cured = Math.min(cured,ar[k]);
                    ar[k] = Math.min(population,Math.max((ar[k] - cured)*2,0));
                    cured = cured*2;
                    days++;
                }

            }
            System.out.println(days +p);
        }
    }
}
