package main.codechef.junecookoff;

import java.util.Scanner;

public class CHFICRM {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int T = 0;
        if(in.hasNextInt())
            T = in.nextInt();

        for(int i = 0;i<T;i++){

            int n = in.nextInt();

            int[] s = new int[n];
            for(int j = 0; j<n;j++) {
                s[j]= in.nextInt();
            }

            int x5 = 0;
            int x10 = 0;
            int j =0;
            for( j = 0; j<n;j++){
                int incoming = s[j];
                if(incoming == 5){
                    x5++;

                }else if(incoming ==10){

                    if(x5 > 0){
                        x5--;
                        x10++;
                    }else {
                        System.out.println("NO");
                        break;
                    }
                }else {

                    if(x10 > 0 ){
                        x10--;
                    } else if(x5 > 1){
                        x5 -=2;
                    } else {
                        System.out.println("NO");
                        break;
                    }

                }

            }
            if(j == n){
                System.out.println("YES");
            }

        }


    }
}
