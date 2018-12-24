import base.BasePageLC;

import base.Items;
import base.Reporter;
import base.WorkWithCollectionAdminProp;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.ImportPropertiesPageAdmin;
import pageobjects.LoginPageLogicorAdmin;
import pageobjects.MainPageLogicorUI;

import java.util.ArrayList;
import java.util.List;



public class LoginLC extends BasePageLC {

    public static MainPageLogicorUI mainPageLogicorUI;
    public static LoginPageLogicorAdmin loginPageLogicorAdmin;
    public static ImportPropertiesPageAdmin importPropertiesPageAdmin;

    @Test
    public void loginLC() {
        LaunchBrowser("chrome");
        openURL("http://ec2-3-8-87-222.eu-west-2.compute.amazonaws.com");
        getDriver().manage().window().maximize();
        loginPageLogicorAdmin = new LoginPageLogicorAdmin(getDriver());
        importPropertiesPageAdmin = new ImportPropertiesPageAdmin(getDriver());
        loginPageLogicorAdmin.login("qa@logicor.eu", "vcVC9eVvX3Ebk");
        loginPageLogicorAdmin.clickImportButton();
        importPropertiesPageAdmin.uploadFile(System.getProperty("user.dir")+"\\src\\main\\resources\\files\\property.csv");
        importPropertiesPageAdmin.startImport();
        goSleep(2);
        importPropertiesPageAdmin.openPropList();

    }


    @Test
    public void setDataToCollection(){
        List<Items> itemsList = new ArrayList<Items>();
        addTableElementsToCollection(itemsList);

        if (isElementPresent(By.xpath("//*[@id='w0']/ul/li[4]/span"))) {
            Reporter.log("All items added");
        } else {
            clickOnElement(By.xpath("//*[@id='w0']/ul/li[4]/a"));
            goSleep(2);
            addTableElementsToCollection(itemsList);
        }
        WorkWithCollectionAdminProp workWithCollectionAdminProp1 = new WorkWithCollectionAdminProp(itemsList);

        openURL("http://ec2-35-178-97-148.eu-west-2.compute.amazonaws.com");


        mainPageLogicorUI = new MainPageLogicorUI(getDriver());
        mainPageLogicorUI.chooseSmallProperties();
        mainPageLogicorUI.selectCountry("France");

        mainPageLogicorUI.clickSearchButton();
        mainPageLogicorUI.chooseListView();
//        scrollToBottom();
        Reporter.log("Verification amount of small properties in France is: " + mainPageLogicorUI.countAssetsMain().toString());
        Assert.assertEquals(workWithCollectionAdminProp1.getCountSmallFrance(), mainPageLogicorUI.countAssetsMain());


        openURL("http://ec2-35-178-97-148.eu-west-2.compute.amazonaws.com");
        mainPageLogicorUI.chooseLargeProperties();
        mainPageLogicorUI.selectCountry("Spain");
        mainPageLogicorUI.clickSearchButton();
        mainPageLogicorUI.chooseListView();
        Reporter.log("Verification amount of large properties in Spain is: " + mainPageLogicorUI.countAssetsMain().toString());
        Assert.assertEquals(workWithCollectionAdminProp1.getCountSpain(), mainPageLogicorUI.countAssetsMain());





    }




}



