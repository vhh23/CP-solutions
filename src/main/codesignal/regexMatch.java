package main.codesignal;

public class regexMatch {


    public static void main(String[] args) {
        System.out.println(new regexMatch().regexMatching("nal$","codesignal"));
    }

    boolean regexMatching(String pattern, String test) {

        if(pattern.charAt(0) == '^'){
            if(pattern.substring(1).equals(test.substring(0,pattern.length()-1)) )
                return true;
            else
                return false;

        }else if(pattern.charAt(pattern.length()-1) == '$'){
            if(pattern.substring(0,pattern.length()-1).equals(test.substring(test.length() - pattern.length()+1)) )
                return true;
            else
                return false;
        }else {

            int[] piArray = findPiArray(pattern);

            int i, j =-1;


            for(i=0;i<test.length();i++){
                if(test.charAt(i) == pattern.charAt(j+1)){
                    j = j+1;
                    if(j == pattern.length()-1){
                        return true;
                    }
                } else {

                    while (j!= -1 && test.charAt(i)!= pattern.charAt(j+1))
                    {
                        j = piArray[j];
                    }

                    if(test.charAt(i)== pattern.charAt(j+1))
                        j = j+1;
                }


            }


            return false;

        }





    }





    public   int[] findPiArray(String pattern) {

        int[] piArray = new int[pattern.length()];

        int j= 0;

        piArray[0] = 0;

        for(int i =1; i< pattern.length();i++){

            if(pattern.charAt(i) == pattern.charAt(j)){
                //char match
                piArray[i] = j+1;
                j++;
            } else {

                while (j != 0 && pattern.charAt(j) != pattern.charAt(i)){
                    j = piArray[j-1];
                }

                if(pattern.charAt(j) == pattern.charAt(i)){
                    piArray[i] = j+1;
                    j++;
                }

            }

        }

        for (int i = 0; i<piArray.length; i++){
            piArray[i] = piArray[i]-1;
        }


        return piArray;

    }

}
