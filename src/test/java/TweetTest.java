import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TweetTest {
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
    public void tweet() {
        driver.get("https://twitter.com/home");
        {
            WebDriverWait wait = new WebDriverWait(driver, 30);
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains(@href, '/compose/tweet')]")));
        }
        driver.findElement(By.xpath("//a[contains(@href, '/compose/tweet')]")).click();
//        driver.findElement(By.cssSelector("div:nth-child(4) .css-18t94o4:nth-child(3) > .css-901oao > .r-13gxpu9")).click();
        driver.findElement(By.xpath("//*[@id='layers']/div[2]/div/div/div/div/div/div[2]/div[2]/div/div[3]/div/div/div/div[1]/div/div/div/div/div[2]/div[4]/div/div/div[1]/div[2]")).click();
        {
            WebDriverWait wait = new WebDriverWait(driver, 30);
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@value='']")));
        }
        driver.findElement(By.xpath("//input[@value='']")).sendKeys("cool");
        {
            WebDriverWait wait = new WebDriverWait(driver, 30);
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//img[@alt='Emmy Amy Poehler GIF']")));
        }
        driver.findElement(By.xpath("//img[@alt='Emmy Amy Poehler GIF']")).click();
        {
            WebDriverWait wait = new WebDriverWait(driver, 30);
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='layers']/div[2]/div/div/div/div/div/div[2]/div[2]/div/div[3]/div/div/div/div[1]/div/div/div/div/div[2]/div[4]/div/div/div[2]/div[4]")));
        }
        driver.findElement(By.xpath("//*[@id='layers']/div[2]/div/div/div/div/div/div[2]/div[2]/div/div[3]/div/div/div/div[1]/div/div/div/div/div[2]/div[4]/div/div/div[2]/div[4]")).click();
    }
}
