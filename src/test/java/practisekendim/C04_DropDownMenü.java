package practisekendim;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class C04_DropDownMenü {
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
    public void test01() throws InterruptedException {
    driver.get("https://www.amazon.com");
    WebElement dropDownMenü=driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        Select select=new Select(dropDownMenü);
        select.selectByVisibleText("Books");
        WebElement aramaKutusu=driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Java"+ Keys.ENTER);
        Thread.sleep(3000);

        WebElement sonucYazısıElementi=driver.findElement(By.xpath("(//div[@class='a-section a-spacing-small a-spacing-top-small'])[1]"));
        String sonucYazısıElementiStr=sonucYazısıElementi.getText();
        String arananKelime="Java";
        Assert.assertTrue(sonucYazısıElementiStr.contains(arananKelime));




}
}
