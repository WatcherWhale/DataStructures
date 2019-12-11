package sem3.datastructures.ses7;

import java.util.ArrayList;
import java.util.HashMap;

public class Main
{
    private static final int PERIODS = 4;
    private static final String FILE = "data.txt";

    private static final String PERIOD = "Periode";

    static Period[] _periods;

    public static void main(String[] args)
    {
        CreatePeriods();

        try
        {
            FileReader reader = new FileReader();
            reader.ReadFile(FILE);

            for (Entry entry: reader.GetList())
            {
                Period period = _periods[entry.getPeriod() - 1];
                period.Insert(entry.getCourse());
            }

            PrintPeriods();

        }
        catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }
    }

    private static void CreatePeriods()
    {
        _periods = new Period[PERIODS];

        for(int i = 0; i < _periods.length; i++)
        {
            _periods[i] = new Period();
        }
    }

    private static void PrintPeriods()
    {
        for (int i = 0; i < _periods.length; i++)
        {
            final Period period = _periods[i];
            System.out.println(PERIOD + " " + (i + 1));

            period.GetMap().forEach((key, value) ->
            {
                System.out.print("    ");
                System.out.println(key + "    " + value);
            });
        }
    }
}
