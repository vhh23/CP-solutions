package main.leetcode;


import java.util.*;

public class sortColors {

    public static void main(String[] args) {

        //String s1 = "foo(bar(baz))blim";
        //System.out.println(check(s1));
        //int[] s1 = new int[]{1,1,3,2,5};
         //sortColors(s1);

        /*char[][] grid =  new char[][]{
                {'.', '.', '.', '1', '4', '.', '.', '2', '.'},
                {'.', '7', '6', '2', '.', '.', '.', '.', '.'},
                {'.', '.', '2', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '1', '.', '.', '.', '.', '.', '.'},
                {'.', '6', '7', '.', '.', '.', '.', '.', '9'},
                {'.', '.', '.', '.', '.', '.', '8', '1', '.'},
                {'.', '3', '.', '.', '.', '.', '.', '.', '6'},
                {'.', '.', '.', '.', '.', '7', '.', '.', '.'},
                {'.', '.', '.', '5', '.', '.', '.', '7', '.'}
        };

        System.out.println(sudoku(grid));*/


        /*String[] crypt = {"AAAAAAAAAAAAAA",
                "BBBBBBBBBBBBBB",
                "CCCCCCCCCCCCCC"};
        char[][] sol = {
                {'A','1'},
                {'B','2'},
                {'C','3'},
        {'E','5'},
    {'N','6'},
        {'D','7'},
        {'R','8'},
        {'S','9'}
        };
        System.out.println(isCryptSolution(crypt,sol));*/
      /* String[][] dishes =  {{"Salad","Tomato","Cucumber","Salad","Sauce"},
               {"Pizza","Tomato","Sausage","Sauce","Dough"} ,
        {"Quesadilla","Chicken","Cheese","Sauce"},
            {"Sandwich","Salad","Bread","Tomato","Cheese"}};
        groupingDishes(dishes);*/


        String[] sts =
                {"cat",
                "dog",
                "doggy"};

        String[] pts=
                {"a",
                "b",
                "b"};
        System.out.println(areFollowingPatterns(sts,pts));

    }

    public static void sortColors(int[] nums) {

        int count1 = 0;
        int count2 = 0;
        int i = 0;
        int fill = 0;

        for(;i<nums.length;i++){

            if(nums[i] == 0){
                nums[fill] = 0;
                fill++;
            }else if(nums[i] == 1){
                count1++;
            }else {
                count2++;
            }
        }

        for(int j = 1;j<=count1;j++){
            nums[fill] = 1;
            fill++;
        }


        for(int j = 1;j<=count2;j++){
            nums[fill] = 2;
            fill++;
        }


    }

    public static long check (String s){
        int[] a = new int[26];

        for(char x: s.toCharArray()){
            a[x-97]++;
        }

        for(int i = 0;i<a.length;i++){
            if(a[i] ==1 ){
                return (char)(i+97);
            }
        }

        return '_';
    }


    public static int check(int[] a){
        Set<Integer> set= new HashSet<>();
        int count = 0;

        for (int x: a){

            set.add(x);

        }

        for(int i = 0;i<a.length;i++)
            for(int j = i;j<a.length;j++){
                if(i != j){
                    if( set.contains(a[i]+a[j])){
                        count++;
                    }
                }
            }

        return count;

    }


    public static String checkpar(String inputString) {
        Stack<Integer> stack = new Stack<>();
        char[] arr = inputString.toCharArray();

        for (int x = 0; x < arr.length; x++) {
            if(arr[x] == '('){
                stack.push(x);

            }else if(arr[x] == ')'){
                Integer start = stack.pop();
                arr = reverse(start+1,x-1,arr,inputString);
            }


        }
        String s ="";
        for (int x = 0; x < arr.length; x++) {

            if(arr[x] != '(' && arr[x] !=')'){
               s = s.concat(arr[x]+"");
            }
        }


        return s;
    }

    public static char[] reverse(int i, int j, char[] a, String input){
        String x1 = new String(a);
        String x = x1.substring(i,j+1);
        int l = 0;
        for(int k = j;k>=i;k--){
            a[k] = x.charAt(l);
            l++;
        }

        return a;
    }

