import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Init {
    public final Properties property = new Properties();
    public WebDriver driver;

    public Init() {
        try {
            FileInputStream fileInputStream = new FileInputStream("src/test/resources/config.properties");
            property.load(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public WebDriver initWebDriver() {
        if (property.getProperty("main.driver").equals("CHROME")) {
            System.setProperty("webdriver.chrome.driver", "C:\\Selenium_Drivers\\chromedriver.exe");
            driver = new ChromeDriver();
        } else if (property.getProperty("main.driver").equals("FIREFOX")) {
            System.setProperty("webdriver.firefox.driver", "geckodriver");
            driver = new FirefoxDriver();
        }
        return driver;
    }

    public void login() {
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
    }
}