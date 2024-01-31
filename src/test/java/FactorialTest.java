import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

public class FactorialTest {

    Random random = new Random(100);

    @Test
    @DisplayName("����������� ��������")
    public void factorialWork(){
        int randomNumber = Math.abs(random.nextInt(100));
        Factorial facTest = new Factorial(randomNumber);
        assertTrue(facTest.getFactor() >= 1);
    }

    @Test
    @DisplayName("��������� ����")
    public void factorialZero(){
        Factorial facTest = new Factorial(0);
        assertTrue(facTest.getFactor() == 1);
    }

    @Test
    @DisplayName("��������� ��� �������������� �����")
    public void factorialNegative(){
        assertThrows(ArithmeticException.class, () -> {
            Factorial facTest = new Factorial(-2);
        });
    }

}
