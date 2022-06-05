package practisekendim;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_HandleWindows {
    WebDriver driver;
    @Before
    public void setUp(){
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
    public void test01() throws InterruptedException {
        driver.get("https://www.amazon.com");
        String ilkSayfaHandeDeğeri=driver.getWindowHandle();
        String istenenKelime="amazon";
        String actualUrl=driver.getCurrentUrl();
        Assert.assertTrue(actualUrl.contains(istenenKelime));
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.bestbuy.com");
        String ikinciSayfaWindowHandleDeğeri=driver.getWindowHandle();
        String actualTittel=driver.getTitle();
        String arananKelime="Best Buy";
        Assert.assertTrue(actualTittel.contains(arananKelime));
        driver.switchTo().window(ilkSayfaHandeDeğeri);
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Java"+ Keys.ENTER);
        WebElement aramaSonucYazısıElementi=driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        String sonucYazısıStr=aramaSonucYazısıElementi.getText();
        String aradığımızKelime="Java";
        Assert.assertTrue(sonucYazısıStr.contains(aradığımızKelime));
        driver.switchTo().window(ikinciSayfaWindowHandleDeğeri);
        WebElement logoElementi=driver.findElement(By.xpath("(//img[@class='logo'])[1]"));
        Assert.assertTrue(logoElementi.isDisplayed());







        Thread.sleep(5000);

}
}
