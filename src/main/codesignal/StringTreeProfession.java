package main.codesignal;

import java.util.ArrayList;
import java.util.List;

public class StringTreeProfession {
    public static void main(String[] args) {

        System.out.println(findProfession(30,163126329));
    }


    public static String findProfession(int l, int pos) {

        long index = ((long)Math.pow(2,l+1) )+ pos - 1;

        int count = 0;



        while(index/2 !=0){
            long temp = index/2;

            if(temp % 2 != 0 && index % 2 != 0 ){
                count++;
            }else if(temp % 2 == 0 && index% 2 != 0 ){
                count++;
            }

            index = temp;

        }



        return count % 2 == 0 ? "Engineer":"Doctor";
    }

}
