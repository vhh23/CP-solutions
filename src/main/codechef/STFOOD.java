package main.codechef;

import java.util.Scanner;
//11.45AM----12.09AC
public class STFOOD {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int N = 1;
        if(scanner.hasNextInt()){
            N = scanner.nextInt();
        }

        for(int i =0;i<N;i++){
            int I = scanner.nextInt();
            int profit = 0;
            for (int j=0;j<I;j++){
                int S = scanner.nextInt();
                int V = scanner.nextInt();
                int P = scanner.nextInt();

                S = S+1;
                int profitForThisFood = (int)(Math.floor(P/S))*V;
                if(profitForThisFood > profit){
                    profit = profitForThisFood;
                }
            }
            System.out.println(profit);

        }

    }



}
