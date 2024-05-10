package driver.Impl;

import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;

public interface IDriver {
    WebDriver getDriver(String deviceName, String port) throws MalformedURLException;
}
