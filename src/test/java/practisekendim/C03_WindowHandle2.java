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
import java.util.Set;

public class C03_WindowHandle2 {
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
        driver.quit();
    }
    @Test
    public void test01() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/windows");
        WebElement sayfadakiYazıElementi=driver.findElement(By.xpath("//h3"));
        String expectedYazı="Opening a new window";
        String actualYazıElementi=sayfadakiYazıElementi.getText();
        Assert.assertEquals(expectedYazı,actualYazıElementi);
        String expectedTitle="The Internet";
        String actualTitle=driver.getTitle();
        Assert.assertEquals(expectedTitle,actualTitle);
        String ilkSayfaWindowHandleDeğeri=driver.getWindowHandle();
        System.out.println(ilkSayfaWindowHandleDeğeri);


        driver.findElement(By.linkText("Click Here")).click();

        Set<String> windowHandleSeti=driver.getWindowHandles();
        System.out.println(windowHandleSeti);

        String ikinciSayfaWindowHandleDeğeri="";
        for (String each:windowHandleSeti
             ) {
            if (!each.equals(ilkSayfaWindowHandleDeğeri)){
              ikinciSayfaWindowHandleDeğeri=each;

            }
            
        }


        driver.switchTo().window(ikinciSayfaWindowHandleDeğeri);
        String expectedİkinciTitle="New Window";
        String actualİkinciTitle=driver.getTitle();
        Assert.assertEquals(expectedİkinciTitle,actualİkinciTitle);

        WebElement ikinciSayfaYazıElementi=driver.findElement(By.xpath("//h3"));
        String expectedikinciYazı="New Window";
        String actualİkinciYazı=ikinciSayfaYazıElementi.getText();
        Assert.assertEquals(expectedikinciYazı,actualİkinciYazı);
        driver.switchTo().window(ilkSayfaWindowHandleDeğeri);
        expectedTitle="The Internet";
         actualTitle=driver.getTitle();
         Assert.assertEquals(expectedTitle,actualTitle);





}
}
