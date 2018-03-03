package com.maxsoft.automation.webapimobileintegration.util;

import com.thoughtworks.gauge.Gauge;
import java.io.*;
import java.util.Scanner;


/**
 * Created by Osanda on 03/02/2018.
 */


public class FileOperator {

    public static void write(String text, String filePath){
        BufferedWriter writer = null;
            try
            {
                writer = new BufferedWriter( new FileWriter(filePath));
                writer.write(text);
                System.out.println("Writing content to the text file in the directory of \"" + filePath + "\" is succeeded.");
                Gauge.writeMessage("Writing content to the text file in the directory of \"" + filePath + "\" is succeeded.");
            }
                catch ( IOException e)
                {
                    System.out.println("Writing content to the text file in the directory of \"" + filePath + "\" is failed.");
                    Gauge.writeMessage("Writing content to the text file in the directory of \"" + filePath + "\" is failed.");
                }
                    finally
                    {
                        try
                        {
                            if ( writer != null)
                                writer.close( );
                        }
                        catch ( IOException e)
                        {
                        }
                    }
    }

    public static String read(String filePath){
        String content = null;
        try {
            content = String.valueOf(new Scanner(new File(filePath)).useDelimiter("\\Z").next());
            System.out.println("Reading content from the text file in the directory of \"" + filePath + "\" is succeeded.");
            Gauge.writeMessage("Reading content from the text file in the directory of \"" + filePath + "\" is succeeded.");
        } catch (FileNotFoundException e) {
            System.out.println("Reading content from the text file in the directory of \"" + filePath + "\" is failed.");
            Gauge.writeMessage("Reading content from the text file in the directory of \"" + filePath + "\" is failed.");

        }
       // System.out.println(content);
        return content;
    }


}