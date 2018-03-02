package com.maxsoft.mobileautomation.android.util;

import com.thoughtworks.gauge.Gauge;
import org.testng.Assert;
import java.io.*;


public class CompareTextFiles {

    public static void compare(String filePath1, String filePath2) throws IOException
    {
        BufferedReader reader1 = new BufferedReader(new FileReader( AndroidDriverSetup.PROJECT_ROOT + filePath1));
        BufferedReader reader2 = new BufferedReader(new FileReader( AndroidDriverSetup.PROJECT_ROOT + filePath2));

        String line1 = reader1.readLine().replaceAll("’", "'");
        String line2 = reader2.readLine().replaceAll("’", "'");

        boolean areEqual = true;
        int lineNum = 1;

        while (line1 != null || line2 != null)
        {
            if(line1 == null || line2 == null)
            {
                areEqual = false;
                break;
            }
            else if(! line1.equalsIgnoreCase(line2))
            {
                areEqual = false;
                break;
            }
            line1 = reader1.readLine();
            line2 = reader2.readLine();
            lineNum++;
        }

        if(areEqual)
        {
            System.out.println("Two files have same content.");
            Gauge.writeMessage("Two files have same content.");
        }
        else
        {
//            System.out.println("Two files have different contents. They differ at line " + lineNum + ".");
//            Gauge.writeMessage("Two files have different contents. They differ at line " + lineNum + ".");
//            System.out.println("Expected content was \"" + line1 + "\" and Actual content is \"" + line2 + "\" at line number " + lineNum + ".");
//            Gauge.writeMessage("Expected content was \"" + line1 + "\" and Actual content is \"" + line2 + "\" at line number " + lineNum + ".");
            Assert.assertEquals(line2, line1, "Two files have different contents. They differ at line number "+lineNum + ".\n" + "Expected content was \"" + line1 + "\" and Actual content is \"" + line2 + "\" at line number " + lineNum + "." + "\n");
        }

        reader1.close();
        reader2.close();
    }


}