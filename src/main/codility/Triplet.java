package main.codility;

import java.util.Arrays;

public class Triplet {
    public static void main(String[] args) {

        int[] a = new int[]{-3,-1,-2,-2,-5,-6};
        //-3,-2,1,2,5,6
        System.out.println(tripletMax(a));


    }

    private static int tripletMax(int[] A) {

        int max = Integer.MIN_VALUE;
        Arrays.sort(A);
        int n = A.length;


        return Math.max(A[0]*A[1]*A[n-1],A[n-1]*A[n-2]*A[n-3]);
    }
}
