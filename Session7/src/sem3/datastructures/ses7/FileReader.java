package sem3.datastructures.ses7;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class FileReader
{
    private Period[] _periods;

    public FileReader(int periods)
    {
        this._periods = new Period[periods];

        for (int i = 0; i < periods; i++)
        {
            this._periods[i] = new Period();
        }
    }

    public Period[] GetPeriods()
    {
        return this._periods;
    }

    public void ReadFile(String path) throws IOException
    {
        for(String line : Files.readAllLines(Path.of(path)))
        {
            Entry e = new Entry(line);
            this._periods[e.getPeriodIndex()].Insert(e.getCourse());
        }
    }
}
