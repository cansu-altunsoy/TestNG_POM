package tests.c04__htmlReports;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestotomasyonuPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class C01_RaporluPositiveLoginTesti extends TestBaseRapor {

   /*
     TestNG kendisi HTML rapor olusturamaz

       HTML rapor olusturabilmek icin
        farkli dependency'ler kullanilabilir
        biz aventstack dependency kullandik

         aventstack raporlama icin 3 objeye ihtiyac duyar
         Bu objeleri her class'da olusturmak ve gerekli islemleri yapmak yerine
         bu islemleri bizim adimiza yapacak bir TestBaseRapor olusturduk

         olusturlmasi gereken 3 obje TestBaseRapor'da olusturuldu
         bu objeleri ve yapilan ayarlari kullanmanin
         en kisa yolu extends keyword ile TestBaseRapor'u parent edinmektir

         TestBaseRapor'da olusturulan 3 objeden
         extentReports ve extentHtmlReporter'a deger atamasi yapildi
         extentTest'e deger atamasi her test method'unda yapilmalidir

         HTML raporda gorunmesini istedigimiz test adimlarini
         extentTest objesi ile rapora isleyebiliriz

    */

    @Test
    public void  raporluPositiveLoginTest() {

        extentTest = extentReports.createTest("Positive Login Testi", "Gecerli bilgilerle giris yapilabildi");

        //  1- https://www.testotomasyonu.com/ anasayfasina gidin
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));
        extentTest.info("Kullanici testotomasyonu anasayfaya gider");


        // 2- account linkine basin
        TestotomasyonuPage testotomasyonuPage = new TestotomasyonuPage();

        testotomasyonuPage.accountLink.click();
        extentTest.info("Account linkine basar");

        // 3- Kullanici email'i olarak gecerli email girin
        testotomasyonuPage.emailKutusu.sendKeys(ConfigReader.getProperty("toGecerliMail"));
        extentTest.info("Kullanici email'i olarak gecerli email girer");

        // 4- Kullanici sifresi olarak gecerli password girin
        testotomasyonuPage.passwordKutusu.sendKeys(ConfigReader.getProperty("toGecerliPassword"));
        extentTest.info(" Kullanici sifresi olarak gecerli password girer");

        // 5- Login butonuna basarak login olun
        testotomasyonuPage.loginKutusu.click();
        extentTest.info("Login butonuna basarak login olur");

        // 6- Basarili olarak giris yapilabildigini test edin
        Assert.assertTrue(testotomasyonuPage.logoutButonu.isDisplayed());
        extentTest.pass(" Basarili olarak giris yapilabildigini test eder");

        // logout olun
        testotomasyonuPage.logoutButonu.click();
        extentTest.info(" logout butonuna basarak cikis yapar");

        extentTest.info("sayfayi kapatir");

    }
}
