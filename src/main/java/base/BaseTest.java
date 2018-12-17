package base;

import com.aventstack.extentreports.ExtentTest;
import com.google.common.base.Function;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.*;
import java.io.IOException;
import java.lang.reflect.Method;
import java.time.Duration;


@org.testng.annotations.Listeners({base.Listeners.class})

public class BaseTest {
    private static WebDriver driver;
    private static final ThreadLocal<WebDriver> DRIVER = new ThreadLocal();
    private static ThreadLocal<ExtentTest> test = new ThreadLocal();
    private String suiteName;
    private static ThreadLocal<ExtentTest> parentTest = new ThreadLocal();


    @BeforeClass
    public synchronized void beforeClass(ITestContext ctx) {
        suiteName = ctx.getCurrentXmlTest().getSuite().getName();
        ExtentTest parent = ExtentManager.getInstance(suiteName).createTest(getClass().getName());
        parentTest.set(parent);
    }

    @BeforeMethod
    public void setup(Method method) throws IOException {
        ExtentTest child = parentTest.get().createNode(method.getName());
        test.set(child);
        base.Reporter.log("Method -" + method.getName() + " - is started.");
        base.Reporter.log("---------------------------------------------------------------------------------------------");
    }

    public static WebDriver getDriver() {
        return DRIVER.get();
    }



//    @Parameters({"browser"})

    public static void LaunchBrowser(String browser) {

        if ("chrome".equalsIgnoreCase(browser)) {
            WebDriverManager.chromedriver().setup();
            SingletonBrowserClass sbc1 = SingletonBrowserClass.getInstanceOfSingletonBrowserClass();
            driver = sbc1.getDriver2();
//            driver = new ChromeDriver();
//            driver.manage().window().maximize();
        } else if ("firefox".equalsIgnoreCase(browser)) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
            driver.manage().window().maximize();
        }

        DRIVER.set(driver);
    }


    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.manage().deleteAllCookies();
            driver.quit();
            DRIVER.remove();
        }
        ExtentManager.getInstance(suiteName).flush();

        Reporter.log("Tests PERFORMED");
    }

    public static ThreadLocal<ExtentTest> getTest() {
        return test;
    }



    @AfterMethod(alwaysRun = true)

    public void closeWindow(ITestResult result) {

        if (result.getStatus() == ITestResult.FAILURE) {
            test.get().fail(result.getThrowable());
            Reporter.logFail("Test FAILED");
        } else if (result.getStatus() == ITestResult.SKIP)
            test.get().skip(result.getThrowable());
        else
            test.get().pass("Test passed");

        ExtentManager.getInstance(suiteName).flush();

        Reporter.log("Stopping tests");
    }


}
