package tests.c01_testNGFramework;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestotomasyonuPage;
import utilities.Driver;

public class C06_PageClassKullanimi {


    // uc farkli test  methody oluşturup asagidaki gorevleri yapin
    // 1- testotomasyonu anasayfasina gidip url'in testotomasyonu icerdigini test edin
    // 2- phone icin arama yapip urun bulunabildigini test edin
    // 3- ilk urune tiklayip, urun isminde case sensitive olmadan "phone" bulundugunu test edin


    TestotomasyonuPage testotomasyonuPage = new TestotomasyonuPage();

    @Test
    public void anaSayfaTesti() {

        Driver.getDriver().get("https://testotomasyonu.com/");

        String expectedUrl = "testotomasyonu";
        String actualUrl = Driver.getDriver().getCurrentUrl();

        Assert.assertTrue(actualUrl.contains(expectedUrl));


    }

    @Test(dependsOnMethods = "anaSayfaTesti")
    public void phoneAramaTesti() {

        testotomasyonuPage.aramaKutusu.sendKeys("phone" + Keys.ENTER);


        // ilk urun bulunabildigini test edin

        String unExpectedSonuc = "0 Products Found";
        String actualSonuc = testotomasyonuPage.urunAramaElementi.getText();

        Assert.assertNotEquals(actualSonuc, unExpectedSonuc);


    }

    @Test(priority = 5, dependsOnMethods = "phoneAramaTesti", groups = {"smoke","E2E"})
    public void ilkUrunTesti() {

        // ilk urune tikleyin
        testotomasyonuPage.ilkUrunElementi.click();


        // urun isminde case sensitive olmadan "phone" bulundugunu test edin
        String expectedIsim = "phone";
        String actualIsim = testotomasyonuPage.ilkUrunIsimElementi.getText().toLowerCase();

        Assert.assertTrue(actualIsim.contains(expectedIsim));

        Driver.quitDriver();


    }
}
