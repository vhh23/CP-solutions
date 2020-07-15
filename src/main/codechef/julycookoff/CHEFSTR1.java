package main.codechef.julycookoff;

import java.util.Scanner;

public class CHEFSTR1 {

    /**
     * 2
     * 6
     * 1 6 11 6 10 11
     * 4
     * 1 3 5 7
     * @param args
     */

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int T = 0;
        if(in.hasNextInt())
            T = in.nextInt();

        for(int i = 0;i<T;i++) {

            int N = in.nextInt();
            if(N == 1){
                System.out.println(0);
                continue;
            }
            int res = 0;
            int prev = in.nextInt();
            for(int j = 1;j<N;j++){
                int x = in.nextInt();
                int diff = Math.abs(prev - x);
                if(diff > 0)
                    res += diff - 1;
                prev = x;
            }
            System.out.println(res);
        }




    }
}
