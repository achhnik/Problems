public class ProductOfArrayExceptSelf238 {
    public static void main(String args[])
    {
        int nums[] = {1, 2, 3, 4};
        int output[] = productExceptSelf(nums);
        for(int o : output)
        {
            System.out.print(o + " ");
        }
    }

    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] output = new int[n];
        output[0] = 1;
        for(int i = 0; i < n - 1; i++)
        {
            output[i+1] = nums[i] * output[i];
        }
        int post = nums[n - 1];
        for(int j = n - 2; j >= 0; j--)
        {
            output[j] = post * output[j];
            post = post * nums[j];
        }
        return output;
    }
}
