import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LikePostTest {
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
    public void like() {
        driver.get("https://twitter.com/home");
        {
            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[3]/div[3]/div/div/div/div")));
        }
        WebElement webElement = driver.findElement(By.xpath("//div[3]/div[3]/div/div/div/div"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", webElement);
    }
}
