package tests.c04__htmlReports;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestotomasyonuPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class C02_RaporluNegatifLoginTesti extends TestBaseRapor {


    static TestotomasyonuPage testotomasyonuPage = new TestotomasyonuPage();


    @Test
    public void gecersizPasswordTesti() {
        extentTest = extentReports.createTest("Gecersiz Password Testi",
                "Kullanici gecerli email ve gecersiz password ile giris yapamamali");

        //1- https://www.testotomasyonu.com/ anasayfasina gidin
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));
        extentTest.info("Kullanici testotomasyonu anasayfaya gider");

        //2- account linkine basin
        testotomasyonuPage.accountLink.click();
        ReusableMethods.bekle(1);
        extentTest.info("account linkine basar");

        // 3- 3 farkli test method’u olusturun.
        // - gecerli email, gecersiz password
        testotomasyonuPage.emailKutusu.sendKeys(ConfigReader.getProperty("toGecerliMail"));
        extentTest.info("email kutusuna gecerli email girer");
        testotomasyonuPage.passwordKutusu.sendKeys(ConfigReader.getProperty("toGecersizPassword"));
        extentTest.info("password kutusuna gecersiz password girer");

        //4- Login butonuna basarak login olmayi deneyin
        testotomasyonuPage.loginKutusu.click();
        extentTest.info(" Login butonuna basarak login olur");

        //5- Basarili olarak giris yapilamadigini test edin
        Assert.assertTrue(testotomasyonuPage.emailKutusu.isDisplayed());
        extentTest.pass(" Basarili olarak giris yapilamadigini test eder");

        ReusableMethods.bekle(1);
      extentTest.info("sayfayi kapatir");

    }


    @Test()
    public void gecersizMailTesti() {
        extentTest = extentReports.createTest("Gecersiz Password Testi",
                "Kullanici gecerli email ve gecersiz password ile giris yapamamali");

        testotomasyonuPage = new TestotomasyonuPage();

        // 1- https://www.testotomasyonu.com/ anasayfasina gidin
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));
        extentTest.info("Kullanici testotomasyonu anasayfaya gider");

        //2- account linkine basin
        testotomasyonuPage.accountLink.click();
        extentTest.info("account linkine basar");

        // - gecersiz email, gecerli password
        testotomasyonuPage.emailKutusu.sendKeys(ConfigReader.getProperty("toGecersizMail"));
        extentTest.info("email kutusuna gecersiz email girer");
        testotomasyonuPage.passwordKutusu.sendKeys(ConfigReader.getProperty("toGecerliPassword"));
        extentTest.info("password kutusuna gecerli password girer");

        //4- Login butonuna basarak login olmayi deneyin
        testotomasyonuPage.loginKutusu.click();
        extentTest.info(" Login butonuna basarak login olur");

        //5- Basarili olarak giris yapilamadigini test edin
        Assert.assertTrue(testotomasyonuPage.loginKutusu.isDisplayed());
        extentTest.pass(" Basarili olarak giris yapilamadigini test eder");


        ReusableMethods.bekle(1);
        extentTest.info("sayfayi kapatir");

    }


    @Test
    public void gecersizMailGecersizPassword() {
        extentTest = extentReports.createTest("Gecersiz Password Testi",
                "Kullanici gecerli email ve gecersiz password ile giris yapamamali");

        testotomasyonuPage = new TestotomasyonuPage();

        // 1- https://www.testotomasyonu.com/ anasayfasina gidin
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));
        extentTest.info("Kullanici testotomasyonu anasayfaya gider");

        //2- account linkine basin
        testotomasyonuPage.accountLink.click();
        extentTest.info("account linkine basar");

        // - gecersiz email, gecersiz password.
        testotomasyonuPage.emailKutusu.sendKeys(ConfigReader.getProperty("toGecersizMail"));
        extentTest.info("email kutusuna gecersiz email girer");
        testotomasyonuPage.passwordKutusu.sendKeys(ConfigReader.getProperty("toGecersizPassword"));
        extentTest.info("password kutusuna gecersiz password girer");

        //4- Login butonuna basarak login olmayi deneyin
        testotomasyonuPage.loginKutusu.click();
        extentTest.info(" Login butonuna basarak login olur");

        //5- Basarili olarak giris yapilamadigini test edin

        Assert.assertTrue(testotomasyonuPage.loginKutusu.isDisplayed());
        extentTest.pass(" Basarili olarak giris yapilamadigini test eder");


        ReusableMethods.bekle(1);
        extentTest.info("sayfayi kapatir");

    }

}
