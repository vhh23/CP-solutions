package main.leetcode;

import java.util.HashMap;
import java.util.Map;

public class CheckPerm {

    public static void main(String[] args) {


        System.out.println(new CheckPerm().checkPerm("abc","bbbca"));
    }

    private boolean checkPerm(String s1, String s2) {


        Map<Character,Integer> store = new HashMap<>();
        int total = 0;
        for(char x: s1.toCharArray()){
            total += x;
            store.compute(x,(k,v)->{
                if(store.containsKey(x))
                    return store.get(x)+1;
                else
                    return 1;
            });
        }

        int i;
        int p1 = 0;
        int temp = 0;
        for(i=0;i<s2.length();i++) {

            int x = s2.charAt(i);
            temp += x;
            if (temp == total) {
                if (check(s2, i, p1, store)) {
                    return true;
                }
            }

            while (p1 >= 0 && p1 <= i) {
                int can = s2.charAt(p1);
                if (temp == total) {
                    if (check(s2, i, p1, store)) {
                        return true;
                    }else{
                        temp = temp - can;
                        p1++;
                    }
                } else if (temp > total) {
                    temp = temp - can;
                    p1++;
                } else {
                    break;
                }
            }
        }

        return false;
    }

    private boolean check(String s2, int i, int p1, Map<Character, Integer> store) {

        HashMap<Character, Integer> cloned = new HashMap<>(store);
        for(int j=p1;j<=i;j++){
            char x = s2.charAt(j);
            if(cloned.containsKey(x) && cloned.get(x) > 0){
                cloned.put(x,cloned.get(x)-1);
            }else{
                return false;
            }
        }

        return cloned.values().stream().allMatch(x->x == 0);
    }
}
