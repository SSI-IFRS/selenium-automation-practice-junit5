package TestCases;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class AcessaEditalIFRS {

    private static WebDriver driver;

    @BeforeAll
    public static void setUp() {
        AcessaEditalIFRS.driver = new ChromeDriver();
    }

    @AfterAll
    public static void tearDown() {
        driver.quit();
    }

    @Test
    @SuppressWarnings("checkstyle:magicnumber")
    public void web() {
        AcessaEditalIFRS.driver.get("https://ifrs.edu.br/");
        AcessaEditalIFRS.driver.manage().window().setSize(new Dimension(1440, 877));
        AcessaEditalIFRS.driver.findElement(By.linkText("Editais")).click();
        List<WebElement> elements = driver.findElements(By.cssSelector(".editais__title"));
        assert elements.size() > 0;
    }
}
