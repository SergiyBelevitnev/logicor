package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class MainPageLogicor {
    public MainPageLogicor(WebDriver driver){
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

    @FindBy(xpath = "//*[@id=\"block-system-main\"]/div[3]/div/div[2]/a[2]")
    private WebElement radioListView;

    @FindBy(xpath = "//*[@class='warehouse-finder-tabs-inner-row'/a[3]")
    private WebElement radioSplitView;


    public void chooseSmallProperties() {
        smallRadioButton.click();
    }

    public void chooseLargeProperties() {
        largeRadioButton.click();
    }

    public void chooseMapView() {
        radioMapView.click();
    }

    public void chooseListView() {
        radioListView.click();
    }

    public void chooseSplitView() {
        radioSplitView.click();
    }

    public void selectCountry(String country) {
        Select drpCountry = new Select(dropdownSelectCountry);
        drpCountry.selectByVisibleText(country);
    }

//    private void inputPassword(String password) {
//        passwordField.sendKeys(password);
//    }
//
    public void clickSearchButton() {
        viewVacanciesButton.click();
    }

}
