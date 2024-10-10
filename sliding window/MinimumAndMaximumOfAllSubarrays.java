import java.util.*;
public class MinimumAndMaximumOfAllSubarrays {
    public static long minimumAndMaximumOfAllSubarrays(ArrayList<Integer> nums, int n, int k)
    {
        long sum = 0;
        PriorityQueue<Integer> pqMin = new PriorityQueue<>();
        PriorityQueue<Integer> pqMax = new PriorityQueue<>((a, b) -> b - a);
        for(int i = 0; i < k; i++)
        {
            pqMin.offer(nums.get(i));
            pqMax.offer(nums.get(i));
        }
        int minVal = pqMin.peek();
        int maxVal = pqMax.peek();
        sum+= minVal + maxVal;
        for(int i = 1; i + k - 1 < nums.size(); i++)
        {
            pqMin.remove(nums.get(i-1));
            pqMax.remove(nums.get(i-1));
            pqMin.offer(nums.get(i + k - 1));
            pqMax.offer(nums.get(i + k - 1));
            minVal = pqMin.peek();
            maxVal = pqMax.peek();
            sum += minVal + maxVal;
        }
        return sum;
    }
    public static void main(String args[])
    {
        ArrayList<Integer> nums = new ArrayList<>(Arrays.asList(10, 7, 8 , 11));
        int n = nums.size();
        int k = 2;
        System.out.println(minimumAndMaximumOfAllSubarrays(nums, n, k));
    }
}
