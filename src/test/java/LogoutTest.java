import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class LogoutTest {
    public WebDriver driver;

    @Before
    public void setUp() {
        Init init = new Init();
        driver = init.initWebDriver();
        init.login();
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void logOut() {
        driver.get("https://twitter.com/home");
        {
            WebDriverWait wait = new WebDriverWait(driver, 30);
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[2]/div/div/div/div/div[2]")));
        }
        driver.findElement(By.xpath("//div[2]/div/div/div/div/div[2]")).click();
        {
            WebDriverWait wait = new WebDriverWait(driver, 30);
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[2]/div/div/span/span")));
        }
        driver.findElement(By.xpath("//a[2]/div/div/span/span")).click();
        driver.findElement(By.xpath("//div[2]/div/span/span")).click();
    }
}