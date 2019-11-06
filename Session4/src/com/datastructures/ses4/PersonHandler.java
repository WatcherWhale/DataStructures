package com.datastructures.ses4;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Iterator;

public class PersonHandler
{
    String _path;
    ArrayList<Person> _list;

    public PersonHandler(String filepath) throws IOException
    {
        this._path = filepath;
        ReadFile(this._path);
    }

    public void SearchName(String name)
    {
        Iterator it = this._list.iterator();
        while (it.hasNext())
        {

        }

        for(Person person : this._list)
        {
            if(person.getName().equals(name))
                System.out.println(person.toString());
        }
    }

    public void SearchLastName(char firstChar)
    {
        for(int i = this._list.size() - 1; i >= 0; i--)
        {
            Person person = this._list.get(i);

            if(person.getLastName().charAt(0) == firstChar)
                System.out.println(person.toString());
        }
    }

    public void SearchAddress(String address)
    {
        ArrayList<Integer> indices = new ArrayList<>();

        for(int i = 0; i <  this._list.size(); i++)
        {
            Person person = this._list.get(i);

            if(person.getAddress().equals(address))
                indices.add(i);
        }

        for(int i : indices)
        {
            System.out.println(this._list.get(i).toString());
        }

    }

    public void PrintList()
    {
        for(Person p : this._list)
            System.out.println(p.toString());
    }

    private void ReadFile(String path) throws IOException
    {
        this._list = new ArrayList<>();

        for(String line : Files.readAllLines(Path.of(path)))
        {
            String[] data = line.split(" ");

            this._list.add(new Person(data[0], data[1], data[2]));
        }
    }
}
