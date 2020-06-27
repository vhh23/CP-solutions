package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KMP {
    public static void main(String[] args) {

        KMP kmp = new KMP();

        // 2, 10,
        String s1 = "aabaacbfaabcdefaa";
        String p1 = "aab";

        //2,3,4,8,9,13,20,29
        String s2 = "aaaaabaaaabaaabcfgaaahjaahjaaa";
        String p2 = "aaa";

        //3,20,30
        String s3 = "abcdabbcdhjkaabcaabcdbbabccabcdccbbaab";
        String p3 = "abcd";


        List<Integer> indexForPattern1 = kmp.findIndexForPattern(s1, p1);

        indexForPattern1.forEach(x-> System.out.print(x+", "));

        System.out.println("-----------------------");

        List<Integer> indexForPattern2 = kmp.findIndexForPattern(s2, p2);

        indexForPattern2.forEach(x-> System.out.print(x+", "));

        System.out.println("-----------------------");

        List<Integer> indexForPattern3 = kmp.findIndexForPattern(s3, p3);

        indexForPattern3.forEach(x-> System.out.print(x+", "));


    }


    public  List<Integer> findIndexForPattern(String test, String pattern){

        //find the pi array
        int[] piArray = findPiArray(pattern);
        List<Integer> result = new ArrayList<>();

        int i, j =-1;


        for(i=0;i<test.length();i++){
            if(test.charAt(i) == pattern.charAt(j+1)){
                j = j+1;
                //check for full match
                if(j == pattern.length()-1){
                    //System.out.println("Found full match at "+ i);
                    result.add(i);
                    j = piArray[j];
                }
            } else {
                //if it doesnt match, find second largest suffix which is the prefix of the pattern

               while (j!= -1 && test.charAt(i)!= pattern.charAt(j+1))
               {
                   j = piArray[j];
               }

               if(test.charAt(i)== pattern.charAt(j+1))
                   j = j+1;
            }


        }


        return result;

    }

    public   int[] findPiArray(String pattern) {

        int[] piArray = new int[pattern.length()];

        int j= 0;

        piArray[0] = 0;

        for(int i =1; i< pattern.length();i++){

            if(pattern.charAt(i) == pattern.charAt(j)){
                //char match
                piArray[i] = j+1;
                j++;
            } else {

                while (j != 0 && pattern.charAt(j) != pattern.charAt(i)){
                    j = piArray[j-1];
                }

                if(pattern.charAt(j) == pattern.charAt(i)){
                    piArray[i] = j+1;
                    j++;
                }

            }

        }

        for (int i = 0; i<piArray.length; i++){
            piArray[i] = piArray[i]-1;
        }


        return piArray;

    }

}
