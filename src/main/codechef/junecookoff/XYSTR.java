package main.codechef.junecookoff;

import java.util.Scanner;
/*
4
xy
xyxxy
yy
xxxyxyxyxxxy
*/
public class XYSTR {



    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int T = 0;
        if(in.hasNextInt())
            T = in.nextInt();

        for(int i = 0;i<T;i++){

            int pairs = 0;
            String current = in.next();
            for (int j = 1;j<current.length();j++){

                if(isPair(current.charAt(j-1),current.charAt(j))){
                    pairs += 1;
                    j++;
                }

            }
            System.out.println(pairs);


        }


    }

    public static boolean isPair(char x, char y){
        if(x == 'x' && y == 'y')
            return true;
        else if(y == 'x' && x == 'y')
            return true;
        else
            return false;
    }
}
