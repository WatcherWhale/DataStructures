package sem3.datastructures.ses7;

public class Main
{
    private static final int PERIODS = 4;
    private static final String FILE = "data.txt";

    static Period[] _periods;

    public static void main(String[] args)
    {
        try
        {
            FileReader reader = new FileReader(PERIODS);
            reader.ReadFile(FILE);
            Main._periods = reader.GetPeriods();

            PrintPeriods();

        }
        catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }
    }

    private static void PrintPeriods()
    {
        for (int i = 0; i < _periods.length; i++)
        {
            final Period period = _periods[i];
            System.out.println("Periode " + (i + 1));

            period.GetMap().forEach((key, value) ->
            {
                System.out.print("    ");
                System.out.println(key + "    " + value);
            });
        }
    }
}
