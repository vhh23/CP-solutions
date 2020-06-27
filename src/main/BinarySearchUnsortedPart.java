package main;

import java.util.ArrayList;

public class BinarySearchUnsortedPart {


    public static void main(String[] args) {

        ArrayList<Integer> t1 = new ArrayList<Integer>();
        t1.add(1);t1.add(2);t1.add(4);t1.add(3);t1.add(5);

        ArrayList<Integer> t2 = new ArrayList<Integer>();
        t2.add(3);t2.add(2);t2.add(1);

        ArrayList<Integer> r1 = subUnsort(t1);
        r1.forEach(x-> System.out.print(x+"-"));
        System.out.println("Next");

        ArrayList<Integer> r2 = subUnsort(t2);
        r2.forEach(x-> System.out.print(x+", "));
    }


    public static ArrayList<Integer> subUnsort(ArrayList<Integer> arr) {
        ArrayList<Integer> r1 = new ArrayList<Integer>();

        int n = arr.size();
        int s = 0, e = n-1, i, max, min;

        // step 1(a) of above algo
        for (s = 0; s < n-1; s++)
        {
            if (arr.get(s) > arr.get(s+1))
                break;
        }
        if (s == n-1)
        {
            r1.add(-1);
            return r1;
        }

        // step 1(b) of above algo
        for(e = n - 1; e > 0; e--)
        {
            if(arr.get(e) < arr.get(e-1))
                break;
        }

        // step 2(a) of above algo
        max = arr.get(s); min = arr.get(s);
        for(i = s + 1; i <= e; i++)
        {
            if(arr.get(i) > max)
                max = arr.get(i);
            if(arr.get(i) < min)
                min = arr.get(i);
        }

        // step 2(b) of above algo
        for( i = 0; i < s; i++)
        {
            if(arr.get(i) > min)
            {
                s = i;
                break;
            }
        }

        // step 2(c) of above algo
        for( i = n -1; i >= e+1; i--)
        {
            if(arr.get(i) < max)
            {
                e = i;
                break;
            }
        }
        r1.add(s);
        r1.add(e);
        return r1;
    }

    private static int binarySearch(ArrayList<Integer> a, boolean b) {

        int size = a.size();
        int low = 0;
        int high = a.size()-1;


        if(b){

            while(low<high){
                int mid = (low+high)/2;
                int midValue = a.get(mid);
                int midPrev = a.get(mid-1);
                int midNext = a.get(mid+1);

                if(midValue > midPrev && midValue > midNext){
                    return mid;
                } else if(midPrev > midValue && midValue > midNext){
                    low = mid;
                } else {
                    high = mid;
                }
            }


        }else {
            while(low<high){
                int mid = (low+high)/2;
                int midValue = a.get(mid);
                int midPrev = a.get(mid-1);
                int midNext = a.get(mid+1);

                if(midValue < midPrev && midValue < midNext){
                    return mid;
                } else if(midPrev < midValue && midValue < midNext){
                    low = mid;
                } else
                    high = mid;
            }
        }

        return -1;
    }
}
