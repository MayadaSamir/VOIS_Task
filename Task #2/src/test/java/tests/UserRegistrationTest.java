package tests;

import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.SignInPage;
import pages.UserRegistrationPage;

public class UserRegistrationTest extends TestBase
{
    HomePage HomeObject;
    UserRegistrationPage RegisterObject;
    SignInPage SignInObject;

    //Generating fake registration data
    Faker fakeData = new Faker();
    String FakeFirstName = fakeData.name().firstName();
    String FakeLastName = fakeData.name().lastName();
    String FakePassword = fakeData.lorem().characters(8, true);  //Generating password of 8 characters including upper case letters
    String FakeEmail = fakeData.internet().emailAddress();
    int FakeBirthday = fakeData.number().numberBetween(1,31);
    int FakeBirthMonthIndex = fakeData.number().numberBetween(1,12);
    int FakeBirthYearIndex = fakeData.number().numberBetween(1,121);
    String FakeAddress = fakeData.address().fullAddress().toString();
    String FakeCity = fakeData.address().cityName();
    int  FakeState= fakeData.number().numberBetween(1,53);
    String FakePostalCode = fakeData.number().digits(5);
    String FakeMobilePhone = fakeData.phoneNumber().cellPhone();
    String FakeAliasAddress = fakeData.address().buildingNumber().toString()+", "+fakeData.address().cityName().toString();

    @Test(priority = 1, alwaysRun = true)
    public void UserCanRegisterSuccessfully()
    {
        HomeObject = new HomePage(driver);
        HomeObject.OpenRegisterationOrLoginPage();

        RegisterObject = new UserRegistrationPage(driver);
        RegisterObject.UserRegistration(FakeEmail,FakeFirstName,FakeLastName,FakePassword,FakeBirthday,FakeBirthMonthIndex,FakeBirthYearIndex,FakeAddress,FakeCity,FakeState,FakePostalCode,1,FakeMobilePhone,FakeAliasAddress);

        Assert.assertTrue(RegisterObject.SuccessRegistration.getText().contains("Welcome to your account. Here you can manage all of your personal information and orders"));
    }

    @Test(dependsOnMethods = {"UserCanRegisterSuccessfully"})
    public void RegisteredUserCanSignOut()
    {
        RegisterObject = new UserRegistrationPage(driver);
        RegisterObject.UserSignOut();

        Assert.assertTrue(RegisterObject.SuccessSignOut.getText().contains("AUTHENTICATION"));
    }

    @Test(dependsOnMethods = {"RegisteredUserCanSignOut"})
    public void RegisteredUserCanSignIn()
    {
        SignInObject = new SignInPage(driver);
        SignInObject.SignIn(FakeEmail,FakePassword);
        Assert.assertTrue(RegisterObject.SuccessRegistration.getText().contains("Welcome to your account. Here you can manage all of your personal information and orders"));
    }
}
