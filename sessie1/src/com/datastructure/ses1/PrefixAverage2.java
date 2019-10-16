package com.datastructure.ses1;

public class PrefixAverage2 implements IRunnable
{
    private int[] _numbers;

    public  PrefixAverage2()
    {
        this._numbers = new int[0];
    }

    public PrefixAverage2(int[] numbers)
    {
        this._numbers = numbers;
    }

    public int[] Run()
    {
        int[] A  = new int[this._numbers.length];
        int s = 0;

        for(int i = 0; i < this._numbers.length; i++)
        {
            s += this._numbers[i];
            A[i] = s/(i+1);
        }

        return A;
    }

    public void Set(int[] numbers)
    {
        this._numbers = numbers;
    }
}
