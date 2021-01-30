package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends HomePage{
    public ProductPage(WebDriver driver)
    {
        super(driver);
    }

    @FindBy(css = "span.cat-name")
    public WebElement BlousesSuccessPage;

    @FindBy(css = "a.product_img_link")
    WebElement ResultedProduct;

    @FindBy(linkText = "Add to cart")
    WebElement AddToCartBtn;

    @FindBy(linkText = "Proceed to checkout")
    WebElement ProceedToCheckoutBtn;

/*    @FindBy(css = "div.h2")
    public WebElement ProductAddedToCartSucessfully;*/

    @FindBy(id = "cart_title")
    public WebElement ShoppingCartSummary;

    @FindBy(id = "center_column")
    public WebElement AddressPageSuccess;

    @FindBy(id = "carrier_area")
    public WebElement ShippingPageSuccess;

    @FindBy(css = "button.btn.btn-default.button-medium")
    public WebElement ProceedToCheckoutInAddressBtn;

    @FindBy(css = "button.button.btn.btn-default.standard-checkout.button-medium")
    public WebElement ProceedToCheckoutInShippingBtn;

    @FindBy(id = "center_column")
    public WebElement PaymentPageSuccess;

    @FindBy(id = "uniform-cgv")
    public WebElement TOSCheckBox;

    @FindBy(css = "p.payment_module")
    public WebElement PayByBankWireBtn;

    @FindBy(css = "h3.page-subheading")
    public WebElement PayByBankWireSuccess;

    @FindBy(css = "button.button.btn.btn-default.button-medium")
    public WebElement ConfirmOrderBtn;

    @FindBy(css = "h1.page-heading")
    public WebElement ConfirmOrderSuccess;

    @FindBy(linkText = "My orders")
    public WebElement OrderHistoryPageBtn;

    @FindBy(css = "div.box")
    public WebElement OrderConfirmationTxt;

    @FindBy(xpath = "//*[@id=\"order-list\"]/tbody/tr[1]/td[1]/a")
    public WebElement OrderReference;

    public void SelectResultedProduct()
    {
        action.moveToElement(ResultedProduct).perform();
        ClickBtn(AddToCartBtn);
    }

    public void ProceedToCheckout()
    {
        ClickBtn(ProceedToCheckoutBtn);
    }

    public void ProceedToCheckoutInAddress()
    {
        ClickBtn(ProceedToCheckoutInAddressBtn);
    }

    public void ProceedToCheckoutInShipping()
    {
        ClickBtn(ProceedToCheckoutInShippingBtn);
    }

    public void MarkTOSCheckBox() { ClickBtn(TOSCheckBox);}

    public void PayByBankWire() { ClickBtn(PayByBankWireBtn);}

    public void ConfirmOrder() { ClickBtn(ConfirmOrderBtn);}

    public void OrderHistoryPage() {ClickBtn(OrderHistoryPageBtn);}
}
