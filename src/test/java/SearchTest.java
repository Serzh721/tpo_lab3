import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class SearchTest {
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
    public void search() {
        driver.get("https://twitter.com/home");
        driver.manage().window().setSize(new Dimension(1936, 1096));
        {
            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[2]/div/div[2]/span")));
        }
        driver.findElement(By.xpath("//a[2]/div/div[2]/span")).click();
        {
            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='react-root']/div/div/div[2]/main/div/div/div/div[1]/div/div[2]/div/div/section/div/div/div[3]/div/div/div/div[2]")));
        }
        driver.findElement(By.xpath("//*[@id='react-root']/div/div/div[2]/main/div/div/div/div[1]/div/div[2]/div/div/section/div/div/div[3]/div/div/div/div[2]")).click();
        assertThat(driver.findElement(By.xpath("//div[2]/div/div/a")).getText(), is("Популярное"));
    }
}
