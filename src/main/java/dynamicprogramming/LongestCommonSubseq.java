package main.java.dynamicprogramming;

/**
 * Created by tyler on 1/7/17.
 */
public class LongestCommonSubseq
{
    public int longestSub(String a, String b)
    {
        int aLength = a.length();
        int bLength = b.length();
        int[][] cache = new int[aLength+1][bLength+1];

        for(int i = 0; i < aLength + 1; i ++)
        {
            for(int j = 0; j < bLength + 1; j++)
            {
                if(i==0 || j == 0)
                {
                    cache[i][j] = 0;
                }
                else if(a.charAt(i-1) == b.charAt(j -1))
                {
                    cache[i][j] = cache[i-1][j-1] + 1;
                }
                else
                {
                    cache[i][j] = Math.max(cache[i-1][j], cache[i][j-1]);
                }
            }
        }
        System.out.println(longestSubString(cache, a, b));
        return cache[aLength][bLength];
    }

    public String longestSubString(int[][] cache, String a, String b)
    {
        int i = a.length();
        int j = b.length();
        StringBuilder sb = new StringBuilder();
        while(i != 0 && j != 0)
        {
            if(a.charAt(i-1) == b.charAt(j-1))
            {
                sb.append(a.charAt(i-1));
                i--;
                j--;
            }
            else if(cache[i-1][j] > cache[i][j-1])
            {
                i--;
            }
            else if(cache[i-1][j] < cache[i][j-1])
            {
                j--;
            }
            else
            {
                i--;
                j--;
            }
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args)
    {
        System.out.println(new LongestCommonSubseq().longestSub("ABCDGH", "AEDFHR"));
        System.out.println(new LongestCommonSubseq().longestSub("TYLER", "TYLER"));
        System.out.println(new LongestCommonSubseq().longestSub("TYLER", "JEN"));
    }
}
