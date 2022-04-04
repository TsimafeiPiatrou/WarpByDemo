import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class TestDemo {

    ChromeDriver driver;

    @BeforeMethod
    public void config(){
        System.setProperty("webdriver.chrome.driver","src/test/resources/chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--headless");
        chromeOptions.addArguments("--ignore-certificate-errors");
        chromeOptions.addArguments("--ignore-popup-blocking");
        chromeOptions.addArguments("--start-maximized");
        driver =new ChromeDriver(chromeOptions);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        //погает решить проблему NoSuchElementException
        driver.get("https://warp.by/");
    }

    @Test
    public void cartTest(){
        WebElement cart = driver.findElement(By.className("cart-total-value"));
        cart.click();
    }

    @Test
    public void menuTest() {
        WebElement menu = driver.findElement(By.xpath("//div[@class='left-nav-trigger']//i[@class='material-icons']"));
        menu.click();
        WebElement menuPS5 = driver.findElement(By.xpath("//a[contains(@title,'PlayStation 5 (PS5)')]//span"));
        menuPS5.click();
    }

    @Test
    public void catalogTest(){
        driver.findElement(By.xpath("//li[@class='amenu-item mm-2 plex']//a[@class='amenu-link']")).click();
        driver.findElement(By.xpath("//ul[@class='category-subs']//a[@href=\"https://warp.by/playstation-5-ps5\"]")).click();
    }

    @Test
    public void customerSingInTest(){
        WebElement customer = driver.findElement(By.className("customer-signin-module"));
        customer.click();
        driver.findElement(By.name("email")).sendKeys("timap446@vk.com");
        driver.findElement(By.name("password")).sendKeys("yVQs6DCXed2W9XV");
        WebElement singin = driver.findElement(By.id("submit-login"));
        singin.click();
        driver.findElement(By.xpath("//li[@class='logout-link']//a")).click();
    }

//    @Test
//    public void customerSignOutTest(){
//        WebElement customer = driver.findElement(By.className("customer-signin-module"));
//        customer.click();
//        driver.findElement(By.xpath("//li[@class='logout-link']//a")).click();
//
//    }

    @AfterMethod
    public void tearDown(){
        driver
                .get("https://warp.by/");
        driver
                .close();
        driver
                .quit();
    }


}
