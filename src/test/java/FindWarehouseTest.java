import base.BasePageLC;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import pageobjects.MainPageLogicor;

@Test

public class FindWarehouseTest extends BasePageLC {


    public static MainPageLogicor mainPageLogicor;

    public void findWarehouse() {
        LaunchBrowser("chrome");
        openURL("http://ec2-35-178-97-148.eu-west-2.compute.amazonaws.com");
        getDriver().manage().window().maximize();
//        scrollToBottom();
        goSleep(4);
//        switchToFrame("//*[@id='warehouse-finder']/div");
//        moveToElement("//*[@id='warehouse-finder']");
        mainPageLogicor = new MainPageLogicor(getDriver());

        Boolean bool =  isElementPresent(By.xpath("//*[@id='warehouse-finder']/div/div[2]/div[1]/div/div"));
            if (bool)
            {System.out.println("truetruetruetruetruetruegfkhpldgfmbd_______---------------------");
        }
        else {System.out.println("falsefalsefalsefalsefalsefalsefalsefalsefalsefalsefalsefalsefalse");}

        Boolean bool2 = isElementPresent(By.xpath("//*[@id='warehouse-finder']//button"));
        System.out.println(bool2);

        mainPageLogicor.chooseLargeProperties();
        mainPageLogicor.selectCountry("France");
//
        mainPageLogicor.clickSearchButton();
        mainPageLogicor.chooseListView();
        scrollToBottom();
        goSleep(30);


    }
}
