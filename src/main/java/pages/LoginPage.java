package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage{

    public static final String BASE_URL = "https://warp.by/login?back=my-account";

    public LoginPage(WebDriver driver) {
        super(driver);
        this.baseUrl = BASE_URL;
        this.basePageElementId = LOGIN_BUTTON;
    }

    Logger log = LogManager.getLogger(LoginPage.class);

    private static final By LOGIN_TEXT_FIELD = By.name("email");
    private static final By PASSWORD_TEXT_FIELD = By.name("password");
    private static final By LOGIN_BUTTON = By.id("submit-login");

    public static final String USERNAME_TEXT_FIELD_PLACEHOLDER = "Username";

    public void login(String username, String password) {
        log.info("Insert [{}] into [{}] field", username, "username");
        driver.findElement(LOGIN_TEXT_FIELD).sendKeys(username);
        log.info("Insert [{}] into [{}] field", "*******", "password");
        driver.findElement(PASSWORD_TEXT_FIELD).sendKeys(password);
        log.info("Click [{}] button", "Login");
        driver.findElement(LOGIN_BUTTON).click();
    }

    public String getUsernamePlaceholder() {
        return driver.findElement(LOGIN_TEXT_FIELD).getAttribute("placeholder");
    }

}
