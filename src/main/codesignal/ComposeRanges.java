package main.codesignal;

import java.util.ArrayList;

public class ComposeRanges {

    public static void main(String[] args) {

        int[] t1 = new int[]{-1,0 , 3,0, 5, 6, 7,10};
        for(String x:new ComposeRanges().composeRanges(t1)){
            System.out.println(x);
        }
    }


    String[] composeRanges(int[] nums) {


        ArrayList<String> l = new ArrayList<>();

        if(nums.length == 0){
            return l.toArray(new String[0]);
        }
        if(nums.length == 1)
            return new String[]{nums[0]+""};

        int j = 0;
        int start = nums[0];
        int i = 1;
        for( i = 1; i< nums.length;i++){

            if(nums[i-1]+1 != nums[i]){
                if(start == nums[i-1])
                    l.add(start+"");
                else
                    l.add(start+"->"+nums[i-1]);

                j = i;
                start = nums[j];
            }

        }
        if(start == nums[nums.length-1] ){
            l.add(start+"");
        }else {
            l.add(start+"->"+nums[nums.length-1]);
         }

        return l.toArray(new String[0]);




    }

}
