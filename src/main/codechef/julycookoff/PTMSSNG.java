package main.codechef.julycookoff;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class PTMSSNG {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int T = 0;
        if(in.hasNextInt())
            T = in.nextInt();

        for(int i = 0;i<T;i++) {

            int N = in.nextInt();
            Set<Integer> setX = new HashSet<>();
            Set<Integer> setY = new HashSet<>();

            for(int j = 0;j<(4*N);j++){
                int x = in.nextInt();
                int y = in.nextInt();

                if(setX.contains(x)){
                    setX.remove(x);
                }else{
                    setX.add(x);
                }
                if(setY.contains(y)){
                    setY.remove(y);
                }else{
                    setY.add(y);
                }

            }

            System.out.println(setX.toArray()[0]+" "+setY.toArray()[0]);


        }

    }
}
