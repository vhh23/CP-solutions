package main;

import java.util.Arrays;
import java.util.Comparator;

public class x2DArraySort {

    public static void main(String[] args) {

        int[][] x2DArray = new int[3][2];
        x2DArray[0][0] = 34;
        x2DArray[0][1] = 456;
        x2DArray[1][0] = 567;
        x2DArray[1][1] = 23;
        x2DArray[2][0] = 2;
        x2DArray[2][1] = 2;




        for(int[] x1Darray: x2DArray){
            Arrays.stream(x1Darray).forEach(x-> System.out.print(x+" "));
            System.out.println("");
        }

    }
}
