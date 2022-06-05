package practisekendim;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_HandleWindows {
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
    public void test01(){
        driver.get("https://www.amazon.com");
        String ilkSayfaHandleDeğeri=driver.getWindowHandle();

        driver.findElement(By.id("twotabsearchtextbox"))
                .sendKeys("Nutella"+ Keys.ENTER);
        WebElement ilkÜrünResmi=driver.findElement(By.xpath("(//div[@class='a-section aok-relative s-image-square-aspect'])[1]"));
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.amazon.com");
        driver.findElement(By.id("twotabsearchtextbox"))
                .sendKeys("Nutella"+ Keys.ENTER);
        driver.findElement(By.xpath("(//div[@class='a-section aok-relative s-image-square-aspect'])[1]")).click();
        WebElement ürünTitleElementi=driver.findElement(By.xpath("//span[@id='productTitle']"));
        System.out.println(ürünTitleElementi.getText());

        driver.switchTo().window(ilkSayfaHandleDeğeri);
        System.out.println(driver.getCurrentUrl());


    }
}
