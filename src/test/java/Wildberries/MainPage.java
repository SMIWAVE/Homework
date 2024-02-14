package Wildberries;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class MainPage {

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected String url = "https://www.wildberries.ru";

    @FindBy(xpath = "//article[normalize-space(@data-card-index)='0']//a[contains(@data-link,'btn-base')]")
    WebElement itemOnPageButton;

    @FindBy(xpath = "//a[@data-wba-header-name='Cart']")
    WebElement basketButton;

    @FindBy(xpath = "//article[@data-card-index='0']//span[@class='btn-icon__white']")
    WebElement unpressedButton;

    @FindBy(xpath = "//body[@class='ru body-gray']")
    WebElement basketPage;

    @FindBy(xpath = "//li[@class='sizes-list__item'][1]")
    WebElement sizeButton;

    @FindBy(xpath = "//div[@class='popup popup-list-of-sizes shown slideUp']")
    WebElement sizeButtonsList;

    @FindBy(xpath = "//p[@class='b-top__total line']//span[2]")
    WebElement totalBasketPrice;


    @BeforeEach
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
        var option = new ChromeOptions();
        option.addArguments("--start-maximized");
        driver = new ChromeDriver(option);
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        PageFactory.initElements(driver, this);
        driver.navigate().to(url);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//html")));
    }

    @AfterEach
    public void tearDown(){
        driver.quit();
    }

    public void checkSizeButton(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
        List<WebElement> sizeButtons = driver.findElements(By.xpath("//li[@class='sizes-list__item']"));
        if (!sizeButtons.isEmpty()){
            new Actions(driver)
                    .moveToElement(sizeButton)
                    .click()
                    .perform();
            wait.until(ExpectedConditions.invisibilityOf(sizeButtonsList));
            driver.manage().timeouts().implicitlyWait(Duration.ZERO);
        }
    }

    public void compareNamesInBasket(int i) {
        wait.until(ExpectedConditions.visibilityOf(itemOnPageButton));
        List<WebElement> itemBasket = new ArrayList<>();
        List<WebElement> itemMainPage = new ArrayList<>();
        List<WebElement> basketPrices = new ArrayList<>();
        for (int w = 0; w < i; w++) {
            WebElement basketItem = driver.findElement(By.xpath("//article[@data-card-index='" + w + "']//a[@draggable='false']"));
            WebElement itemButton = driver.findElement(By.xpath("//article[@data-card-index='" + w + "']//a[@class='product-card__add-basket j-add-to-basket btn-main']"));
            itemMainPage.add(basketItem);
            wait.until(ExpectedConditions.visibilityOf(itemButton));
            new Actions(driver)
                    .moveToElement(itemButton)
                    .click()
                    .perform();
            checkSizeButton();
        }
        basketButton.click();
        wait.until(ExpectedConditions.visibilityOf(basketPage));
        for (int w = 0; w < i; w++) {
            int a = w + 1;
            int b = i - a;
            WebElement basketItem = driver.findElement(By.xpath("//div[@class='accordion__list']//div[@class='accordion__list-item list-item j-b-basket-item'][" + a + "]"));
            itemBasket.add(basketItem);
            String actualLine = itemBasket.get(w).getAttribute("innerText");
            String actual = actualLine.split("\n")[0].replace(",", "").replaceAll("\\s+", " ").replaceAll("\\.", "").replaceAll("/", " ").replaceAll("MOMI", "").trim();
            if (actual.equals("Неотказной товар")) {
                String actualTrue = actualLine.split("\n")[1].replace(",", "").replaceAll("\\s+", " ").replaceAll("\\.", "").replaceAll("/", " ").replaceAll("MOMI", "").trim();
                String expectedLine = itemMainPage.get(b).getAttribute("aria-label");
                String expected = expectedLine.replace(",", "").replaceAll("\\s+", " ").replaceAll("\\.", "").replaceAll("/", " ").trim();
                assertEquals(actualTrue, expected, "Описание позиций в корзине не совпадает");
            } else {
                String expectedLine = itemMainPage.get(b).getAttribute("aria-label").trim();
                String expected = expectedLine.replace(",", "").replaceAll("\\s+", " ").replaceAll("\\.", "").replaceAll("/", " ").trim();
                assertEquals(expected, actual, "Описание позиций в корзине не совпадает");
            }
        }
//        int sum = 0;
//        for (int w = 0; w < i; w++) {
//            int a = w + 1;
//            WebElement basketItemPrice = driver.findElement(By.xpath("//div[@class='accordion__list']//div[@class='accordion__list-item list-item j-b-basket-item'][" + a + "]//div[@class='list-item__price-new']"));
//            basketPrices.add(basketItemPrice);
//            String itemBasketPrice = basketPrices.get(w).getAttribute("innerText").replaceAll("\\.", "").replaceAll("/", "").replaceAll("₽", "").replaceAll(" ", "").replaceAll("\\s+$", "").replaceAll("\\s+", "").replaceAll("\\p{C}", "").trim();
//            itemBasketPrice = itemBasketPrice.replace("\u00A0", "");
//            int itemBasketPriceValue = Integer.parseInt(itemBasketPrice);
//            sum = sum + itemBasketPriceValue;
//            if (w == i - 1){
//                String total = totalBasketPrice.getText().replaceAll("\\s+", "").replaceAll("\\.", "").replaceAll("/", "").replaceAll("₽", "").replaceAll(" ", "").replaceAll("\\s+$", "").replaceAll("\\p{C}", "").trim();
//                total = total.replace(" ", "");
//                int totalSum = Integer.parseInt(total);
//                assertEquals(sum,totalSum,"Сумма товаров в корзине не совпадает со значением 'Итого'");
//            }
//        }
    }
}
