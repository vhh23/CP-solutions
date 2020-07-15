package main;

import java.util.Map;
import java.util.TreeMap;

public class PermutationsString {


    public static void main(String[] args) {
         new PermutationsString().permutations("AABCDFGDFGTH");
    }

    private void permutations(String s) {


        int n = s.length();

        TreeMap<Character,Integer> store = new TreeMap<>();

        for(char x: s.toCharArray()){
            if(store.containsKey(x)){
                store.put(x,store.get(x)+1);
            }else{
                store.put(x,1);
            }
        }

        char[] val = new char[store.size()];
        int[] count = new int[store.size()];

        int i = 0;
        for(Map.Entry<Character, Integer> x: store.entrySet()){
            val[i] = x.getKey();
            count[i] = x.getValue();
            i++;
        }

        char[] temp = new char[n];
        perm(val, count, temp, 0);
    }

    private void perm(char[] val, int[] count, char[] temp, int level) {


        if(level == temp.length){
            print(temp);
            return;
        }


        for(int i = 0;i<val.length;i++){

            if(count[i] > 0){
                count[i] = count[i] - 1;
                temp[level] = val[i];
                perm(val,count,temp,level+1);
                count[i]++;
            }

        }


    }

    private void print(char[] chars){

        for(char x: chars){
            System.out.print(x+"");
        }
        System.out.println("");


    }

}
