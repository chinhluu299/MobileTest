package pages.Settings;

import driver.DriverManager;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import pages.BasePage;
import pages.Settings.Modals.ChangeEnvModal;

public class SyncModelPage extends BasePage {

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"\uF142\"]")
    private WebElement btnOption;
    @AndroidFindBy(xpath = "//android.widget.Button[@text=\"SYNC ALL MODELS\"]")
    private WebElement btnSyncAllModel;
    @AndroidFindBy(xpath = "//android.widget.Button[@text=\"SYNC MODEL\"]")
    private WebElement btnSyncModel;

    public SyncModelPage(){
        PageFactory.initElements(new AppiumFieldDecorator(DriverManager.getDriver()), this);
    }

    public void clickOnOption(){
        btnOption.click();
    }
    public void changeTestEnv(){
        clickOnOption();
        new ChangeEnvModal().clickOnChooseTestEnv();
    }

    public void changeLiveEnv(){
        clickOnOption();
        new ChangeEnvModal().clickOnChooseLiveEnv();
    }
    public void clickOnSyncAllModel(){
        btnSyncAllModel.click();
    }

    public void clickOnSyncModel(){
        btnSyncModel.click();
    }


}
