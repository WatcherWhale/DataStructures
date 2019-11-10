package com.datastructures.ses4;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Iterator;

public class PersonHandler
{
    private String _path;
    private ArrayList<Person> _list;

    public PersonHandler(String filepath) throws IOException
    {
        this._path = filepath;
        ReadFile(this._path);
    }

    public void PrintList()
    {
        Iterator<Person> it = this._list.iterator();

        for (int i = 0; it.hasNext(); i++)
        {
            Person p = it.next();
            System.out.println(i + " " + p.toString());
        }
    }

    public void SearchName(String name)
    {
        Iterator<Person> it = this._list.iterator();

        while(it.hasNext())
        {
            Person person = it.next();
            if(person.getName().equals(name))
                System.out.println(person.toString());
        }
    }

    public void SearchLastName(char firstChar)
    {
        Iterator<Person> it = this._list.iterator();
        ArrayList<Person> list = new ArrayList<>();

        while(it.hasNext())
        {
            Person person = it.next();
            if(person.getLastName().charAt(0) == firstChar)
                list.add(person);
        }

        for(int i = list.size() - 1; i >= 0; i--)
        {
            System.out.println(list.get(i).toString());
        }
    }

    public void SearchAddress(String address)
    {
        ArrayList<Integer> indices = new ArrayList<>();

        Iterator<Person> it = this._list.iterator();

        for (int i = 0; it.hasNext(); i++)
        {
            Person person = it.next();

            if(person.getAddress().equals(address))
                indices.add(i);
        }

        for(int i : indices)
        {
            System.out.println(i + " " + this._list.get(i).toString());
        }

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
