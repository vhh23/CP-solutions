package main.codesignal;

public class CLoud {
    public static void main(String[] args) {

        CLoud c = new CLoud();

        /*char[][] s1 = {
                {'0', '1', '1', '0', '1'},
                {'0', '1', '1', '0', '1'},
                {'0', '0', '1', '0', '1'},
                {'1', '0', '0', '1', '1'}
        };*/
        char[][] s1 = {};

        System.out.println(c.countClouds(s1));


    }

    int countClouds(char[][] s) {


        if(s == null || s.length == 0)
            return 0;

        boolean[][] visited = new boolean[s.length][s[0].length];

        int count = 0;
        for(int i = 0;i<s.length;i++)
            for(int j = 0;j<s[0].length;j++){

                if(!visited[i][j]){

                    if(s[i][j] == '0')
                        visited[i][j] = true;
                    else {
                        count++;
                        visit(i,j,visited,s);

                    }
                }
            }
        return count;
    }

    void visit(int i,int j, boolean[][] visited,char[][] s){

        if(visited[i][j])
            return;
        else
            visited[i][j] = true;


        //up
        if(i-1 >=0  && !visited[i-1][j] && s[i-1][j] == '1' ){
            visit(i-1,j,visited,s);
        }

        //down
        if(i+1 < visited.length  && !visited[i+1][j] && s[i+1][j] == '1' ){
            visit(i+1,j,visited,s);
        }
        //left
        if( j-1>=0 && !visited[i][j-1] && s[i][j-1] == '1' ){
            visit(i,j-1,visited,s);
        }

        //right
        if(j+1<visited[0].length && !visited[i][j+1] && s[i][j+1] == '1' ){
            visit(i,j+1,visited,s);
        }



    }
}
