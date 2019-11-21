package sem3.datastructures.ses5;

import java.util.Random;

public class GenerateInput
{
    private static Random r = new Random();

    public static int[] GenerateOrderedNumbers(int len)
    {
        int[] ints = new int[len];
        int offset = Math.abs(r.nextInt()) % (Integer.MAX_VALUE - len);

        for(int i = 0; i < len; i++)
        {
            ints[i] = i + offset;
        }

        return ints;
    }

    public static int[] GenerateRandomNumbers(int len)
    {
        int[] ints = new int[len];

        for(int i = 0; i < len; i++)
        {
            ints[i] = Math.abs(r.nextInt()) % (Integer.MAX_VALUE - len);
        }

        return ints;
    }
}
