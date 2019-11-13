package com.datastructures.ses4;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

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
        ListIterator<Person> it = this._list.listIterator();

        for (int i = 0; it.hasNext(); i++)
        {
            Person p = it.next();
            System.out.println(i + " " + p.toString());
        }
    }

    public void SearchName(String name)
    {
        ListIterator<Person> it = this._list.listIterator();

        while(it.hasNext())
        {
            Person person = it.next();
            if(person.getName().equals(name))
                System.out.println(person.toString());
        }
    }

    public void SearchLastName(char firstChar)
    {
        ListIterator<Person> it = this._list.listIterator(this._list.size());

        while(it.hasPrevious())
        {
            Person person = it.previous();
            if(person.getLastName().charAt(0) == firstChar)
                System.out.println(person.toString());
        }
    }

    public void SearchAddress(String address)
    {
        ArrayList<Integer> indices = new ArrayList<>();

        ListIterator<Person> it = this._list.listIterator();

        for (int i = 0; it.hasNext(); i++)
        {
            Person person = it.next();

            if(person.getAddress().equals(address))
                indices.add(i);
        }

        ListIterator<Integer> iterator = indices.listIterator();
        while (iterator.hasNext())
        {
            System.out.println(i + " " + this._list.get(iterator.next()).toString());
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
