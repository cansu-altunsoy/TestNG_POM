package tests.c05_CrossBrowserCalistirilacakTestler;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.ReusableMethods;
import utilities.TestBaseCross;

public class C02_NegativeLoginTesti extends TestBaseCross {


    @Test
    public void gecersizPasswordTesti() {

        //1- https://www.testotomasyonu.com/ anasayfasina gidin
        driver.get("https://www.testotomasyonu.com/");
        ReusableMethods.bekle(1);

        //2- account linkine basin
        driver.findElement(By.xpath("(//span[.='Account'])[1]")).click();
        ReusableMethods.bekle(1);

        // 3- 3 farkli test method’u olusturun.
        // - gecerli email, gecersiz password
        WebElement emailKutusu = driver.findElement(By.id("email"));
        WebElement passwordKutusu = driver.findElement(By.id("password"));

        emailKutusu.sendKeys(ConfigReader.getProperty("toGecerliMail"));
        passwordKutusu.sendKeys(ConfigReader.getProperty("toGecersizPassword"));

        //4- Login butonuna basarak login olmayi deneyin
        WebElement loginButon = driver.findElement(By.id("submitlogin"));
        loginButon.click();

        //5- Basarili olarak giris yapilamadigini test edin
        loginButon = driver.findElement(By.id("submitlogin"));
       Assert.assertTrue(loginButon.isDisplayed());


    }


    @Test()
    public void gecersizMailTesti() {

        // 1- https://www.testotomasyonu.com/ anasayfasina gidin
        driver.get("https://www.testotomasyonu.com/");

        //2- account linkine basin
        driver.findElement(By.xpath("(//span[.='Account'])[1]")).click();
        ReusableMethods.bekle(1);

        // - gecersiz email, gecerli password
        WebElement emailKutusu = driver.findElement(By.id("email"));
        WebElement passwordKutusu = driver.findElement(By.id("password"));

        emailKutusu.sendKeys(ConfigReader.getProperty("toGecersizMail"));
        passwordKutusu.sendKeys(ConfigReader.getProperty("toGecerliPassword"));
        ReusableMethods.bekle(1);

        //4- Login butonuna basarak login olmayi deneyin
        WebElement loginButon = driver.findElement(By.id("submitlogin"));
        loginButon.click();
        ReusableMethods.bekle(1);

        //5- Basarili olarak giris yapilamadigini test edin
        loginButon = driver.findElement(By.id("submitlogin"));
        Assert.assertTrue(loginButon.isDisplayed());



    }


    @Test
    public void gecersizMailGecersizPassword() {

        // 1- https://www.testotomasyonu.com/ anasayfasina gidin
        driver.get("https://www.testotomasyonu.com/");

        //2- account linkine basin
        driver.findElement(By.xpath("(//span[.='Account'])[1]")).click();
        ReusableMethods.bekle(1);

        // - gecersiz email, gecersiz password.
        WebElement emailKutusu = driver.findElement(By.id("email"));
        WebElement passwordKutusu = driver.findElement(By.id("password"));

        emailKutusu.sendKeys(ConfigReader.getProperty("toGecersizMail"));
        passwordKutusu.sendKeys(ConfigReader.getProperty("toGecersizPassword"));
        ReusableMethods.bekle(1);

        //4- Login butonuna basarak login olmayi deneyin
        WebElement loginButon = driver.findElement(By.id("submitlogin"));
        loginButon.click();
        ReusableMethods.bekle(1);

        //5- Basarili olarak giris yapilamadigini test edin

        loginButon = driver.findElement(By.id("submitlogin"));
        Assert.assertTrue(loginButon.isDisplayed());


    }


}


