package main.toptal;

import java.util.HashMap;
import java.util.Map;

public class tests {

    public static void main(String[] args) {

        System.out.println(new tests().solution(new String[0],new String[0]));
        System.out.println(new tests().solution(null,null));

    }

    public int solution(String[] T, String[] R) {


        if(T == null || R == null || T.length == 0 || R.length == 0){
            return 0;
        }

        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i<T.length;i++){

            String x = T[i];
            int testSeq = findTestSeq(x);
            if(map.containsKey(testSeq)){
                int currentStatus = map.get(testSeq);
                if(currentStatus == 1 && !R[i].equals("OK")){
                    map.put(testSeq,0);
                }

            }else{
                if(R[i].equals("OK")){
                    map.put(testSeq,1);
                }else{
                    map.put(testSeq,0);
                }
            }
        }

        int totalSets = map.size();
        int passedSets = (int) map.values().stream().filter(x->x == 1).count();

        return (int) Math.floor((passedSets*100)/totalSets);





    }

    private int findTestSeq(String x){

        if(x.isEmpty())
            return -1;

        if(x.charAt(x.length() - 1 ) >=97 && x.charAt(x.length()-1) <= 122 ){
            return Integer.parseInt(x.charAt(x.length()-2)+"");
        } else {
            return Integer.parseInt(x.charAt(x.length()-1)+"");

        }

    }
}
