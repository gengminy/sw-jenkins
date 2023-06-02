import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;

import java.util.*;

public class SeleniumTest1Test {
    private WebDriver driver;
    private Map<String, Object> vars;
    JavascriptExecutor js;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        js = (JavascriptExecutor) driver;
        vars = new HashMap<String, Object>();  // provides a way to share data or pass information between different parts of the test
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void hongik5() throws InterruptedException {
        driver.get("https://www.hongik.ac.kr/index.do");
        driver.manage().window().setSize(new Dimension(1552, 840));
        driver.findElement(By.linkText("대학/대학원")).click();
        driver.findElement(By.linkText("컴퓨터공학과")).click();
        driver.findElement(By.linkText("대학소개")).click();

        driver.navigate().to("https://www.google.com");
        Thread.sleep(1000);
        driver.get("https://www.selenium.dev/"); // driver.navigate().to("https://www.selenium.dev/");
        Thread.sleep(2000);

        driver.navigate().to("https://www.google.com");
        Thread.sleep(1000);

        driver.findElement((By.name("q"))).sendKeys("Hongik University", Keys.ENTER);
        Thread.sleep(3000);

        driver.navigate().back();
        Thread.sleep(1000);

        WebElement button = driver.findElement(By.name("btnI"));
        js.executeScript("arguments[0].click();", button);
        Thread.sleep(3000);
    }
}
