package main.codechef.junecookoff;

import java.util.Scanner;
/*
1
5
 */
public class EVENM {

    public static void main(String[] args) {


        Scanner in = new Scanner(System.in);

        int T = 0;
        if(in.hasNextInt())
            T = in.nextInt();

        for(int i = 0;i<T;i++) {

            int n = in.nextInt();

            int n2 = n*n;
            int temp = 1;
            if(n2 % 2 ==0){
                //even num
                int rowNum = 1;
                int prevNum = -1;
                for(int j = 1;j<=n2;j++){

                    if(rowNum % 2 != 0){

                        System.out.print(j+" ");
                        if(j % n ==0 ){
                            rowNum++;
                            prevNum = j+1;
                            j++;
                            System.out.println("");
                        }

                    }else {

                        if(prevNum != -1 && j % n == 1 && rowNum != 2){
                            j++;
                            System.out.print(j+" ");
                        } else if(j % n == 0){
                            System.out.print(j+" "+ prevNum);
                            prevNum = -1;
                            rowNum++;
                            System.out.println("");
                        } else {
                            System.out.print(j+" ");
                        }


                    }

                }
            }else {
                //odd num
                for(int j = 1;j<=n2;j++,temp++){

                    if(temp > n){
                        temp = 1;
                        System.out.println("");
                        System.out.print(j+" ");
                    } else {
                        System.out.print(j+" ");
                    }
                }

            }
        }


    }
}
