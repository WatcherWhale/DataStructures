package com.datastructure.ses3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.stream.Collectors;

public class Main
{

    public static void main(String[] args)
    {
	    Parser parser = new Parser();

	    try
        {
            // Open file
            BufferedReader reader = new BufferedReader(new FileReader("file.in"));
            // Read all lines in an array and collect them all in one string.
            String str = reader.lines().collect(Collectors.joining(System.lineSeparator()));

            // Check if the file is correctly formatted!
            if(parser.Parse(str))
                System.out.println("Passed!");
            else
                System.out.println("Failed!");
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }

    }
}
