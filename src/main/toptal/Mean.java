package main.toptal;

public class Mean {
    public static void main(String[] args) {
        System.out.println(new Mean().solution(new int[]{2,1,3},2));
        System.out.println(new Mean().solution(new int[]{0,4,3,-1},2));
        System.out.println(new Mean().solution(new int[]{2,1,4},3));
        System.out.println(new Mean().solution(new int[]{2,2,2,2,2,2,2,2,2,2,2,-2},-2));

    }

    public int solution(int[] A, int S) {
        // write your code in Java SE 8

        if(A == null || A.length == 0){
            return 0;
        }

        int[] sumA = new int[A.length];
        sumA[0] = A[0];
        for(int i = 1; i<A.length;i++){
            sumA[i] = sumA[i-1] + A[i];
        }
        int count = 0;
        for(int i = 0;i<A.length;i++){
            for(int j = i;j<A.length;j++){

                int diff = sumA[j] - sumA[i] + A[i];
                if(diff%(j-i+1) == 0 && diff/(j-i+1) == S){
                    count++;
                    if(count == 1000000000){
                        return count;
                    }
                }
            }
        }

        return count;
    }
}
