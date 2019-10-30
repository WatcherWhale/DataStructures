package com.datastructure.ses2;

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

    public static LList<Integer> GenerateRandomLinkedList(int n)
    {
        LList<Integer> list = new LList<Integer>();

        Random rand = new Random();

        for(int i = 0; i < n; i++)
        {
             list.append(rand.nextInt());
        }

        return list;
    }

    public static LList<Integer> GenerateRandomLinkedList(int n, int a, int b)
    {
        LList<Integer> list = new LList<Integer>();

        Random rand = new Random();

        for(int i = 0; i < n; i++)
        {
            list.append( Math.abs(rand.nextInt() % (b - a)) + a);
        }

        return list;
    }

    public static BLList<Integer> GenerateRandomBetterLinkedList(int n, int a, int b)
    {
        BLList<Integer> list = new BLList<Integer>();

        Random rand = new Random();

        for(int i = 0; i < n; i++)
        {
            list.append( Math.abs(rand.nextInt() % (b - a)) + a);
        }

        return list;
    }
}
