package com.datastructure.ses3;

import java.awt.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class Main
{
    private static final String folderPath = "TestFiles";

    public static void main(String[] args)
    {
        String useFolderPath = folderPath;
        if(args.length > 0) useFolderPath = args[0];

	    Parser parser = new Parser();

	    try
        {
            for(String path : GetFilePaths(useFolderPath))
            {
                String str = ReadFile(path);
                String[] arr = str.split(":");
                String output = arr[arr.length - 1];

                // Check if the file is correctly formatted!
                if(parser.Parse(str) && output.equals("PASS") || !parser.Parse(str) && output.equals("FAIL"))
                    System.out.println(path + ":Test successful!");
                else
                    System.out.println(path + ":Test failed!");
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }

    }

    private static ArrayList<String> GetFilePaths(String folderPath) throws FileNotFoundException
    {
        ArrayList<String> output = new ArrayList<>();

        File dir = new File(folderPath);
        for(File file : dir.listFiles())
        {
            if(file.isFile())
                output.add(file.getPath());
        }

        return output;
    }

    private static String ReadFile(String path) throws FileNotFoundException
    {
        // Open file
        BufferedReader reader = new BufferedReader(new FileReader(path));
        // Read all lines in an array and collect them all in one string.
        return reader.lines().collect(Collectors.joining(System.lineSeparator()));
    }
}
