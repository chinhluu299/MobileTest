package pages.Settings;

import driver.DriverManager;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.BasePage;

public class SettingPage extends BasePage {

    @FindAll({@FindBy(xpath = "//android.widget.Button[@text=\"ACTIVATE\"]"),
            @FindBy(xpath = "//android.widget.Button[@text=\"KÍCH HOẠT\"]")})
    private WebElement btnActivate;
    @FindAll({@FindBy(xpath = "//android.widget.EditText[@text=\"TEST\"]"),
            @FindBy(xpath = "//android.widget.EditText[@text=\"KIỂM TRA\"]")})
    private WebElement btnTest;
    @FindAll({@FindBy(xpath = "//android.widget.EditText[@text=\"SYNC MODELS\"]"),
            @FindBy(xpath = "//android.widget.EditText[@text=\"ĐỒNG BỘ BAQ\"]")})
    private WebElement btnSyncModel;

    public SettingPage(){
        PageFactory.initElements(new AppiumFieldDecorator(DriverManager.getDriver()), this);
    }

    public void clickOnActivate(){
        btnActivate.click();
    }

    public void clickOnTest(){
        btnTest.click();
    }

    public void clickOnSyncModel(){
        btnSyncModel.click();
    }



}
