import  java.util.*;
public class CountDistinctElementInWindowSize {
    public static ArrayList<Integer> countDistinctElements(ArrayList<Integer> arr, int k)
    {
        ArrayList<Integer> arrList = new ArrayList<>();
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for(int j = 0; j < k; j++)
        {
            if(hashMap.containsKey(arr.get(j)))
            {
                hashMap.put(arr.get(j), hashMap.get(arr.get(j)) + 1);
            }
            else hashMap.put(arr.get(j), 1);
        }
        arrList.add(hashMap.size());
        for(int  i = 1; i + k - 1 < arr.size(); i++)
        {
            if(hashMap.containsKey(arr.get(i - 1)))
            {
                hashMap.put(arr.get(i - 1), hashMap.get(arr.get(i-1)) - 1);
                if(hashMap.get(arr.get(i-1)) == 0) hashMap.remove(arr.get(i-1));
            }
            if(hashMap.containsKey(arr.get(i + k - 1)))
            {
                hashMap.put(arr.get(i + k - 1), hashMap.get(i + k - 1) + 1);
            }
            else {
                hashMap.put(arr.get(i + k - 1), 1);
            }
            arrList.add(hashMap.size());
        }
        return arrList;
    }
    public static void main(String args[])
    {
        ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(10, 2, 1, 2, 10, 6, 10, 6));
        int k = 3;
        System.out.println(countDistinctElements(arrayList, k));
    }
}
