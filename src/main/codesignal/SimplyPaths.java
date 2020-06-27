package main.codesignal;

public class SimplyPaths {
    public static void main(String[] args) {
        String path = "/../";
        System.out.println(simplifyPath(path));
    }

   public static String simplifyPath(String path) {

        String[] splits = path.split("/");

        String res = "";
        for(String x: splits){

            switch (x) {
                case ".":
                    break;
                case "":
                    break;
                case "..":{
                    int index = res.lastIndexOf("/");
                    if(index != -1)
                        res = res.substring(0, index);

                }
                break;
                default:{
                    res = res.concat("/"+x);
                }
            }

        }

        if(res.isEmpty()){
            res = res.concat("/");
        }
        return res;

    }

}
