package main.codechef.junecookoff;

import java.util.Scanner;

public class TTUPLE {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int T = 0;
        if (in.hasNextInt())
            T = in.nextInt();


        for (long i = 0; i < T; i++) {

            int p = in.nextInt();
            int q = in.nextInt();
            int r = in.nextInt();
            int a = in.nextInt();
            int b = in.nextInt();
            int c = in.nextInt();


            int cost =0;

            int d1 = a - p;
            Integer m1 = null;
            if(p>0 && a % p == 0)
                m1 = a/p;

            int d2 = b - q;
            Integer m2 = null;
            if(q>0 && b % q == 0)
                m2 = b/q;

            int d3 = c - r;
            Integer m3 = null;
            if(r>0 &&  c % r == 0)
                m3 = c/r;


            //1st number
            if(d1 == 0 & m1!= null && m1 == 1){
                cost = 0;
            } else if(a == 0 && p == 0) {
                cost = 0;
            } else {
                cost = 1;
            }


            //2nd number

            if(d2 == 0 && m2!= null && m2 ==1){
                //dont do anything
            }else if(d1 != d2 &&  (m2 == null || !m2.equals(m1))){
                cost++;
            }

            //3rd number
            if(d3 == 0 && m3!= null && m3 == 1 ){
                //dont do anything
            }else if(d3 != d2  && d3 != d1   &&
                    (m3 == null || !m3.equals(m2) || !m3.equals(m1))){
                cost++;
            }

            System.out.println(cost);


        }
    }

}
