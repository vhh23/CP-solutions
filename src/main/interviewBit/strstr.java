package main.interviewBit;

import java.util.ArrayList;
import java.util.List;

public class strstr {

    public static void main(String[] args) {


        // 2, 10,
        String s1 = "aacaacbfaabcdefaa";
        String p1 = "aab";

        //2,3,4,8,9,13,20,29
        String s2 = "aaaaabaaaabaaabcfgaaahjaahjaaa";
        String p2 = "ccc";

        //3,20,30
        String s3 = "abcsabbcdhjkaabcaabcsbbabccabcdccbbaab";
        String p3 = "abcd";


        System.out.println(findIndexForPattern(s1, p1));
        System.out.println(findIndexForPattern(s2, p2));
        System.out.println(findIndexForPattern(s3, p3));





    }


    public static Integer findIndexForPattern(String test, String pattern){

        //find the pi array
        int[] piArray = findPiArray(pattern);

        int i, j =-1;


        for(i=0;i<test.length();i++){
            if(test.charAt(i) == pattern.charAt(j+1)){
                j = j+1;
                //check for full match
                if(j == pattern.length()-1){
                    //System.out.println("Found full match at "+ i);
                    return i - pattern.length()+1;
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


        return -1;

    }

    private static int[] findPiArray(String pattern) {

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
