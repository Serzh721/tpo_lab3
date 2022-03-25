import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertTrue;

public class PasswordRecoveryTest {
    public WebDriver driver;
    public Map<String, Object> vars;

    @Before
    public void setUp() {
        Init init = new Init();
        driver = init.initWebDriver();
        vars = new HashMap<String, Object>();
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void recover() {
//        driver.get("https://twitter.com");
//        vars.put("root", driver.getWindowHandle());
//        driver.switchTo().window(vars.get("root").toString());
//        {
//            WebDriverWait wait = new WebDriverWait(driver, 30);
//            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[2]/div")));
//        }
//        driver.findElement(By.xpath("//a[2]/div")).click();
//        {
//            WebDriverWait wait = new WebDriverWait(driver, 30);
//            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a/span")));
//        }
//        driver.findElement(By.xpath("//a/span")).click();
//        driver.findElement(By.xpath("//input[@name='account_identifier']")).sendKeys("sergeykrivosheykin@gmail.com");
//        driver.findElement(By.xpath("//input[@value='Поиск']")).click();
//        driver.findElement(By.xpath("(//input[@name='method'])[2]")).click();
//        driver.findElement(By.xpath("//input[@value='Далее']")).click();
//        driver.findElement(By.xpath("//body")).click();
//        assertThat(driver.findElement(By.xpath("//p")).getText(), is("Вы получите код подтверждения, который нужно будет ввести здесь, чтобы сбросить пароль."));

        driver.get("https://twitter.com/");
        {
            WebDriverWait wait = new WebDriverWait(driver, 30);
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[2]/div")));
        }
        driver.findElement(By.xpath("//a[2]/div")).click();
        {
            WebDriverWait wait = new WebDriverWait(driver, 30);
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a/span")));
        }
        driver.findElement(By.xpath("//a/span")).click();
        driver.findElement(By.xpath("//input[@name='account_identifier']")).click();
        driver.findElement(By.xpath("//input[@name='account_identifier']")).sendKeys("sergeykrivosheykin@gmail.com");
        {
            boolean element = driver.findElement(By.xpath("//input[@value='Поиск']")).isDisplayed();
            assertTrue(element);
        }
    }
}