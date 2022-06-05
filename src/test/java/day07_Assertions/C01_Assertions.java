package day07_Assertions;

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

public class C01_Assertions {


    /*
    amazon ana sayfaya gidin
    3 farkli test method'u olusturarak asagidaki gorevleri yapin
    1- Url'in amazon icerdigini test edin
    2- title'in facebook icermedigini test edin
    3- sol ust kosede amazon logosunun gorundugunu test edin
     */
    static WebDriver driver;


    @BeforeClass
    public static void setup() {
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.amazon.com");


    }
    @AfterClass
    public  static void tearDown(){
        driver.close();

    }
    // 1- Url'in amazon icerdigini test edin
    @Test
    public void test01(){

        String arananKelime="amazon";
        String actualUrl=driver.getCurrentUrl();
        Assert.assertTrue(actualUrl.contains(arananKelime));
    }
    // 2- title'in facebook icermedigini test edin
    @Test
    public void test02(){
        String istenmeyenKelime="facebook";
        String actualTitle=driver.getTitle();
        Assert.assertFalse(actualTitle.contains(istenmeyenKelime));

    }
    // 3- sol ust kosede amazon logosunun gorundugunu test edin
    @Test
    public void test03(){
        WebElement logoElementi=driver.findElement(By.id("nav-logo-sprites"));
        Assert.assertTrue(logoElementi.isDisplayed());
    }


}
