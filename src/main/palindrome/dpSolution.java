package main.palindrome;

public class dpSolution {

    public static void main(String[] args) {

        dpSolution dp = new dpSolution();

        String s1 = "abbcccbbbcaaccbababcbcabca";
        String s2 = "geekeg";
        String s3 = "geekeeg";
        String s4 = "geek";
        String s5 = "gek";


        printLongestPalindromicSequence(s1);



    }

    private static void printLongestPalindromicSequence(String testString) {


        int[][] dpTable = new int[testString.length()][testString.length()];


        int index = -1;
        int maxLength = -1;
        boolean flag = false;


        for(int i = 0; i< testString.length();i++){
            dpTable[i][i] = 1;
            if(!flag){
                index = i;
                maxLength =1;

            }
        }


        flag = false;
        for(int i =0;i<testString.length()-1; i++){

            if(testString.charAt(i) == testString.charAt(i+1)){
                dpTable[i][i+1] = 1;
                if(!flag){
                    index = i;
                    maxLength =2;
                    flag = true;
                }

            }
        }



        for(int k = 3;k<=testString.length();k++){
            flag = false;
            for(int i = 0;i<testString.length() - k +1;i++){

                int j = k - 1 + i;

                if(dpTable[i+1][j-1] == 1 && testString.charAt(i) == testString.charAt(j)){
                    dpTable[i][j]=1;
                    if(!flag){
                        index = i;
                        maxLength = k;
                        flag = true;
                    }

                }

            }

        }


        if(index == -1){
            System.out.println("Something wrong!");
        }else {
            System.out.println(index+" ------ "+maxLength);
            System.out.println(testString.substring(index,maxLength+index));
        }

    }
}
