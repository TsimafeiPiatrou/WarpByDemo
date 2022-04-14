package pages;

import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;


public class CatalogMainPage extends BasePage {

    public static final String BASE_URL = "https://warp.by/#";

    public static final By CATALOG_SALES_BUTTON = By.xpath("//ul[@class='category-subs']//span[contains(.,'Акции и скидки')]");
    public static final By CATALOG_PS4_BUTTON = By.xpath("//ul[@class='category-subs']//span[contains(.,'PlayStation 4 (PS4)')]");
    public static final By CATALOG_TRANSFER_BUTTON = By.xpath("//li[@class='amenu-item mm-2 plex']//a[@class='amenu-link']");
    public static final By CATALOG_MENU_BUTTON = By.xpath("//div[@class='left-nav-trigger']//i[@class='material-icons']");
    public static final By MENU_PS5_BUTTON = By.xpath("//a[contains(@title,'PlayStation 5 (PS5)')]//span");
    public static final By MENU_NINTENDO_BUTTON = By.xpath("//a[contains(@title,'Nintendo Switch')]//span");
    public static final By CATALOG_PAYMENT = By.cssSelector("li[class='amenu-item mm-4 ']");
    public static final By CATALOG_ABOUT = By.cssSelector("li[class='amenu-item mm-5 ']");
    public static final By CATALOG_CONTACTS = By.cssSelector("li[class='amenu-item mm-6 ']");
    public static final By CATALOG_RENT = By.cssSelector("li[class='amenu-item mm-7 ']");
    public static final By CATALOG_SERVICE = By.cssSelector("li[class='amenu-item mm-8 ']");
    public static final By MENU_CROSS_BUTTON = By.xpath("//div[@class='st-menu st-effect-left']//div[@class='st-menu-close d-flex']");
    public static final By CATALOG_CART_BUTTON = By.cssSelector("ul a[class='cart-link btn-primary']");
    public static final By CART_CROSS_BUTTON = By.xpath("//div[@class='st-menu-right st-effect-right']//div[@class='st-menu-close d-flex']");
    public static final By ADD_CART_BUTTON = By.xpath("//button[@class='btn add-to-cart']");
    public static final By REMOVE_FROM_CART_BUTTON = By.xpath("//div[@class='sidebar-cart cart-preview']//a[@data-link-action='delete-from-cart']");
    public static final By CATALOG_LOGO = By.xpath("//a[@class='logo']");
    public static final By SEARCH_FIELD = By.cssSelector("input[class='form-control ui-autocomplete-input']");
    public static final By SEARCH_BUTTON = By.cssSelector("button[class='btn-primary']");
    private static final String PRODUCT_XPATH_PATTERN =
            "//h5//a[contains(@title,'%s')]";


    public CatalogMainPage(WebDriver driver) {
        super(driver);
        this.baseUrl=BASE_URL;
        this.basePageElementId=CATALOG_LOGO;
    }

    Logger log = LogManager.getLogger(LoginPage.class);

    @Step
    public void openPayment(){
        driver.findElement(CATALOG_PAYMENT).click();
    }

    @Step
    public void openAbout(){
        driver.findElement(CATALOG_ABOUT).click();
    }

    @Step
    public void openContacts(){
        driver.findElement(CATALOG_CONTACTS).click();
    }

    @Step
    public void openRent(){
        driver.findElement(CATALOG_RENT).click();
    }

    @Step
    public void openService(){
        driver.findElement(CATALOG_SERVICE).click();
    }

    @Step
    public boolean openMenuCheck(){
        driver.findElement(CATALOG_MENU_BUTTON).click();
        Wait<WebDriver> fluent = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(5))
                .pollingEvery(Duration.ofSeconds(5))
                .ignoring(ElementNotInteractableException.class);
        WebElement crossButton = fluent.until(driver -> {
            System.out.println(" FLUENT WAIT ");
            driver.findElement(MENU_CROSS_BUTTON).click();
            return driver.findElement(MENU_CROSS_BUTTON);
        });

        return crossButton.isDisplayed();
    }

    @Step
    public void searchCheck(String partialProductTitle){
        driver.findElement(SEARCH_FIELD).sendKeys("Геймпад DualSense (PS5)");
        driver.findElement(SEARCH_BUTTON).click();
        driver.findElement(By.xpath(String.format(PRODUCT_XPATH_PATTERN, partialProductTitle))).click();

    }

    @Step
    public boolean openCartCheck(){
        driver.findElement(CATALOG_CART_BUTTON).click();
        Wait<WebDriver> fluent = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(5))
                .pollingEvery(Duration.ofSeconds(5))
                .ignoring(ElementNotInteractableException.class);
        WebElement crossButton = fluent.until(driver -> {
            System.out.println(" FLUENT WAIT ");
            driver.findElement(CART_CROSS_BUTTON).click();
            return driver.findElement(CART_CROSS_BUTTON);
        });

        return crossButton.isDisplayed();
    }

    @Step
    public void addToCart(String partialProductTitle){
        driver.findElement(By.xpath(String.format(PRODUCT_XPATH_PATTERN, partialProductTitle))).click();
        driver.findElement(ADD_CART_BUTTON).click();
        driver.findElement(CART_CROSS_BUTTON).click();

    }

    @Step
    public void openMenuPS5(){
        driver.findElement(CATALOG_MENU_BUTTON).click();
        driver.findElement(MENU_PS5_BUTTON).click();
    }

    @Step
    public void openMenuNintendo(){
        driver.findElement(CATALOG_MENU_BUTTON).click();
        driver.findElement(MENU_NINTENDO_BUTTON).click();

    }


    @Step
    public void catalogTransferSalesCheck(){
        driver.findElement(CATALOG_TRANSFER_BUTTON).click();
        driver.findElement(CATALOG_SALES_BUTTON).click();
    }

    @Step
    public void catalogTransferPS4Check(){
        driver.findElement(CATALOG_TRANSFER_BUTTON).click();
        driver.findElement(CATALOG_PS4_BUTTON).click();
    }

    @Step
    public void deleteFromCart(){
        driver.findElement(CATALOG_CART_BUTTON).click();
        driver.findElement(REMOVE_FROM_CART_BUTTON).click();
//        driver.findElement(CART_CROSS_BUTTON).click();
    }

}
