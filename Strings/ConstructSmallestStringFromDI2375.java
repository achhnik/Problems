public class ConstructSmallestStringFromDI2375 {
    public static void main(String args[])
    {
        String pattern = "IIIDIDDD";
        System.out.println(smallestNumber(pattern));
    }
    public static String smallestNumber(String pattern) {
        StringBuilder sb = new StringBuilder("123456789".substring(0, pattern.length() + 1));
        int j = 0;
        for(int i = 0; i <= pattern.length(); i++)
        {
            if(i < pattern.length() && pattern.charAt(i) == 'D')
            {
                j++;
                continue;
            }
            if(j > 0)
            {
                StringBuilder ns = new StringBuilder(sb.substring(i-j, i+1));
                sb.replace(i-j, i+1, ns.reverse().toString());
            }
            j=0;
        }

        return sb.toString();
    }}
