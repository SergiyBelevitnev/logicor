import base.BasePageLC;
import base.PropertyData;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageobjects.ElementTranslationPage;
import pageobjects.LoginPageLogicor;
import pageobjects.PropertyDetailPageUi;

@Test

public class ElementTranslationTest extends BasePageLC {

    public static ElementTranslationPage elTrPage;
    public static LoginPageLogicor loginPageLogicor;
    public static PropertyDetailPageUi propertyDetailPageUi;

    private static PropertyData propertyData;

    @DataProvider(name = "propertyData")
    public static Object[][] propertyDataProvider(){
        if (propertyData == null){

            propertyData=new PropertyData.Builder(
                    "Warehouse",
                    "Dublim",
                    "ldtgldsjgjdthijeptjpetjpiejpigh  rgodjjgjohgjgi",
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
                    "madagaslar",
                    "jgfkgb--------------ljs",
                    "jg---__________________fkljs").build();
        }
        return new Object[][]{{propertyData}};
    }
    @Test(dataProvider = "propertyData")
    public void elementTranslationPageTest(PropertyData propertyData){
        LaunchBrowser("chrome");
        openURL("http://ec2-3-8-87-222.eu-west-2.compute.amazonaws.com");
        getDriver().manage().window().maximize();
        loginPageLogicor = new LoginPageLogicor(getDriver());
        loginPageLogicor.login("qa@logicor.eu", "vcVC9eVvX3Ebk");
        openURL("http://ec2-3-8-87-222.eu-west-2.compute.amazonaws.com/admin/property/translate?id=1760&code=en");
        elTrPage = new ElementTranslationPage(getDriver());
        goSleep(5);
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
        elTrPage.setLongtitudeCell(propertyData.getLongitude());
        elTrPage.setLattitudeCell(propertyData.getLatitude());

        elTrPage.saveProperty();



        openURL("http://ec2-35-178-97-148.eu-west-2.compute.amazonaws.com/en/uk/find-a-warehouse/warehouse-detail?id=1760");
        propertyDetailPageUi = new PropertyDetailPageUi(getDriver());
        scrollToBottom();
//        System.out.println(propertyDetailPageUi.getOfficeTotalVacant());

        System.out.println(propertyDetailPageUi.getVacantSpaceField());
        goSleep(5);
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












        goSleep(8);





    }
}
