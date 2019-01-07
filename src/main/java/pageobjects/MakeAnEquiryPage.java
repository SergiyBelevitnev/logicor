package pageobjects;

import base.BasePageLC;
import base.Reporter;
import com.sun.org.apache.regexp.internal.RE;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MakeAnEquiryPage extends BasePageLC {

    public MakeAnEquiryPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public WebDriver driver;

    @FindBy(xpath = "//*[@id='edit-submitted-first-name']")
    private WebElement firstNameTextField;

    @FindBy(xpath = "//*[@id=\"edit-submitted-last-name\"]")
    private WebElement lastNameTextField;

    @FindBy(xpath = "//*[@id=\"edit-submitted-email\"]")
    private WebElement emailTextField;

    @FindBy(xpath = "//*[@id=\"edit-submitted-phone-number\"]")
    private WebElement phoneTextField;

    @FindBy(xpath = "//*[@id=\"edit-submitted-message\"]")
    private WebElement messageTextField;

    @FindBy(xpath = "//*[@class=\"webform-submit button-primary form-submit ajax-processed\"]")
    private WebElement sendButton;

    @FindBy(xpath = "//*[@id=\"edit-submitted-agree-1\"]")
    private WebElement checkBox;

    private void setFirstNameTextField(String firstName) {
        goSleep(12);
        firstNameTextField.click();
                firstNameTextField.sendKeys(firstName);
    }

    private void setLastNameTextField(String lastName) {
        setTextEl(lastNameTextField, lastName);
    }

    private void setEmailTextField(String email) {
        setTextEl(emailTextField, email);
    }

    private void setPhoneTextField(String phone) {
        setTextEl(phoneTextField, phone);
    }

    private void setMessageTextField(String messageText) {
       setTextEl(messageTextField,messageText);
    }

    private void clickSendButton() {
        waitForPresenceOfElement(sendButton);
        sendButton.click();
    }


    private void checkBox(){

    }

    public void makeAnEnquiry(String firstName, String lastName, String email, String phone, String message){
        Reporter.log("Making an enquiry");
        setFirstNameTextField(firstName);
        setLastNameTextField(lastName);
        setEmailTextField(email);
        setPhoneTextField(phone);
        setMessageTextField(message);

        clickSendButton();
    }
}