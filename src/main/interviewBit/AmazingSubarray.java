package main.interviewBit;

public class AmazingSubarray {


    public static void main(String[] args) {
        String s1 = "ABEC";
        System.out.println(findNoOfAS(s1));
    }

    private static int findNoOfAS(String testString) {


        int size = testString.length();

        int count = 0;

        for(Character x: testString.toCharArray()){
            if(x == 'A' || x == 'E' || x == 'I' || x == 'O' || x == 'U' || x == 'a' ||
                    x == 'e' || x == 'i' || x == 'o' || x == 'u' ){
                count = count + size;


            }
            size --;
        }



        return count % 10003;
    }

}
