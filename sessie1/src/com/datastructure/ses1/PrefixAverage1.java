package com.datastructure.ses1;

public class PrefixAverage1 implements IRunnable
{
    private int[] _numbers;

    public  PrefixAverage1()
    {
        this._numbers = new int[0];
    }

    public  PrefixAverage1(int[] numbers)
    {
        this._numbers = numbers;
    }

    public int[] Run()
    {
        int[] A  = new int[this._numbers.length];

        for(int i = 0; i < this._numbers.length; i++)
        {
            int a = 0;

            for(int j = 0; j <= i; j++)
                a += this._numbers[j];

            A[i] = a/(i+1);
        }

        return A;
    }

    public void Set(int[] numbers)
    {
        this._numbers = numbers;
    }
}
