package main.codility;

public class PermCheck {
    public static void main(String[] args) {
        int[] s1 = new int[]{1000000000,1,2,3};
        System.out.println(solution(s1));//1
        int[] s2 = new int[]{5,4,4,2,3};
        System.out.println(solution(s2));//0
        int[] s3 = new int[]{5,5,5};
        System.out.println(solution(s3));//0

    }

    private static int solution(int[] A) {

        int sum = 0;
        for (int x : A) {
            sum += x;
        }


        int calculatedSum = (A.length*(A.length+1))/2;

        if(calculatedSum == sum)
            return 1;
        else
            return 0;

    }
}
