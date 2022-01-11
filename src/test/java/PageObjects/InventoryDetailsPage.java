package PageObjects;

import Framework.Waits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class InventoryDetailsPage {

    private WebDriver driver;
    private Waits wait;

    public InventoryDetailsPage(WebDriver driver) {
        wait = new Waits(driver);
        this.driver = driver;
    }

    public WebElement getCartButton() {
        return wait.visibilityOfElement(By.id("shopping_cart_container"));
    }

    public WebElement getAddCartButton() {

        return this.driver.findElement(By.xpath("//button[starts-with(@id, 'add-to-cart-sauce-labs')]"));
    }

    public WebElement getProductCarLabel() {

        return this.driver.findElement(By.className("inventory_details_name"));
    }

}
