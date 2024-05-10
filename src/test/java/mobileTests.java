import core.BaseTest;
import driver.DriverManager;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.Home.HomePage;
import pages.Login.LoginPage;
import pages.Settings.ActivatePage;
import pages.Settings.SettingPage;
import pages.Settings.SyncModelPage;
import utils.TestGesture.ScrollDirection;
import utils.TestGesture;


import java.lang.reflect.Method;
import java.util.HashMap;

public class mobileTests extends BaseTest{
   
    @Test
    public void testExample() {
        int actualValue = 5;
        int expectedValue = 5;
        Assert.assertEquals(actualValue, expectedValue, "Giá trị không khớp");
    }
    @Test
    public void activateTest(Method m) throws InterruptedException {
        new LoginPage().clickOnSettings();
        new SettingPage().clickOnActivate();
        new ActivatePage().sendKeyActCode("01EFSFRQ7WJSWVK15HJB4S4X3N");
        new ActivatePage().sendKeyName("automateTest");
        new ActivatePage().clickOnSave();
        Thread.sleep(5000);
        new SettingPage().clickOnTest();
        new SettingPage().goBack();

        Assert.assertEquals(new SettingPage().checkToastMessageIsCorrect("ok", m.getName()),true,"Activate is not successful");
    }
    @Test
    public void syncModelTest() throws InterruptedException {
        new LoginPage().clickOnSettings();
        new SettingPage().clickOnSyncModel();
        new SyncModelPage().changeTestEnv();
        new SyncModelPage().clickOnSyncAllModel();
        Thread.sleep(20000);
        System.out.println("Sync done bat dau quay lai");
        new SyncModelPage().goBack();
        new SyncModelPage().goBack();
        new SyncModelPage().goBack();
    }
    @Test
    public void loginTest() throws InterruptedException {
        new LoginPage().sendKeyUsername("tuan.pham");
        new LoginPage().sendKeyPassword("12345");
        new LoginPage().clickOnLogin();
        Thread.sleep(10000);
        Assert.assertEquals(new HomePage().isElementPresent(AppiumBy.xpath("//android.widget.LinearLayout[@resource-id=\"pocketv.datavtech.application:id/action_bar_root\"]")),
                true,"Login failed");
    }

    @Test
    public void TestCase() throws InterruptedException{
        WebDriver driver = (AppiumDriver) DriverManager.getDriver();
        WebElement el4 = driver.findElement(AppiumBy.accessibilityId("milestone"));
        el4.click();
        TestGesture.scrollById("complete");
        WebElement el5 = driver.findElement(AppiumBy.accessibilityId("complete"));
        el5.click();
    }
}
