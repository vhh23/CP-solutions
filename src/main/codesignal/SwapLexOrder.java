package main.codesignal;

import java.util.*;

public class SwapLexOrder {
    public static void main(String[] args) {
        String s1 = "fixmfbhyutghwbyezkveyameoamqoi";
        int[][] pairs ={{8,5},
                {10,8},
                {4,18},
        {20,12},
    {5,2},
        {17,2},
        {13,25},
        {29,12},
        {22,2},
        {17,11}};
        //zdxrabca
        //"dbcaefhg"
        System.out.println(swapLexOrder(s1,pairs));
    }



   public static String swapLexOrder(String str, int[][] pairs) {

    char[] res = new char[str.length()+1];

       Map<Integer,Integer> fromTo = new HashMap<>();
       Map<Integer,Integer> toFrom = new HashMap<>();
       TreeMap<String,Integer> indexMap = new TreeMap<>(Collections.reverseOrder());
       for(int[] x: pairs){
          // if(fromTo.containsKey(x[0])){
            //   toFrom.put(x[0],x[1]);
           //}else {
               fromTo.put(x[0],x[1]);
           //}
           //if(toFrom.containsKey(x[1])){
             //  fromTo.put(x[1],x[0]);
           //}else {
               toFrom.put(x[1],x[0]);
           //}
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


       Set set = indexMap.entrySet();
       Iterator i = set.iterator();
       // Display elements
       while(i.hasNext()) {
           Map.Entry<String,Integer> me = (Map.Entry<String, Integer>) i.next();
           String key = me.getKey();
           int cindex = me.getValue();

           int dindex = getTheBestIndex(cindex+1,occupied,fromTo,toFrom);

            res[dindex] = key.charAt(0);

           occupied.add(dindex);
       }

       String s="";
       for(int k = 1;k<res.length;k++){
           s=s.concat(res[k]+"");
       }

    return s;

    }

    private static int getTheBestIndex(int cindex, Set<Integer> occupied,
                                       Map<Integer, Integer> fromTo, Map<Integer, Integer> toFrom) {

        Set<Integer> probableIndex = new TreeSet<>();
        probableIndex.add(cindex);
        int check = cindex;

        while(fromTo.containsKey(check)){
            check = fromTo.get(check);
            probableIndex.add(check);
        }

        check = cindex;
        while(toFrom.containsKey(check)){
            check = toFrom.get(check);
            probableIndex.add(check);
        }


        Iterator<Integer> it = probableIndex.iterator();
        int findex = -1;
        while (it.hasNext()){
            int pindex = it.next();
            if(!occupied.contains(pindex)){
                findex = pindex;
                break;
            }
        }

        return findex;
    }

}
