package helper;

import constants.FrameworkConstants;
import driver.DriverManager;
import io.appium.java_client.android.AndroidStartScreenRecordingOptions;
import io.appium.java_client.screenrecording.CanRecordScreen;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import utils.Log;
import utils.PropertyUtils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Base64;
import java.util.Date;

import static driver.DriverManager.getDriver;

public class CaptureScreenHelper {
    private static SimpleDateFormat dateFormat = new SimpleDateFormat("HH-mm-ss dd-MM-yyyy");

    public static void takeScreenshot(String fileName, String path){
        try {
            TakesScreenshot ts = (TakesScreenshot) getDriver();
            File source = ts.getScreenshotAs(OutputType.FILE);
            String filePath = FrameworkConstants.getCaptureScreenPath() + File.separator + path;

            File theDir = new File(filePath);
            if (!theDir.exists()) {
                theDir.mkdirs();
            }
            FileHandler.copy(source, new File(filePath + File.separator + fileName + " " + dateFormat.format(new Date())+ ".png"));
            Log.info("Screenshot success: " + fileName + " at " + dateFormat.format(new Date()));
        } catch (Exception e) {
            Log.error("Exception while taking screenshot " + e.getMessage());
        }

    }

    public static void startScreenRecording(){
        if (getDriver() instanceof CanRecordScreen) {
            ((CanRecordScreen) getDriver()).startRecordingScreen(
                    new AndroidStartScreenRecordingOptions()
                            .withVideoSize("1280x720")
                            .withTimeLimit(Duration.ofSeconds(200)));
            Log.info("Start record at: "+ dateFormat.format(new Date()));
        } else {
            Log.warn("Screen recording is not supported on this driver");
        }
    }

    public static void stopScreenRecording(String testName){
        try{
            if (getDriver() instanceof CanRecordScreen) {
                String video = ((CanRecordScreen)getDriver()).stopRecordingScreen();
                byte[] decode = Base64.getDecoder().decode(video);
                FileUtils.writeByteArrayToFile(new File(FrameworkConstants.getRecordScreenPath() +File.separator +testName + File.separator
                        + dateFormat.format(new Date())+ ".mp4") , decode);
            } else {
                Log.warn("Screen recording is not supported on this driver");
            }
        }catch (Exception ex){
            Log.error("Stop record screen get something error: " +ex.getMessage());
        }

    }

}
