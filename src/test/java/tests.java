import io.appium.java_client.android.AndroidDriver;
import org.junit.jupiter.api.Test;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.jupiter.api.DisplayName;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import static org.testng.AssertJUnit.assertEquals;

public class tests {
    AndroidDriver<AndroidElement> driver = null;

    DesiredCapabilities capabilities = new DesiredCapabilities();

    public void initialize(){
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"Pixel 3a");
        capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE,"com.google.android.calculator");
        capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY,"com.google.android.calculator");
        capabilities.setCapability(MobileCapabilityType.NO_RESET,true);
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");

        try {
            driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        } catch(MalformedURLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    @DisplayName("Сложение")
    public void testCheckPlusCalculate(){
        initialize();
        driver.findElement(By.id("com.google.android.calculator:id/digit_3")).click();
        driver.findElement(By.id("com.google.android.calculator:id/op_add")).click();
        driver.findElement(By.id("com.google.android.calculator:id/digit_9")).click();
        driver.findElement(By.id("com.google.android.calculator:id/eq")).click();
        String actualResult = driver.findElement(By.id("com.google.android.calculator:id/result_final")).getText();
        assertEquals("12",actualResult);
    }


    @Test
    @DisplayName("Вычитание")
    public void testCheckMinusCalculate(){
        initialize();
        driver.findElement(By.id("com.google.android.calculator:id/digit_9")).click();
        driver.findElement(By.id("com.google.android.calculator:id/op_sub")).click();
        driver.findElement(By.id("com.google.android.calculator:id/digit_3")).click();
        driver.findElement(By.id("com.google.android.calculator:id/eq")).click();
        String actualResult = driver.findElement(By.id("com.google.android.calculator:id/result_final")).getText();
        assertEquals("6",actualResult);
    }

    @Test
    @DisplayName("Умножение")
    public void testCheckMultiplyCalculate(){
        initialize();
        driver.findElement(By.id("com.google.android.calculator:id/digit_9")).click();
        driver.findElement(By.id("com.google.android.calculator:id/op_mul")).click();
        driver.findElement(By.id("com.google.android.calculator:id/digit_3")).click();
        driver.findElement(By.id("com.google.android.calculator:id/eq")).click();
        String actualResult = driver.findElement(By.id("com.google.android.calculator:id/result_final")).getText();
        assertEquals("27",actualResult);
    }

    @Test
    @DisplayName("Деление")
    public void testCheckDivisionCalculate(){
        initialize();
        driver.findElement(By.id("com.google.android.calculator:id/digit_9")).click();
        driver.findElement(By.id("com.google.android.calculator:id/op_div")).click();
        driver.findElement(By.id("com.google.android.calculator:id/digit_3")).click();
        driver.findElement(By.id("com.google.android.calculator:id/eq")).click();
        String actualResult = driver.findElement(By.id("com.google.android.calculator:id/result_final")).getText();
        assertEquals("3",actualResult);
    }
}
