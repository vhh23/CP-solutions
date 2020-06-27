package main.codechef.junecookoff;

import java.util.Scanner;

public class EOEO {

    public static void main(String[] args) {


        Scanner in = new Scanner(System.in);

        int T = 0;
        if(in.hasNextInt())
            T = in.nextInt();


        for(long i = 0;i<T;i++) {

            long cn = in.nextLong();

            if(cn == 1){
                System.out.println(0);

            }else {

                if(cn % 2 == 0){
                    //even number

                    long JS2pow = findPow2(cn);

                    System.out.println((JS2pow-1)/2);

                } else {
                    //odd number
                    long noe = (cn-1)/2;
                    System.out.println(noe);
                }
            }

        }



        }

    public static long findPow2(long n){


        while(n%2 == 0){
            n = n/2;
        }

       return n;
    }
}
