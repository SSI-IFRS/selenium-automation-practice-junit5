package TestCases;

import Framework.*;
import Tasks.*;
import com.aventstack.extentreports.Status;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.WebDriver;

public class RealizarCompraParametrizadaDataProvider extends TestBase {

    private WebDriver driver = this.getDriver();

    LoginTask login = new LoginTask(driver);
    SelecionarProdutoTask produto = new SelecionarProdutoTask(driver);
    InvetoryDetailsTask invetoryProduto= new InvetoryDetailsTask(driver);
    CartTask cart = new CartTask(driver);
    InformationTask informacoes = new InformationTask(driver);
    FinishTask finish = new FinishTask(driver);

    /*public static Object[][] loginTestData(){

        return new Object[][] {{"standard_user","secret_sauce"}};

    }*/
    /*@MethodSource("loginTestData")*/

    @ParameterizedTest
    @MethodSource("Utils.DataClass#loginTestData")
    public void realizarCompra(String usuario, String senha){

        try {
            Report.createTest("Realizar Compra com Sucesso " , ReportType.GROUP);
            Report.createStep("Parametrizado com DataProvider");

            login.realizarLoginParametrizado(usuario,senha);
            produto.selecionarProduto();
            invetoryProduto.addToCart();
            cart.realizarChekout();
            informacoes.preencherInformacoes();
            finish.finalizarCompra();

        }catch (Exception e){

            Report.log(Status.ERROR, e.getMessage(), Screenshot.fullPageBase64(driver));

        }

    }

}
