import java.util.Arrays;

public class MinimumArrowsToBurstBalloons452 {

    public static void main(String args[])
    {
        int points[][] = {{3,9},{7,12},{3,8},{6,8},{9,10},{2,9},{0,9},{3,9},{0,6},{2,8}};
        System.out.println(findMinArrowShots(points));
    }
    public static int findMinArrowShots(int[][] points)
    {
        Arrays.sort(points, (a,b) -> a[0] - b[0] == 0 ? a[1] - b[1] : a[0] - b[0]);
        int[] prev = points[0];
        int arrows = 1;
        for(int i = 1; i < points.length; i++)
        {
            int[] curr = points[i];
            if(curr[0] >= prev[0] && curr[0] <= prev[1])
            {
                prev[0] = Math.max(prev[0],curr[0]);
                prev[1] = Math.min(prev[1],curr[1]);
            }
            else
            {
                arrows++;
                prev = points[i];
            }
        }
        return arrows;
    }
}
