package main.codesignal;

import java.util.*;

public class SpaceXCode {

    public static void main(String[] args) {

        int[] s1 = new int[]{1, 1, 0, 0, 0, 2, 2, 2};
        char[] c1 = new char[]{'+', '+', 'A', 'A', 'B','#', '#', '#' };
        System.out.println(packetDescrambler(s1,c1,3));
    }

    public static String packetDescrambler(int[] seq, char[] fragmentData, int n) {

        TreeMap<Integer, List<Character>> map = new TreeMap<>();
        String res = "";
        for(int i = 0; i <seq.length;i++){
            if(map.containsKey(seq[i])){
                map.get(seq[i]).add(fragmentData[i]);
            }else {
                List<Character> l = new ArrayList<>();
                l.add(fragmentData[i]);
                map.put(seq[i],l);
            }
        }

        Iterator<Integer> it = map.keySet().iterator();
        while(it.hasNext()){
            int key = it.next();
            List<Character> codes = map.get(key);
            Map<Character,Integer> t  = new HashMap<>();
            int count = 0;
            char code = ' ';
            for(char x: codes) {
                if (t.containsKey(x)) {
                    int current = t.get(x);
                    t.put(x, current + 1);
                    if (current + 1 > count) {
                        count = current + 1;
                        code = x;
                    }
                } else {
                    t.put(x, 1);
                    if(count == 0){
                        count = 1;
                        code = x;
                    }

                }
            }
            if(count > n/2 ){
                res = res + code;
            }
            else
                return "";




        }

            int index = res.indexOf('#');
            if(index == res.length()-1)
                return res;
            else
                return "";
    }

}
