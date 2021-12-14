package Framework;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class TestBase extends DriverManager{

    private static WebDriver driver;
    //private static FileOperations fileOperations = new FileOperations();

    /* Inicialmente monta a testbase passando a url por string, se der tempo ao longo da mentoria
       mostra como trabalhar com as propriedades, pois em API será mostrado novamente
     */

    /* Iniciar sem report, apos construcao inserir metodos de config e close */

    private String URL = "https://www.saucedemo.com/index.html";

    public static WebDriver getDriver(){

        driver = getDriver(TypeDriver.CHROME);
        return driver;
    }

    @BeforeEach
    public void setUp() throws IOException {
       // String index = fileOperations.getProperties("url").getProperty("url.index");
        //configReportExtent();
        getDriver().get(URL);
        //getDriver().get(index);
    }

    @AfterEach
    public void tearDown(){

        //Report.close();
        quitDriver();

    }

}
