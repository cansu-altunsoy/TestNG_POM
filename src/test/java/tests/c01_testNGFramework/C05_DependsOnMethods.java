package tests.c01_testNGFramework;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;

public class C05_DependsOnMethods {


    // uc farkli test  methody oluşturup asagidaki gorevleri yapin
    // 1- testotomasyonu anasayfasina gidip url'in testotomasyonu icerdigini test edin
    // 2- phone icin arama yapip urun bulunabildigini test edin
    // 3- ilk urune tiklayip, urun isminde case sensitive olmadan "phone" bulundugunu test edin

    /*
     dependsOnMethods = "anaSayfaTesti"

    1- siralama icin degil, method'lari birbirine baglamak icin kullanilir
     eger anasayfa testi calisip PASSED olmazsa phoneAramaTestini calistirmanin hicbir anlami olmayacaksa
      dependsOnMethods = "anaSayfaTesti" yazabiliriz


      2- Her test method'u bagimsiz olarak calistirilabilir, ancak dependsOnMethods ile
      calismasi baska class'in calismasina baglanan bir method
      bagimsiz olarak calistirilmak istendiginde ONCE bagli oldugu method'u calistirir, o method PASSED olursa kendiside calisir

      AANNCAAKKK bu sadece 2 method icin gecerlidir, eger 3 method birbirine bagli ise 3.method'u bagimsiz calistirmak
      istedigimizde tum methodlari calistirmaz

       3- Her ne kadar siralama icin kullanilmasa da dependsOnmethod kullanmis olan bir method'a sira geldiginde
          once bagli oldugu method'un calismasini saglayacagi icin otomatik olarak bir siralama da yapmis olur


     */


    @Test
    public void anaSayfaTesti() {

        Driver.getDriver().get("https://testotomasyonu.com/");

        String expectedUrl = "testotomasyonu";
        String actualUrl = Driver.getDriver().getCurrentUrl();

        Assert.assertTrue(actualUrl.contains(expectedUrl));


    }

    @Test(dependsOnMethods = "anaSayfaTesti")
    public void phoneAramaTesti() {

        WebElement aramaKutusu = Driver.getDriver().findElement(By.id("global-search"));
        aramaKutusu.sendKeys("phone" + Keys.ENTER);


        // ilk urun bulunabildigini test edin
        WebElement urunAramaElementi = Driver.getDriver().findElement(By.className("product-count-text"));

        String unExpectedSonuc = "0 Products Found";
        String actualSonuc = urunAramaElementi.getText();

        Assert.assertNotEquals(actualSonuc, unExpectedSonuc);


    }

    @Test(priority = 5, dependsOnMethods = "phoneAramaTesti")
    public void ilkUrunTesti() {

        // ilk urune tikleyin
        WebElement ilkUrunElementi = Driver.getDriver().findElement(By.xpath("(//*[@class='prod-img'])[1]"));
        ilkUrunElementi.click();

        // urun isminde case sensitive olmadan "phone" bulundugunu test edin
        String expectedIsim = "phone";
        String actualIsim = Driver.getDriver().findElement(By.xpath("//div[@class=' heading-sm mb-4']")).getText().toLowerCase();

        Assert.assertTrue(actualIsim.contains(expectedIsim));

        Driver.quitDriver();


    }
}
