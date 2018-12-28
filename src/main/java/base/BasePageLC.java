package base;

import com.google.common.base.Function;
import data.Items;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class BasePageLC extends BaseTest {

    private WebDriver driver = BaseTest.getDriver();
    public BasePageLC() {
        driver = BaseTest.getDriver();
    }
    public WebElement findElement(By element) {
        return BaseTest.getDriver().findElement(element);
    }

    public List<WebElement> findElements(By element) {
        return BaseTest.getDriver().findElements(element);
    }

    public void switchToFrame(int index) {
        BaseTest.getDriver().switchTo().frame(index);
    }

    public void waitForPresenceOfElement(WebElement element) {
        WebElement wait = (new WebDriverWait(driver,20)).until(ExpectedConditions.visibilityOf(element));
    }


    public String getElementText(By element) {
//        Reporter.log("Getting element text - " + findElement(element).getText());
        return findElement(element).getText();
    }

    public static String getElementTextElement(WebElement element) {
        return element.getText();
    }

    public String getElementHref(By element) {
        Reporter.log("Getting element href - " + findElement(element).getAttribute("href"));
        return findElement(element).getAttribute("href");
    }

    public String getElementTextValue(By element) {
        Reporter.log("Getting element text - " + findElement(element).getText());
        return findElement(element).getAttribute("value");
    }

    public void typeTextToField(String message, String text, By field) {
        Reporter.log(message + " With data - " + text);
        findElement(field).sendKeys(text);
    }

    public void overwriteTextToField(String message, String text, By field) {
        Reporter.log(message + " With data - " + text);
        findElement(field).sendKeys(Keys.HOME, Keys.chord(Keys.SHIFT, Keys.END), text);
    }

    public void tapENTER(By element) {
        BaseTest.getDriver().findElement(element).sendKeys(Keys.ENTER);
    }

    public void tapARROW_DOWN(By element) {
        BaseTest.getDriver().findElement(element).sendKeys(Keys.ARROW_DOWN);
    }

    public void typeSimulation(String message, String keys, By field) {
        clickOnElement(field);
        Reporter.log(message);
        Robot robot;
        try {
            robot = new Robot();
            for (int i = 0; i < keys.length(); i++) {
                final char ch = keys.charAt(i);
                final boolean upperCase = Character.isUpperCase(ch);
                final int keyCode = KeyEvent.getExtendedKeyCodeForChar(ch);
                robot.delay(10);
                if (upperCase) {
                    robot.keyPress(KeyEvent.VK_SHIFT);
                }
                robot.keyPress(keyCode);
                robot.keyRelease(keyCode);
                if (upperCase) {
                    robot.keyRelease(KeyEvent.VK_SHIFT);
                }
            }
        } catch (AWTException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void switchToFrame(String frameName) {
        BaseTest.getDriver().switchTo().frame(frameName);
    }

    public void switchToFrameByElement(WebElement element) {
        BaseTest.getDriver().switchTo().frame(element);
    }

    public void refreshPage() {
        BaseTest.getDriver().navigate().refresh();
        scrollToTop();
    }

    public void goToPreviousPage() {
        BaseTest.getDriver().navigate().back();
    }

    public void switchToDefaultContent() {
        BaseTest.getDriver().switchTo().defaultContent();
    }

    public void switchToPopUp() {
        switchToDefaultContent();
        switchToFrame(0);
    }


    public void clickOnElementFromList(String message, By elements, int elementIndex) {
        Reporter.log(message);
        BaseTest.getDriver().findElements(elements).get(elementIndex - 1).click();
    }

    public void clickOnElement(By element) {
        findElement(element).click();
    }

    public boolean isCheckedByClass(By element, String textToContain) {
        if (findElement(element).getAttribute("class").contains(textToContain)) {
            return true;
        }
        return false;
    }

    public boolean isCneckboxChecked(By element) {
        if (findElement(element).getAttribute("class").contains("glyphicon glyphicon-check")) {
            return true;
        }
        return false;
    }

    public Items getDataFromItem(int i){
        String s1 = getElementText(By.xpath("//*[@id='w0']/table/tbody/tr[" + i + "]/td[1]"));
        String s2 = getElementText(By.xpath("//*[@id='w0']/table/tbody/tr[" + i + "]/td[2]"));
        String s3 = getElementText(By.xpath("//*[@id='w0']/table/tbody/tr[" + i + "]/td[3]"));
        String s4 = getElementText(By.xpath("//*[@id='w0']/table/tbody/tr[" + i + "]/td[4]"));
        Boolean bool = isCneckboxChecked(By.xpath("//*[@id='w0']/table/tbody/tr[" + i + "]/td[6]/a/span"));
        findElement(By.xpath("//*[@id=\"w0\"]/table/tbody/tr[" + i + "]/td[5]/a[1]")).click();

        String s6 = getElementText(By.xpath("//*[@class='table table-condensed table-hover']//*[19]//*[2]"));

        Double x = Double.valueOf(s6);
        findElement(By.xpath("//*[@class=\"h2\"]/*[1]")).click();
        Items items = new Items(s1, s2, s3, s4, x, bool);
        return items;
    }


    public boolean isCheckedByClass(By element, String attributeName, String textToContain) {
        if (findElement(element).getAttribute(attributeName).contains(textToContain)) {
            return true;
        }
        return false;
    }

    public void addTableElementsToCollection(List itemsList) {
        List rows = getDriver().findElements(By.xpath("//*[@id='w0']/table/tbody/tr/td[1]"));
        for (int i = 1; i < rows.size() + 1; i++) {
            if (itemsList.size() < 41) {
                itemsList.add(getDataFromItem(i));
                Reporter.log(getDataFromItem(i).toString());
            } else {
                findElement(By.xpath("//*[@id=\"w0\"]/ul/li[3]/a")).click();
                goSleep(2);
                itemsList.add(getDataFromItem(i));
                Reporter.log(getDataFromItem(i).toString());
            }
            Reporter.log(itemsList.size() + " items added to collection");
        }
    }



    public void clickOnElementWithWait(String message, By element, int timeWaitSeconds) {
        Reporter.log(message);
        BaseTest.getDriver().manage().timeouts().implicitlyWait(timeWaitSeconds, TimeUnit.SECONDS);
        try {
            clickOnElement(element);

        } catch (Exception e) {
            Reporter.log("Element is not visible, it might be present in other tab.");
        } finally {
            BaseTest.getDriver().manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        }
    }


    public static void scrollToBottom() {
        JavascriptExecutor jse1 = (JavascriptExecutor) BaseTest.getDriver();
        jse1.executeScript("scroll(0, 1000)"); // if the element is at bottom.
    }

    public void scrollToTop() {
        JavascriptExecutor jse1 = (JavascriptExecutor) BaseTest.getDriver();
        jse1.executeScript("scroll(250, 0)"); // if the element is on top.
    }

    public void refreshPageUntilElementContainsText(By element, List<String> successList, int tries) {
        for (int i = 1; i <= tries; i++) {
            if (successList.contains(getElementText(element).toLowerCase())) {
                break;
            } else {
                Reporter.log("Page refreshing...");
                dirtyWait(10000);
                BaseTest.getDriver().navigate().refresh();
            }
        }
    }

    public void chooseSelectOptionByName(String message, By selectElement, String optionText) {
        Reporter.log(message + optionText);
        Select dropdown = new Select(findElement(selectElement));
        dropdown.selectByVisibleText(optionText);
    }

    public void clearTextField(By textField) {
        Reporter.log("Clearing text field");
        BaseTest.getDriver().findElement(textField).clear();
    }

    public String getElementValue(By element) {
        return BaseTest.getDriver().findElement(element).getAttribute("value");
    }


    public void choseElementByIndex(String messages, By element, String tagName, int answerNumber) {
        Reporter.log(messages);
        WebElement table = findElement(element);
        dirtyWait(5000);
        table.findElements(By.tagName(tagName)).get(answerNumber - 1).click();
    }


    public void useHotKey(String message, String hotKey) {
        Reporter.log(message);
        findElement(new By.ById("txtChatScenarioText")).sendKeys(hotKey);
    }

    public void scrollToElement(By elem) {
        WebElement element = findElement(elem);
        ((JavascriptExecutor) BaseTest.getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void selectCheckBox(String xpath) {
        WebElement element = driver.findElement(By.xpath(xpath));
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", element);
    }


    //Waiters

    public void dirtyWait(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void waitForElement(By by) {

        FluentWait<WebDriver> wait3 = new FluentWait<>(BaseTest.getDriver())
                .withTimeout(Duration.ofSeconds(200))
                .pollingEvery(Duration.ofMillis(1000))
                .ignoring(NoSuchElementException.class);

        Function<WebDriver, WebElement> function = new Function<WebDriver, WebElement>() {

            public WebElement apply(WebDriver arg0) {

                WebElement element = arg0.findElement(by);
                if (element != null) {
                    base.Reporter.log("Element found");
                }
                return element;
            }
        };
        wait3.until(function);
    }


    public String getCurrentURL() {
        return BaseTest.getDriver().getCurrentUrl();
    }

    public void deleteAllItemsLogikor(String xpathOfResult, String xpathOfBin) {

        FluentWait<WebDriver> wait2 = new FluentWait<>(BaseTest.getDriver())
                .withTimeout(Duration.ofSeconds(200))
                .pollingEvery(Duration.ofMillis(1000))
                .ignoring(NoSuchElementException.class);

        Function<WebDriver, WebElement> function = new Function<WebDriver, WebElement>() {


            public WebElement apply(WebDriver arg0) {

                clickOnElement(By.xpath(xpathOfBin));
                dirtyWait(300);
                BaseTest.getDriver().switchTo().alert().accept();
                dirtyWait(300);

                Reporter.log("Deleting the item");
                WebElement element = arg0.findElement(By.xpath(xpathOfResult));
                if (element != null) {
                    Reporter.log("All items deleted");
                }

                return element;
            }
        };
        wait2.until(function);
    }


    public static void goSleep(int time) {
        try {
            Thread.sleep(time * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public void moveToElement(String xpath) {
        Actions action = new Actions(driver);
        WebElement element = driver.findElement(By.xpath(xpath));
        action.moveToElement(element);
        action.perform();
        this.goSleep(2);
    }


    public static void openURL(String URL) {
        getDriver().get(URL);
    }

    public void deleteAllItemsAdmin() {

        openURL("http://ec2-3-8-87-222.eu-west-2.compute.amazonaws.com/admin/property/index");
        deleteAllItemsLogikor("//*[@id='w0']/table/tbody/tr/td/div", "//*[@id='w0']/table/tbody/tr[1]/td[7]/a/span");
    }

    public void enterTextInTextField(String xPathExpression, String text) {
        By xPath = new By.ByXPath(xPathExpression);
        getDriver().findElement(xPath).sendKeys(text);

    }

    public void setTextCell(WebElement element, String text) {

        element.clear();
        element.sendKeys(text);

}

    public void clickButton(String xPathExpression) {
        getDriver().findElement(By.xpath(xPathExpression)).click();
    }

    public void setText(By element, String text) {
        waitForElement(element);
        findElement(element).click();
        goSleep(1);
        findElement(element).clear();
        findElement(element).sendKeys(text);
        findElement(element).submit();
    }

    public void setTextEl(WebElement element, String text) {
        waitForPresenceOfElement(element);
        element.click();
        element.clear();
        element.sendKeys(text);
    }


    public boolean isElementPresent(By element) {

        try {
            FluentWait<WebDriver> wait = new FluentWait<>(getDriver())
                    .withTimeout(Duration.ofSeconds(1));
            wait.until(visibilityOf(findElement(element)));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}

