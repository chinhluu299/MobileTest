package driver.Impl;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class LocalDriverImpl implements IDriver {
    @Override
    public WebDriver getDriver(String deviceName,String port) throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options()
                .setAppPackage("pocketv.datavtech.application")
                .setAppActivity("com.tns.NativeScriptActivity")
                .setAutomationName("UiAutomator2")
                .setUdid(deviceName)
                .setPlatformVersion("14")
                .setDeviceName(deviceName)
                .setPlatformName("android")
                .setNoReset(true);
        WebDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/"), options);
        return driver;
    }
}

//              .setApp("/Users/chinhluu/downloads/1.0.013.5.apk")
//              .setDeviceName("CU99WW9HMFEMF6V8")
//              .setPlatformVersion("14");