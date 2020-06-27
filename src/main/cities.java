package main;

import java.util.ArrayList;
import java.util.List;

public class cities {
    public static void main(String[] args) {

        int[] t1 = new int[]{9,1,4,9,0,4,8,9,0,1};

        int[] res = findTriplet(t1);

        for (int re : res) {
            System.out.print(re+", ");
        }

    }

    private static int[] findTriplet(int[] A) {

        int[] result = new int[A.length];


        int root = findRoot(A);



        ArrayList<Integer> next = new ArrayList<Integer>(){};
        next.add(root);
        int i = 0;
        while (!next.isEmpty()){

            ArrayList<Integer> temp = (ArrayList<Integer>) next.clone();

            next.clear();
            temp.forEach(x->{
                next.addAll(findNextIndexes(x,A));

            });
            result[i] = next.size();
            i++;
        }




        return result;
    }

    private static List<Integer> findNextIndexes(int find, int[] a) {

        List<Integer> res = new ArrayList<>();
        for(int i =0;i<a.length;i++){
            if(a[i] == find && i != find){
                res.add(i);
            }
        }
        return res;
    }

    private static int findRoot(int[] a) {

        for(int i =0;i<a.length;i++){
            if(a[i]==i){
                return i;
            }
        }

        return 0;
    }


}
