package main.codesignal;

import java.util.Arrays;
import java.util.Iterator;
import java.util.TreeSet;

public class CountSmaller {

    public static void main(String[] args) {

        int[] arr =  new int[]{3,8,4,1};


        TreeSet<Integer> set = new TreeSet<>();

        int sum = 0;

        for(int i = arr.length-1;i>=0;i--){

            set.add(arr[i]);
            Integer lower = set.lower(arr[i]);
            if(lower != null){
                Iterator<Integer> it = set.iterator();
                int k = 0;
                while (it.hasNext()){
                    if(it.next().equals(lower)){
                        sum += k+1;
                        break;
                    }
                    k++;
                }
            }


        }


        System.out.println(sum);



    }
}
