package com.datastructure.ses3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args)
    {
	    Parser parser = new Parser();

	    try
        {
            BufferedReader reader = new BufferedReader(new FileReader("file.in"));
            String str = reader.lines().collect(Collectors.joining(System.lineSeparator()));

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
