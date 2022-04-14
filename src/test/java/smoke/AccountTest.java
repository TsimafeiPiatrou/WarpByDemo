package smoke;

import base.BaseAuthenticatedTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AccountTest extends BaseAuthenticatedTest {

    @Test(groups = {"account"})
    public void addAddressTest(){
        validLogin();
        accountPage.openAddress();
        accountPage.addAddress();
//        Assert.assertFalse(accountPage.isPageLoaded(),"Account page is not loaded");
//        Assert.assertTrue(accountPage.isPageLoaded(),"Account page is not loaded");
    }

    @Test(groups = {"account"})
    public void addIdentityTest(){
        validLogin();
        accountPage.openIdentity();
        accountPage.addIdentityInfo();
//        Assert.assertFalse(accountPage.isPageLoaded(),"Account page is not loaded");
//        Assert.assertTrue(accountPage.isPageLoaded(),"Account page is not loaded");
    }

    @Test(groups = {"account"})
    public void closeAccountTest(){
        validLogin();
        accountPage.closeAccount();
    }
}
