package main.codesignal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class Justification {

    public static void main(String[] args) {
        Justification j = new Justification();

        String[] words  = {"Looks",
                "like",
                "it",
                "can",
                "be",
                "a",
                "tricky",
                "test"};

        System.out.println(Arrays.toString(j.textJustification(words, 25)));
       // System.out.println(Arrays.toString(j.textJustification(words, 10)));


    }




    String[] textJustification(String[] words, int l) {

        Queue<String> s = new LinkedBlockingQueue<>();
        ArrayList<String> list = new ArrayList<>();

        int currentSize = 0;

        for(String x: words){

            int xSize = x.length();
            if(currentSize + xSize > l){
                currentSize = currentSize - 1;
                StringBuilder temp = new StringBuilder();
                int totalSpaces = l - currentSize;
                int ws = s.size();
                int perWordSpace = totalSpaces;
                int remWordSpace = 0;
                if(ws > 1) {
                    perWordSpace = totalSpaces / (ws-1);
                    remWordSpace = totalSpaces % (ws-1);
                }


                String spaces = "";
                for(int i = 1;i<=perWordSpace;i++){
                    spaces = spaces.concat(" ");
                }

                while(!s.isEmpty()){
                    if(remWordSpace != 0){
                        temp.append(s.remove()).append(spaces).append(" ");
                        remWordSpace --;
                    }else {
                        temp.append(s.remove()).append(spaces);

                    }
                }

                if(ws > 1)
                    list.add(temp.toString().trim());
                else
                    list.add((temp.toString()));
                currentSize = xSize+1;
                s.add(x+" ");

            }else {
                currentSize += xSize+1;
                s.add(x+" ");
            }

        }
        StringBuilder temp = new StringBuilder();

        while(!s.isEmpty()){
            temp.append(s.remove());
        }

        int trailSpaces = l - temp.length();
        for(int i = 1;i<=trailSpaces;i++){
            temp.append(" ");
        }
        temp.trimToSize();
        list.add(temp.toString());







        return list.toArray(new String[0]);
    }

}
