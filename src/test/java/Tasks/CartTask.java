package Tasks;

import Framework.Report;
import Framework.Screenshot;
import PageObjects.CartPage;
import PageObjects.InformationPage;
import com.aventstack.extentreports.Status;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class CartTask {

    private static WebDriver driver;
    private static InformationPage informationPage;
    private static CartPage carrinhoPage;

    public CartTask(WebDriver driver) {

        this.driver = driver;
        informationPage = new InformationPage(this.driver);
        carrinhoPage = new CartPage(this.driver);
    }

    public void realizarChekout() throws IOException {

        validaItemCarrinho();
        carrinhoPage.getCheckoutButton().click();
        validaPageInformacoes();
    }

    private void validaItemCarrinho() throws IOException {
        try{
            Assertions.assertTrue(carrinhoPage.getProductLabel().isEnabled());
            Assertions.assertEquals(carrinhoPage.getProductLabel().getText(), "Sauce Labs Backpack");
            Report.log(Status.PASS, "Produto adicionado ao carrinho com sucesso", Screenshot.fullPageBase64(driver));

        }catch (Exception e){

            Report.log(Status.FAIL, "Produto nao foi adicionado com sucesso", Screenshot.fullPageBase64(driver));
        }
    }

    private void validaPageInformacoes(){

        try{
            Assertions.assertEquals(carrinhoPage.getPageLabel().getText(), "Checkout: Your Information");
            Report.log(Status.PASS, "Pagina Informacoes Carregada", Screenshot.fullPageBase64(driver));

        }catch (Exception e){

            Report.log(Status.FAIL, "Pagina Informacoes nao Carregada", Screenshot.fullPageBase64(driver));
        }



    }



}
