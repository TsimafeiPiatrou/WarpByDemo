package smoke;

import base.BaseAuthenticatedTest;
import org.testng.annotations.Test;

public class ProductTest extends BaseAuthenticatedTest {

    public static final String TEST_PRODUCT_TITLE_PS5 = "Геймпад DualSense (PS5)";
    public static final String TEST_PRODUCT_TITLE_NINTENDO = "Nintendo Switch 2019 (серый)";


    @Test
    public void addProductPS5ToCartTest(){
        validLogin();
        catalogMainPage.openMenuPS5();
        catalogMainPage.addToCart(TEST_PRODUCT_TITLE_PS5);
        catalogMainPage.deleteFromCart();
    }

    @Test
    public void addProductNintendoToCartTest(){
        validLogin();
        catalogMainPage.openMenuNintendo();
        catalogMainPage.addToCart(TEST_PRODUCT_TITLE_NINTENDO);
        catalogMainPage.deleteFromCart();
    }

}
