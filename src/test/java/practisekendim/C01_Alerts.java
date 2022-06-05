package practisekendim;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_Alerts {
    WebDriver driver;
    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @After
    public void tearDown(){
        //driver.quit();
    }
   @Test
   public void test01(){

       driver.get("https://the-internet.herokuapp.com/javascript_alerts ");
       driver.findElement(By.xpath("//*[text()='Click for JS Alert']")).click();
       driver.switchTo().alert().accept();

       String expectedResult="You successfully clicked an alert";
        WebElement sonucaYazısıElementi=driver.findElement(By.xpath("//p[@id='result']"));
        String actualResult=sonucaYazısıElementi.getText();
       Assert.assertEquals(expectedResult,actualResult);


   }
}
