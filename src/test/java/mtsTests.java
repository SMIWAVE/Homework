import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class mtsTests {

    WebDriver driver = new ChromeDriver();
    WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));

    @BeforeEach
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
        driver.navigate().to("https://www.mts.by");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//html")));
        driver.findElement(By.id("cookie-agree")).click();
    }

    @AfterEach
    public void tearDown(){
        driver.quit();
    }

    @Test
    @DisplayName("Наличие элемента на странице")
    public void testMts(){
        String popolnenine = driver.findElement(By.xpath("//div[@class='pay__wrapper']/h2")).getText().replaceAll("\\r|\\n", " ");
        String expectedText = "Онлайн пополнение без комиссии";
        assertEquals(expectedText, popolnenine );
    }

    @Test
    @DisplayName("Наличие логотипов платежных систем")
    public void testBankIcons(){
        driver.findElement(By.xpath("//*[contains(@alt,'Visa')]"));
        driver.findElement(By.xpath("//*[contains(@alt,'Verified By Visa')]"));
        driver.findElement(By.xpath("//*[contains(@alt,'MasterCard')]"));
        driver.findElement(By.xpath("//*[contains(@alt,'MasterCard Secure Code')]"));
        driver.findElement(By.xpath("//*[contains(@alt,'Белкарт')]"));
        driver.findElement(By.xpath("//*[contains(@alt,'МИР')]"));
    }

    @Test
    @DisplayName("Подробнее о сервисе")
    public void serviceDetail(){
        driver.findElement(By.xpath("//div[@class='pay__wrapper']/a")).click();
        WebElement passElements = driver.findElement(By.xpath("//span[@itemprop='item']/span[@itemprop='name']"));
        assertEquals(true, passElements.isDisplayed(),"Раздел 'Порядок оплаты и безопасность интернет платежей'");
    }

    @Test
    @DisplayName("Кнопка 'продолжить'")
    public void buttonContinue(){
        String favor = driver.findElement((By.xpath("//span[@class='select__now']"))).getText();
        assertEquals("Услуги связи",favor,"Выбран раздел 'Услуги свзяи'");
        driver.findElement(By.id("connection-phone")).sendKeys("297777777");
        driver.findElement(By.id("connection-sum")).sendKeys("10");
        driver.findElement(By.xpath("//form[@id='pay-connection']/button")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section")));
        driver.findElement(By.xpath("//section//button"));
    }
}