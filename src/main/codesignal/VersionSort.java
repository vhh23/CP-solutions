package main.codesignal;

public class VersionSort {

    public static void main(String[] args) {
        System.out.println(higherVersion2("1.2.2","1.2.0"));
    }

  public static  int higherVersion2(String ver1, String ver2) {

        String[] ver1Split = ver1.split("\\.");
        String[] ver2Split = ver2.split("\\.");


        for(int i = 0;i<ver1Split.length;i++){

            int v1 = Integer.parseInt(ver1Split[i]);
            int v2 = Integer.parseInt(ver2Split[i]);

            if(v1 != v2){
                if(v1 > v2)
                    return 1;
                else
                    return -1;
            }

        }



        return 0;
    }

}
