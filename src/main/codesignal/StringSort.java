package main.codesignal;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StringSort {

    public static void main(String[] args) {

        String s = "good";
        String t = "";

        String s1 ="ydlglxktpcmeqbzbdwceuvfwijmbcxlfkmjjvqigmysyphbdinhrlazsyojlpjdnjpxwolienipgkzwtqgwlfltsravoedynjumjojsfdjfpngychsndkdgyaxfdnukvkwhljnslpkhiineyfowmkaaracwzsmetciqekqlgtstbarundksqwaqiplfwtvpwyhtgstsgaefgylfubqurhzeadburmtgsavcpqmhsyxbizuqsizatavuvfhvznkktthbwaxittlelkmbqffvlgpvxjmyghetokrjftryhggxcpbrvtqkhxmbldgljpipphuktlkykblyb";
        String s2 = "ydlglxktpcmeqbzbdwceuvfwijmbcxlfkm";
                // "tswmpclbcadjucfiqkokoyfphyfbqhuwtatveoitzxeavxcvdsmzgchtffqaiykaygovb" +
                //"gpkyeqtpurwdrmbrvzdmqiyweewkpgmftabjsoqnlxphljasuwepubhdfzeeouxnkokpjaufrsaht" +
                //"bxnsmdlskevzkkqbyvsfqxioyuskkqspcsspjbfvfrliabtzudytqvxtefqfmgdbnctxrceqdetdhefqwyymtvelfgrqygsrogzgaiykujpxpghbhfunbzoaejkzblsgokvufeypnzknpogjqatdsbaznwesxitkuprzrydfbrbtxdpcumynrzvozxknsvzlexgnikxvdwvxvcxraizdeggfaeqzhocmgsmbvcouhakgbdusrkkocirurcyyjiv" +
               // "rxepbyprxsfuxhazgivtouqcargehvaahpgwdmvydlglxktpcmeqbzbdwceuvfwijmbcxlfkmnokxriufdxlqvyybiejjjvqigmysyphbdinhrlazsyojlpjdnjpxwolienipgkzwtqgwlfltsravoedynjumjojsfdjfpngychsndkdgyaxfdnukvkwhljnslpkhiineyfowmkaaracwzsmetciqekqlgtstbarundksqwaqiplfwtvpwyhtgstsgaefgylfubqurhzeadburmtgsavcpqmhsyxbizuqsizatav------uvfhvznkktthbwaxittlelkmbqffvlgpvxjmyghetokrjftryhggxcpbrvtqkhxmbldgljpipphuktlkykblyb";//gyudpwudlvgkeoseugodiublsbzuwvgjttfrshstksqgvguclckkghwryucbvrmdmivgabkqndibmekcuvjpbkzagvtgqosladbjvgwtgnzrspthopkvvkmcrv" +
                //"ybcbmwcnjfmglzjlekrivakbfvmhriwygcmxmocjnwzjkbweywonwigyfzgragvvresjdkgcerstwpooblcxjg";
        String t1 = "izhlsocpwfrdamjtbxveygnquk";

        List<Character> collect = s1.chars().mapToObj(i -> (char) i).sorted((x, y) -> {
            if (t1.indexOf(String.valueOf(x)) < t1.indexOf(String.valueOf(y)))
                return -1;
            else
                return 1;
        }).collect(Collectors.toList());

        StringBuilder sb = new StringBuilder();

        for(Character x: collect){
            sb.append(x);
        }
        System.out.println( sb.toString());
    }
}
