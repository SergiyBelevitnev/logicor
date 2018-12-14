package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageLogicor {
    public LoginPageLogicor(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
    public WebDriver driver;

    @FindBy(xpath = "//*[@id='authorizationloginform-email']")
    private WebElement loginField;

    @FindBy(xpath = "//*[@id='authorizationloginform-password']")
    private WebElement passwordField;

    @FindBy(xpath = "//*[@id='form-user-login']//button")
    private WebElement loginButton;

    public void inputLogin(String username) {
        loginField.sendKeys(username);
    }

    public void inputPassword(String password) {
        passwordField.sendKeys(password);
    }

    public void clickLoginButton() {
        loginButton.click();
    }

}
