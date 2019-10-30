package com.datastructure.ses3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class Main
{
    public static final String folderPath = "TestFiles";

    public static void main(String[] args)
    {
	    Parser parser = new Parser();

	    try
        {
            for(String path : GetFilePaths(folderPath))
            {
                String str = ReadFile(path);

                // Check if the file is correctly formatted!
                if(parser.Parse(str))
                    System.out.println(path + ":Passed!");
                else
                    System.out.println(path + ":Failed!");
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }

    }

    public static ArrayList<String> GetFilePaths(String folderPath) throws FileNotFoundException
    {
        ArrayList<String> outp = new ArrayList<>();

        File dir = new File(folderPath);
        for(File file : dir.listFiles())
        {
            if(file.isFile())
                outp.add(file.getPath());
        }

        return outp;
    }

    public static String ReadFile(String path) throws FileNotFoundException
    {
        // Open file
        BufferedReader reader = new BufferedReader(new FileReader(path));
        // Read all lines in an array and collect them all in one string.
        return reader.lines().collect(Collectors.joining(System.lineSeparator()));
    }
}
