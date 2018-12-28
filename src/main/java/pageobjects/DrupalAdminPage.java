package pageobjects;

import base.BasePageLC;
import base.Reporter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static java.lang.Integer.parseInt;

public class DrupalAdminPage extends BasePageLC {

    public WebDriver driver;

    public DrupalAdminPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//*[@id=\"block-system-main\"]//*[contains(text(),'Make an enquiry')]/../following-sibling::*[3]//*[contains(text(),'Submissions')]")
    private WebElement makeAnEnquiryReportsButton;


    @FindBy(xpath = "//*[@class=\"views-table sticky-enabled cols-5 tableheader-processed sticky-table\"]/tbody/tr[1]/td[1]/a")
    private WebElement lastEnquiry;

    @FindBy(xpath = "//*[@class=\"form-item webform-component webform-component-display webform-component--first-name webform-container-inline\"]")
    private WebElement firstName;

    @FindBy(xpath = "//*[@class='form-item webform-component webform-component-display webform-component--last-name webform-container-inline']")
    private WebElement lastName;

    @FindBy(xpath = "//*[@class=\"form-item webform-component webform-component-display webform-component--email\"]")
    private WebElement email;

    @FindBy(xpath = "//*[@class=\"form-item webform-component webform-component-display webform-component--phone-number\"]")
    private WebElement phoneNumber;

    @FindBy(xpath = "//*[@class=\"form-item webform-component webform-component-display webform-component--message\"]/*[2]")
    private WebElement message;

    @FindBy(xpath = "//*[@class=\"views-empty\"]")
    private WebElement noEnquiriesEl;

    @FindBy(xpath = "//*[@id=\"branding\"]/div/a[3]")
    private WebElement backToListEnquiries;

    @FindBy(xpath = "//*[@class=\"views-table sticky-enabled cols-5 tableheader-processed sticky-table\"]/tbody/tr[1]/td[5]/a[3]")
    private WebElement deleteEnquiry;

    @FindBy(xpath = "//*[@id=\"edit-actions-submit\"]")
    private WebElement deleteSubmit;


    public void deleteEnquiry() {
        waitForPresenceOfElement(backToListEnquiries);
        backToListEnquiries.click();
        waitForPresenceOfElement(deleteEnquiry);
        deleteEnquiry.click();
        waitForPresenceOfElement(deleteSubmit);
        deleteSubmit.click();
        Reporter.log("Deleting test enquiry");
    }

    public boolean noEnquiries(){
        return isElementPresent(By.xpath("//*[@class='views-empty']"));
    }



    public String getFirstName() {
        return getElementTextElement(firstName);
    }

    public String getLastName() {
        return getElementTextElement(lastName);
    }

    public String getEmail() {
        return getElementTextElement(email);
    }

    public String getPhoneNumber() {
        return getElementTextElement(phoneNumber);
    }

    public String getMessage() {
        return getElementTextElement(message);
    }

    public int lastEnquiryIndex(){
//        Reporter.log("Getting last enquiry index");
        waitForPresenceOfElement(lastEnquiry);
    return parseInt(getElementTextElement(lastEnquiry));}

    public void openMakeAnEnquiryReportPage(){
        Reporter.log("Opening enquiry page");
        waitForPresenceOfElement(makeAnEnquiryReportsButton);
        makeAnEnquiryReportsButton.click();
    }

    public void openLastEnquiry(){
        Reporter.log("Opening last enquiry");
        lastEnquiry.click();
        goSleep(2);
    }
}