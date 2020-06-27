package main.codesignal;

public class challengeMatrix {
    public static void main(String[] args) {
        
        char[][] m = {{'1','0','1','1','1'}, 
                {'1','0','1','1','1'},
                {'1','1','1','1','1'}, 
        {'1','0','0','1','0'}, 
    {'1','0','0','1','0'}};

        char[][] m1 = {{}};

        System.out.println(maximalSquare(m));


    }


   public static int maximalSquare(char[][] m) {


       int c = 1;
       for( int i = 0;i < m.length;i++)
           for(int j = 0; j<m[0].length;j++)
               if(i-1 >=0 && j-1 >= 0 && m[i][j] != '0'
                       && m[i-1][j-1] != '0' && m[i-1][j] != '0' &&
                       m[i][j-1] != 0){
                   m[i][j] = (char)(m[i-1][j-1]+1);
                   c = Math.max(m[i][j]-48,c);
               }

       return  c*c;

   }

}
