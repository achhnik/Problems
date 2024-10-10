public class MinOpToMakeArrayEqual3229 {
    public static void main(String args[])
    {
        int nums[] = {4,8,3,4,2,3};
        int target[] = {7,9,8,7,6,5};
        System.out.println(minimumOperations(nums, target));
    }
    public static long minimumOperations(int[] nums, int[] target) {
        int diff[] = new int[nums.length];
        for(int i = 0; i < nums.length; i++)
        {
            diff[i] = target[i] - nums[i];
        }
        int incOp = 0, decOp = 0;
        long extra = 0;
        for(int j = 0; j < nums.length; j++)
        {
            if(diff[j] > 0)
            {
                if(diff[j] > incOp)
                {
                    extra += diff[j] - incOp;
                }
                incOp = diff[j];
                decOp = 0;
            }else if(diff[j] < 0)
            {
                if(diff[j] < decOp)
                {
                    extra += Math.abs(diff[j]) - Math.abs(decOp);
                }
                decOp = diff[j];
                incOp = 0;
            }else {
                incOp = 0;
                decOp = 0;
            }
        }
        return extra;
    }
}
