package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserRegistrationPage extends PageBase {
    public UserRegistrationPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "email_create")
    WebElement EmailAddressTxtBox;

    @FindBy(id = "SubmitCreate")
    WebElement CreateAccountBtn;

    @FindBy(id = "uniform-id_gender1")
    WebElement GenderRadioBtn;

    @FindBy(id = "customer_firstname")
    WebElement CustomerFirstNameTxtBox;

    @FindBy(id = "customer_lastname")
    WebElement CustomerLastNameTxtBox;

    @FindBy(id = "email")
    WebElement EmailTxtBox;

    @FindBy(id = "passwd")
    WebElement PasswordTxtBox;

    @FindBy(id = "days")
    WebElement BirthdayTxtBox;

    @FindBy(id = "months")
    WebElement BirthmonthTxtBox;

    @FindBy(id = "years")
    WebElement BirthyearTxtBox;

    @FindBy(id = "firstname")
    WebElement FirstNameTxtBox;

    @FindBy(id = "lastname")
    WebElement LastNameTxtBox;

    @FindBy(id = "address1")
    WebElement AddressTxtBox;

    @FindBy(id = "city")
    WebElement CityTxtBox;

    @FindBy(id = "id_state")
    WebElement StateTxtBox;

    @FindBy(id = "postcode")
    WebElement PostalCodeTxtBox;

    @FindBy(id = "id_country")
    WebElement CountryTxtBox;

    @FindBy(id = "phone_mobile")
    WebElement MobilePhoneTxtBox;

    @FindBy(id = "alias")
    WebElement AliasAddressTxtBox;

    @FindBy(id = "submitAccount")
    WebElement RegisterBtn;

    @FindBy(css = "p.info-account")
    public WebElement SuccessRegistration;

    @FindBy(linkText = "Sign out")
    WebElement SignOutLink;

    @FindBy(css = "h1.page-heading")
    public WebElement SuccessSignOut;

    public void UserRegistration(String EmailAddress, String CustomerFirstName, String CustomerLastName, String Password, int Birthday,
                                 int BirthMonth, int BirthYear, String Address, String City, int StateDDL,
                                 String PostalCode, int Country, String MobilePhone, String AliasAddress) {
        SetTxtElementText(EmailAddressTxtBox, EmailAddress);
        ClickBtn(CreateAccountBtn);
        ClickBtn(GenderRadioBtn);
        SetTxtElementText(CustomerFirstNameTxtBox, CustomerFirstName);
        SetTxtElementText(CustomerLastNameTxtBox, CustomerLastName);
        SetTxtElementText(PasswordTxtBox, Password);
        ClickBtn(BirthdayTxtBox);
        BirthdayDDL(BirthdayTxtBox, Birthday);
        ClickBtn(BirthmonthTxtBox);
        BirthMonthDDL(BirthmonthTxtBox, BirthMonth);
        ClickBtn(BirthyearTxtBox);
        BirthYearDDL(BirthyearTxtBox, BirthYear);
        SetTxtElementText(AddressTxtBox, Address);
        SetTxtElementText(CityTxtBox, City);
        ClickBtn(StateTxtBox);
        StateDDL(StateTxtBox, StateDDL);
        SetTxtElementText(PostalCodeTxtBox, PostalCode);
        ClickBtn(CountryTxtBox);
        SetTxtElementText(MobilePhoneTxtBox, MobilePhone);
        AliasAddressTxtBox.clear();
        SetTxtElementText(AliasAddressTxtBox, AliasAddress);
        ClickBtn(RegisterBtn);
    }

    public void UserSignOut() {
        ClickBtn(SignOutLink);
    }
}


