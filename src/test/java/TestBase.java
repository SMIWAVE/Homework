import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
public class TestBase {

    WebDriver driver = new ChromeDriver();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    String phone = "297777777";
    String sum = "10.00";

    @BeforeEach
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
        driver.navigate().to("https://www.mts.by");

        PageFactory.initElements(driver, this);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//html")));
        driver.findElement(By.id("cookie-agree")).click();
    }

    @AfterEach
    public void tearDown(){
        driver.switchTo().defaultContent();
        driver.quit();
    }

    @FindBy(xpath = "//button[@class='select__header']")
    WebElement selectButton;

    @FindBy(xpath = "//ul[@style='opacity: 1; visibility: inherit; height: auto;']")
    WebElement selectList;

    @FindBy(xpath = "//span[@class='select__now']")
    WebElement selectNow;

    @FindBy(id = "connection-phone")
    WebElement phoneField;

    @FindBy(id = "connection-sum")
    WebElement sumField;

    @FindBy(id = "internet-phone")
    WebElement phoneInternet;

    @FindBy(id = "internet-sum")
    WebElement sumInternet;

    @FindBy(id = "score-instalment")
    WebElement scoreInstalment;

    @FindBy(id = "instalment-sum")
    WebElement sumInstalment;

    @FindBy(id = "score-arrears")
    WebElement scoreArrear;

    @FindBy(id = "arrears-sum")
    WebElement sumArrear;

    @FindBy(xpath = "//iframe[@src='https://checkout.bepaid.by/widget_v2/index.html']")
    WebElement frameNext;

    @FindBy(xpath = "//iframe[@name='ya-frame-8cdcd00e']")
    WebElement frameMain;

    @FindBy(xpath = "//div[@class='content ng-tns-c47-1']/label")
    WebElement cardText;

    @FindBy(xpath = "//div[@class='content ng-tns-c47-4']/label")
    WebElement dateText;

    @FindBy(xpath = "//div[@class='content ng-tns-c47-5']/label")
    WebElement cvcText;

    @FindBy(xpath = "//div[@class='content ng-tns-c47-3']/label")
    WebElement ownerText;

    public void switchToFrame(){
        driver.switchTo().frame(frameNext);
    }

    public void fillLinesAndClick(){
        String head = selectNow.getText();
        assertEquals("Услуги связи",head,"Выбран раздел 'Услуги свзяи'");
        phoneField.sendKeys(phone);
        sumField.sendKeys(sum);
        driver.findElement(By.xpath("//form[@id='pay-connection']/button")).click();
    }

    public void navigationToList(int i){
        new Actions(driver)
                .moveToElement(selectButton)
                .click()
                .perform();
        wait.until(ExpectedConditions.visibilityOf(selectList));
        new Actions(driver)
                .moveToElement(selectList.findElement(By.xpath("./*[" + i + "]")))
                .click()
                .perform();
    }

    public void frameTest(int i,String expected,WebElement test) throws InterruptedException {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//iframe[@src='https://checkout.bepaid.by/widget_v2/index.html']")));
        driver.switchTo().frame(frameNext);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='content ng-tns-c47-" + i +"']/label")));
        Thread.sleep(Duration.ofSeconds(3).toMillis());
        assertTrue(test.isDisplayed());
        String actualText = test.getText();
        assertEquals(expected, actualText, "Не совпадает текст поля 'Номер карты'");
    }
}
