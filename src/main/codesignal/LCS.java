package main.codesignal;

public class LCS {
    public static void main(String[] args) {
        System.out.println(new LCS().longestCommonSubstring("GeeksforGeeks","GeeksQuiz"));
        System.out.println(new LCS().recursiveLcs("GeeksforGeeks","GeeksQuiz"));
    }


    /*

    GrabPay is another new venture started by Grabtaxi. I was part of the Loan team, to create product like Shop now pay later, loan for drivers, pay later wallets for consumer.
    One of the most important part for any loan product is to have a good risk check engine to decrease the NPA and have a profitable business model.
    One of my main responsibility was to design, estimate and execute the risk engine with the team of developers.


     */



    int longestCommonSubstring(String s, String t) {

        int m = 0;
        int[][] lookup = new int[s.length()][t.length()];
        for(int i = 0; i<s.length(); i++)
            for(int j = 0; j<t.length(); j++){
                if(i == 0 || j == 0){
                    lookup[i][j] = 0;
                } else if(s.charAt(i-1) == t.charAt(j-1)) {
                    lookup[i][j] = 1 + lookup[i-1][j-1];
                    m = Math.max(m,lookup[i][j]);
                } else{
                    lookup[i][j] = 0;
                }
            }
        return m;
    }


    int recursiveLcs(String s, String t){

        return lcs(s,t,s.length(),t.length(),0);
    }
    int lcs(String s, String t,int i, int j, int c) {

        if (i == 0 || j == 0)  {
            return c;
        }

        if (s.charAt(i - 1) == t.charAt(j - 1)) {
            c = lcs(s,t,i - 1, j - 1, c + 1);
        }
        c = Math.max(c, Math.max(lcs(s,t,i, j - 1, 0),
                lcs(s,t,i - 1, j, 0)));
        return c;
    }
}
