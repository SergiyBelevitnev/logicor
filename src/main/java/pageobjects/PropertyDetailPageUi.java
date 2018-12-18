package pageobjects;

import base.BasePageLC;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PropertyDetailPageUi {
    public PropertyDetailPageUi(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
    public WebDriver driver;

    @FindBy(xpath = "//*[@class=\"details-wrapper\"]/*[1]/*[2]")
    private WebElement officeTotalVacantField;


    @FindBy(xpath = "//*[@class=\"details-wrapper\"]/*[2]/*[2]")
    private WebElement yearField;


    @FindBy(xpath = "//*[@class=\"details-wrapper\"]/*[3]/*[2]")
    private WebElement vacantSpaceField;


    @FindBy(xpath = "//*[@class=\"details-wrapper\"]/*[4]/*[2]")
    private WebElement loadingDocksField;


    @FindBy(xpath = "//*[@class=\"details-wrapper\"]/*[5]/*[2]")
        private WebElement carParkingSpacesField;



    public String getOfficeTotalVacant(){

        return BasePageLC.getElementTextElement(officeTotalVacantField);
    }

    public String getYear(){
        return BasePageLC.getElementTextElement(yearField);
    }

    public String getVacantSpaceField(){
        return BasePageLC.getElementTextElement(vacantSpaceField);
    }

    public String getLoadingDocks(){
        return BasePageLC.getElementTextElement(loadingDocksField);
    }

    public String getParkingSpacesField(){
        return BasePageLC.getElementTextElement(carParkingSpacesField);
    }

}
