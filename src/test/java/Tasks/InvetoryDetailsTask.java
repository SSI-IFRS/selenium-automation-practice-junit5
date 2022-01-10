package Tasks;

import Framework.Report;
import Framework.ReportFactory;
import Framework.Screenshot;
import PageObjects.CartPage;
import PageObjects.InventoryDetailsPage;
import com.aventstack.extentreports.Status;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

public class InvetoryDetailsTask {

    private static WebDriver driver;
    private static InventoryDetailsPage invetoryPage;
    private static CartPage carrinhoPage;

    public InvetoryDetailsTask(WebDriver driver) {

        this.driver = driver;
        invetoryPage = new InventoryDetailsPage(this.driver);
        carrinhoPage = new CartPage(this.driver);
    }

    public void addToCart(){

        invetoryPage.getAddCartButton().click();
        invetoryPage.getCartButton().click();
        validaCarrinho();

    }

    private void validaCarrinho(){

        try{
            String label = carrinhoPage.getPageLabel().getText();
            Assertions.assertEquals(label, "Your Cart");
            Report.log(Status.INFO,"Pagina Carrinho Carregada", Screenshot.fullPageBase64(driver));
            /* coloquei INFO para exemplificar que tem outras opcoes */
        }catch (Exception e){

            Report.log(Status.FAIL,"Produto não foi adicionado no carrinho",Screenshot.fullPageBase64(driver));

        }


    }


}
