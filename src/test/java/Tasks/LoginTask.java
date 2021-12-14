package Tasks;


import Framework.Report;
import Framework.Screenshot;
import PageObjects.LoginPage;
import PageObjects.SelecionarProdutoPage;
import com.aventstack.extentreports.Status;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

public class LoginTask {

    private static WebDriver driver;
    private static LoginPage login;
    private static SelecionarProdutoPage selectProduto;

    public LoginTask(WebDriver driver) {

        this.driver = driver;
        login = new LoginPage(this.driver);
        selectProduto = new SelecionarProdutoPage(this.driver);
    }

    public void realizarLogin(){

       login.getUsernameTextField().sendKeys("standard_user");
       login.getPasswordTextField().sendKeys("secret_sauce");
       login.getLoginButton().click();
       validaLogin();

    }

    public void realizarLoginParametrizado(String usuario, String senha){

        login.getUsernameTextField().sendKeys(usuario);
        login.getPasswordTextField().sendKeys(senha);
        login.getLoginButton().click();
        validaLogin();

    }

    private void validaLogin(){
        /* Antes de termos report, construir o fluxo sem try/cat para report,apos implementar report incluir try/cat*/
        try{
        String label = selectProduto.getHomeLabelText().getText();
        Assertions.assertEquals(label, "Products");
        Report.log(Status.PASS, "Login Realizado : " + label , Screenshot.fullPageBase64(driver));
        }catch (Exception e){

            Report.log(Status.FAIL,"Login Falhou", Screenshot.fullPageBase64(driver));
        }
    }


}
