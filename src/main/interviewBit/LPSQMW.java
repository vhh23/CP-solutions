package main.interviewBit;

import main.KMP;

public class LPSQMW {

    public static void main(String[] args) {
        LPSQMW l = new LPSQMW();

        String s1 = "aaaaa";
        System.out.println( l.findOperations(s1));
    }

    private int findOperations(String s1) {

        KMP kmp = new KMP();

        String newS1 = s1.concat("$");
        for(int i =s1.length();i>0;i--){
            newS1 = newS1.concat(s1.substring(i-1,i));
        }

        System.out.println(newS1);

        int[] piArray = kmp.findPiArray(newS1);





        return s1.length() - piArray[newS1.length()-1];

    }
}
