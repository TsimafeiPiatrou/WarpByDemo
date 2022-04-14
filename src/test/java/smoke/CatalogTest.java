package smoke;

import base.BaseAuthenticatedTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CatalogTest extends BaseAuthenticatedTest {

    public static final String TEST_PRODUCT_TITLE = "DualSense (PS5)";


    @Test
    public void menuIsOpenedTest(){
        validLogin();
        Assert.assertTrue(catalogMainPage.openMenuCheck(),"Menu cross button is not displayed");
    }

    @Test
    public void cartIsOpenedTest(){
        validLogin();
        Assert.assertTrue(catalogMainPage.openCartCheck(),"Cart cross button is not displayed");
    }

    @Test
    public void aboutIsOpenedTest(){
        validLogin();
        catalogMainPage.openAbout();
        Assert.assertTrue(catalogMainPage.isPageLoaded(),"About page is not loaded");
    }

    @Test
    public void contactsIsOpenedTest(){
        validLogin();
        catalogMainPage.openContacts();
        Assert.assertTrue(catalogMainPage.isPageLoaded(),"Contacts page is not loaded");
    }

    @Test
    public void rentIsOpenedTest(){
        validLogin();
        catalogMainPage.openRent();
        Assert.assertTrue(catalogMainPage.isPageLoaded(),"Rent page is not loaded");
    }

    @Test
    public void serviceIsOpenedTest(){
        validLogin();
        catalogMainPage.openService();
        Assert.assertTrue(catalogMainPage.isPageLoaded(),"Service page is not loaded");
    }

    @Test
    public void paymentIsOpenedTest(){
        validLogin();
        catalogMainPage.openPayment();
        Assert.assertTrue(catalogMainPage.isPageLoaded(),"Payment page is not loaded");
    }

    @Test
    public void searchPS5Test(){
        validLogin();
        catalogMainPage.searchCheck(TEST_PRODUCT_TITLE);
    }

    @Test
    public void catalogTransferTest(){
        validLogin();
        catalogMainPage.catalogTransferSalesCheck();
        Assert.assertTrue(catalogMainPage.isPageLoaded(),"Catalog sales page is not loaded");
        catalogMainPage.catalogTransferPS4Check();
        Assert.assertTrue(catalogMainPage.isPageLoaded(),"Catalog PS4 page is not loaded");
    }
}
