import base.BaseTest;
import base.EnquiryData;

import base.Reporter;
import base.URL;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageobjects.DrupalAdminPage;
import pageobjects.MainPageLogicorUI;
import pageobjects.MakeAnEquiryPage;

import static base.BasePageLC.goSleep;
import static base.BasePageLC.openURL;

public class MakeAnEnquiryTest extends BaseTest {
    private static EnquiryData enquiryData;
    public MakeAnEquiryPage makeAnEquiryPage;
    public MainPageLogicorUI mainPageLogicorUI;
    public DrupalAdminPage drupalAdminPage;

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
            mainPageLogicorUI = new MainPageLogicorUI(getDriver());
            drupalAdminPage = new DrupalAdminPage(getDriver());
            openURL(URL.CLIENT_TEST.toString()+"/en/user/login");
            mainPageLogicorUI.loginDrupal("qa@logicor.eu","vc<V&C@9eVvX3Ebk");
            drupalAdminPage = new DrupalAdminPage(getDriver());
            openURL(URL.CLIENT_TEST.toString()+"/en/admin/content/webform");

            drupalAdminPage.openMakeAnEnquiryReportPage();
            goSleep(5);
            int x = drupalAdminPage.lastEnquiryIndex();
            Reporter.log("Last number of enquiry is: "+String.valueOf(x));


//            openURL(URL.CLIENT_TEST.toString()+"/en/admin/content/webform");
//
//            drupalAdminPage.openMakeAnEnquiryReportPage();

            openURL(URL.CLIENT_TEST.toString());

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


//            openURL(URL.CLIENT_TEST.toString()+"/en/user/login");
//            mainPageLogicorUI.loginDrupal("qa@logicor.eu","vc<V&C@9eVvX3Ebk");
//            goSleep(5);


            openURL(URL.CLIENT_TEST.toString()+"/en/admin/content/webform");

            drupalAdminPage.openMakeAnEnquiryReportPage();
            Assert.assertEquals(drupalAdminPage.lastEnquiryIndex(), x+1);
            Reporter.log("Last number of enquiry is: "+String.valueOf(drupalAdminPage.lastEnquiryIndex()));
            drupalAdminPage.openLastEnquiry();

            goSleep(2);


            Assert.assertEquals(drupalAdminPage.getFirstName(),"First name "+enquiryData.getFirstName() );
            Reporter.log("Verification of First Name success!");
            Assert.assertEquals(drupalAdminPage.getLastName(),"Last name "+enquiryData.getLastName() );
            Reporter.log("Verification of Last Name success!");
            Assert.assertEquals(drupalAdminPage.getMessage(),enquiryData.getMessage());
            Reporter.log("Verification of Message success!");
            Assert.assertEquals(drupalAdminPage.getEmail(),"Email"+"\n"+enquiryData.getEmail());
            Reporter.log("Verification of Email success!");
            Assert.assertEquals(drupalAdminPage.getPhoneNumber(),"Phone number"+"\n"+enquiryData.getPhoneNumber());
            Reporter.log("Verification of PhoneNumber success!");





            goSleep(5);


        }


}
