package com.datastructures.ses4;

import java.io.IOException;

public class Main
{

    public static void main(String[] args)
    {
        try
        {
            PersonHandler personHandler = new PersonHandler("ListData.txt");

            System.out.println("Alle personen");
            personHandler.PrintList();
            System.out.println("");

            System.out.println("De personen met de voornaam: Albert");
            personHandler.SearchName("Albert");
            System.out.println("");

            System.out.println("Personen met familienaam: M*");
            personHandler.SearchLastName('M');
            System.out.println("");

            System.out.println("Personen die in Antwerpen wonen.");
            personHandler.SearchAddress("Antwerpen");
            System.out.println("");

        }
        catch (IOException e)
        {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
