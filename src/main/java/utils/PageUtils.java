package utils;

import java.time.Duration;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import driver.DriverManager;
import helper.CaptureScreenHelper;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import static driver.DriverManager.getDriver;

public class PageUtils {
  public static boolean isElementPresent(By locator) {
        try {
            getDriver().findElement(locator);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    public static void goBack() throws InterruptedException {
        ((AppiumDriver)getDriver()).executeScript("mobile: pressKey", Map.ofEntries(Map.entry("keycode", 4)));
        Thread.sleep(200);
    }
    
    public static WebElement explicitWait(By by, int sc){
        new WebDriverWait(DriverManager.getDriver(),Duration.ofSeconds(sc))
                .withMessage(()->"Some problems while find element")
                .pollingEvery(Duration.ofSeconds(1))
                .until(ExpectedConditions.visibilityOfElementLocated(by));
        return getDriver().findElement(by);
    }

    public static WebElement findElement(By by){
          new WebDriverWait(DriverManager.getDriver(),Duration.ofSeconds(3))
                .withMessage(()->"Some problems while find element")
                .pollingEvery(Duration.ofSeconds(1))
                .until(ExpectedConditions.visibilityOfElementLocated(by));
        return getDriver().findElement(by);
    }
    public static WebElement findElement(By by, int seconds){
          new WebDriverWait(DriverManager.getDriver(),Duration.ofSeconds(seconds))
                .withMessage(()->"Some problems while find element")
                .pollingEvery(Duration.ofSeconds(1))
                .until(ExpectedConditions.visibilityOfElementLocated(by));
        return getDriver().findElement(by);
    }

    public boolean checkToastMessageIsCorrect(String assertMessage, String testName){
        try{
            WebElement toastMessage = getDriver().findElement(AppiumBy.xpath("//android.widget.Toast"));
            String messageText = toastMessage.getText();
            System.out.println(messageText);
            CaptureScreenHelper.takeScreenshot("",testName);
            return messageText.contains(assertMessage);
        }catch (Exception e) {
            System.out.println("None message appear");
            return false;
        }
    }
   public static void goBackToHomeScreen() throws InterruptedException{
      for (int i =0; i< 15; i++) {
        if(isElementPresent(AppiumBy.accessibilityId("home")))
          break;
        else {
          goBack();
          Thread.sleep(200);
        }
      }
    }
}
