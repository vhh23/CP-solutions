package main.codesignal;

import java.util.Stack;

public class decodeString {
    public static void main(String[] args) {

        String s1 = "100[codesignal]";
        System.out.println(decodeString(s1));
    }


   public static String decodeString(String s) {

        Stack<String> sChar = new Stack<>();
        Stack<Integer>  sInt = new Stack<>();

        String res = "";
        for(int x = 0; x< s.length();x++){
            if(isNum(s.charAt(x))){
                String num = "";
                while (isNum(s.charAt(x)))
                {
                    num = num.concat(s.charAt(x)+"");
                    x++;
                }
                x--;
                sInt.push(Integer.parseInt(num));
            }else if(s.charAt(x) == ']'){
                StringBuilder temp = new StringBuilder();
                while(!sChar.isEmpty() && !sChar.peek().equals("[")){
                    temp.insert(0, sChar.pop());
                }
                sChar.pop();
                StringBuilder t2 = new StringBuilder();
                int count = 1;
                if(!sInt.isEmpty())
                     count = sInt.pop();
                for(int i = 1;i<=count;i++){
                    t2.append(temp);
                }
                sChar.push(t2.toString());
            }else {
                sChar.push(s.charAt(x)+"");
            }
        }
        while(!sChar.isEmpty())
            res = sChar.pop().concat(res);
        return res;
    }


    public static boolean isNum(char x){
        return x == '1' || x == '2' ||x == '3' ||x == '4' ||x == '5' ||x == '6' ||
                x == '7' ||x == '8' ||x == '9' || x == '0';
    }
}
