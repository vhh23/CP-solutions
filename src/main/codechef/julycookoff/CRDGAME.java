package main.codechef.julycookoff;

import java.util.Scanner;

public class CRDGAME {


    /**
     * CRDGAME
     *
     * 2
     * 3
     * 10 4
     * 8 12
     * 7 6
     * 2
     * 5 10
     * 3 4
     * @param args
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int T = 0;
        if(in.hasNextInt())
            T = in.nextInt();

        for(int i = 0;i<T;i++) {

            int N = in.nextInt();
            long c = 0;
            long m = 0;
            for(int j = 0;j<N;j++){
                int cx = in.nextInt();
                int mx = in.nextInt();
                int ca = 0;
                int ma = 0;
                while(cx > 0)
                {
                    ca += cx % 10;
                     cx = cx / 10;
                }

                while(mx > 0)
                {
                    ma += mx % 10;
                    mx = mx / 10;
                }


                if(ca > ma){
                    c++;
                }else if(ca == ma){
                    c++;
                    m++;
                }else {
                    m++;
                }
            }

            if(c == m){
                System.out.println(2+" "+ c);
            }else if (c > m){
                System.out.println(0+" "+c);
            }else {
                System.out.println(1+" "+m);

            }
        }
    }
}
