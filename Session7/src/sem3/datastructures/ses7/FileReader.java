package sem3.datastructures.ses7;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class FileReader
{
    private ArrayList<Entry> _list;

    public FileReader()
    {
        this._list = new ArrayList<>();
    }

    public ArrayList<Entry> GetList()
    {
        return this._list;
    }

    public void ReadFile(String path) throws IOException
    {
        this._list = new ArrayList<>();

        for(String line : Files.readAllLines(Path.of(path)))
        {
            this._list.add(new Entry(line));
        }
    }
}
