package main.codesignal;

import java.util.ArrayList;
import java.util.Stack;

public class minStack {
    public static void main(String[] args) {

        String[] s1 = {"push 10",
                "min",
                "push 5",
                "min",
                "push 8",
                "min",
                "pop",
                "min",
                "pop",
                "min"};
        System.out.println(minimumOnStack(s1));

    }
    public static int[] minimumOnStack(String[] operations) {

        Stack<Integer> actual = new Stack<>();
        Stack<Integer> min = new Stack<>();
        ArrayList<Integer> res = new ArrayList<>();

        for(String x: operations){

            if(x.contains("push")){
                String[] s = x.split(" ");
                int num = Integer.parseInt(s[1]);
                actual.push(num);
                if(min.isEmpty()){
                    min.push(num);
                }else if(min.peek() > num){
                    min.push(num);
                }


            } else if(x.contains("pop")){

                if(!actual.isEmpty()){
                    int pop = actual.pop();
                    if(!min.isEmpty() && min.peek().intValue() == pop){
                        min.pop();
                    }
                }

            } else if(x.contains("min")){
                if(!min.isEmpty()){
                    res.add(min.peek());
                }

            }

        }
        int[] resI = new int[res.size()];
        int i =0;
        for(int x: res){
            resI[i] = x;
            i++;
        }

        return resI;

    }


}
