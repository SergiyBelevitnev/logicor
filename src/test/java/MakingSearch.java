import base.BasePageLC;
import data.URL;
import org.testng.annotations.Test;
import pageobjects.MainPageLogicorUI;
@Test
public class MakingSearch extends BasePageLC {

    public static MainPageLogicorUI mainPageLogicorUI;

    public void makingSearch(){

        LaunchBrowser("chrome");


        openURL(URL.CLIENT_TEST.toString());

        mainPageLogicorUI = new MainPageLogicorUI(getDriver());
        mainPageLogicorUI.searchClick();
        mainPageLogicorUI.searchMaking("Story");
        goSleep(10);


    }
}
