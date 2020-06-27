package main;

import java.util.ArrayList;
import java.util.Arrays;

public class Hello {

    public static void main(String[] args) {
        int[] t1 = new int[]{1,3,6,4,1,2};
        int[] t2 = new int[]{-1000000,1000000};
        int[] t3 = new int[]{0,0,0,0,1,1,1,-1,-3, 4 , 2, 1};


        System.out.println(find(t1));
        System.out.println(find(t2));

        System.out.println(find(t3));

    }

    private static int find(int[] A) {


        boolean[] x = new boolean[1000000+1];

        for (int i : A){
            if(i > 0){
                x[i] = true;
            }
        }
        int i =1;
        for( i = 1; i<x.length; i++){
            if(x[i] != true){
                break;
            }
        }

        if( i == x.length-1){
            return  i +1;
        } else {
            return i;
        }

    }



    private static int findArraylist(ArrayList<Integer> A) {


        boolean[] x = new boolean[1000000+1];

        for (int i : A){
            if(i > 0){
                x[i] = true;
            }
        }
        int i =1;
        for( i = 1; i<x.length; i++){
            if(x[i] != true){
                break;
            }
        }

        if( i == x.length-1){
            return  i +1;
        } else {
            return i;
        }

    }
}
