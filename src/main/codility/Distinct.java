package main.codility;

import java.util.Arrays;

public class Distinct {
    public static void main(String[] args) {

        int[] arr = new int[]{2,3,3,3,6,12,1,8,9,123,567,-876,1000000,-100000,6,6,123};

        long count = Arrays.stream(arr).distinct().count();
        System.out.println(count);


    }
}
