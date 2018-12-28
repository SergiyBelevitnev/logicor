import base.*;

import data.CREDS;
import data.Items;
import data.URL;
import data.WorkWithCollectionAdminProp;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
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
        openURL(URL.ADMIN.toString());
        getDriver().manage().window().setPosition(new Point(0,0));
        getDriver().manage().window().setSize(new Dimension(1924,838));
        loginPageLogicorAdmin = new LoginPageLogicorAdmin(getDriver());
        importPropertiesPageAdmin = new ImportPropertiesPageAdmin(getDriver());
        loginPageLogicorAdmin.login(CREDS.KEY.ADMINNAME(), CREDS.KEY.ADMINPASSWORD());
        loginPageLogicorAdmin.clickImportButton();
        importPropertiesPageAdmin.uploadFile(System.getProperty("user.dir")+"\\src\\main\\resources\\files\\property.csv");
        importPropertiesPageAdmin.startImport();

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

        openURL(URL.CLIENT.toString());

        mainPageLogicorUI = new MainPageLogicorUI(getDriver());
        mainPageLogicorUI.chooseSmallProperties();
        mainPageLogicorUI.selectCountry("France");
        mainPageLogicorUI.clickSearchButton();
        mainPageLogicorUI.chooseListView();
        Reporter.log("Verification amount of small properties in France is: " + mainPageLogicorUI.countAssetsMain().toString());
        Assert.assertEquals(workWithCollectionAdminProp1.getCountSmallFrance(), mainPageLogicorUI.countAssetsMain());

        openURL(URL.CLIENT.toString());
        mainPageLogicorUI.chooseLargeProperties();
        mainPageLogicorUI.selectCountry("Spain");
        mainPageLogicorUI.clickSearchButton();
        mainPageLogicorUI.chooseListView();
        Reporter.log("Verification amount of large properties in Spain is: " + mainPageLogicorUI.countAssetsMain().toString());
        Assert.assertEquals(workWithCollectionAdminProp1.getCountSpain(), mainPageLogicorUI.countAssetsMain());
    }
}



