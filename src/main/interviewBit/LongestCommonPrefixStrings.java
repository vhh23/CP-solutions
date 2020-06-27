package main.interviewBit;

import java.util.ArrayList;

public class LongestCommonPrefixStrings {

    public static void main(String[] args) {


        //    A = ["abcdefgh", "aefghijk", "abcefgh"]

        ArrayList<String> s1 = new ArrayList<>();
        s1.add("abcdefgh");
        s1.add("abcghijk");
        s1.add("abcefgh");

        System.out.println(longestCommonPrefix(s1));
    }



    public static String longestCommonPrefix(ArrayList<String> A) {


        if(A.size() < 2)
            return A.get(0);

        String lcp = findLCPBwt(A.get(0),A.get(1));


        for(int i = 2; i<A.size();i++){

            lcp = findLCPBwt(lcp,A.get(i));

            if(lcp.isEmpty()){
                break;
            }



        }

        return lcp;

    }


    public static String  findLCPBwt(String s1, String s2){

        String lcp = "";

        int ls1 = s1.length();
        int ls2 = s2.length();

        int k =0;
        while(ls1 > 0 && ls2 > 0){
            if(s1.charAt(k) == s2.charAt(k))
            {
                lcp = lcp+s1.charAt(k);
                k++;
                ls1--;
                ls2--;

            }
            else
                break;
        }


        return lcp;
    }
}
