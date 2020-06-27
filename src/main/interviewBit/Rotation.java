package main.interviewBit;

import java.math.BigInteger;
import java.util.ArrayList;

public class Rotation {

    public static void main(String[] args) {
        Rotation rotation = new Rotation();

        //A: [a,ababa,aba]
        ArrayList<String> s1 = new ArrayList<>();
        s1.add("a");
        s1.add("ababa");
        s1.add("aba");
        System.out.println(rotation.solve(s1));
    }

    private BigInteger gcd(BigInteger a, BigInteger b) {
        if (a.compareTo(b) < 0) {
            return gcd(b, a);
        }
        if (b.equals(BigInteger.ZERO)) return a;
        return gcd(b, a.mod(b));
    }

    private BigInteger lcm(BigInteger a, BigInteger b) {
        return (a.multiply(b)).divide(gcd(a, b));
    }

    private long minNumberOfRotation(String str) {
        // long count = 1;
        String two = str + str;
        return two.indexOf(str, 1);
        // for (int i = 1; i < str.length(); i ++) {
        //     if (two.substring(i, i + str.length()).equals(str)) {
        //         return count;
        //     }
        //     count ++;
        // }
        // return count;
    }

    public int solve(ArrayList<String> A) {
        BigInteger max = BigInteger.ONE;
        for (String s : A) {
            long numberOfRotation = minNumberOfRotation(s);
            for (long i = 1; i <= 2 * numberOfRotation + 1; i ++) {
                if ((i * (i + 1) / 2) % numberOfRotation == 0) {
                    max = lcm(max, new BigInteger(String.valueOf(i)));
                    break;
                }
            }
        }
        return max.mod(new BigInteger("1000000007")).intValue();
    }
}