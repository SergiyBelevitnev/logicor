package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPageLogicor {
    public MainPageLogicor(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
    public WebDriver driver;

    @FindBy(xpath = "//*[@type='radio'][@value='large'][@name='size']")
    private WebElement largeRadioButton;

    @FindBy(xpath = "//*[@type='radio'][@value='small'][@name='size']")
    private WebElement smallRadioButton;

    @FindBy(xpath = "//*[@id='warehouse-finder']//button")
    private WebElement viewVacanciesButton;

//    private void inputLogin(String username) {
//        loginField.sendKeys(username);
//    }
//
//    private void inputPassword(String password) {
//        passwordField.sendKeys(password);
//    }
//
//    private void clickLoginButton() {
//        loginButton.click();
//    }

}
