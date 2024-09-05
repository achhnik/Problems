import java.util.Arrays;

public class MinimumLevels3096 {
    public static void main(String[] args) {

        int possible[] = {1, 0, 1, 0};
        System.out.println(minimumLevels(possible));

    }

    public static int minimumLevels(int[] possible) {
        int sum = 0;
        for(int i = 0; i < possible.length ; i++)
        {
            sum += possible[i] == 1 ? 1 : -1;
        }
        int prefSum = 0;
        for(int k = 0; k < possible.length - 1; k++)
        {
            prefSum+= (possible[k] == 1) ? 1 : -1;
            int temp = sum - prefSum;

            if(prefSum > temp) return k+1;
        }
        return -1;
    }

}
