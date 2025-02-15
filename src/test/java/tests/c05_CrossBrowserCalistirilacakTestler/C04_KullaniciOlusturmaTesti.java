package tests.c05_CrossBrowserCalistirilacakTestler;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.ReusableMethods;
import utilities.TestBaseCross;

public class C04_KullaniciOlusturmaTesti extends TestBaseCross {


    @Test
    public void KullaniciOlusturmaTesti(){

        // testotomasyonu sayfasina gidin
        driver.get(ConfigReader.getProperty("toUrl"));

        // account butonuna basin
        driver.findElement(By.xpath("(//span[.='Account'])[1]")).click();
        ReusableMethods.bekle(1);

        // signUp linkine basin
        driver.findElement(By.xpath(" //*[.=' Sign Up']"))
                .click();
        ReusableMethods.bekle(1);
        // Formdaki bilgileri fake degerler ile doldurun
        WebElement firstNameKutusu = driver.findElement(By.id("firstName"));

        Actions actions = new Actions(driver);
        Faker faker = new Faker();
        ReusableMethods.bekle(1);

        String fakePassword = faker.internet().password();
        String fakeEmail = faker.internet().emailAddress();

        actions.click(firstNameKutusu)
                .sendKeys(faker.name().firstName())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.name().lastName())
                .sendKeys(Keys.TAB)
                .sendKeys(fakeEmail)
                .sendKeys(Keys.TAB)
                .sendKeys(fakePassword)
                .sendKeys(Keys.TAB)
                .sendKeys(fakePassword).perform();
        ReusableMethods.bekle(1);

        // signUp buttonuna basiniz
        driver.findElement(By.id("btn-submit-form")).click();

        // Kayit olusturuldugunu test edin

        /*
          kayit olusturulunca bizi login sayfasina yonlendiriyor
          kayit olustugunu test etmek icin
          kullandigimiz fake email ve sifre ile giris yapip
          giris yapabildigimizi test edelim

        */

        WebElement emailKutusu = driver.findElement(By.id("email"));
        WebElement passwordKutusu = driver.findElement(By.id("password"));

        emailKutusu.sendKeys(fakeEmail);
        passwordKutusu.sendKeys(fakePassword);

        WebElement loginButon = driver.findElement(By.id("submitlogin"));
        loginButon.click();

        // 6- Basarili olarak giris yapilabildigini test edin
        WebElement logoutButton = driver.findElement(By.xpath( "//span[.='Logout']"));
        Assert.assertTrue(logoutButton.isDisplayed());



























    }

}
