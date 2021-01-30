package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class PageBase {

    protected WebDriver driver;
    public Select select;
    public Actions action;

    //Create Constructor
    public PageBase(WebDriver driver)
    {
        PageFactory.initElements(driver,this);
    }

    protected static void ClickBtn(WebElement button)
    {
        button.click();
    }

    protected static void SetTxtElementText(WebElement TxtElement, String value)
    {
        TxtElement.sendKeys(value);
    }

    protected static void BirthdayDDL(WebElement BirthdayTxtBox,int index)
    {
        Select drop = new Select(BirthdayTxtBox);
        drop.selectByIndex(index);
    }

    protected static void BirthMonthDDL(WebElement BirthmonthTxtBox,int index)
    {
        Select drop = new Select(BirthmonthTxtBox);
        drop.selectByIndex(index);
    }

    protected static void BirthYearDDL(WebElement BirthyearTxtBox,int index)
    {
        Select drop = new Select(BirthyearTxtBox);
        drop.selectByIndex(index);
    }

    protected static void StateDDL(WebElement StateDDL,int index)
    {
        Select drop = new Select(StateDDL);
        drop.selectByIndex(index);
    }
}
