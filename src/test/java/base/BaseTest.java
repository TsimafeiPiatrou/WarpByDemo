package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestContext;
import org.testng.annotations.*;
import utils.CapabilitiesGenerator;
import utils.PropertiesUtils;
import utils.TestListener;
import pages.AccountPage;
import pages.LoginPage;
import pages.CatalogMainPage;
import java.io.File;
import java.util.HashMap;
import java.time.Duration;

@Listeners({TestListener.class})
public class BaseTest {

    protected WebDriver driver;
    protected LoginPage loginPage;
    protected CatalogMainPage catalogMainPage;
    protected AccountPage accountPage;

    public static String USERNAME = PropertiesUtils.getEnv("valid_login");
    public static String PASSWORD = PropertiesUtils.getEnv("valid_password");


    @BeforeMethod(groups = {"config"})
    public void setup(ITestContext iTestContext){
        driver = new ChromeDriver(CapabilitiesGenerator.getChromeOptions());
        setContextAttribute(iTestContext, "driver", driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        loginPage = new LoginPage(driver);
        accountPage = new AccountPage(driver);
        catalogMainPage = new CatalogMainPage(driver);
    }

    private void setContextAttribute(ITestContext iTestContext, String attributeKey, Object attributeValue) {
        iTestContext.setAttribute(attributeKey, attributeValue);
    }

    @AfterMethod(alwaysRun=true, groups = {"config"})
    public void teardown() {
        driver.close();
        driver.quit();
    }

}