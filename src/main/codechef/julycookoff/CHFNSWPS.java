package main.codechef.julycookoff;

import java.util.*;
import java.util.stream.Collectors;


/*
7
6
6 6 6 6 6 6
8 8 8 8 8 8
5
6 6 6 6 6
8 8 8 8 8
8
1 2 3 6 6 6 8 8
2 3 1 7 7 6 9 9
3
1 2 3
2 1 3
1
0
0
2
1 1
1 1
1
1
1
 */
public class CHFNSWPS {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int T = 0;
        if(in.hasNextInt())
            T = in.nextInt();

        for(int i = 0;i<T;i++) {

            int N = in.nextInt();
            Map<Long,Integer> mapA = new TreeMap<>();
            Map<Long, Integer> mapB = new TreeMap<>(Collections.reverseOrder());
            long cost = 0;
            for(int j=0;j<N;j++){
                long x = in.nextLong();
                if(mapA.containsKey(x)){
                    mapA.put(x,mapA.get(x)+1);
                }else{
                    mapA.put(x,1);
                }
            }

            for(int j=0;j<N;j++){
                long x = in.nextLong();
                 if(mapA.containsKey(x)){
                     if(mapA.get(x) <= 1){
                         mapA.remove(x);
                     }else{
                         mapA.put(x,mapA.get(x)-1);
                     }

                 }else if(mapB.containsKey(x)) {
                     mapB.put(x,mapB.get(x)+1);
                 }else{
                     mapB.put(x,1);
                 }
            }

            if(mapA.size() == 0 && mapB.size() == 0){
                System.out.println(0);
            }else{

                Integer sumA = mapA.values().stream().reduce(Integer::sum).get();
                Integer sumB = mapA.values().stream().reduce(Integer::sum).get();

                if(sumA % 2 != 0 || sumB %2 != 0 || !sumA.equals(sumB)){
                    System.out.println(-1);

                }else if(mapA.values().stream().anyMatch(x -> x % 2 != 0)
                        || mapB.values().stream().anyMatch(x -> x % 2 != 0) ) {

                    System.out.println(-1);

                }else {

                     int ai = 0;
                     int bi = 0;
                    List<Long> Al = new ArrayList<>(mapA.keySet());
                    List<Long> Bl = new ArrayList<>(mapB.keySet());
                    while(ai < Al.size() && bi < Bl.size()){

                        long nextA = Al.get(ai);
                        long nextB = Bl.get(bi);
                       cost += Math.min(nextA,nextB);

                        int Aval = mapA.get(nextA);
                        int Bval = mapB.get(nextB);

                        if(Aval -2 == 0){
                            mapA.remove(nextA);
                            ai++;
                        }else{
                            mapA.put(nextA,mapA.get(nextA)-2);
                        }

                        if(Bval -2 == 0){
                            mapB.remove(nextB);
                            bi++;
                        }else{
                            mapB.put(nextB,mapB.get(nextB)-2);
                        }


                    }


                    System.out.println(cost);
                }


            }

        }


    }
}
