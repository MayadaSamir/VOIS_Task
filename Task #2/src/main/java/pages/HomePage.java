package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class HomePage extends PageBase
{
    public HomePage(WebDriver driver)
    {
        super(driver);
        action = new Actions(driver);
    }

    @FindBy(linkText = "Sign in")
    WebElement RegisterOrSignInLink;

    @FindBy(css = "a.sf-with-ul")
    WebElement WomenMenu;

    @FindBy(linkText = "Blouses")
    WebElement BlousesBtn;

    public void OpenRegisterationOrLoginPage()
    {
        RegisterOrSignInLink.click();
    }

    public void SelectBlousesMenu()
    {
        action.moveToElement(WomenMenu).perform();
        ClickBtn(BlousesBtn);
    }
}
