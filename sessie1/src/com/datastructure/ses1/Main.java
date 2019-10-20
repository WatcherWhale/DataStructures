package com.datastructure.ses1;

import java.io.PrintWriter;

public class Main
{
    private static final char splitChar = ';';
    private static final int n = 100;

    public static void main(String[] args)
    {
        try
        {
            PrintWriter fileWriter = new PrintWriter("Dataset.csv");

            fileWriter.println("Constant Tests");
            PerformConstantTests(new PrefixAverage1(), n, 100, fileWriter);
            fileWriter.print('\n');
            PerformConstantTests(new PrefixAverage2(), n, 100, fileWriter);

            fileWriter.println("\n\nDynamic Tests");
            fileWriter.println(PerformDynamicTests(new PrefixAverage1(),n));
            fileWriter.print('\n');
            fileWriter.println(PerformDynamicTests(new PrefixAverage2(),n));

            fileWriter.close();

            System.out.println("Done.");
        }
        catch (Exception ex)
        {
            System.out.println("Failed.");
            System.out.println(ex.getMessage());
        }
    }

    private static void PerformConstantTests(IRunnable runnable, int n, int len, PrintWriter fileWriter)
    {
        long time0, time1;
        int[] randArr;

        for (int i = 0; i < n; i++)
        {
            randArr = RandomGenerator.GenerateRandomArray(len);
            runnable.Set(randArr);

            // Measure Delta time
            time0 = System.nanoTime();
            runnable.Run();
            time1 = System.nanoTime();

            String dt = Long.toString(time1 - time0);
            fileWriter.print(dt + splitChar);
        }
    }

    private static String PerformDynamicTests(IRunnable runnable, int n)
    {
        StringBuilder line1 = new StringBuilder();
        StringBuilder line2 = new StringBuilder();


        long time0, time1;
        int[] randArr;

        for (int i = 2; i < n + 2; i++)
        {
            randArr = RandomGenerator.GenerateRandomArray(i);
            runnable.Set(randArr);

            // Measure Delta time
            time0 = System.nanoTime();
            runnable.Run();
            time1 = System.nanoTime();

            long dt = time1 - time0;

            line1.append(i);
            line1.append(splitChar);
            line2.append(dt);
            line2.append(splitChar);
        }

        return line1.toString() + "\n" + line2.toString();
    }

}
