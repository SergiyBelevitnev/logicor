package pageobjects;

import base.BasePageLC;
import base.Reporter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class MainPageLogicorUI extends BasePageLC {
    public MainPageLogicorUI(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
    public WebDriver driver;

    @FindBy(xpath = "//*[@id='warehouse-finder']/div/div[2]/div[2]/div/div")
    private WebElement largeRadioButton;

    @FindBy(xpath = "//*[@id='warehouse-finder']/div/div[2]/div[1]/div/div")
    private WebElement smallRadioButton;

    @FindBy(xpath = "//*[@id='warehouse-finder']//button")
    private WebElement viewVacanciesButton;

    @FindBy(xpath = "//*[@class='warehouse-finder__location-input']")
    private WebElement dropdownSelectCountry;

    @FindBy(xpath = "//*[@class='warehouse-finder-tabs-inner-row'/a[1]")
    private WebElement radioMapView;

    @FindBy(xpath = "//*[@class=\"warehouse-finder-listing-country\"]/*[1]")
    private WebElement firstWarehouse;

    @FindBy(xpath = "//*[@id=\"block-system-main\"]/div[3]/div/div[2]/a[2]")
    private WebElement radioListView;

    @FindBy(xpath = "//*[@class='warehouse-finder-tabs-inner-row'/a[3]")
    private WebElement radioSplitView;

    @FindBy (xpath = "//*[@class=\"warehouse-finder-listing-country\"]/*")
    private List<WebElement> assetList ;


    @FindBy (xpath = "//*[@class=\"language-click\"]")
    private WebElement languageMenu;

    @FindBy (xpath = "//*[@class=\"search search-click\"]")
    private WebElement searchButton;

    @FindBy (xpath = "//*[@placeholder=\"Search\"]")
    private WebElement searchField;

    @FindBy (xpath = "//*[@id=\"edit-name\"]")
    private WebElement nameField;

    @FindBy (xpath = "//*[@id=\"edit-pass\"]")
    private WebElement passField;

    @FindBy (xpath = "//*[@id=\"edit-submit\"]")
    private WebElement submitButton;


    public void loginDrupal(String name, String pass){
        Reporter.log("Login in admin console");
        waitForPresenceOfElement(nameField);
        setTextCell(nameField,name);
        setTextCell(passField,pass);
        submitButton.click();

    }

    public void searchMaking(String string){
        waitForPresenceOfElement(searchField);
        searchField.sendKeys(string);
        findElement(By.xpath("//*[@class=\"search-btn\"]")).click();


    }

    public void searchClick(){
        searchButton.click();
    }



    public void languageMenuClick(){
        languageMenu.click();
    }

    public void chooseLanguage(String lang) {
        waitForPresenceOfElement(findElement(By.xpath("//*[@class='language-menu']")));

        switch (lang){
            case "EN":{findElement(By.xpath("//*[@class='language-menu']//*[@title='English']")).click(); break;}
            case "FR":{findElement(By.xpath("//*[@class='language-menu']//*[@title='French']")).click(); break;}
            case "DE":{findElement(By.xpath("//*[@class='language-menu']//*[@title='German']")).click(); break;}
            case "IT":{findElement(By.xpath("//*[@class='language-menu']//*[@title='Italian']")).click(); break;}
            case "PL":{findElement(By.xpath("//*[@class='language-menu']//*[@title='Polish']")).click(); break;}
            case "ES":{findElement(By.xpath("//*[@class='language-menu']//*[@title='Spanish']")).click(); break;}

            }
        }

    public  Integer countAssetsMain(){
        goSleep(2);
        return assetList.size();
    }

    public void chooseFirstWarehouse(){
        waitForPresenceOfElement(firstWarehouse);
        firstWarehouse.click();
    }

    public void chooseSmallProperties() {
        Reporter.log("Choosing small properties");
        smallRadioButton.click();
    }

    public void chooseLargeProperties() {
        Reporter.log("Choosing large properties");
        largeRadioButton.click();
    }



    public void chooseMapView() {
        radioMapView.click();
    }

    public void chooseListView() {

        Reporter.log("Choosing list view");
        goSleep(3);
        radioListView.click();

        waitForPresenceOfElement(firstWarehouse);
        goSleep(4);
//        moveToElement("//*[@class='warehouse-finder-listing-country']/*");
    }

    public void chooseSplitView() {
        radioSplitView.click();
    }

    public void selectCountry(String country) {
        Reporter.log("Choosing country");
        Select drpCountry = new Select(dropdownSelectCountry);
        drpCountry.selectByVisibleText(country);
    }


    public void foundWarehouse(String s) {
        Reporter.log("Searching warehouse");

    }


    public void clickSearchButton() {
        Reporter.log("Searching warehouse");
        viewVacanciesButton.click();
    }

}
