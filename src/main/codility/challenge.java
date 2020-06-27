package main.codility;

public class challenge {

    public static void main(String[] args) {

        int[] s1 = new int[]{5, 3 , 2 , 4};
        int[] s2 = new int[]{3, 1, 4};
        int[] s3 = new int[]{5, 3, 5, 2, 1};
        int[] s4 = new int[]{7,7,3,7,7};
        int[] s5 = new int[]{1,1,7,6,6,6};

       /* System.out.println(solution(s1));
        System.out.println(solution(s2));
        System.out.println(solution(s3));
        System.out.println(solution(s4));*/
        System.out.println(solution(s5));
    }


    public static int solution(int[] H) {
        // write your code in Java SE 8
        int l = H.length;

        int[] maxL = new int[H.length];
        int[] maxR = new int[H.length];
        maxL[0]= H[0];
        maxR[l-1] = H[l-1];
        for(int i = 1;i<l ;i++){
            int j = l-1-i;
            if(H[i] > maxL[i-1]){
                maxL[i] = H[i];
            } else {
                maxL[i] = maxL[i-1];
            }
            if(H[j]>maxR[j+1]){
                maxR[j] = H[j];
            } else {
                maxR[j] = maxR[j+1];
            }
        }

        int minA = Integer.MAX_VALUE;

        for (int x=0;x<l;x++){
            if(x+1>=l){
                int area = (maxL[x]*(x+1))+(maxR[x]*(l-x-1));
                minA = Math.min(area,minA);
            }else {
                int area = (maxL[x]*(x+1))+(maxR[x+1]*(l-x-1));
                minA = Math.min(area,minA);
            }
        }

        return minA;
    }
}
