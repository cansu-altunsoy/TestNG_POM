package tests.c04__htmlReports;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.TestotomasyonuPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class C05_RaporluDataProviderTesti extends TestBaseRapor {


    @DataProvider
    public static Object[][] UrunProvideri() {

        String[][] urunlerArrayi = {{"phone"}, {"java"}, {"dress"}, {"baby"},
                {"nutella"}, {"samsung"}, {"iphone"}, {"shirt"}};

        return urunlerArrayi;
    }


    @Test(dataProvider = "UrunProvideri")
    public void aramaTesti( String aranacakUrun){

        extentTest = extentReports.createTest(aranacakUrun+ "arama testi",
                "Arama sonucunda "+ aranacakUrun+ "bulunabilmeli");

        // testotomasyonu sayfasina gidin
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));
        extentTest.info("testotomasyonu sayfasina gider");

        TestotomasyonuPage testotomasyonuPage = new TestotomasyonuPage();

        // arama kutusuna aranacakUrun'u yazdirip enter'a basin

        testotomasyonuPage.aramaKutusu.sendKeys(aranacakUrun + Keys.ENTER);
        extentTest.info("arama kutusuna"+aranacakUrun+ "'u yazdirip enter'a basar");

        // arama sonucunda urun bulunabildigini test edin

        String unexpectedAramaSonucu = ConfigReader.getProperty("toUnexpectedSonuc");
        String actualAramaSonucYazisi = testotomasyonuPage.urunAramaElementi.getText();


        Assert.assertNotEquals(actualAramaSonucYazisi,unexpectedAramaSonucu,aranacakUrun+" bulunamadi" );
        extentTest.pass("arama sonucunda urun bulunabildigini test eder");

       extentTest.info("sayfayı kapatir");
    }
}
