package sem3.datastructures.ses7;

public class Entry
{
    private String _course;
    private Integer _period;

    public Entry(String line)
    {
        String[] data = line.split(" ");

        this._course = data[2];
        this._period = Integer.parseInt(data[3]);
    }

    public String getCourse()
    {
        return this._course;
    }

    public Integer getPeriod()
    {
        return this._period;
    }

    public Integer getPeriodIndex()
    {
        return this._period - 1;
    }
}
