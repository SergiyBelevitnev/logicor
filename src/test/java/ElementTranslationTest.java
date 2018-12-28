import base.*;
import data.PropertyData;
import data.URL;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageobjects.*;

@Test

public class ElementTranslationTest extends BaseTest {

    public static ElementTranslationPageAdmin elTrPage;
    public static PropertyDetailPageUi propertyDetailPageUi;
    public static AddImagePageAdmin addImagePageAdmin;
    public static MainPageLogicorUI mainPageLogicorUI;

    private static PropertyData propertyData;

    @DataProvider(name = "propertyData")
    public static Object[][] propertyDataProvider(){
        if (propertyData == null){

            propertyData=new PropertyData.Builder(
                    "BestWarehouseinWorld",
                    "Dublin",
                    "Lorem ipsum dolor sit amet, consectetur adipiscing elit, " +
                            "sed do eiusmod tempor incididunt ut labore et dolore magna aliqua." +
                            " Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi " +
                            " ut aliquip ex ea commodo consequat.",
                    1999,
                    80.00,
                    50,
                    96,
                    11111.00,
                    22222.00,
                    33333.00,
                    44444.00,
                    55555.00,
                    66666.00,
                    "France",
                    "2.43654646",
                    "545.6545646").build();
        }
        return new Object[][]{{propertyData}};
    }
    @Test(dataProvider = "propertyData")
    public void elementTranslationPageTest(PropertyData propertyData){
        elTrPage = new ElementTranslationPageAdmin(getDriver());

        BasePageLC.goSleep(2);

        elTrPage.countrySort();
        String editElementCountry= elTrPage.getCountryName();
        System.out.println(editElementCountry);



        elTrPage.clickPublishButton();


        elTrPage.setAssetNameCell(propertyData.getAssetName());
        elTrPage.setTownCell(propertyData.getTown());
        elTrPage.setAssetDescriptionCell(propertyData.getAssetDescription());
        elTrPage.setYearAvaCell(propertyData.getYearAvailableFrom());
        elTrPage.setHeightCell(propertyData.getHeightMax());
        elTrPage.setCarParkingCell(propertyData.getCarPparkingSpacesTotal());
        elTrPage.setLoadingDocksCell(propertyData.getLoadingDocksTotal());
        elTrPage.setVacantSpaceFeetCell(propertyData.getVacantSpaceSquareFeet());
        elTrPage.setVacantSpaceMetresCell(propertyData.getVacantSpaceSquareMetres());
        elTrPage.setTotalSpaceFeetCell(propertyData.getTotalSpaceVacantSqft());
        elTrPage.setTotalSpaceMetresCell(propertyData.getTotalVacantSquareMetres());
        elTrPage.setOfficeTotalFeetCell(propertyData.getOfficeTotalVacantSquareFeet());
        elTrPage.setOfficeTotalMetresCell(propertyData.getOfficeTotalVacantSquareMetres());
        elTrPage.setCountryCell(propertyData.getCountry());
        elTrPage.setLongitudeCell(propertyData.getLongitude());
        elTrPage.setLatitudeCell(propertyData.getLatitude());

        elTrPage.saveProperty();

        elTrPage.clickAddImageButton();
        addImagePageAdmin = new AddImagePageAdmin(getDriver());
        addImagePageAdmin.addFirstImage();
        addImagePageAdmin.addFirstImage();

        BasePageLC.goSleep(2);

        Integer imageCountAdmin = addImagePageAdmin.imageCountAdmin();

        elTrPage.clickFloorPanButton();
        addImagePageAdmin.addFirstImage();
        BasePageLC.goSleep(2);

        Integer imageFloorPanAdmin = addImagePageAdmin.imageFloorPanAdmin();

        addImagePageAdmin.goBackButton();


        BasePageLC.openURL(URL.CLIENT.toString());


        BasePageLC.goSleep(2);

        mainPageLogicorUI = new MainPageLogicorUI(getDriver());

        mainPageLogicorUI.chooseLargeProperties();
        mainPageLogicorUI.selectCountry(editElementCountry);

        mainPageLogicorUI.clickSearchButton();
        mainPageLogicorUI.chooseListView();
        BasePageLC.goSleep(2);

        getDriver().findElement(By.xpath("//*[@class=\"warehouse-finder-listing\"]//*[@class=\"info-box-inner__heading\"][.='" + propertyData.getAssetName() + "']")).click();

        BasePageLC.scrollToBottom();


        propertyDetailPageUi = new PropertyDetailPageUi(getDriver());


        BasePageLC.goSleep(2);

        Assert.assertEquals(propertyDetailPageUi.getYear(),propertyData.getYearAvailableFrom().toString());

        Assert.assertEquals(propertyDetailPageUi.getLoadingDocks(),propertyData.getLoadingDocksTotal().toString()+ " docks");

        Assert.assertEquals(propertyDetailPageUi.getParkingSpacesField(),propertyData.getCarPparkingSpacesTotal().toString()+ " car parking spaces");

        Assert.assertEquals(Long.toString(Math.round(Math.floor(propertyData.getOfficeTotalVacantSquareFeet())))
                        +"SQFT"+"\n"
                +Long.toString(Math.round(Math.floor(propertyData.getOfficeTotalVacantSquareMetres())))+"SQM"
                ,propertyDetailPageUi.getOfficeTotalVacant());

        Assert.assertEquals(Long.toString(Math.round(Math.floor(propertyData.getTotalSpaceVacantSqft())))
                        +"SQFT"+"\n"
                        +Long.toString(Math.round(Math.floor(propertyData.getTotalVacantSquareMetres())))+"SQM"
                ,propertyDetailPageUi.getVacantSpaceField());
        Reporter.log("Verification property success!");
        Assert.assertEquals(propertyData.getAssetName().toUpperCase(),propertyDetailPageUi.getTitleField());

        Assert.assertEquals(imageCountAdmin,propertyDetailPageUi.imageCountUi());

        Assert.assertEquals(imageFloorPanAdmin,propertyDetailPageUi.floorCountUi());
        Reporter.log("Verification media elements success!");

        BasePageLC.goSleep(2);
    }
}
