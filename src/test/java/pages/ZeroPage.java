package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class ZeroPage {

    public ZeroPage() {

        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy(id = "signin_button")
    public WebElement singInButton;

    @FindBy(id = "user_login")
    public WebElement loginKutusu;

    @FindBy(id = "user_password")
    public WebElement passwordKutusu;

    @FindBy(name = "submit")
    public WebElement loginPageSingInButton;

    @FindBy(partialLinkText = "Settings")
    public WebElement settingMenu;

    @FindBy(xpath = "//strong[.='Online Banking']")
    public WebElement bankingMenu;

    @FindBy(id = "pay_bills_link")
    public WebElement payBillMenu;

    @FindBy(xpath = "//a[.='Purchase Foreign Currency']")
    public WebElement PurchaseForeignCurrency;

    @FindBy(id = "pc_currency")
    public WebElement currencyDdm;


}
