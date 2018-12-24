package pageobjects;

import base.BasePageLC;
import base.Reporter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ImportPropertiesPageAdmin extends BasePageLC {

    public WebDriver driver;

    public ImportPropertiesPageAdmin(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void waitForPresenceOfElement(WebElement element) {
        WebElement wait = (new WebDriverWait(driver,20)).until(ExpectedConditions.visibilityOf(element));
    }

    @FindBy(xpath = "//*[@id='propertyimportform-file_import']")
    private WebElement chooseFileButton;


    public void uploadFile(String filePath) {

        chooseFileButton.sendKeys(filePath);
        importButton.click();
        Reporter.log("Properties imported");
    }

    @FindBy(xpath = "//*[@id='w0']/div[2]/button")
    private WebElement importButton;

    @FindBy(xpath = "//*[@class=\"btn btn-success btn-xs\"][1]")
    private WebElement listPropertiesButton;


    public void openPropList(){
        waitForPresenceOfElement(listPropertiesButton);
        listPropertiesButton.click();

    }

    public void startImport(){
        importButton.click();

    }

}
