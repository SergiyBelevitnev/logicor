import base.BasePageLC;

import base.Items;
import base.Reporter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pageobjects.LoginPageLogicor;

import java.util.ArrayList;
import java.util.List;


@Test
public class LoginLC extends BasePageLC {

    public static LoginPageLogicor loginPageLogicor;


    public void loginLC() {
        LaunchBrowser("chrome");
        openURL("http://ec2-3-8-87-222.eu-west-2.compute.amazonaws.com");
        loginPageLogicor = new LoginPageLogicor(getDriver());
        loginPageLogicor.inputLogin("qa@logicor.eu");
        loginPageLogicor.inputPassword("vcVC9eVvX3Ebk");
        loginPageLogicor.clickLoginButton();
        clickOnElement(By.xpath("//*[@title='Property import']"));

        uploadFile(By.xpath("//*[@id='propertyimportform-file_import']"), "C:\\Users\\Itsmy\\Desktop\\logikor\\logicor\\files\\property.csv");
        goSleep(3);

        clickOnElement(By.xpath("//*[@id=\"w0\"]/div[2]/button"));
        goSleep(2);
        clickOnElement(By.xpath("/html/body/div/p/a[1]"));
        goSleep(2);
//        clickOnElement(By.xpath("//*[@id='w0']/ul/li[4]/a"));

    }

    public void putDataToCollection() {

        WebElement baseTable = getDriver().findElement(By.tagName("table"));
        List col = getDriver().findElements(By.xpath(".//*[@id='w0']/table/thead/tr/th"));
        List rows = getDriver().findElements(By.xpath("//*[@id='w0']/table/tbody/tr/td[1]"));

        List<Items> itemsList = new ArrayList<Items>();
        for (int i = 1; i < rows.size()+1; i++) {

            String s1 = getElementText(By.xpath("//*[@id='w0']/table/tbody/tr[" + i + "]/td[1]"));
            String s2 = getElementText(By.xpath("//*[@id='w0']/table/tbody/tr[" + i + "]/td[2]"));
            String s3 = getElementText(By.xpath("//*[@id='w0']/table/tbody/tr[" + i + "]/td[3]"));
            String s4 = getElementText(By.xpath("//*[@id='w0']/table/tbody/tr[" + i + "]/td[4]"));
            Boolean bool = isCneckboxChecked(By.xpath("//*[@id='w0']/table/tbody/tr[" + i + "]/td[6]/a/span"));

            Items items = new Items(s1, s2, s3, s4, bool);

            itemsList.add(items);
            System.out.println(items.toString());
            System.out.println(itemsList.size() + "ITEMS__________KDKEKE___________________________");
//                data[i - 1][k - 1] = s;


//                System.out.println(data[i][k]);

        }
        deleteAllItemsLogikor("//*[@id='w0']/table/tbody/tr/td/div", "//*[@id='w0']/table/tbody/tr[1]/td[7]/a/span");
    }



//    public void putDataToArray() {
//
//        WebElement baseTable3 = getDriver().findElement(By.tagName("table"));
//        List col3 = getDriver().findElements(By.xpath(".//*[@id='w0']/table/thead/tr/th"));
//        List rows3 = getDriver().findElements(By.xpath("//*[@id='w0']/table/tbody/tr/td[1]"));
//
//
//
//
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
//
//
//
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
//
//

//
//
//        }
//
//
//    }
}
