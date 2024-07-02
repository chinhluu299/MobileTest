package core;

import driver.DriverManager;
import helper.CaptureScreenHelper;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.time.LocalTime;  

@Listeners(TestListener.class)
public class BaseTest {
    @Parameters({"device","port"})
    @BeforeTest
    public void setUpSuite(@Optional("emulator-5554") String deviceName,@Optional("4723") String port) throws MalformedURLException {
        DriverManager.initDriver(deviceName, port);
        CaptureScreenHelper.startScreenRecording();
    }

    @AfterTest
    public  void tearDownSuite(ITestContext context) throws IOException{
        String testName = context.getCurrentXmlTest().getName();
        CaptureScreenHelper.stopScreenRecording(testName);
        DriverManager.quitDriver();

    }

    @BeforeMethod
    public void setUpMethod(Method m){

    }

    @AfterMethod
    public void tearDownMethod(Method m){
    }
}
