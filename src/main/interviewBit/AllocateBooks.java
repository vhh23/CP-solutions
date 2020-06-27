package main.interviewBit;

import java.util.ArrayList;

public class AllocateBooks {


    public static void main(String[] args) {
        AllocateBooks ab = new AllocateBooks();






    }

    private long findAllocateBooks(ArrayList<Integer> A, int B) {

        int len = A.size();
        if(len < B) return -1;
        int total =0 ; int max = Integer.MIN_VALUE;
        for(int i=0;i<len;i++){
            total += A.get(i);
            max = Math.max(max,A.get(i));
        }

        int lo = max;int hi = total;
        while(lo < hi) {
            int mid = lo + (hi-lo)/2;
            int requiredReaders = getRequiredReaders(A, mid);
            if(requiredReaders <= B) {
                hi = mid;
            }else {
                lo = mid + 1;
            }
        }
        return lo;

    }

    private int getRequiredReaders(ArrayList<Integer> a, int maxLengthPerReader) {
        int total = 0;
        int readers = 1;
        for(int i = 0; i < a.size(); i++) {
            total += a.get(i);
            if(total > maxLengthPerReader) {
                total = a.get(i);
                readers++;
            }
        }
        return readers;
    }
}
