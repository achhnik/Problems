import java.util.Arrays;

public class StrangePrinter664 {
    static int[][] t = new int[101][101];
    public static void main(String[] args) {

        String s = "abcabc";
        int i = 0;
        int j = s.length()-1;
        for (int k = 0; k < s.length(); k++) {
            Arrays.fill(t[k], -1);
        }
        System.out.println(solve(s,i,j));
    }
    public static int solve(String s, int i, int j)
    {
        if(i > j) return t[i][j] = 0;
        if(i == j) return t[i][j] = 1;
        if(t[i][j] != -1) return t[i][j];
        int minAns = Integer.MAX_VALUE;
        for(int k = i; k <= j-1; k++)
        {
            int temp = solve(s, i, k) + solve(s, k+1, j);
            minAns = temp < minAns ? temp : minAns;
        }
        if(s.charAt(i) == s.charAt(j)) return t[i][j] = minAns - 1;
        else return t[i][j] = minAns;
    }
}
