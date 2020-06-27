package main;

public class MaxSubArray {


    public static void main(String[] args) {
        int [] t1 = new int[]{-2,-3,4,-2,-1,1,5,-3};
        int [] t2 = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int [] t3 = new int[]{1,2,3,4,-5};
        int [] t4 = new int[]{4,-1,2,1};
        int [] t5 = new int[]{-500,-400};

        System.out.println(findMaxSubArray(t1));
        System.out.println(findMaxSubArray(t2));
        System.out.println(findMaxSubArray(t3));
        System.out.println(findMaxSubArray(t4));
        System.out.println(findMaxSubArray(t5));


    }

    private static int findMaxSubArray(int[] x) {

        int max_ending_here = 0;
        int max = Integer.MIN_VALUE;

        for(int i =0;i<x.length;i++){
            max_ending_here = max_ending_here + x[i];

            if(max_ending_here < 0)
                max_ending_here = 0;
            if(max_ending_here > max)
                max = max_ending_here;
        }

        return max;
    }
}
