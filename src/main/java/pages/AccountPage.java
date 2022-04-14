package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class AccountPage extends BasePage {

    public static final String BASE_URL = "https://warp.by/my-account";

    public static final By TITLE_LOCATOR = By.xpath("//h1[contains(.,'Ваша учетная запись')]");
    public static final By ACCOUNT_IDENTITY_BUTTON = By.id("identity-link");
    public static final By ACCOUNT_ADDRESS_BUTTON = By.id("addresses-link");
    public static final By ADDRESS_ADD_BUTTON = By.xpath("//a[@data-link-action='add-address']");
    public static final By ADDRESS_ADD_FIELD = By.xpath("//input[@name='address1']");
    public static final By ADDRESS_ADD_CITY_FIELD = By.xpath("//input[@name='city']");
    public static final By ADDRESS_SAVE_BUTTON = By.xpath("//button[@class='btn btn-primary']");
    public static final By ACCOUNT_ENTER_BUTTON = By.className("customer-signin-module");
    public static final By IDENTITY_FIRSTNAME_FIELD = By.cssSelector("input[name='firstname']");
    public static final By IDENTITY_LASTNAME_FIELD = By.cssSelector("input[name='lastname']");
    public static final By IDENTITY_SAVE_BUTTON = By.cssSelector("button[data-link-action='save-customer']");
    public static final By ACCOUNT_EXIT_BUTTON = By.cssSelector("a[class='logout']");

    Logger log = LogManager.getLogger(LoginPage.class);


    public AccountPage(WebDriver driver) {
        super(driver);
        this.baseUrl = BASE_URL;
        this.basePageElementId = TITLE_LOCATOR;
    }

    @Step("Open identity page")
    public void openIdentity(){
        driver.findElement(ACCOUNT_IDENTITY_BUTTON).click();
    }

    @Step("Open address page")
    public void openAddress(){
        driver.findElement(ACCOUNT_ADDRESS_BUTTON).click();
    }

    @Step("Exit account")
    public void closeAccount(){
        driver.findElement(ACCOUNT_EXIT_BUTTON).click();
    }

    @Step("Add and save address")
    public void addAddress(){
        driver.findElement(ADDRESS_ADD_BUTTON).click();
        driver.findElement(ADDRESS_ADD_FIELD).sendKeys("Gikalo st., ul.23");
        driver.findElement(ADDRESS_ADD_CITY_FIELD).sendKeys("Minsk");
        driver.findElement(ADDRESS_SAVE_BUTTON).click();
        driver.findElement(ACCOUNT_ENTER_BUTTON).click();
    }

    @Step("Add and save identity")
    public void addIdentityInfo(){
        driver.findElement(IDENTITY_FIRSTNAME_FIELD);
        driver.findElement(IDENTITY_LASTNAME_FIELD);
        driver.findElement(IDENTITY_SAVE_BUTTON).click();
        driver.findElement(ACCOUNT_ENTER_BUTTON).click();
    }

}
