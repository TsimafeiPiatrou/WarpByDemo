package base;

import io.qameta.allure.Allure;
import io.qameta.allure.Link;
import io.qameta.allure.Step;
import org.testng.Assert;

public class BaseAuthenticatedTest extends BaseTest{


    @Step("Open Login page")
    public void openLoginPage() {
        loginPage.open();
        Assert.assertTrue(loginPage.isPageLoaded(), "Login page is not loaded");
    }

    @Step("Login with valid credentials {USERNAME}/{PASSWORD}")
    @Link("https://warp.by/my-account")
    public void validLogin() {
        openLoginPage();
        loginPage.login(USERNAME, PASSWORD);
        String json = String.format("{\"username\": \"%s\", \"password\": \"%s\"}", USERNAME, PASSWORD);
//        AllureUtils.attachJson(json.getBytes(StandardCharsets.UTF_8));
        Allure.addAttachment("Credentials from allure static", "text/json", json);
        Assert.assertTrue(accountPage.isPageLoaded(), "Account page is not loaded");
    }

}
