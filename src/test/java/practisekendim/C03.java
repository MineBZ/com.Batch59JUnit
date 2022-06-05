package practisekendim;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03 {
     WebDriver driver;

    @Before
    public  void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }
    @After
    public void tearDown(){
       //driver.close();
    }
    @Test
    public void test01(){
        driver.get("http://automationpractice.com/index.php");
        driver.findElement(By.xpath("//a[@class='login']")).click();
        WebElement mailKutusu=driver.findElement(By.xpath("//input[@id='email_create']"));
        mailKutusu.sendKeys("mehmetgmail.com"+ Keys.ENTER);
        WebElement uyarıYazısı=driver.findElement(By.xpath("//*[text()='Invalid email address.']"));
        Assert.assertTrue(uyarıYazısı.isDisplayed());

}
}
