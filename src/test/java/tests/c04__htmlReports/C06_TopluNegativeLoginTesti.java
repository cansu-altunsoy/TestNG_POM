package tests.c04__htmlReports;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.TestotomasyonuPage;
import utilities.Driver;

public class C06_TopluNegativeLoginTesti {

    //1- https://www.testotomasyonu.com/ anasayfasina gidin
    //2- account linkine basin
    // 3-asagidaki listede verilen email ve sifreleri yazin
    //4- Login butonuna basarak login olmayi deneyin
    //5- Basarili olarak giris yapilamadigini test edin
    // cns@gmail.com  12345

    @DataProvider
    public static Object[][] emailPasswordProvider() {
        String[][] emailPasswordArr = {{"cns@gmail.com","123"},
                                       {"brk@gmail.com","12345"},
                                     {"crn@gmail.com","159"}  };

        return emailPasswordArr;
    }



    @Test(dataProvider = "emailPasswordProvider")
    public void negatifLoginTesti(String verilemEmail, String verilenSifre){

        //1- https://www.testotomasyonu.com/ anasayfasina gidin
        Driver.getDriver().get("https://www.testotomasyonu.com/");

        //2- account linkine basin
        TestotomasyonuPage testotomasyonuPage = new TestotomasyonuPage();
        testotomasyonuPage.accountLink.click();

        // 3-asagidaki listede verilen email ve sifreleri yazin
        testotomasyonuPage.emailKutusu.sendKeys(verilemEmail);
        testotomasyonuPage.passwordKutusu.sendKeys(verilenSifre);

        //4- Login butonuna basarak login olmayi deneyin
        testotomasyonuPage.loginKutusu.click();

        //5- Basarili olarak giris yapilamadigini test edin
        Assert.assertTrue(testotomasyonuPage.emailKutusu.isDisplayed());

        Driver.quitDriver();



    }
}
