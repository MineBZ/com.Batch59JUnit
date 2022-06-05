package practisekendim;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02 {
    static WebDriver driver;

    @BeforeClass
    public static void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.bestbuy.com/");
    }
    @AfterClass
    public static void tearDown(){

    }
    @Test
    public void test01(){

        String expectedUrl="https://www.bestbuy.com/";
        String actualUrl=driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl,actualUrl);

    }@Test
    public void test02(){
        String istenmeyenKelime="Rest";
        String actualTitle=driver.getTitle();
        Assert.assertFalse(actualTitle.contains(istenmeyenKelime));
    }
    @Test
    public void Test03(){
        WebElement logoElementi=driver.findElement(By.xpath("(//img[@class='logo'])[1]"));
        Assert.assertTrue(logoElementi.isDisplayed());

    }
    @Test
    public void Test04(){
        WebElement franchiseElementi=driver.findElement(By.xpath("//*[text()='Français']"));
        Assert.assertTrue(franchiseElementi.isDisplayed());
    }



}
