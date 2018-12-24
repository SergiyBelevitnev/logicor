import base.BasePageLC;
import base.BaseTest;
import base.PropertyData;
import base.Reporter;
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

//        String dgf = propertyDataProvider()[0][0].toString();
//        System.out.println(dgf);

        elTrPage.clickPublishButton();


//        elTrPage
//                .setAssetNameCell(propertyData.getAssetName())
//                .setTownCell()
//                .setAssetDescriptionCell()
//                .setYearAvaCell()
//                .setHeightCell()
//                .setCarParkingCell()
//                .setLoadingDocksCell()
//                .setVacantSpaceFeetCell()
//                .setVacantSpaceMetresCell()
//                .setTotalSpaceFeetCell()
//                .setTotalSpaceMetresCell()
//                .setOfficeTotalFeetCell()
//                .setOfficeTotalMetresCell()
//                .setCountryCell()
//                .setLongitudeCell()
//                .setLatitudeCell();


//        System.out.println(AssetName);
//        System.out.println(Town);
//        System.out.println(AssetDescription);
//        System.out.println(YearAvailableFrom.toString());
//        System.out.println(HeightMax);
//        System.out.println(CarParkingSpacesTotal);
//        System.out.println(LoadingDocksTotal);
//        System.out.println(VacantSpaceSquareFeet);
//        System.out.println(VacantSpaceSquareMetres);
//        System.out.println(TotalSpaceVacantSqft);
//        System.out.println(TotalVacantSquareMetres);
//        System.out.println(OfficeTotalVacantSquareFeet);
//        System.out.println(OfficeTotalVacantSquareMetres);
//        System.out.println(Country);
//        System.out.println(Longitude);
//        System.out.println(Latitude);






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


        BasePageLC.openURL("http://ec2-35-178-97-148.eu-west-2.compute.amazonaws.com");


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
