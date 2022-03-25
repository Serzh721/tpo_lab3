import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;

public class LoginTest {
    public WebDriver driver;

    @Before
    public void setUp() {
        Init init = new Init();
        driver = init.initWebDriver();
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void logIn() {
        driver.get("https://twitter.com/");
        {
            WebDriverWait wait = new WebDriverWait(driver, 30);
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[2]/div")));
        }
        driver.findElement(By.xpath("//a[2]/div")).click();
        {
            WebDriverWait wait = new WebDriverWait(driver, 30);
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label/div/div[2]")));
        }
        driver.findElement(By.xpath("//label/div/div[2]")).click();
        driver.findElement(By.xpath("//input[@name='session[username_or_email]']")).sendKeys("+71234569870");
        driver.findElement(By.xpath("//input[@name='session[password]']")).click();
        driver.findElement(By.xpath("//input[@name='session[password]']")).sendKeys("Passfortpo3");
        driver.findElement(By.xpath("//div[3]/div/div")).click();
        {
            WebDriverWait wait = new WebDriverWait(driver, 30);
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h2/span")));
        }
        assertThat(driver.findElement(By.xpath("//h2/span")).getText(), is("Главная"));
    }
}