package TestCases;

import Framework.*;
import Tasks.*;
import com.aventstack.extentreports.Status;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import static Framework.Report.log;

public class RealizarCompraComSucesso extends TestBase {

    private WebDriver driver = this.getDriver();

    LoginTask login = new LoginTask(driver);
    SelecionarProdutoTask produto = new SelecionarProdutoTask(driver);
    InvetoryDetailsTask invetoryProduto= new InvetoryDetailsTask(driver);
    CartTask cart = new CartTask(driver);
    InformationTask informacoes = new InformationTask(driver);
    FinishTask finish = new FinishTask(driver);


    @Test
    public void realizarCompra(){

        try {

            Report.createTest("Realizar Compra com Sucesso" , ReportType.SINGLE);

            login.realizarLogin();
            produto.selecionarProduto();
            invetoryProduto.addToCart();
            cart.realizarChekout();
            informacoes.preencherInformacoes();
            finish.finalizarCompra();

        }catch (Exception e){

            log(Status.ERROR, e.getMessage(), Screenshot.fullPageBase64(driver));

        }

    }
}
