package pages.Settings;

import driver.DriverManager;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class ActivatePage {
    @AndroidFindBy(xpath = "//android.widget.EditText[@text=\"Act. Code\"]")
    private WebElement edtActCode;
    @AndroidFindBy(xpath = "//android.widget.EditText[@text=\"Name\"]")
    private WebElement edtName;
    @AndroidFindBy(xpath = "//android.widget.Button[@text=\"SAVE\"]")
    private WebElement btnSave;

    @AndroidFindBy(xpath = "//android.widget.Button[@text=\"CLOSE\"]")
    private WebElement btnClose;

    public ActivatePage(){
        PageFactory.initElements(new AppiumFieldDecorator(DriverManager.getDriver()), this);
    }

    public void clickOnSave(){
        btnSave.click();
    }

    public void clickOnClose(){
        btnClose.click();
    }

    public void sendKeyActCode(String code){
        edtActCode.sendKeys(code);
    }

    public void sendKeyName(String name){
        edtName.sendKeys(name);
    }
}
