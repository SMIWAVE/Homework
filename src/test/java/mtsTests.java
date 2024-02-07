import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
public class mtsTests extends TestBase{

    @Test
    @DisplayName("Наличие элемента на странице")
    public void testMts(){
        String popolnenine = driver.findElement(By.xpath("//div[@class='pay__wrapper']/h2")).getText().replaceAll("[\\r\\n]", " ");
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
        assertTrue(passElements.isDisplayed(), "Раздел 'Порядок оплаты и безопасность интернет платежей'");
    }

    @Test
    @DisplayName("Кнопка 'продолжить'")
    public void buttonContinue(){
        fillLinesAndClick();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//iframe[@src='https://checkout.bepaid.by/widget_v2/index.html']")));
        driver.switchTo().frame(frameNext);
    }

    @Test
    @DisplayName("Проверка надписей полей'Услуги свзяи'")
    public void favorConnection(){
        String head = selectNow.getText();
        assertEquals("Услуги связи",head,"Выбран раздел 'Услуги свзяи'");
        String number = phoneField.getAttribute("placeholder");
        assertEquals("Номер телефона", number,"Текст поля 'номер телефона");
        String sum = sumField.getAttribute("placeholder");
        assertEquals("Сумма",sum,"Текст поля 'Сумма'");
    }

    @Test
    @DisplayName("Проверка надписей полей 'Домашний интернет'")
        public void homeInternet(){
        navigationToList(2);
        String head = selectNow.getText();
        assertEquals("Домашний интернет",head,"Выбран раздел 'Домашний интернет'");
        String number = phoneInternet.getAttribute("placeholder");
        assertEquals("Номер абонента",number,"Текст поля 'Номер абонента");
        String sum = sumInternet.getAttribute("placeholder");
        assertEquals("Сумма",sum,"Текст поля 'Сумма'");
    }

    @Test
    @DisplayName("Проверка надписей полей 'Рассрочка'")
        public void installment(){
        navigationToList(3);
        String head = selectNow.getText();
        assertEquals("Рассрочка",head,"Выбран раздел 'Рассрочка'");
        String number = scoreInstalment.getAttribute("placeholder");
        assertEquals("Номер счета на 44",number,"Текст поля 'Номер счета на 44");
        String sum = sumInstalment.getAttribute("placeholder");
        assertEquals("Сумма",sum,"Текст поля 'Сумма'");
    }

    @Test
    @DisplayName("Проверка надписей полей 'Рассрочка'")
    public void arrear(){
        navigationToList(4);
        String head = selectNow.getText();
        assertEquals("Задолженность",head,"Выбран раздел 'Задолженность'");
        String number = scoreArrear.getAttribute("placeholder");
        assertEquals("Номер счета на 2073",number,"Текст поля 'Номер счета на 2073");
        String sum = sumArrear.getAttribute("placeholder");
        assertEquals("Сумма",sum,"Текст поля 'Сумма'");
    }

    @Test
    @DisplayName("Проверка текста поля 'Номер карты'")
    public void framePaidTest() throws InterruptedException {
        fillLinesAndClick();
        frameTest(1,"Номер карты",cardText);
    }

    @Test
    @DisplayName("Проверка текста поля 'Срок действия'")
    public void frameDateTest() throws InterruptedException {
        fillLinesAndClick();
        frameTest(4,"Срок действия",dateText);
    }

    @Test
    @DisplayName("Проверка текста поля 'CVC'")
    public void cvcDateTest() throws InterruptedException {
        fillLinesAndClick();
        frameTest(5, "CVC", cvcText);
    }

    @Test
    @DisplayName("Проверка текста поля 'Имя держателя (как на карте)'")
    public void ownerTest() throws InterruptedException {
        fillLinesAndClick();
        frameTest(3, "Имя держателя (как на карте)", ownerText);
    }

    @Test
    @DisplayName("Проверка отображения корректной суммы")
    public void sumTest() throws InterruptedException {
        fillLinesAndClick();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//iframe[@src='https://checkout.bepaid.by/widget_v2/index.html']")));
        driver.switchTo().frame(frameNext);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@class='colored disabled ng-star-inserted']")));
        Thread.sleep(Duration.ofSeconds(3).toMillis());
        String buttonText = driver.findElement(By.xpath("//button[@class='colored disabled ng-star-inserted']")).getText();
        assertEquals("Оплатить " + sum + " BYN", buttonText, "Не совпадает текст кнопки 'Номер карты'");
        String sumText = driver.findElement(By.xpath("//p[@class='header__payment-amount']")).getText();
        assertEquals(sum + " BYN", sumText, "Не совпадает текст кнопки 'Номер карты'");
    }

    @Test
    @DisplayName("Проверка отображения номера телефона")
    public void phoneText() throws InterruptedException {
        fillLinesAndClick();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//iframe[@src='https://checkout.bepaid.by/widget_v2/index.html']")));
        driver.switchTo().frame(frameNext);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//p[@class='header__payment-info']")));
        Thread.sleep(Duration.ofSeconds(3).toMillis());
        String phoneText = driver.findElement(By.xpath("//p[@class='header__payment-info']")).getText().replaceAll("[\\r\\n]", " ");
        assertEquals( "Оплата: Услуги связи Номер:375" + phone, phoneText, "Не совпадает текст кнопки 'Номер карты'");
    }

    @Test
    @DisplayName("Проверка платежных систем")
    public void paySystem() throws InterruptedException {
        fillLinesAndClick();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//iframe[@src='https://checkout.bepaid.by/widget_v2/index.html']")));
        driver.switchTo().frame(frameNext);
        Thread.sleep(Duration.ofSeconds(3).toMillis());
        driver.findElement(By.xpath("//img[@src='assets/images/payment-icons/card-types/mastercard-system.svg']"));
        driver.findElement(By.xpath("//img[@src='assets/images/payment-icons/card-types/visa-system.svg']"));
        driver.findElement(By.xpath("//img[@src='assets/images/payment-icons/card-types/belkart-system.svg']"));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//img[@src='assets/images/payment-icons/card-types/mir-system-ru.svg']")));
        driver.findElement(By.xpath("//img[@src='assets/images/payment-icons/card-types/mir-system-ru.svg']"));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//img[@src='assets/images/payment-icons/card-types/maestro-system.svg']")));
        driver.findElement(By.xpath("//img[@src='assets/images/payment-icons/card-types/maestro-system.svg']"));
    }
}