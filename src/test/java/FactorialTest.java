import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Random;

public class FactorialTest {

    Random random = new Random(100);

    @Test(description = "Конструктор работает")
    public void factorialWork(){
        int randomNumber = Math.abs(random.nextInt(100));
        Factorial facTest = new Factorial(randomNumber);
        Assert.assertTrue(facTest.getFactor() >= 1);
    }

    @Test(description = "Факториал нуля")
    public void factorialZero(){
        Factorial facTest = new Factorial(0);
        Assert.assertTrue(facTest.getFactor() == 1);
    }

    @Test(description = "Факториал для отрицательного числа")
    public void factorialNegative(){
        Assert.assertThrows(ArithmeticException.class, () -> {
            Factorial facTest = new Factorial(-2);
        });
    }

}
