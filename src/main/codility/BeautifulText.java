package main.codility;

public class BeautifulText {


    public static void main(String[] args) {

        System.out.println(new BeautifulText().beautifulText("abc def ghi",4,10));
        System.out.println(new BeautifulText().beautifulText("Look at this example of a correct text",5,15));
        System.out.println(new BeautifulText().beautifulText("aa aa aaaaa aaaaa aaaaa",6,10));
        System.out.println(new BeautifulText().beautifulText("aa aa aaaaa aaaaa aaaaa",5,10));
    }

    boolean beautifulText(String s, int l, int r) {

        for(int i = 0;i<s.length();i++){

            if(s.charAt(i) == ' ' && i >= l && i <=r ){
                int j = i;
                while(j<s.length() && s.charAt(j) == ' '){
                    j = j+i+1;
                    if(j > s.length())
                        return false;
                }
                if(j==s.length() )
                    return true;
            }


        }

        return false;
    }

}
