package Wildberries;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
public class WildberriesTests extends MainPage {

    @Test
    @DisplayName("Переход в корзину")
    public void addToBasket() {
        wait.until(ExpectedConditions.visibilityOf(itemOnPageButton));
        itemOnPageButton.click();
        checkSizeButton();
        wait.until(ExpectedConditions.invisibilityOf(unpressedButton));
        basketButton.click();
        assertEquals("https://www.wildberries.ru/lk/basket",driver.getCurrentUrl(),"Не открыта страница корзины");
    }

    @Test
    @DisplayName("Соответствие названий товаров в корзине")
    public void multipleItemsInBasket(){
        compareNamesInBasket(4);
    }
}
