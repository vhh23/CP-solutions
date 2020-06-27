package main;

import java.util.*;

public class Compress {

    public static void main(String[] args) {
        /*String str = "ABDCA";
        int[] X = new int[]{2,-1,-4,-3,3};
        int[] Y = new int[]{2,-2,4,1,-3};
        System.out.println(solution(str,X,Y));*/

        String str1 = "AA";
        int[] X1 = new int[]{1,1};
        int[] Y1 = new int[]{1,1};
        System.out.println(solution(str1,X1,Y1));
    }


    public static int solution(String S, int[] X, int[] Y) {


        Map<Character, List<Integer>> map = new HashMap<>();
        for(int i =0;i<S.length();i++){

            if(map.containsKey(S.charAt(i))){
                map.get(S.charAt(i)).add(i);

            }else{
                List<Integer> newList = new ArrayList<>();
                newList.add(i);
                map.put(S.charAt(i),newList);
            }

        }


        List<Character> tags = new ArrayList<>();
        map.keySet().forEach(x->{
            if(map.get(x).size() > 1){
                tags.add(x);
            }
        });
 
        if(tags.size() == 0){
            //no repeated tags we can include all points
            return S.length();
        }
        //find optimum radius for each tag
        double optimumRadius = Double.MAX_VALUE;
        for(char tag: tags){

            List<Integer> pointIndex = map.get(tag);
            List<Double> radiuses = new ArrayList<>();

            pointIndex.forEach(p-> radiuses.add(radius(X[p],Y[p])));

            Double min = Collections.min(radiuses);

            Double secondMin = radiuses.stream().filter(x -> x > min).findAny().orElse(min);

            //System.out.println("min and max for "+tag+" "+min+"-"+max);



            if(optimumRadius > secondMin){
                optimumRadius = secondMin;
            }


        }

       // System.out.println("optimum radius"+ optimumRadius);

        //get all the points within optimum radius
        int finalPointsCount = 0;
        for(int i =0;i<X.length;i++){
            double radius = radius(X[i],Y[i]);
            System.out.println("radius for "+i+"-"+radius);
            if(radius < optimumRadius){
                finalPointsCount++;
            }
        }

        return finalPointsCount;
     }

     public static double radius(int x, int y){

        return Math.sqrt((x*x) + (y*y));
     }
}
