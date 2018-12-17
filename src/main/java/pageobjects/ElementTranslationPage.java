package pageobjects;

import base.BasePageLC;
import base.Items;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ElementTranslationPage extends BasePageLC {

    public WebDriver driver;
    public ElementTranslationPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
    @FindBy(xpath = "/html/body/div[2]/p/a[3]")
    private WebElement translateButton;

    @FindBy(xpath = "/html/body/div[2]/p/a[4]")
    private WebElement addImagesButton;

    @FindBy(xpath = "/html/body/div[2]/p/a[5]")
    private WebElement addFloorPanButton;

    @FindBy(xpath = "/html/body/div[2]/p/a[6]")
    private WebElement addBrochurePdfButton;

    @FindBy(xpath = "/html/body/div[2]/form/div[1]/div[2]/a[1]")
    private WebElement cancelButton;

    @FindBy(xpath = "/html/body/div[2]/form/div[1]/div[2]/button")
    private WebElement saveButton;

    @FindBy(xpath = "/html/body/div[2]/form/div[1]/div[2]/a[2]")
    private WebElement publishButton;


    public void handleTableElements() {
        goSleep(1);
        List rows = getDriver().findElements(By.xpath("//*[@class='table table-condensed table-hover']/tbody/tr"));
        System.out.println(rows.size());
        for (int i = 1; i < rows.size()+1; i++) {

            String s1 = getElementText(By.xpath("//*[@class='table table-condensed table-hover']/tbody/tr[" + i + "]/th[1]"));
            setText(By.xpath("//*[@class='table table-condensed table-hover']/tbody/tr[" + i + "]/td[3]"), "11111111111111");

            String s3 = getElementText(By.xpath("//*[@class='table table-condensed table-hover']/tbody/tr[" + i + "]/td[3]"));
            System.out.println(s1+"-----------------"+s3);

        }
    }





    }
