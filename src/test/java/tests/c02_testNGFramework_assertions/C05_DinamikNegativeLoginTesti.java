package tests.c02_testNGFramework_assertions;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestotomasyonuPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class C05_DinamikNegativeLoginTesti {

    static TestotomasyonuPage testotomasyonuPage = new TestotomasyonuPage();


    @Test
    public void gecersizPasswordTesti() {

        //1- https://www.testotomasyonu.com/ anasayfasina gidin
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));

        //2- account linkine basin
        testotomasyonuPage.accountLink.click();

        // 3- 3 farkli test method’u olusturun.
        // - gecerli email, gecersiz password
        testotomasyonuPage.emailKutusu.sendKeys(ConfigReader.getProperty("toGecerliMail"));
        testotomasyonuPage.passwordKutusu.sendKeys(ConfigReader.getProperty("toGecersizPassword"));

        //4- Login butonuna basarak login olmayi deneyin
        testotomasyonuPage.loginKutusu.click();

        //5- Basarili olarak giris yapilamadigini test edin
        Assert.assertTrue(testotomasyonuPage.loginKutusu.isDisplayed());

        ReusableMethods.bekle(1);
        Driver.quitDriver();

    }


    @Test()
    public void gecersizMailTesti() {

        testotomasyonuPage = new TestotomasyonuPage();

        // 1- https://www.testotomasyonu.com/ anasayfasina gidin
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));

        //2- account linkine basin
        testotomasyonuPage.accountLink.click();

        // - gecersiz email, gecerli password
        testotomasyonuPage.emailKutusu.sendKeys(ConfigReader.getProperty("toGecersizMail"));
        testotomasyonuPage.passwordKutusu.sendKeys(ConfigReader.getProperty("toGecerliPassword"));

        //4- Login butonuna basarak login olmayi deneyin
        testotomasyonuPage.loginKutusu.click();

        //5- Basarili olarak giris yapilamadigini test edin
        Assert.assertTrue(testotomasyonuPage.loginKutusu.isDisplayed());

        ReusableMethods.bekle(1);
        Driver.quitDriver();

    }


    @Test
    public void gecersizMailGecersizPassword() {

        testotomasyonuPage = new TestotomasyonuPage();

        // 1- https://www.testotomasyonu.com/ anasayfasina gidin
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));

        //2- account linkine basin
        testotomasyonuPage.accountLink.click();

        // - gecersiz email, gecersiz password.
        testotomasyonuPage.emailKutusu.sendKeys(ConfigReader.getProperty("toGecersizMail"));
        testotomasyonuPage.passwordKutusu.sendKeys(ConfigReader.getProperty("toGecersizPassword"));

        //4- Login butonuna basarak login olmayi deneyin
        testotomasyonuPage.loginKutusu.click();

        //5- Basarili olarak giris yapilamadigini test edin

        Assert.assertTrue(testotomasyonuPage.loginKutusu.isDisplayed());

        ReusableMethods.bekle(1);
        Driver.getDriver();

    }


}
