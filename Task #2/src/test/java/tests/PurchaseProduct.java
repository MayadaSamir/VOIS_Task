package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ProductPage;
import pages.HomePage;
import pages.UserRegistrationPage;

public class PurchaseProduct extends TestBase
{
    HomePage HomeObject;
    ProductPage ProductObject;
    UserRegistrationPage RegisterObject;

    @Test(priority = 1, alwaysRun = true)
    public void UserCanSelectBlousesMenu()
    {
        HomeObject = new HomePage(driver);
        HomeObject.SelectBlousesMenu();
        ProductObject = new ProductPage(driver);

        Assert.assertTrue(ProductObject.BlousesSuccessPage.getText().contains("BLOUSES"));
        Assert.assertTrue(driver.getCurrentUrl().contains("id_category=7&controller=category"));
    }

    @Test(dependsOnMethods = "UserCanSelectBlousesMenu")
    public void UserCanSelectResultedProduct()
    {
        ProductObject = new ProductPage(driver);
        ProductObject.SelectResultedProduct();
        //Assert.assertTrue(ProductObject.ProductAddedToCartSucessfully.getText().contains("Product successfully added to your shopping cart"));
    }

    @Test(dependsOnMethods = "UserCanSelectResultedProduct")
    public void UserCanProceedToCheckout()
    {
        ProductObject = new ProductPage(driver);
        ProductObject.ProceedToCheckout();

        Assert.assertTrue(ProductObject.ShoppingCartSummary.getText().contains("SHOPPING-CART SUMMARY"));
    }

    @Test(dependsOnMethods = "UserCanProceedToCheckout")
    public void UserCanProceedToAddress()
    {
        ProductObject = new ProductPage(driver);
        ProductObject.ProceedToCheckout();

        Assert.assertTrue(ProductObject.AddressPageSuccess.getText().contains("ADDRESSES"));
    }

    @Test(dependsOnMethods = "UserCanProceedToAddress")
    public void UserCanProceedToShipping()
    {
        ProductObject = new ProductPage(driver);
        ProductObject.ProceedToCheckoutInAddress();

        Assert.assertTrue(ProductObject.ShippingPageSuccess.getText().contains("SHIPPING"));
    }

    @Test(dependsOnMethods = "UserCanProceedToShipping")
    public void UserCanProceedToPayment()
    {
        ProductObject = new ProductPage(driver);
        ProductObject.MarkTOSCheckBox();
        //Assert.assertTrue(ProductObject.TOSCheckBox.isSelected());

        ProductObject.ProceedToCheckoutInShipping();
        Assert.assertTrue(ProductObject.PaymentPageSuccess.getText().contains("PLEASE CHOOSE YOUR PAYMENT METHOD"));
    }

    @Test(dependsOnMethods = "UserCanProceedToPayment")
    public void UserCanPayByBankWire()
    {
        ProductObject = new ProductPage(driver);
        ProductObject.PayByBankWire();
        Assert.assertTrue(ProductObject.PayByBankWireSuccess.getText().contains("BANK-WIRE PAYMENT"));
    }

    @Test(dependsOnMethods = "UserCanPayByBankWire")
    public void UserCanConfirmOrder()
    {
        ProductObject = new ProductPage(driver);
        ProductObject.ConfirmOrder();
        Assert.assertTrue(ProductObject.ConfirmOrderSuccess.getText().contains("ORDER CONFIRMATION"));
    }

    @Test(dependsOnMethods = "UserCanConfirmOrder")
    public void ValidateOrderInHistoryPage()
    {
        ProductObject = new ProductPage(driver);
        String GeneratedOrdRef = ProductObject.OrderConfirmationTxt.getText();
        ProductObject.OrderHistoryPage();
        String OrderRef = ProductObject.OrderReference.getText();
        Assert.assertTrue(GeneratedOrdRef.contains(OrderRef));
    }
}