package driver;

import driver.Impl.LocalDriverImpl;
import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;

public class DriverFactory {
    private  DriverFactory(){}

    public static WebDriver get(Modes mode,String deviceName, String port) throws MalformedURLException{
        WebDriver driver = null;

        switch (mode){
            case LOCAL:
                driver = new LocalDriverImpl().getDriver(deviceName,port);
                break;
        }

        return driver;
    }
}
