package sem3.datastructures.ses7;

import java.util.TreeMap;

public class Period
{
    private TreeMap<String, Integer> _courses;

    public Period()
    {
        this._courses = new TreeMap<>();
    }

    public void Insert(String course)
    {
        int amount = 1;
        if(this._courses.containsKey(course)) amount += this._courses.get(course);

        this._courses.put(course, amount);
    }

    public TreeMap<String, Integer> GetMap()
    {
        return this._courses;
    }
}
