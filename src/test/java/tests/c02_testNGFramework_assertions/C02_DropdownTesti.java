package tests.c02_testNGFramework_assertions;

import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestOtomasyonuFormPage;
import utilities.Driver;
import utilities.ReusableMethods;

public class C02_DropdownTesti {


    @Test
    public void dropdownTesti() {


        // 1 - https://testotomasyonu.com/form adresine gidin
        Driver.getDriver().get(" https://testotomasyonu.com/form");

        TestOtomasyonuFormPage testotomasyonuFormPage = new TestOtomasyonuFormPage();

        //2- Dogum tarihi gun seçeneğinden index kullanarak 5’i secin
        Select selectgun = new Select(testotomasyonuFormPage.gunDdm);
        selectgun.selectByIndex(5);

        //3- Dogum tarihi ay seçeneğinden value kullanarak Nisan’i secin
        Select selectay = new Select(testotomasyonuFormPage.ayDdm);
        selectay.selectByValue("nisan");

        //4- Dogum tarihi yil seçeneğinden visible text kullanarak 1990’i secin
        Select selectyil = new Select(testotomasyonuFormPage.yilDdm);
        selectyil.selectByVisibleText("1990");

        //5- Secilen değerleri konsolda yazdirin
        System.out.println(
                selectgun.getFirstSelectedOption().getText() + " " + selectay.getFirstSelectedOption().getText() + " " + selectyil.getFirstSelectedOption().getText()
        );
        //6- Ay dropdown menüdeki tum değerleri(value) yazdırın
        System.out.println(ReusableMethods.stringListeyeDonustur(selectay.getOptions()));

        //7- Ay Dropdown menusunun boyutunun 13 olduğunu test edin
        int expectedBoyut = 13;
        int actualBoyut = selectay.getOptions().size();

        Assert.assertEquals(actualBoyut, expectedBoyut);


        Driver.quitDriver();


    }


}
