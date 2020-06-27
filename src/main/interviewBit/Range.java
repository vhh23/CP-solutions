package main.interviewBit;

import java.util.ArrayList;
import java.util.List;

public class Range {


    public static void main(String[] args) {

        Range r = new Range();

        //[5, 7, 7, 8, 8, 10]
        List<Integer> s1 = new ArrayList<>();
        s1.add(8);
        s1.add(8);
        s1.add(8);



        ArrayList<Integer> integers = r.searchRange(s1, 8);
        System.out.println(integers.get(0)+"---"+integers.get(1));

    }


    public ArrayList<Integer> searchRange(final List<Integer> A, int B) {


        ArrayList<Integer> result = new ArrayList<>();
        int l = 0;
        int h = A.size() -1;
        int start = -1;

        if(A.size() == 1){
            if(A.get(0) == B){
                result.add(0);
                result.add(0);
            } else {
                result.add(-1);
                result.add(-1);
            }
          return result;
        }

        if(A.get(0) == B){
            start = 0;
        } else {
            while (l<h){
                int mid = l+((h-l)/2);
                int midP = mid-1;
                if(midP >=0 && A.get(midP) <B && A.get(mid) == B){
                    start = mid;
                    break;
                } else if(midP >=0 && A.get(midP) < B && A.get(mid) < B && l != mid){
                    l = mid;
                } else {
                    h = mid;
                }

            }
        }

          l = 0;
         h = A.size()-1;
        int end = -1;

        if(A.get(A.size()-1) == B){
            end = A.size()-1;
        } else {
            while (l<h){
                int mid = l+((h-l)/2);
                int midN = mid+1;
                if(midN < A.size() && A.get(midN) > B && A.get(mid) == B){
                    end = mid;
                    break;
                } else if(midN < A.size() && A.get(midN) > B && A.get(mid) > B ){
                    h = mid;
                } else {
                    if(l == mid)
                        break;
                    l = mid;
                }

            }
        }


        result.add(start);
        result.add(end);

       return result;
    }




}
