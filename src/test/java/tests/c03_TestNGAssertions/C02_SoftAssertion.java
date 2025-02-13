package tests.c03_TestNGAssertions;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.TestotomasyonuPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C02_SoftAssertion {


    @Test
    public void softAssertionTesti(){

        // 1- testotomasyonu anasayfaya gidip
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));

        // url'in testotomasyonu icerdigini test edin

        String expectedUrlIcerik = "testotomasyonu";
        String actualUrl = Driver.getDriver().getCurrentUrl();

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertTrue(actualUrl.contains(expectedUrlIcerik));

        // 2- phone icin arama yapip

        TestotomasyonuPage testotomasyonuPage = new TestotomasyonuPage();

        testotomasyonuPage.aramaKutusu
                .sendKeys(ConfigReader.getProperty("toAranacakKelime") + Keys.ENTER);

        // urun bulunabildigini test edin

        String actualSonuc = testotomasyonuPage.urunAramaElementi.getText();
        String unExpectedSonuc = ConfigReader.getProperty("toUnexpectedSonuc");

         softAssert.assertNotEquals(actualSonuc, unExpectedSonuc);


        // 3- ilk urunu tiklayip,
        testotomasyonuPage.ilkUrunElementi.click();

        // urun isminde case sensitive olmadan "phone" bulundugunu test edin

        String expectedIsimIcerik = ConfigReader.getProperty("toAranacakKelime");
        String actualUrunIsmi = testotomasyonuPage.ilkUrunIsimElementi
                .getText()
                .toLowerCase();

        softAssert.assertTrue(actualUrunIsmi.contains(expectedIsimIcerik));

        softAssert.assertAll(); // bu satir durumu raporlar, bu yazilmaz ise durumu raporlamaz

        Driver.quitDriver();

    }
}
