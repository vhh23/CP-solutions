package main.codechef.maylunchtime;

import java.util.Scanner;

/**
 * 3
 * 4
 * 1 3 3 4
 * 1 2 4 4
 * 2
 * 2 3
 * 3 2
 * 2
 * 3 3
 * 3 3
 * Example Output
 * 5
 * 0
 * 6
 */
public class WWALK {

    public static void main(String[] args) {


        Scanner in = new Scanner(System.in);

        int N = 0;
        if(in.hasNextInt())
            N = in.nextInt();

        for(int i = 0; i< N ; i++){

            int n = in.nextInt();
            int[][] x2d = new int[2][n];
            for(int k =0; k< 2;k++)
                for (int j = 0; j<n;j++){
                    x2d[k][j] = in.nextInt();
                }

            long wd = 0;
            int runningSum1 = 0;
            int runningSum2 = 0;

            for(int v =0;v<n;v++){

                if(runningSum1 == runningSum2 && x2d[0][v]== x2d[1][v]){
                    wd = wd + x2d[0][v];
                }
                runningSum1 += x2d[0][v];
                runningSum2 += x2d[1][v];

            }

            System.out.println(wd);
        }



    }
}
