package pageobjects;

import base.BasePageLC;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

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


    @FindBy(xpath = "//*[@class=\"hero hero__sub-page hero__sub-page-blue\"]/*[1]/*[2]")
    private WebElement titleField;

    @FindBy(xpath = "//*[@class=\"warehouse-detail\"]/*[3]")
    private WebElement assetDescriptionField;

    @FindBy (xpath = "//*[@class=\"owl-dots\"]/*")
    private List<WebElement> elementName ;

    @FindBy (xpath = "//*[@class=\"button button__blue button__download\"]")
    private List<WebElement> floorPans ;





    public  Integer floorCountUi(){
        return floorPans.size();
    }

    public  Integer imageCountUi(){
        return elementName.size();
    }

    public String getAssetDescrField(){

        return BasePageLC.getElementTextElement(assetDescriptionField);
    }


    public String getTitleField(){
        return BasePageLC.getElementTextElement(titleField);
    }

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
