package main.codility;

public class RangeK {
    public static void main(String[] args) {

        System.out.println(findRange(10,1,112));




    }

    private static int findRange(int A, int B, int K) {

        int start = -1;
        int end = -1;
        for(int i = A;i<=B;i++){
            if(i % K == 0) {

                start = i;
                break;
            }
        }

        if(start != -1){
            for(int i = B;i>=A;i--){
                if(i % K == 0) {

                    end = i;
                    break;
                }
            }
        }




        return start == -1 ? 0 : (end/K) - (start/K) + 1;
    }


}
