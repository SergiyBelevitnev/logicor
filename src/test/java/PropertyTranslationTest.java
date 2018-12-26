import base.*;
import org.apache.commons.collections4.KeyValue;
import org.apache.commons.collections4.map.MultiValueMap;
import org.openqa.selenium.By;
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



        String assetName = elTrPage.getAssetName();
        Reporter.log("Property name is: "+assetName);
        String f = getDriver().getCurrentUrl();


        String languages[] = new String[]{ "French", "Germany", "Finnish", "Italian", "Polish", "Spanish", "English"};

        elTrPage.clickPublishButton();
        String idItem = idCurentItem(getDriver().getCurrentUrl());


        for (int i = 0; i < languages.length; i++) {

            elTrPage.selectLanguage(languages[i]);
            elTrPage.setAssetNameCell(languages[i] + " asset name");
            elTrPage.saveProperty();
        }

        BasePageLC.goSleep(3);
        propertyDetailPageUi = new PropertyDetailPageUi(getDriver());
//
//        BasePageLC.openURL(URL.CLIENT_TEST.toString() + "/en/uk/find-a-warehouse/warehouse-detail?id=" + idItem);
//        Reporter.log(URL.CLIENT_TEST.toString() + "/en/uk/find-a-warehouse/warehouse-detail?id=" + idItem);


//        Assert.assertEquals("English asset name".toUpperCase(), propertyDetailPageUi.getTitleField());
//        Reporter.log("Verification of english translation asset name success!");
//        BasePageLC.goSleep(5);
        for (int i = 0; i < languages.length; i++) {

            switch (languages[i]) {
                case "English": {
                    switchDetailTranslationProperty(languages[i], "/en", idItem);
                    break;
                }
                case "French": {
                    switchDetailTranslationProperty(languages[i], "/fr", idItem);
                    break;
                }
                case "Germany": {
                    switchDetailTranslationProperty(languages[i], "/de", idItem);
                    break;
                }
                case "Italian": {
                    switchDetailTranslationProperty(languages[i], "/it", idItem);
                    break;
                }
                case "Polish": {
                    switchDetailTranslationProperty(languages[i], "/pl", idItem);
                    break;
                }
                case "Spanish": {
                    switchDetailTranslationProperty(languages[i], "/es", idItem);
                    break;
                }
            }
        }
    }

    public void switchDetailTranslationProperty(String language, String lang, String idItem) {
        BasePageLC.goSleep(2);
        BasePageLC.openURL(URL.CLIENT_TEST.toString() + lang + "/find-a-warehouse/warehouse-detail?id=" + idItem);
        Assert.assertEquals((language + " asset name").toUpperCase(), propertyDetailPageUi.getTitleField());
        Reporter.log("Verification of " + language + " translation asset name success!");

    }
}
//        mainPageLogicorUI=new MainPageLogicorUI(getDriver());
//        mainPageLogicorUI.languageMenuClick();
//        mainPageLogicorUI.chooseLanguage("IT");










