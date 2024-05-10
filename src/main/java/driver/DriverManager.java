package driver;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.WebDriver;
import utils.PropertyUtils;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

public final class DriverManager {
    private static final ThreadLocal<WebDriver> dr = new ThreadLocal<>();

    public static WebDriver getDriver(){
        return dr.get();
    }

    public static void setDriver(WebDriver driver){
        dr.set(driver);
    }
    public static void unload(){
        dr.remove();
    }
    private DriverManager(){

    }

    public static void initDriver(String deviceName, String port) throws MalformedURLException{
        if(Objects.isNull(getDriver())){
            String modeValue = PropertyUtils.getValue("mode");
            WebDriver driver = DriverFactory.get(Modes.valueOf(modeValue.toUpperCase()), deviceName,port);
            driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
            setDriver(driver);
        }
    }
    public static void quitDriver(){
        if(Objects.nonNull(getDriver())){
            getDriver().quit();
            unload();
        }
    }
}

