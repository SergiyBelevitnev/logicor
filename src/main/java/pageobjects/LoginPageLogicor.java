package pageobjects;

import base.Reporter;
import org.openqa.selenium.By;
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

    @FindBy(xpath = "//*[@title='Property import']")
    private WebElement importButton;



    public void clickImportButton() {
        importButton.click();
    }



    private void inputLogin(String username) {
        loginField.sendKeys(username);
    }

    private void inputPassword(String password) {
        passwordField.sendKeys(password);
    }

    private void clickLoginButton() {
        loginButton.click();
    }

    public void login(String username, String password) {
        Reporter.log("Login to admin page");

        inputLogin(username);
        inputPassword(password);
        clickLoginButton();


    }

}