    public static boolean sudoku(char[][] grid){
        Map<Integer, List<pair>> map = new HashMap<>();
        for(int i = 0;i<9;i++){
            for(int j= 0;j<9;j++){
                if(grid[i][j] != '.'){
                    int x = Integer.parseInt(grid[i][j]+"");
                    if(map.containsKey(x)){
                        map.get(x).add(new pair(i+1, j+1));
                    }else {
                        List<pair> pairs = new ArrayList<>();
                        pairs.add(new pair(i+1,j+1));
                        map.put(x,pairs);
                    }
                }
            }
        }

        //check for every entry
        for(Integer key : map.keySet()){
            if(map.get(key).size()>1){

                List<pair> l = map.get(key);

                for(int i = 0;i<l.size();i++)
                    for(int j = i;j<l.size();j++){
                        if(j!=i){
                            if(l.get(i).row == l.get(j).row ||
                                    l.get(i).col == l.get(j).col ){
                                return false;
                            }
                           int iQuad = getQuad(l.get(i).row,l.get(i).col);
                            int jQuad = getQuad(l.get(j).row,l.get(j).col);
                            if(iQuad == jQuad){
                                return false;
                            }
                        }
                    }
            }
        }
        return true;

    }

    private static int getQuad(int row, int col) {
        if(row <= 3 ){
            if(col <= 3)
                return 1;
            else if(col >3 && col <=6)
                return 2;
            else
                return 3;
        } else  if(row > 3 && row <=6 ){
            if(col <= 3)
                return 4;
            else if(col >3 && col <=6)
                return 5;
            else
                return 6;
        } else  if(row >6 && row <=9 ){
            if(col <= 3)
                return 7;
            else if(col >3 && col <=6)
                return 8;
            else
                return 9;
        }
        return -1;

    }

    static class pair{
        public int row;
        public int col;
        pair(int x, int y){
            this.row = x;
            this.col = y;

        }
    }

    public static boolean  isCryptSolution(String[] crypt, char[][] solution) {

        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0;i<solution.length;i++){
            map.put(solution[i][0],Integer.parseInt(solution[i][1]+""));
        }

        String s1 = crypt[0];
        String s2 = crypt[1];
        String s3 = crypt[2];

        if((s1.length() > 1 && map.get(s1.charAt(0)) ==0 ) ||
                (s2.length() > 1 && map.get(s2.charAt(0)) ==0 ) ||
                (s3.length() > 1 && map.get(s3.charAt(0)) ==0 )
        ){
            return false;
        }

        String n1 = "";
        for(int i = 0;i<s1.length();i++){
            n1 = n1 + map.get(s1.charAt(i));
        }

        String n2 = "";
        for(int i = 0;i<s2.length();i++){
            n2 = n2 + map.get(s2.charAt(i));
        }

        String n3 = "";
        for(int i = 0;i<s3.length();i++){
            n3 = n3 + map.get(s3.charAt(i));
        }

        return Long.parseLong(n1)+Long.parseLong(n2) == Long.parseLong(n3);

    }

    public static String[][] groupingDishes(String[][] dishes) {

        int dlength = dishes.length;
        TreeMap<String,SortedSet<String>> map = new TreeMap();
        for(int i = 0;i<dlength;i++){
            for(int j = 1;j<dishes[i].length;j++){

                if(map.containsKey(dishes[i][j])){
                    map.get(dishes[i][j]).add(dishes[i][0]);
                }else {
                    SortedSet<String> list = new TreeSet();
                    list.add(dishes[i][0]);
                    map.put(dishes[i][j], list);
                }
            }
        }
        int count = (int)map.values().stream().filter(x->x.size() > 1).count();

        String[][] r = new String[count][];

        int i = 0;

            for(Map.Entry<String,SortedSet<String>> x: map.entrySet()){
                if(x.getValue().size() > 1){
                    String key = x.getKey();
                    SortedSet<String> value = x.getValue();
                    r[i] = new String[value.size()+1];
                    r[i][0] = key;
                    int j = 1;
                    Iterator<String> iterator = value.iterator();
                    while (iterator.hasNext()){
                        r[i][j++] = iterator.next();
                    }
                    i++;
                }
        }

        return r;

    }


  public static  boolean areFollowingPatterns(String[] strings, String[] patterns) {


        Map<String,Boolean> table = new HashMap();

        for(int i = 0;i< strings.length;i++){
            for(int j = 0; j <strings.length;j++){
                if(j!=i){
                    if(!table.containsKey(i+""+j) && !table.containsKey(j+""+i)){

                        if(strings[i].equals(strings[j]) && patterns[i].equals(patterns[j])){
                            table.put(i+""+j,true);
                        }else if(!strings[i].equals(strings[j]) && !patterns[i].equals(patterns[j])){
                            table.put(i+""+j,true);
                        }else {
                            return false;
                        }

                    }
                }
            }
        }

        return true;

    }

}

