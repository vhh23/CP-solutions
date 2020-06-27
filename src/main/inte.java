package main;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class inte {

    public static void main(String[] args) {

        ArrayList<Interval> t1 = new ArrayList<>();
        t1.add(new Interval(1,2));
        t1.add(new Interval(3,5));
        t1.add(new Interval(6,7));
        t1.add(new Interval(8,10));
        t1.add(new Interval(12,16));

        ArrayList<Interval> res = insert(t1, new Interval(4, 9));

        res.forEach(x-> System.out.println(x.start+","+x.end));

    }




    public static ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {


        Interval start = null;
        Interval end = null;


        if(intervals.size() == 0){
            intervals.add(newInterval);
            return intervals;
        }
        if(newInterval == null){
            return intervals;
        }

        List<Interval> temp = intervals.stream()
                .filter(x -> Math.max(x.start, newInterval.start) < Math.min(x.end, newInterval.end))
                .collect(Collectors.toList());

        if(temp.size() > 0){
            start = temp.get(0);
            end = temp.get(temp.size()-1);

            Interval mergeInterval = new Interval(Math.min(newInterval.start,start.start),
                    Math.max(newInterval.end,end.end));

            intervals.removeAll(temp);
            intervals.add(mergeInterval);
        } else if(intervals.get(0).start <= newInterval.start && intervals.get(0).end <= newInterval.start)
        {
            intervals.add(newInterval);

        } else if(intervals.get(intervals.size()-1).start >= newInterval.start && intervals.get(intervals.size()-1).end >= newInterval.start)
        {
            intervals.add(newInterval);

        }

         intervals.sort(Comparator.comparingInt(x->x.start));
        return intervals;
    }
}
class Interval {
      int start;
      int end;
      Interval() { start = 0; end = 0; }
      Interval(int s, int e) { start = s; end = e; }
  }