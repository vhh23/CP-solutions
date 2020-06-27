package main;

import java.util.ArrayList;
import java.util.List;

public class Duplicate {
    public static void main(String[] args) {
        List<Integer> t1 = new ArrayList<>();
        //3 4 1 4 1
        t1.add(3);t1.add(5);t1.add(1);t1.add(4);t1.add(2);

        System.out.println(repeatedNumber(t1));


    }

    public static int repeatedNumber(final List<Integer> A) {

        boolean[] b = new boolean[A.size()+1];

        for (int i = 0; i< A.size();i++){
            int t = A.get(i);
            if(b[t] == true){
                return A.get(i);
            } else {
                b[t] = true;
            }
        }

        return -1;


    }
}
