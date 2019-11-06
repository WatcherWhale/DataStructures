package com.datastructures.ses4;

public class Person
{
    private String _name, _lastName, _address;

    public Person(String name, String last, String address)
    {
        this._name = name;
        this._lastName = last;
        this._address = address;
    }

    public String toString()
    {
        return getLastName() + " " + getName() + " " + getAddress();
    }

    public String getName()
    {
        return this._name;
    }

    public String getLastName()
    {
        return this._lastName;
    }

    public String getAddress()
    {
        return this._address;
    }
}
