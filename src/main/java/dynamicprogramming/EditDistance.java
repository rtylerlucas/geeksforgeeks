package main.java.dynamicprogramming;

/**
 * Created by tyler on 1/8/17.
 */
public class EditDistance {

    public int editDistance(String a, String b)
    {
        if(a.isEmpty() )
        {
            return b.length();
        }
        else if(b.isEmpty())
        {
            return a.length();
        }
        int[][] cache = new int[a.length()+1][b.length()+1];

        for(int i = 0; i < a.length()+1; i ++)
        {
            for(int j = 0; j < b.length()+1; j++)
            {
                if(i == 0 || j == 0)
                {
                    cache[i][j] = 0;
                }
                else if(a.charAt(i-1) == b.charAt(j-1))
                {
                    cache[i][j] = cache[i-1][j-1];
                }
                else
                {
                    cache[i][j] = 1 + Math.min(cache[i-1][j], cache[i][j-1]);
                }
            }
        }
        return cache[a.length()][b.length()];
    }

    public static void main(String[] args)
    {
        System.out.println(new EditDistance().editDistance("tyler", ""));
    }
}
