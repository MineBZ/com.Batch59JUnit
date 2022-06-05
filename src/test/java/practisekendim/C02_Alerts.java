package practisekendim;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_Alerts {
    static WebDriver driver;

    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        // https://the-internet.herokuapp.com/javascript_alerts adresine gidin.
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
    }

    @AfterClass
    public static void tearDown(){
        //driver.quit();
    }


   @Test
   public void acceptAlert() {
       //● Bir metod olusturun: acceptAlert
       //		○ 1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve result mesajının
       //		“You successfully clicked an alert” oldugunu test edin.

       driver.findElement(By.xpath("//*[text()='Click for JS Alert']")).click();
       driver.switchTo().alert().accept();
       String expectedResultYazisi = "You successfully clicked an alert";
       WebElement sonucYaziElementi = driver.findElement(By.xpath("//*[text()='You successfully clicked an alert']"));
       String actualResultYazisi = sonucYaziElementi.getText();
       Assert.assertEquals(expectedResultYazisi, actualResultYazisi);
   }
   @Test
    public void dismissAlert(){
        driver.findElement(By.xpath("//*[text()='Click for JS Confirm']")).click();
       driver.switchTo().alert().dismiss();
       String istenmeyenKelime="successfuly";
       WebElement sonucYaziElementi=driver.findElement(By.xpath("//p[@id='result']"));
       String actualSonucYazisi=sonucYaziElementi.getText();
       Assert.assertFalse(actualSonucYazisi.contains(istenmeyenKelime));



   }
   @Test
    public void test03(){
        driver.findElement(By.xpath("//*[text()='Click for JS Prompt']")).click();
        driver.switchTo().alert().sendKeys("mine");
        driver.switchTo().alert().accept();
        WebElement sonucYaziElementi=driver.findElement(By.xpath("//p[@id='result']"));
        String sonucYazısıStr=sonucYaziElementi.getText();
        String girilenIsim="mine";
        Assert.assertTrue(sonucYazısıStr.contains(girilenIsim));
   }

   }




