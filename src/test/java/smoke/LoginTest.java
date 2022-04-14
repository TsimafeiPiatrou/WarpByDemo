package smoke;

import base.BaseAuthenticatedTest;
import io.qameta.allure.Flaky;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import org.testng.Assert;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.Random;

public class LoginTest extends BaseAuthenticatedTest {

    @Step("Second step {keyword}")
    public void productPageOpenedStep(String keyword) {
        if (new Random().nextInt(2) == 1) {
            Assert.fail(" Искусственный провал теста");
        }
    }

    @Step("Third step")
    public void accountCheck(){
        System.out.println(" accountCheck ");
    }

    @Test
    @Parameters({"keyword"})
    @Flaky
    @Severity(SeverityLevel.BLOCKER)
    public void validCredentialsLoginTest(@Optional String keyword) {
        System.out.println("validCredentialsLoginTest");
        validLogin();
        productPageOpenedStep(keyword);
        accountCheck();
    }
}
