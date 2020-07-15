package main.codechef.julycookoff;

import java.util.Scanner;

public class ADAKING {

    public static void main(String[] args) {


        Scanner in = new Scanner(System.in);

        int T = 0;
        if(in.hasNextInt())
            T = in.nextInt();


        for(int i = 0;i<T;i++) {

            int N = in.nextInt();
            char[][] board = new char[8][8];
            board[0][0] = 'O';

            int allXLine = N/8;

            if(allXLine != 8 ){
                for(int j = 0;j<8;j++){
                    if(N%8 == 0){
                        board[allXLine][j] = 'X';
                    }else if(allXLine != 7){
                        board[allXLine+1][j] = 'X';

                    }
                }
            }

            int remX = N%8;

            if(remX != 0 ){
                for(int j = 7;j>=remX;j--){
                    board[allXLine][j] = 'X';
                }
            }

            for(char[] x: board){
                for(char y: x){
                    if(y == 'X' || y == 'O')
                        System.out.print(y);
                    else
                        System.out.print('.');
                }
                System.out.println();
            }
        }


    }

}
