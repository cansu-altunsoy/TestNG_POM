package utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

public class ReusableMethods {


    public static void bekle(int saniye) {


        try {
            Thread.sleep(saniye * 1000);
        } catch (InterruptedException e) {
            System.out.println("Thread.sleep calismadi");
        }


    }

    public static List<String> stringListeyeDonustur(List<WebElement> webElementList) {


        List<String> tumListeStr = new ArrayList<>();

        for (WebElement eacBaslik : webElementList) {

            tumListeStr.add(eacBaslik.getText());
        }
        return tumListeStr;
    }


    public static void urlIleWindowDegistir(WebDriver driver, String hedefUrl) {

        Set<String> tumWindowWhdseti = driver.getWindowHandles();


        for (String each : tumWindowWhdseti) {

            driver.switchTo().window(each);

            if (driver.getCurrentUrl().equals(hedefUrl)) {
                break;
            }
        }
    }


    public static void titleIleWindowDegistir(WebDriver driver, String hedefTitle) {

        Set<String> tumWindowWhdseti = driver.getWindowHandles();


        for (String each : tumWindowWhdseti) {

            driver.switchTo().window(each);

            if (driver.getTitle().equals(hedefTitle)) {
                break;
            }
        }
    }


    public static void tumSayfaScreenshotIsimli(WebDriver driver, String raporIsmi) {

        // 1. adim tss objesini olusturalim
        TakesScreenshot tss = (TakesScreenshot) driver;

        // 2. adim resmi kaydedecegimiz File'i olusturalim

        File asilResim = new File("target/screenshots/" + raporIsmi + ".jpg");


        // 3. screenshot'i alip gecici bir dosya olarak kaydedelim
        File geciciDosya = tss.getScreenshotAs(OutputType.FILE);

        // gecici dosyayı asil dosyaya kaydedelim

        try {
            FileUtils.copyFile(geciciDosya, asilResim);
        } catch (IOException e) {
            System.out.println("Ekran resmi kaydedilmedi");
        }


    }


    public static void tumSayfaScreenshotTarihli(WebDriver driver) {

        LocalDateTime ldt = LocalDateTime.now();
        DateTimeFormatter formatScreen = DateTimeFormatter.ofPattern("yyMMddHHmmss");
        String tarihEtiketi = ldt.format(formatScreen);


        // 1. adim tss objesini olusturalim
        TakesScreenshot tss = (TakesScreenshot) driver;

        // 2. adim resmi kaydedecegimiz File'i olusturalim

        File asilResim = new File("target/screenshots/TumSayfaSS" + tarihEtiketi + ".jpg");


        // 3. screenshot'i alip gecici bir dosya olarak kaydedelim
        File geciciDosya = tss.getScreenshotAs(OutputType.FILE);

        // gecici dosyayı asil dosyaya kaydedelim

        try {
            FileUtils.copyFile(geciciDosya, asilResim);
        } catch (IOException e) {
            System.out.println("Ekran resmi kaydedilmedi");
        }


    }


    public static void tumSayfaScreenshotIsimVeTarihli(WebDriver driver, String isim) {

        LocalDateTime ldt = LocalDateTime.now();
        DateTimeFormatter formatScreen = DateTimeFormatter.ofPattern("yyMMddHHmmss");
        String tarihEtiketi = ldt.format(formatScreen);


        // 1. adim tss objesini olusturalim
        TakesScreenshot tss = (TakesScreenshot) driver;

        // 2. adim resmi kaydedecegimiz File'i olusturalim

        File asilResim = new File("target/screenshots/" + isim + tarihEtiketi + ".jpg");


        // 3. screenshot'i alip gecici bir dosya olarak kaydedelim
        File geciciDosya = tss.getScreenshotAs(OutputType.FILE);

        // gecici dosyayı asil dosyaya kaydedelim

        try {
            FileUtils.copyFile(geciciDosya, asilResim);
        } catch (IOException e) {
            System.out.println("Ekran resmi kaydedilmedi");
        }


    }


    public static void webElementScreenshotIsimli(WebElement targetElement, String raporIsmi) {

        // 1. adim screenshot alacagimiz webelementi locate edip kaydedelim
        // biz yukarda Logout butonunu locate ettik

        // 2. adim resmi kaydedecegimiz File'i olusturalim

        File asilResim = new File("target/screenshots/" + raporIsmi + ".jpeg");


        // 3. screenshot'i alip gecici bir dosya olarak kaydedelim
        File geciciDosya = targetElement.getScreenshotAs(OutputType.FILE);

        // gecici dosyayı asil dosyaya kaydedelim

        try {
            FileUtils.copyFile(geciciDosya, asilResim);
        } catch (IOException e) {
            System.out.println("Web elementin fotografı çekilemedi");
        }


    }


    public static void webElementScreenshotTarihli(WebElement targetElement) {


        LocalDateTime ldt = LocalDateTime.now();
        DateTimeFormatter formatScreen = DateTimeFormatter.ofPattern("yyMMddHHmmss");
        String tarihEtiketi = ldt.format(formatScreen);


        // 1. adim screenshot alacagimiz webelementi locate edip kaydedelim
        // biz yukarda Logout butonunu locate ettik

        // 2. adim resmi kaydedecegimiz File'i olusturalim

        File asilResim = new File("target/screenshots/Webelement" + tarihEtiketi + ".jpeg");


        // 3. screenshot'i alip gecici bir dosya olarak kaydedelim
        File geciciDosya = targetElement.getScreenshotAs(OutputType.FILE);

        // gecici dosyayı asil dosyaya kaydedelim

        try {
            FileUtils.copyFile(geciciDosya, asilResim);
        } catch (IOException e) {
            System.out.println("Web elementin fotografı çekilemedi");
        }


    }



    public static void webElementScreenshotTarihliVeIsimliVeTarihli(WebElement targetElement, String raporIsmi) {


        LocalDateTime ldt = LocalDateTime.now();
        DateTimeFormatter formatScreen = DateTimeFormatter.ofPattern("yyMMdd_HHmmss");
        String tarihEtiketi = ldt.format(formatScreen);


        // 1. adim screenshot alacagimiz webelementi locate edip kaydedelim
        // biz yukarda Logout butonunu locate ettik

        // 2. adim resmi kaydedecegimiz File'i olusturalim

        File asilResim = new File("target/screenshots/" + raporIsmi + "_" + tarihEtiketi + ".jpeg");


        // 3. screenshot'i alip gecici bir dosya olarak kaydedelim
        File geciciDosya = targetElement.getScreenshotAs(OutputType.FILE);

        // gecici dosyayı asil dosyaya kaydedelim

        try {
            FileUtils.copyFile(geciciDosya, asilResim);
        } catch (IOException e) {
            System.out.println("Web elementin fotografı çekilemedi");
        }


    }

    public static String getScreenshot(String name) throws IOException {
        // naming the screenshot with the current date to avoid duplication
        String date = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        // TakesScreenshot is an interface of selenium that takes the screenshot
        TakesScreenshot ts = (TakesScreenshot) Driver.getDriver();
        File source = ts.getScreenshotAs(OutputType.FILE);
        // full path to the screenshot location
        String target = System.getProperty("user.dir") + "/test-output/Screenshots/" + name + date + ".png";
        File finalDestination = new File(target);
        // save the screenshot to the path given
        FileUtils.copyFile(source, finalDestination);
        return target;
    }


}
