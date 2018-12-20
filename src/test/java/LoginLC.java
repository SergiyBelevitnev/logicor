import base.BasePageLC;

import base.Items;
import base.Reporter;
import base.WorkWithCollectionAdminProp;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.ImportPropertiesPage;
import pageobjects.LoginPageLogicor;
import pageobjects.MainPageLogicor;

import java.util.ArrayList;
import java.util.List;



public class LoginLC extends BasePageLC {

    public static MainPageLogicor mainPageLogicor;
    public static LoginPageLogicor loginPageLogicor;
    public static ImportPropertiesPage importPropertiesPage;

    @Test
    public void loginLC() {
        LaunchBrowser("chrome");
        openURL("http://ec2-3-8-87-222.eu-west-2.compute.amazonaws.com");
        getDriver().manage().window().maximize();
        loginPageLogicor = new LoginPageLogicor(getDriver());
        importPropertiesPage = new ImportPropertiesPage(getDriver());
        loginPageLogicor.login("qa@logicor.eu", "vcVC9eVvX3Ebk");
        loginPageLogicor.clickImportButton();
        importPropertiesPage.uploadFile(System.getProperty("user.dir")+"\\src\\main\\resources\\files\\property.csv");
        importPropertiesPage.startImport();
        goSleep(2);
        importPropertiesPage.openPropList();

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
        mainPageLogicor = new MainPageLogicor(getDriver());
        mainPageLogicor.chooseSmallProperties();
        mainPageLogicor.selectCountry("France");

        mainPageLogicor.clickSearchButton();
        mainPageLogicor.chooseListView();
//        scrollToBottom();
        Reporter.log("Verification amount of small properties in France is: " + mainPageLogicor.countAssetsMain().toString());
        Assert.assertEquals(workWithCollectionAdminProp1.getCountSmallFrance(), mainPageLogicor.countAssetsMain());


        openURL("http://ec2-35-178-97-148.eu-west-2.compute.amazonaws.com");
        mainPageLogicor.chooseLargeProperties();
        mainPageLogicor.selectCountry("Spain");

        mainPageLogicor.clickSearchButton();
        mainPageLogicor.chooseListView();
        Reporter.log("Verification amount of large properties in Spain is: " + mainPageLogicor.countAssetsMain().toString());
        Assert.assertEquals(workWithCollectionAdminProp1.getCountSpain(), mainPageLogicor.countAssetsMain());





    }




}



//    public void putDataToArray() {
//
//        WebElement baseTable3 = getDriver().findElement(By.tagName("table"));
//        List col3 = getDriver().findElements(By.xpath(".//*[@id='w0']/table/thead/tr/th"));
//        List rows3 = getDriver().findElements(By.xpath("//*[@id='w0']/table/tbody/tr/td[1]"));
//        String[][] data = new String[44][7];
//
//        for (int i = 1; i < rows3.size(); i++) {
//            for (int k = 1; k < col3.size(); k++) {
//                String s = getElementText(By.xpath("//*[@id='w0']/table/tbody/tr[" + i + "]/td[" + k + "]"));
//                data[i - 1][k - 1] = s;
//
//
//                System.out.println(data[i][k]);
//            }
//
//        }
//        if (isElementPresent(By.xpath("//*[@id='w0']/ul/li[4]/span"))) {
//            Reporter.log("All items added");

//        } else {
//            clickOnElement(By.xpath("//*[@id='w0']/ul/li[4]/a"));
//            goSleep(5);
//            WebElement baseTable2 = getDriver().findElement(By.tagName("table"));
//            List col2 = getDriver().findElements(By.xpath(".//*[@id='w0']/table/thead/tr/th"));
//            List rows2 = getDriver().findElements(By.xpath("//*[@id='w0']/table/tbody/tr/td[1]"));
//
//            for (int i = 1; i < rows2.size(); i++) {
//                for (int k = 1; k < col2.size(); k++) {
//                    String s = getElementText(By.xpath("//*[@id='w0']/table/tbody/tr[" + i + "]/td[" + k + "]"));
//                    data[i - 1][k - 1] = s;
//
//                    System.out.println(data[i][k]);
//                }
//            }
