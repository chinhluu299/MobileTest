package pages.Login;

import driver.DriverManager;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.pagefactory.AndroidFindAll;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.Console;

public class LoginPage {

    @FindAll({ @FindBy(xpath = "//android.widget.EditText[@text=\"UserName\"]"),
            @FindBy(xpath = "//android.widget.EditText[@text=\"Tên Đăng Nhập\"]")})
    private WebElement edtUsername;
    @FindAll({@FindBy(xpath = "//android.widget.EditText[@text=\"Password\"]"),
            @FindBy(xpath = "//android.widget.EditText[@text=\"Mật Khẩu\"]")})
    private WebElement edtPassword;
    @FindAll({@FindBy(xpath = "//android.widget.Button[@text=\"LOGIN\"]"),
            @FindBy(xpath = "//android.widget.Button[@text=\"ĐĂNG NHẬP\"]")})
    private WebElement btnLogin;
    @FindAll({@FindBy(xpath = "//android.widget.Button[@text=\"SETTINGS\"]"),
            @FindBy(xpath = "//android.widget.Button[@text=\"CÀI ĐẶT\"]")})
    private WebElement btnSettings;

    public  LoginPage(){
        PageFactory.initElements(new AppiumFieldDecorator(DriverManager.getDriver()), this);
    }

    public void clickOnLogin(){
        btnLogin.click();
    }

    public void clickOnSettings(){
        btnSettings.click();
    }

    public void sendKeyUsername(String username){
        edtUsername.sendKeys(username);
    }

    public void sendKeyPassword(String password){
        edtPassword.sendKeys(password);
    }
}
