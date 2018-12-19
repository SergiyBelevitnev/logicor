package pageobjects;

import base.BasePageLC;
import base.Reporter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ImportPropertiesPage extends BasePageLC {

    public WebDriver driver;

    public ImportPropertiesPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
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
}
