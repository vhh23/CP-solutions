package main.codility;

public class MaxProfit {

    public static void main(String[] args) {
        System.out.println(new MaxProfit().solution(new int[]{14}));
    }

    private int solution(int[] A) {
        int maxP = 0;
        int buyAt = Integer.MAX_VALUE;



        for(int i = 1;i<A.length;i++){

            if(buyAt == Integer.MAX_VALUE && A[i-1] < A[i]  ){
                    buyAt = A[i-1];
                    maxP = A[i] - buyAt;
            }else {
                if (A[i] > buyAt) {
                    maxP = Math.max(maxP, A[i] - buyAt);
                }else {
                    buyAt = Math.min(buyAt,A[i]);
                }
            }
            }

            return maxP;

    }
}
