package com.maxsoft.automation.webapimobileintegration.util;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import com.maxsoft.automation.webapimobileintegration.common.AndroidAppBase;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import com.aspose.ocr.ImageStream;
import com.aspose.ocr.OcrEngine;
import static org.bytedeco.javacpp.lept.pixDestroy;
import static org.bytedeco.javacpp.lept.pixRead;
import org.bytedeco.javacpp.lept.PIX;
import org.bytedeco.javacpp.tesseract.TessBaseAPI;


/**
 * Created by Osanda on 03/02/2018.
 */


public abstract class ToastMessage {

    static AndroidAppBase androidAppBaseObj = new AndroidAppBase();
    static String projectRootDir = System.getProperty("user.dir");
    static String screenshotFolderPath = projectRootDir + "\\resources\\screenshots";
    static String screenshotFileName = "toastmessage1.png";
    static String imagePath = screenshotFolderPath + "\\" + screenshotFileName;
    static TessBaseAPI api = new TessBaseAPI();

    public static void initTesseract(){
        System.out.println("Initializing Tesseract library...............");
        if (api.Init(projectRootDir+"/resources/tessdata", "eng") != 0) {
            System.err.println("Could not initialize Tesseract library.");
        } else {
            System.out.println("Successfully initialized Tesseract library.");
        }
    }

    public static String getToastMessage() throws Exception {
        captureScreenshot(screenshotFolderPath);
            // Create an instance of OcrEngine
            OcrEngine ocr = new OcrEngine();
            // Set image file
            ocr.setImage(ImageStream.fromFile(imagePath));
            // Perform OCR and get extracted text
                try {
                    if (ocr.process()) {
                        System.out.println(ocr.getText().toString());
                        return ocr.getText().toString();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            // ExEnd:PerformOCROnImage
            return ocr.getText().toString();
    }

    public static synchronized String getToastMessageContent() throws IOException {
        initTesseract();
        String outText;
        Boolean isMsgContains = false;
        captureScreenshot(screenshotFolderPath);
        PIX image = pixRead(imagePath);
        api.SetImage(image);
        outText = api.GetUTF8Text().getString().replaceAll("\\s", "");
        return outText;
    }

    public static synchronized boolean verifyToastMessage(String msg) throws IOException {
        initTesseract();
        String outText;
        Boolean isMsgContains = false;
        captureScreenshot(screenshotFolderPath);
        PIX image = pixRead(imagePath);
        api.SetImage(image);
        outText = api.GetUTF8Text().getString().replaceAll("\\s", "");
        System.out.println(outText);
        isMsgContains = outText.contains(msg);
        pixDestroy(image);
        return isMsgContains;
    }

    public static void captureScreenshot(String folderPath) {
        File scrFile = ((TakesScreenshot) AndroidDriverSetup.androidDriver)
                .getScreenshotAs(OutputType.FILE);
        try {
            Arrays.stream(new File(folderPath).listFiles()).forEach(File::delete);  // Delete all files in the directory (sub-directories are untouched)
            String filePath = folderPath + "\\" + screenshotFileName;
            FileUtils.copyFile(scrFile, new File(filePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}