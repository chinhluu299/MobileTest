package pages.Settings.Modals;

import driver.DriverManager;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class ChangeEnvModal {
    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"Live Environment\"]")
    private WebElement liveEnv;
    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"Test/Train Environment\"]")
    private WebElement testEnv;
    @AndroidFindBy(xpath = "//android.widget.Button[@resource-id=\"android:id/button2\"]")
    private WebElement btnCancel;

    public ChangeEnvModal(){
        PageFactory.initElements(new AppiumFieldDecorator(DriverManager.getDriver()), this);
    }

    public void clickOnChooseLiveEnv(){
        liveEnv.click();
    }

    public void clickOnChooseTestEnv(){
        testEnv.click();
    }

    public void clickOnCancel(){
        btnCancel.click();
    }
}
