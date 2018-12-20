//import base.BasePageLC;
//import org.openqa.selenium.By;
//import org.testng.annotations.Test;
//import pageobjects.MainPageLogicor;
//
//@Test
//
//public class FindWarehouseTest extends BasePageLC {
//
//
//    public static MainPageLogicor mainPageLogicor;
//
//    public void findWarehouse() {
//        LaunchBrowser("chrome");
//        openURL("http://ec2-35-178-97-148.eu-west-2.compute.amazonaws.com");
//        getDriver().manage().window().maximize();
//
//        goSleep(4);
//
//        mainPageLogicor = new MainPageLogicor(getDriver());
//
//        mainPageLogicor.chooseLargeProperties();
//        mainPageLogicor.selectCountry("France");
//
//        mainPageLogicor.clickSearchButton();
//        mainPageLogicor.chooseListView();
//        scrollToBottom();
//        goSleep(30);
//
//
//    }
//}
