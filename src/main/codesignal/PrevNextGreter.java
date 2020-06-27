package main.codesignal;

public class PrevNextGreter {


    public static void main(String[] args) {
        PrevNextGreter p = new PrevNextGreter();

        int[] s1= new int[]{2, 1, 2, 1, 2};
        System.out.println(p.nextLarger(s1));

    }

    int[] nextLarger(int[] a) {

        int[] next = nextGretest(a);
        int[] prev = prevGretest(a);
        int[] res = new int[a.length];

        for(int i = 0; i< a.length;i++){

            if(next[i] == prev[i] && next[i] == -1){
                res[i] = -1;
            }else if(next[i] == -1 ) {
                res[i] = prev[i];
            } else if(prev[i] == -1) {
                res[i] = next[i];
            } else  if(a[next[i]] < a[prev[i]]){
                    res[i] = next[i];
                }else if(a[next[i]] == a[prev[i]]) {
                    res[i] = Math.min(next[i], prev[i]);
                }else {
                    res[i] = prev[i];
                }
            }



        return res;


    }

    int[] prevGretest(int[] a) {

        int[] res = new int[a.length];
        int[] index = new int[a.length];

        res[0] = -1;
        index[0] = -1;
        for(int i = 1;i<a.length;i++){

            if(a[i-1] > a[i] ){
                res[i] = a[i-1];
                index[i] = i-1;
            }else {
                int j = i-1;
                while(res[j]!= -1 && a[i] >= res[j]){
                    j = index[j];
                }
                res[i] = res[j];
                index[i] = index[j];
            }
        }
        return index;
    }

    int[] nextGretest(int[] a) {

        int[] res = new int[a.length];
        int[] index = new int[a.length];

        res[a.length - 1] = -1;
        index[a.length - 1] = -1;
        for(int i = a.length-2;i>=0;i--){

            if(a[i+1] > a[i] ){
                res[i] = a[i+1];
                index[i] = i+1;
            }else {
                int j = i+1;
                while(res[j]!= -1 && a[i] >= res[j]){
                    j = index[j];
                }
                res[i] = res[j];
                index[i] = index[j];
            }
        }
        return index;
    }

}
