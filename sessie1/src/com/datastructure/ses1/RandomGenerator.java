package com.datastructure.ses1;

import java.util.Random;

public class RandomGenerator
{
    public static int[] GenerateRandomArray(int len)
    {
        int[] out = new int[len];
        Random rand = new Random();

        for(int i = 0; i < len; i++)
        {
            out[i] = rand.nextInt();
        }

        return out;
    }
}
