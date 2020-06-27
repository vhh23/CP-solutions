package main;

import java.util.ArrayList;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class HotelBooking {

    public static void main(String[] args) {
        ArrayList<Integer> a = new ArrayList<>();
        ArrayList<Integer> d = new ArrayList<>();

        a.add(1);
        a.add(2);a.add(3);
        d.add(2);d.add(3);d.add(4);
        System.out.println(hotel(a,d,1));

    }

    public static boolean hotel(ArrayList<Integer> arrive, ArrayList<Integer> depart, int K) {


        ArrayList<booking> bookings = new ArrayList<booking>();
        arrive.forEach(x-> bookings.add(new booking(x,'A')));
        depart.forEach(x-> bookings.add(new booking(x,'D')));

        bookings.sort(Comparator.comparing(booking::getTime).thenComparing((x,y)->y.getType()-x.getType()));

        for (booking b : bookings) {
            if (b.type == 'A')
                K--;
            else if (b.type == 'D')
                K++;

            if(K < 0)
                return false;
        }

        if(K<0)
            return false;
        else
            return true;
    }
}
class booking  {
    public int time;
    public char type;

    public booking(int time, char type) {
        this.time = time;
        this.type = type;
    }

    public int getTime() {
        return time;
    }

    public char getType() {
        return type;
    }
}