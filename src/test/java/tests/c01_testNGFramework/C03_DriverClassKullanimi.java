package tests.c01_testNGFramework;

import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;
import utilities.ReusableMethods;

public class C03_DriverClassKullanimi {


    // uc farkli test method'u olusturun
    // testotomasyonu, wisequarter ve bestbuy sitelerine gidip
    // url'in bu kelimeleri icerdigini test edin
    // ve windowlari kapatin


    @Test
    public void testOtomasyonuTest() {

        Driver.getDriver().get("https://www.testotomasyonu.com");

        String expectedUrlIcerik = "testotomasyonu";
        String actualUrlIcerik = Driver.getDriver().getCurrentUrl();

        Assert.assertTrue(actualUrlIcerik.contains(expectedUrlIcerik));

        ReusableMethods.bekle(1);

        Driver.quitDriver();

    }


    @Test
    public void wisequarterTest() {

        Driver.getDriver().get("https://wisequarter.com");

        String expectedUrlIcerik = "wisequarter";
        String actucalUrlIcerik = Driver.getDriver().getCurrentUrl();

        Assert.assertTrue(actucalUrlIcerik.contains(expectedUrlIcerik));

        Driver.quitDriver();

    }


    @Test
    public void bestbuyTest() {

        Driver.getDriver().get("https://www.bestbuy.com/");

        String expectedUrlIcerik = "bestbuy";
        String actualUrlIcerik = Driver.getDriver().getCurrentUrl();

        Assert.assertTrue(actualUrlIcerik.contains(expectedUrlIcerik));

        Driver.quitDriver();


    }


}
