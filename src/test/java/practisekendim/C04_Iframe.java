package practisekendim;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_Iframe {
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
        driver.get("https://the-internet.herokuapp.com/iframe");
        WebElement baslıkElementi=driver.findElement(By.xpath("//h3"));
        Assert.assertTrue(baslıkElementi.isEnabled());
        System.out.println(baslıkElementi.getText());

        WebElement iframeElementi=driver.findElement(By.id("mce_0_ifr"));
        driver.switchTo().frame(iframeElementi);
        WebElement textKutusu=driver.findElement(By.xpath("//body[@id='tinymce']"));
        textKutusu.clear();
        textKutusu.sendKeys("Merhaba Dünya");
        driver.switchTo().defaultContent();

        WebElement linkTextYazısı=driver.findElement(By.xpath("//*[text()='Elemental Selenium']"));
        Assert.assertTrue(linkTextYazısı.isDisplayed());
        System.out.println(linkTextYazısı.getText());



    }


}
