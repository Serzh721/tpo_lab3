import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertTrue;

public class RegistrationTest {
    private WebDriver driver;

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
    public void signUp() {
        driver.get("https://twitter.com/");
        {
            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a/div/span/span")));
        }
        driver.findElement(By.xpath("//a/div/span/span")).click();
        {
            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@name='name']")));
        }
        driver.findElement(By.xpath("//input[@name='name']")).sendKeys("Сергей");
        driver.findElement(By.xpath("//input[@name='phone_number']")).click();
        driver.findElement(By.xpath("//input[@name='phone_number']")).sendKeys("+79112233444");
        driver.findElement(By.xpath("//select[@id='Месяц']")).click();
        {
            WebElement dropdown = driver.findElement(By.id("Месяц"));
            dropdown.findElement(By.xpath("//option[. = 'января']")).click();
        }
        driver.findElement(By.xpath("//select[@id='Месяц']")).click();
        driver.findElement(By.xpath("//select[@id='День']")).click();
        {
            WebElement dropdown = driver.findElement(By.id("День"));
            dropdown.findElement(By.xpath("//option[. = '1']")).click();
        }
        driver.findElement(By.xpath("//select[@id='День']")).click();
        driver.findElement(By.xpath("//select[@id='Год']")).click();
        {
            WebElement dropdown = driver.findElement(By.id("Год"));
            dropdown.findElement(By.xpath("//option[. = '2001']")).click();
        }
        driver.findElement(By.xpath("//select[@id='Год']")).click();
        driver.findElement(By.xpath("//span/span")).click();
        driver.findElement(By.xpath("//span/span")).click();
        {
            boolean element = driver.findElement(By.xpath("//div[5]/div")).isDisplayed();
            assertTrue(element);
        }
    }
}