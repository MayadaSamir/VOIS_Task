package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignInPage extends PageBase{
    public SignInPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "email")
    WebElement EmailTxtBox;

    @FindBy(id = "passwd")
    WebElement PasswordTxtBox;

    @FindBy(id = "SubmitLogin")
    WebElement SignInBtn;

    public void SignIn(String Email, String Password)
    {
        SetTxtElementText(EmailTxtBox,Email);
        SetTxtElementText(PasswordTxtBox,Password);
        ClickBtn(SignInBtn);
    }

}
