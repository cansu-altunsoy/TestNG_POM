package tests.c04__htmlReports;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.TestotomasyonuPage;
import utilities.ConfigReader;
import utilities.Driver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class C03_TopluAramaTesti {


    @Test
    public void topluAramaTesti() {

        // testotomasyonu sayfasina gidin

        // verilen urunlerin herbiri icin arama yaptirip

        // arama sonucunda urun bulunabildigini test edin

        // phone, java, dress, baby, nutella samsung, iphone shirt


        List<String> aranacakUrunlerListesi = new ArrayList<>(Arrays.asList("phone", "java", "dress", "baby", "nutella", "samsung", "iphone", "shirt"));

        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));

        TestotomasyonuPage testotomasyonuPage = new TestotomasyonuPage();
        SoftAssert softAssert = new SoftAssert();

        for (String eacUrun : aranacakUrunlerListesi) {

            testotomasyonuPage.aramaKutusu.sendKeys(eacUrun + Keys.ENTER);
            String unExpectedAramaSonucu = ConfigReader.getProperty("toUnexpectedSonuc");
            String actualAramaSonuc = testotomasyonuPage.aramaKutusu.getText();

            softAssert.assertNotEquals(actualAramaSonuc, unExpectedAramaSonucu, eacUrun + "aranan urun bulunamadi");

        }

        softAssert.assertAll();


    }
}
