package main.codility;

public class MissingInteger {

    public static void main(String[] args) {
        int[] s1 = new int[]{-1,-3};
        System.out.println(solution(s1));//1
        int[] s2 = new int[]{1, 3, 6, 4, 1, 2};
        System.out.println(solution(s2));//5
        int[] s3 = new int[]{0};
        System.out.println(solution(s3));//1
        int[] s4 = new int[]{1};
        System.out.println(solution(s4));//2
        int[] s5 = new int[]{1,1,1,1,-1,-1,-1,-1,-1,-1,-1,-1};
        System.out.println(solution(s5));//2
        int[] s6 = new int[]{-1,-2,-3,1,4,4,4,2,2,2,5,5,6,7,8,9,10,11,12};
        System.out.println(solution(s6));//3
        int[] s7 = new int[]{10,9,8,7,6,5,4,3,2,1,1,1,2,3,3,2,1,113,4,5,13,12,14};
        System.out.println(solution(s7));//11
        int[] s8 = new int[]{1000000,-1000000,1};
        System.out.println(solution(s8));//2

    }

    public static int solution(int[] A) {
        // write your code in Java SE 8

        int[] flags = new int[1000001];

        for (int x:A){
            if(x>=0)
                flags[x] = 1;
        }
        int i =1;
        for(;i<1000001;i++){
            if(flags[i] != 1){
                break;
            }
        }

        return i;
    }
}
