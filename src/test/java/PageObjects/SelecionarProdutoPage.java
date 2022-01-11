package PageObjects;

import Framework.Waits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SelecionarProdutoPage {

    private WebDriver driver;
    private Waits wait;

    public SelecionarProdutoPage(WebDriver driver) {
        wait = new Waits(driver);
        this.driver = driver;
    }

    public WebElement getHomeLabelText(){

        return driver.findElement(By.xpath("//*[@class='header_secondary_container']/span"));
    }

    public WebElement getProdutoLinkImage(){

        return  driver.findElement(By.id("item_4_title_link"));
    }

    /* Essa e a forma de mapear o botao add do item
    public WebElement getProduto04() {
        return driver.findElement(By.xpath("//div[@class='pricebar']/button[contains(@class, btn_primary)]"
                + "//parent::div//parent::div//parent::div[@class='inventory_item_img']/a[@id='item_4_img_link']"
                + "//parent::div//parent::div/div[@class='pricebar']//button[contains(@class, btn_primary)]"));
    }*/

    /*caso faca pelo add esse e o mapeamento do cart
    public WebElement getCartButton() {
        return wait.visibilityOfElement(By.xpath("//div[@id='shopping_cart_container']"
                + "/a[@class='shopping_cart_link fa-layers fa-fw']"));
    }*/

    /* Esse é o mapeamento do botao add carrinho quando seleciona imagem ou label que vai para proxima tela */



}
