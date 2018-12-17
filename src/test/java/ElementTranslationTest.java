import base.BasePageLC;
import org.testng.annotations.Test;
import pageobjects.ElementTranslationPage;
import pageobjects.LoginPageLogicor;

@Test

public class ElementTranslationTest extends BasePageLC {

    public static ElementTranslationPage elementTranslationPage;
    public static LoginPageLogicor loginPageLogicor;

    public void elementTranslationPageTest(){
        LaunchBrowser("chrome");
        openURL("http://ec2-3-8-87-222.eu-west-2.compute.amazonaws.com");
        getDriver().manage().window().maximize();
        loginPageLogicor = new LoginPageLogicor(getDriver());
        loginPageLogicor.login("qa@logicor.eu", "vcVC9eVvX3Ebk");
        openURL("http://ec2-3-8-87-222.eu-west-2.compute.amazonaws.com/admin/property/translate?id=1629&code=en");
        elementTranslationPage = new ElementTranslationPage(getDriver());
        elementTranslationPage.handleTableElements();


    }
}
