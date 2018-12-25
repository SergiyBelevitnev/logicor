import base.*;
import org.apache.commons.collections4.KeyValue;
import org.apache.commons.collections4.map.MultiValueMap;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.AddImagePageAdmin;
import pageobjects.ElementTranslationPageAdmin;
import pageobjects.MainPageLogicorUI;
import pageobjects.PropertyDetailPageUi;

import java.lang.reflect.Array;
import java.time.temporal.TemporalAccessor;
import java.util.AbstractMap;
import java.util.AbstractMap.SimpleImmutableEntry;
import java.util.Map;

public class PropertyTranslationTest extends BaseTest {

    public static ElementTranslationPageAdmin elTrPage;
    public static PropertyDetailPageUi propertyDetailPageUi;
    public static AddImagePageAdmin addImagePageAdmin;
    public static MainPageLogicorUI mainPageLogicorUI;



    @Test
    public void propertyTranslationTest() {
        elTrPage = new ElementTranslationPageAdmin(getDriver());

        BasePageLC.goSleep(2);



        Reporter.log(elTrPage.getCountryName());


        String assetName = elTrPage.getAssetName();
        Reporter.log(assetName);
        String f=getDriver().getCurrentUrl();


        String languages[] = new  String[] {"English","French","Germany","Finnish","Italian","Polish","Spanish"};

        elTrPage.clickPublishButton();
        String idItem = idCurentItem(getDriver().getCurrentUrl());


        for (int i = 0; i < languages.length; i++) {

            elTrPage.selectLanguage(languages[i]);
            elTrPage.setAssetNameCell(languages[i] + " asset name");
            elTrPage.saveProperty();
        }

        BasePageLC.goSleep(5);

        BasePageLC.openURL(URL.CLIENT_TEST.toString()+ "/en/uk/find-a-warehouse/warehouse-detail?id="+idItem);

        propertyDetailPageUi = new PropertyDetailPageUi(getDriver());


        Assert.assertEquals("English asset name".toUpperCase(),propertyDetailPageUi.getTitleField());
        Reporter.log("Verification of english translation asset name success!");
        BasePageLC.goSleep(5);

//        mainPageLogicorUI=new MainPageLogicorUI(getDriver());
//        mainPageLogicorUI.languageMenuClick();
//        mainPageLogicorUI.chooseLanguage("IT");








    }

}
