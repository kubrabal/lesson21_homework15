import com.github.kubrabal.Property;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AddRecordTest {

    Property property = new Property();
    static WebDriver driver = new ChromeDriver();


    @BeforeAll
    public static void openUrl() {
        driver.get("https://demoqa.com/webtables");
    }

    @Test
    public void addRecord() {
        WebElement addButton = driver.findElement(By.xpath("//*[@id='addNewRecordButton']"));
        addButton.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='registration-form-modal']")));

        WebElement firstNameField = driver.findElement(By.xpath("//*[@id='firstName']"));
        firstNameField.sendKeys("Joh");

        WebElement lastNameField = driver.findElement(By.xpath("//*[@id='lastName']"));
        lastNameField.sendKeys("Doe");

        WebElement emailField = driver.findElement(By.xpath("//*[@id='userEmail']"));
        emailField.sendKeys("john.doe@email.com");

        WebElement ageField = driver.findElement(By.xpath("//*[@id='age']"));
        ageField.sendKeys("25");

        WebElement salaryField = driver.findElement(By.xpath("//*[@id='salary']"));
        salaryField.sendKeys("35000");

        WebElement departmentField = driver.findElement(By.xpath("//*[@id='department']"));
        departmentField.sendKeys("Sales");

        WebElement submitButton = driver.findElement(By.xpath("//*[@id='submit']"));
        submitButton.click();

        WebElement editButton = driver.findElement(By.xpath("//*[@id='edit-record-4']"));
        editButton.click();

        WebElement updatedFirstNameField = driver.findElement(By.xpath("//*[@id='firstName']"));
        updatedFirstNameField.clear();
        updatedFirstNameField.sendKeys("John");

        WebElement updateSubmitButton = driver.findElement(By.xpath("//*[@id='submit']"));
        updateSubmitButton.click();
    }

    @AfterAll
    public static void closeConnection() {
        driver.close();
    }
}
