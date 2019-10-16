package com.datastructure.ses1;

import java.io.PrintWriter;

public class Main
{

    public static void main(String[] args)
    {
        try
        {
            int n = 100;

            PrintWriter fileWriter1 = new PrintWriter("out.csv");
            //PrintWriter fileWriter2 = new PrintWriter("2.csv");

            PerformTests(new PrefixAverage1(), n, fileWriter1);
            fileWriter1.print('\n');
            PerformTests(new PrefixAverage2(), n, fileWriter1);

            fileWriter1.close();

            System.out.println("Done.");
        }
        catch (Exception ex)
        {
            System.out.println("Failed.");
            System.out.println(ex.getMessage());
        }
    }

    public static void PerformTests(IRunnable runnable, int n, PrintWriter fileWriter)
    {
        long time0, time1;
        int[] randArr;

        for (int i = 0; i < n; i++)
        {
            randArr = RandomGenerator.GenerateRandomArray(20);
            runnable.Set(randArr);

            // Measure Delta time
            time0 = System.nanoTime();
            runnable.Run();
            time1 = System.nanoTime();

            String dt = Long.toString(time1 - time0);
            fileWriter.print(dt + ";");
        }
    }

}
