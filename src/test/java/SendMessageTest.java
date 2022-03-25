import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SendMessageTest {
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
    public void send() {
        driver.get("https://twitter.com/home");
        {
            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[4]/div")));
        }
        driver.findElement(By.xpath("//a[4]/div")).click();
        {
            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div/div/div/div/div[2]/div/div/div/div/div/div/span/span")));
        }
        driver.findElement(By.xpath("//div/div/div/div/div[2]/div/div/div/div/div/div/span/span")).click();
        {
            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[2]/div/div/div/div/div/div/div/div/div[2]/div/div/div/div")));
        }
        driver.findElement(By.xpath("//div[2]/div/div/div/div/div/div/div/div/div[2]/div/div/div/div")).click();
        driver.findElement(By.xpath("//div[2]/div/div/div/div/div/div/div/div/div[2]/div/div/div/div")).sendKeys("Здравствуйте, Selenium на связи");
        driver.findElement(By.xpath("//div[2]/div[3]/div")).click();
    }
}
