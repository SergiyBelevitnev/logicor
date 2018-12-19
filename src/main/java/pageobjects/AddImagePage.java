package pageobjects;

import base.BasePageLC;
import base.Reporter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class AddImagePage extends BasePageLC {

    public WebDriver driver;
    public AddImagePage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }


    @FindBy(xpath = "//*[@id=\"property-bynder-list\"]/*[1]")
    private WebElement firstImage;

    @FindBy(xpath = "//*[@id=\"property-bynder-list\"]/*[2]")
    private WebElement secondImage;

    @FindBy(xpath = "//*[@id=\"property-bynder-list\"]/*[3]")
    private WebElement thirdImage;

    @FindBy(xpath = "//*[@id=\"property-bynder-list\"]/*[4]")
    private WebElement fourthImage;

    @FindBy(xpath = "//*[@class=\"btn btn-default btn-sm\"]")
    private WebElement backButton;

    @FindBy (xpath = "//*[@class=\"ui-sortable-handle\"]")
    private List<WebElement> elementName ;

    @FindBy (xpath = "//*[@class=\"ui-sortable-handle\"]")
    private List<WebElement> floorPans ;

    public  Integer imageFloorPanAdmin(){


        goSleep(2);
        return floorPans.size();
    }


    public  Integer imageCountAdmin(){
        goSleep(2);
        return elementName.size();
    }


    public void waitForPresenceOfElement() {
        WebElement wait = (new WebDriverWait(driver,20)).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"property-bynder-list\"]/*[1]")));
    }

    public void addFirstImage(){
        Reporter.log("Adding media element");
        waitForPresenceOfElement();
        firstImage.click();
        goSleep(2);
    }


    public void goBackButton(){
        backButton.click();
    }



}
