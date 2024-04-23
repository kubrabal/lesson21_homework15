import com.github.kubrabal.Property;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ButtonsTest {

    Property property = new Property();
    static WebDriver driver = new ChromeDriver();

    @BeforeAll
    public static void openUrl() {
        driver.get("https://demoqa.com/elements");
    }

    @Test
    public void clickButtons() {
        WebElement buttons = driver.findElement(By.xpath("//*[@id='item-4']"));
        buttons.click();

        WebElement clickMeButton = driver.findElement(By.xpath("//button[starts-with(text(), 'Click')]"));
        clickMeButton.click();

        WebElement dynamicMessage = driver.findElement(By.xpath("//*[@id='dynamicClickMessage']"));
        System.out.println(dynamicMessage.getText());
    }

    @AfterAll
    public static void closeConnection() {
        driver.close();
    }
}