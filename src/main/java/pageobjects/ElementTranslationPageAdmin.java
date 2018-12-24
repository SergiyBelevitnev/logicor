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

public class ElementTranslationPageAdmin extends BasePageLC {

    public WebDriver driver;
    public ElementTranslationPageAdmin(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
    @FindBy(xpath = "//*[@id=\"w0\"]/table/tbody/tr[2]/td[5]/a[1]")
    private WebElement propertiesEnButton;

    @FindBy(xpath = "//*[@class=\"btn btn-info btn-xs\"][1]")
    private WebElement translateButton;

    @FindBy(xpath = "//*[@class=\"btn btn-info btn-xs\"][2]")
    private WebElement addImagesButton;

    @FindBy(xpath = "//*[@class=\"btn btn-info btn-xs\"][3]")
    private WebElement addFloorPanButton;

    @FindBy(xpath = "//*[@class=\"btn btn-info btn-xs\"][4]")
    private WebElement addBrochurePdfButton;

    @FindBy(xpath = "//*[@class=\"col-md-4 text-right\"]/*[1]")
    private WebElement cancelButton;

    @FindBy(xpath = "//*[@class=\"col-md-4 text-right\"]/*[2]")
    private WebElement saveButton;

    @FindBy(xpath = "//*[@id=\"w0\"]/table/tbody/tr[2]/td[5]/a[1]")
    private WebElement publishButton;



///Cells
    @FindBy(xpath = "//*[@id=\"propertytranslationform-asset_name\"]")
    private WebElement assetNameCell;


    @FindBy(xpath = "//*[@id=\"propertytranslationform-asset_town\"]")
    private WebElement townCell;


    @FindBy(xpath = "//*[@id=\"propertytranslationform-asset_description\"]")
    private WebElement assetDescriptionCell;


    @FindBy(xpath = "//*[@id=\"propertytranslationform-building_year_from\"]")
    private WebElement yearAvaCell;


    @FindBy(xpath = "//*[@id=\"propertytranslationform-building_height_max\"]")
    private WebElement heightCell;


    @FindBy(xpath = "//*[@id=\"propertytranslationform-building_car_parking_total\"]")
    private WebElement carParkingCell;


    @FindBy(xpath = "//*[@id=\"propertytranslationform-building_loading_dock_total\"]")
    private WebElement loadingDocksCell;


    @FindBy(xpath = "//*[@id=\"propertytranslationform-demise_total_vacant_sqf\"]")
    private WebElement vacantSpaceFeetCell;


    @FindBy(xpath = "//*[@id=\"propertytranslationform-demise_total_vacant_sqm\"]")
    private WebElement vacantSpaceMetresCell;


    @FindBy(xpath = "//*[@id=\"propertytranslationform-wh_total_vacant_sqf\"]")
    private WebElement totalSpaceFeetCell;


    @FindBy(xpath = "//*[@id=\"propertytranslationform-wh_total_vacant_sqm\"]")
    private WebElement totalSpaceMetresCell;


    @FindBy(xpath = "//*[@id=\"propertytranslationform-office_total_vacant_sqf\"]")
    private WebElement officeTotalFeetCell;


    @FindBy(xpath = "//*[@id=\"propertytranslationform-office_total_vacant_sqm\"]")
    private WebElement officeTotalMetresCell;


    @FindBy(xpath = "//*[@id=\"propertytranslationform-location_country\"]")
    private WebElement countryCell;
//*[@id="w0"]/table/thead/tr/th[4]/a

    @FindBy(xpath = "//*[@id=\"w0\"]/table/thead/tr/th[4]/a")
    private WebElement countrySort;

    @FindBy(xpath = "//*[@id=\"propertytranslationform-location_longitude\"]")
    private WebElement longtitudeCell;


    @FindBy(xpath = "//*[@id=\"propertytranslationform-location_latitude\"]")
    private WebElement lattitudeCell;


    public void clickAddImageButton(){
        Reporter.log("Openning add image page");
        addImagesButton.click();
    }

    public void clickEnTranslateButton(){
        Reporter.log("Openning translation page");
        translateButton.click();
    }

    public void clickFloorPanButton(){
        Reporter.log("Openning 'add floorpan/ page");
        addFloorPanButton.click();
    }

    public void clickAddBrochureButton(){
        addBrochurePdfButton.click();
    }

    public void clickCancelButton(){
        cancelButton.click();
    }

    public void clickPublishButton(){

        Reporter.log("Openning 'translation property' page");


        goSleep(3);
        publishButton.click();
    }

    public void waitForPresenceOfElement(WebElement element) {
        WebElement wait = (new WebDriverWait(driver,20)).until(ExpectedConditions.elementToBeClickable(element));
    }

    public void countrySort(){
        waitForPresenceOfElement(countrySort);
        countrySort.click();

        waitForPresenceOfElement(countrySort);
        countrySort.click();
        goSleep(3);

    }
   public void setAssetNameCell(String assetName){
       Reporter.log("Setting asset name");
       setTextCell(assetNameCell,assetName);
   }

    public void setTownCell(String town){
        Reporter.log("Setting town");
        setTextCell(townCell,town);
    }

    public void setAssetDescriptionCell(String assetDescription){
        Reporter.log("Setting asset description");

        setTextCell(assetDescriptionCell,assetDescription);
    }

    public void setYearAvaCell(Integer yearAva){
        Reporter.log("Setting year");

        setTextCell(yearAvaCell,yearAva.toString());
    }

    public void setHeightCell(Double height){
        Reporter.log("Setting height");
        setTextCell(heightCell,height.toString());
    }

    public void setCarParkingCell(Integer carParking){
        Reporter.log("Setting car parking spaces");
        setTextCell(carParkingCell,carParking.toString());
    }

    public void setLoadingDocksCell(Integer loadingDocks){
        Reporter.log("Setting loading docks");

        setTextCell(loadingDocksCell,loadingDocks.toString());
    }


    public void setVacantSpaceFeetCell(Double vacantSpaceFeet){
        Reporter.log("Setting vacant space(feet)");
        setTextCell(vacantSpaceFeetCell,vacantSpaceFeet.toString());
    }


    public void setVacantSpaceMetresCell(Double vacantSpaceMetres){
        Reporter.log("Setting vacant space(metres)");
        setTextCell(vacantSpaceMetresCell,vacantSpaceMetres.toString());
    }


    public void setTotalSpaceFeetCell(Double totalSpaceFeet){
        Reporter.log("Setting total space(feet)");
        setTextCell(totalSpaceFeetCell,totalSpaceFeet.toString());
    }


    public void setTotalSpaceMetresCell(Double totalSpaceMetres){
        Reporter.log("Setting total space(metres)");
        setTextCell(totalSpaceMetresCell, totalSpaceMetres.toString());
    }


    public void setOfficeTotalFeetCell(Double officeTotalFeet){
        Reporter.log("Setting office total space(feet)");
        setTextCell(officeTotalFeetCell,officeTotalFeet.toString());
    }


    public void setOfficeTotalMetresCell(Double officeTotalMetres){
        Reporter.log("Setting office total space(metres)");
        setTextCell(officeTotalMetresCell,officeTotalMetres.toString());
    }


    public void setCountryCell(String assetName){
        Reporter.log("Setting country");

        setTextCell(countryCell,assetName);
    }


    public void setLongitudeCell(String assetName){

        Reporter.log("Setting longitude");
        setTextCell(longtitudeCell,assetName);
    }


    public void setLatitudeCell(String assetName){
        Reporter.log("Setting latitude");
        setTextCell(lattitudeCell,assetName);
    }

    public  void saveProperty(){
        Reporter.log("Saving property");
        saveButton.click();
    }

    private String getCountryName2(){
        waitForPresenceOfElement(findElement(By.xpath("//*[@id='w0']/table/tbody/tr[2]/td[4]")));
        return getElementText(By.xpath("//*[@id='w0']/table/tbody/tr[2]/td[4]"));


    }
    public String getCountryName(){
        if (getCountryName2().equals("UK")){
            return "United Kingdom";
        }
        else return getCountryName2();
    }


    public void handleTableElements() {
        goSleep(1);
        List rows = getDriver().findElements(By.xpath("//*[@class='table table-condensed table-hover']/tbody/tr"));
        System.out.println(rows.size());
        for (int i = 1; i < rows.size()+1; i++) {

            String s1 = getElementText(By.xpath("//*[@class='table table-condensed table-hover']/tbody/tr[" + i + "]/th[1]"));
            setText(By.xpath("//*[@class='table table-condensed table-hover']/tbody/tr[" + i + "]/td[3]"+"/*[1]"), "11111111111111");

            String s3 = getElementText(By.xpath("//*[@class='table table-condensed table-hover']/tbody/tr[" + i + "]/td[3]"));
            System.out.println(s1+"-----------------"+s3);

        }
    }





    }
