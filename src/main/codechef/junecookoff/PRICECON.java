package main.codechef.junecookoff;

import java.util.Scanner;

public class PRICECON {

//3
//5 4
//10 2 3 4 5
//7 15
//1 2 3 4 5 6 7
//5 5
//10 9 8 7 6
    public static void main(String[] args) {


        Scanner in = new Scanner(System.in);

        int T = 0;
        if(in.hasNextInt())
            T = in.nextInt();

        for(int i = 0;i<T;i++){

            int N = in.nextInt();
            int k = in.nextInt();
            int loose = 0;
            for(int j = 0 ;j <N;j++){
                int temp = in.nextInt();
                if(temp>k)
                    loose += temp - k;
            }

            System.out.println(loose);

        }


    }
}
