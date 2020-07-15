package main.codesignal;

import java.util.*;

public class SwapLexOrder {
    public static void main(String[] args) {
        String s1 = "dcab";
        int[][] pairs ={{0,3},
                {1,2},
                {0,2}};
        //zdxrabca
        //"dbcaefhg"
        System.out.println(swapLexOrder(s1,pairs));
    }



   public static String swapLexOrder(String str, int[][] pairs) {

    char[] res = new char[str.length()+1];

       Map<Integer,TreeSet<Integer>> fromTo = new HashMap<>();

       TreeMap<String,Integer> indexMap = new TreeMap<>();
       for(int[] x: pairs){

           if(fromTo.containsKey(x[0])){

               fromTo.get(x[0]).add(x[1]);
               if(fromTo.containsKey(x[1])){
                   fromTo.get(x[1]).add(x[0]);
               }else{
                   TreeSet<Integer> set1 = new TreeSet<>();
                   set1.add(x[0]);
                   fromTo.put(x[1],set1);
               }

           }else if(fromTo.containsKey(x[1])){
               fromTo.get(x[1]).add(x[0]);
               if(fromTo.containsKey(x[0])){
                   fromTo.get(x[1]).add(x[1]);
               }else{
                   TreeSet<Integer> set1 = new TreeSet<>();
                   set1.add(x[1]);
                   fromTo.put(x[0],set1);
               }
           }else{
               TreeSet<Integer> set1 = new TreeSet<>();
               set1.add(x[0]);

               TreeSet<Integer> set2 = new TreeSet<>();
               set2.add(x[1]);
               fromTo.put(x[0], set2);
               fromTo.put(x[1], set1);
           }

       }

       Set<Integer> occupied = new HashSet<>();

       char[] input = str.toCharArray();
       for(int x=0;x<input.length;x++){
           if(indexMap.containsKey(input[x]+"")){
               String a= input[x]+"$";
               indexMap.put(a,x);
           }else {
               indexMap.put(input[x]+"",x);
           }       }


       Set<String> strings = indexMap.keySet();
       // Display elements
       for ( String key : strings) {

           int cindex = indexMap.get(key);

           int dindex = getTheBestIndex(cindex, occupied, fromTo);

           res[dindex] = key.charAt(0);

           occupied.add(dindex);
       }

       String s="";
       for(int k = 0;k<res.length;k++){
           s=s.concat(res[k]+"");
       }

    return s;

    }

    private static int getTheBestIndex(int cindex, Set<Integer> occupied,
                                       Map<Integer, TreeSet<Integer>> fromTo) {


        TreeSet<Integer> set = fromTo.get(cindex);
        int minimum = cindex;
        for (int next : set) {
            if ( next < cindex && !occupied.contains(next)) {
                 minimum = Math.min(Math.min(minimum,next),getTheBestIndex(next,occupied,fromTo));
            }else{
                return Math.min(minimum,getTheBestIndex(next,occupied,fromTo));
            }
        }

        return minimum;
    }

}
