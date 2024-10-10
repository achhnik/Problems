import java.util.*;

public class MeetingRoom2919 {
   public static int minMeetingRooms(List<Interval> intervals) {
            Collections.sort(intervals,(a, b) -> a.start - b.start);
            if(intervals.size() == 0) return 0;
            PriorityQueue<Interval> pq = new PriorityQueue<>((a, b)-> a.end - b.end);
            pq.add(intervals.get(0));
            for(int i = 1; i < intervals.size(); i++)
            {
                Interval interval = intervals.get(i);
                if(!pq.isEmpty() && interval.start >= pq.peek().end)
                {
                    pq.poll();
                    pq.add(interval);
                }
                else pq.add(interval);
            }
            return pq.size();
        }
        public static void main(String args[])
        {
            List<Interval> intervals = new ArrayList<>(Arrays.asList(new Interval(1,5),
                    new Interval(2, 6),
                    new Interval(3, 7),
                    new Interval(4, 8),
                    new Interval(5, 9)));
            // [(1,5),(2,6),(3,7),(4,8),(5,9)]
            System.out.println(minMeetingRooms(intervals));
        }


}
