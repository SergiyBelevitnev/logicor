package pageobjects;

import base.BasePageLC;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ElementTranslationPage extends BasePageLC {

    public WebDriver driver;
    public ElementTranslationPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
    @FindBy(xpath = "/html/body/div[2]/p/a[3]")
    private WebElement translateButton;

    @FindBy(xpath = "/html/body/div[2]/p/a[4]")
    private WebElement addImagesButton;

    @FindBy(xpath = "/html/body/div[2]/p/a[5]")
    private WebElement addFloorPanButton;

    @FindBy(xpath = "/html/body/div[2]/p/a[6]")
    private WebElement addBrochurePdfButton;

    @FindBy(xpath = "/html/body/div[2]/form/div[1]/div[2]/a[1]")
    private WebElement cancelButton;

    @FindBy(xpath = "//*[@class=\"btn btn-primary btn-sm\"]")
    private WebElement saveButton;
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


    @FindBy(xpath = "//*[@id=\"propertytranslationform-location_longitude\"]")
    private WebElement longtitudeCell;


    @FindBy(xpath = "//*[@id=\"propertytranslationform-location_latitude\"]")
    private WebElement lattitudeCell;


   public void setAssetNameCell(String assetName){
       setTextCell(assetNameCell,assetName);
   }

    public void setTownCell(String town){
        setTextCell(townCell,town);
    }

    public void setAssetDescriptionCell(String assetDescription){
        setTextCell(assetDescriptionCell,assetDescription);
    }

    public void setYearAvaCell(Integer yearAva){
        setTextCell(yearAvaCell,yearAva.toString());
    }

    public void setHeightCell(Double height){
        setTextCell(heightCell,height.toString());
    }

    public void setCarParkingCell(Integer carParking){
        setTextCell(carParkingCell,carParking.toString());
    }

    public void setLoadingDocksCell(Integer loadingDocks){
        setTextCell(loadingDocksCell,loadingDocks.toString());
    }


    public void setVacantSpaceFeetCell(Double vacantSpaceFeet){
        setTextCell(vacantSpaceFeetCell,vacantSpaceFeet.toString());
    }


    public void setVacantSpaceMetresCell(Double vacantSpaceMetres){
        setTextCell(vacantSpaceMetresCell,vacantSpaceMetres.toString());
    }


    public void setTotalSpaceFeetCell(Double totalSpaceFeet){
        setTextCell(totalSpaceFeetCell,totalSpaceFeet.toString());
    }


    public void setTotalSpaceMetresCell(Double totalSpaceMetres){
        setTextCell(totalSpaceMetresCell, totalSpaceMetres.toString());
    }


    public void setOfficeTotalFeetCell(Double officeTotalFeet){
        setTextCell(officeTotalFeetCell,officeTotalFeet.toString());
    }


    public void setOfficeTotalMetresCell(Double officeTotalMetres){
        setTextCell(officeTotalMetresCell,officeTotalMetres.toString());
    }


    public void setCountryCell(String assetName){
        setTextCell(countryCell,assetName);
    }


    public void setLongtitudeCell(String assetName){
        setTextCell(longtitudeCell,assetName);
    }


    public void setLattitudeCell(String assetName){
        setTextCell(lattitudeCell,assetName);
    }

    public  void saveProperty(){
       saveButton.click();
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
