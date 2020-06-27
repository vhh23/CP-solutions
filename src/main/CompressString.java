package main;

import org.xml.sax.ext.DeclHandler;

public class CompressString {
    public static void main(String[] args) {

        String s1 = "ABBBCCDDCCC";
        String s2 = "ABCDDDEFG";
        String s3 = "AAAAAAAAAAABXXAAAAAAAAAA";
        String s4 = "AAAAAAAAAAVAAAAAAAAAA";

       System.out.println(compress(s1,3));
        System.out.println(compress(s2,2));
        System.out.println(compress(s3,3));
        System.out.println(compress(s4,2));

    }

    public static int compress(String s, int k){

        int l = s.length();
        int[] counts = new int[l];
        char[] chars = new char[l];
        int[] lengths = new int[l];

        int i = 0;
        int currentSize = 0;
        for(int j = 0;j<l;j++){
            int count = 1;
            char c = s.charAt(j);
            chars[i] = c;
            while (j<l-1 && c == s.charAt(j+1)){
                count++;
                j++;
            }

            counts[i] = count;
            lengths[i] = findLength(count);
            currentSize += lengths[i];
            i++;
        }


        int reducedSize = currentSize;

        for (int a = 0;a<chars.length;a++){
            if(counts[a]>0)
            {
                //System.out.println(chars[a]+" ->"+counts[a]+" ->"+lengths[a]);

                //reduction due to K chars
                int temp = k;
                int start = a-1;
                int end = a;
                int reducedlength = 0;
                int reducedEndCount = 0;
                while (temp != 0 && counts[end] != 0){
                    if(temp < counts[end]){
                        reducedlength += lengths[end] - findLength(counts[end]-temp);
                        reducedEndCount = counts[end]-temp;
                        temp = 0;
                    } else if(temp >= counts[end]){
                        reducedlength += lengths[end];
                        temp -= counts[end];
                        reducedEndCount = counts[end];
                        end++;
                    }
                }

                //reduction due to edges overlaps
                if(start >=0 && end<l && chars[start] == chars[end]){
                        int total = counts[start]+reducedEndCount;
                        int totalLength = findLength(total);
                        reducedlength += lengths[start]+findLength(reducedEndCount) - totalLength;
                    }


                reducedSize = Math.min(reducedSize,currentSize - reducedlength );

                //System.out.println(reducedSize);
            }

        }






        return reducedSize;
    }

    private static int findLength(int count) {
        if(count == 1)
            return (count+"").length();
        else
            return (count+"").length()+1;
    }
}
