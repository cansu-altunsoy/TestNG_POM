package tests.c01_testNGFramework;

import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;
import utilities.ReusableMethods;

public class C04_Priority {


    // uc farkli test method'u olusturun
    // testotomasyonu, wisequarter ve bestbuy sitelerine gidip
    // url'in bu kelimeleri icerdigini test edin
    // ve windowlari kapatin

    /*
    TestNG biz birsey soylemedi isek test method'larini
    alfabetik siraya uygun olarak calistirir


     1- biz test method'larina priority tanimlarsak
         priority degerlerini kucukten buyuge dogru calistirir

     2- bazi method'lar priority atayip, bazilarina atama yapmazsak
         atama yapilmayan method'larin priority degeri
         default deger olan 0 olur ve buna uygun sirada calisir

     3- ayni priority degerine sahip birden fazla method olursa
          esit priority degeri olanlar, kendi iclerinde alfabetik siraya uyarlar



     */

    @Test(priority = 1, groups = {"smoke", "E2E"})
    public void testOtomasyonuTest() {

        Driver.getDriver().get("https://www.testotomasyonu.com");

        String expectedUrlIcerik = "testotomasyonu";
        String actualUrlIcerik = Driver.getDriver().getCurrentUrl();

        Assert.assertTrue(actualUrlIcerik.contains(expectedUrlIcerik));

        ReusableMethods.bekle(1);

        Driver.quitDriver();

    }


    @Test(priority = 2)
    public void wisequarterTest() {

        Driver.getDriver().get("https://wisequarter.com");

        String expectedUrlIcerik = "wisequarter";
        String actucalUrlIcerik = Driver.getDriver().getCurrentUrl();

        Assert.assertTrue(actucalUrlIcerik.contains(expectedUrlIcerik));

        Driver.quitDriver();

    }


    @Test(priority = 3, groups = {"smoke", "E2E"})
    public void bestbuyTest() {

        Driver.getDriver().get("https://www.bestbuy.com/");

        String expectedUrlIcerik = "bestbuy";
        String actualUrlIcerik = Driver.getDriver().getCurrentUrl();

        Assert.assertTrue(actualUrlIcerik.contains(expectedUrlIcerik));

        Driver.quitDriver();


    }


}
