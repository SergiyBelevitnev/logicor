import base.BaseTest;
import base.EnquiryData;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageobjects.MainPageLogicorUI;
import pageobjects.MakeAnEquiryPage;

import static base.BasePageLC.goSleep;
import static base.BasePageLC.openURL;

public class MakeAnEnquiryTest extends BaseTest {
    private static EnquiryData enquiryData;
    public MakeAnEquiryPage makeAnEquiryPage;
    public MainPageLogicorUI mainPageLogicorUI;

    @DataProvider(name = "enquiryGetData")

    public static Object[][] enquiryDataProvider() {
        if (enquiryData == null) {
            enquiryData = new EnquiryData.Builder(
                    "Richard",
                    "Brenson",
                    "richi@virgin.com",
                    "1-800-145465456",
                    "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod " +
                            "tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam," +
                            " quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. " +
                            "Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat" +
                            " nulla pariatur.").build();
        }
        return new Object[][]{{enquiryData}};
    }



        @Test (dataProvider = "enquiryGetData")
        public void makeAnEquiryVoid(EnquiryData enquiryData){

            openURL("http://ec2-35-178-97-148.eu-west-2.compute.amazonaws.com");

            mainPageLogicorUI = new MainPageLogicorUI(getDriver());
            mainPageLogicorUI.chooseSmallProperties();
            mainPageLogicorUI.selectCountry("France");

            mainPageLogicorUI.clickSearchButton();
            mainPageLogicorUI.chooseListView();
            mainPageLogicorUI.chooseFirstWarehouse();

            makeAnEquiryPage = new MakeAnEquiryPage(getDriver());

            makeAnEquiryPage.makeAnEnquiry(enquiryData.getFirstName(),enquiryData.getLastName(),
                    enquiryData.getEmail(),enquiryData.getPhoneNumber(),enquiryData.getMessage());
            goSleep(5);
        }

}
