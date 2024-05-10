package pages;


import driver.DriverManager;
import helper.CaptureScreenHelper;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static driver.DriverManager.getDriver;

public class BasePage {
    public BasePage(){

    }

    public boolean isElementPresent(By locator) {
        try {
            getDriver().findElement(locator);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    public void goBack() throws InterruptedException {
        ((AppiumDriver)getDriver()).executeScript("mobile: pressKey", Map.ofEntries(Map.entry("keycode", 4)));
        Thread.sleep(200);
    }
    
    public void explicitWait(WebElement element){
        new WebDriverWait(DriverManager.getDriver(),Duration.ofSeconds(5))
                .withMessage(()->"Some problems while find element")
                .pollingEvery(Duration.ofSeconds(1))
                .until(ExpectedConditions.visibilityOf(element));
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
}
