package tests;

import org.easetech.easytest.annotation.DataLoader;
import org.easetech.easytest.annotation.Param;
import org.easetech.easytest.runner.DataDrivenTestRunner;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import pages.BasePage;
import pages.HomePage;
import pages.LoginPage;
import suporte.Web;
import static org.junit.Assert.*;

@RunWith(DataDrivenTestRunner.class)
@DataLoader (filePaths = "InformacoesUsuarioPageObjectsTest.csv")
public class InformacoesUsuarioPageObjectsTest {
    private WebDriver navegador;

    @Before
    public void setUp() {

        navegador = Web.createChrome();
    }

    @Test
    public void testAdicionarUmaInformacaoAdicionalDoUsuario(
            @Param(name="login")String login,
            @Param(name="senha")String senha,
            @Param(name="tipo")String tipo,
            @Param(name="contato")String contato,
            @Param(name="mensagem")String mensagemEsperada)
    {
        String textoToast = new LoginPage(navegador)
                .clicarSignIn()
                .fazerLogin(login,senha)
                .clicarMe()
                .clicarAbaMoreDataAboutYou()
                .clicarBotaoAddMoreDataAboutYou()
                .adicionarContato(tipo,contato)
                .capturarTextoToast();

        assertEquals(mensagemEsperada, textoToast);
    }

    @Test
    public void testRemoverUmContato(){

        new LoginPage(navegador)
                .clicarSignIn()
                .fazerLogin("julio0001","123456")
                .clicarMe()
                .clicarAbaMoreDataAboutYou()
                .deletarContato();
    }

    @Test
    public void testRemoverTodosOsContatos(){

        new LoginPage(navegador)
                .clicarSignIn()
                .fazerLogin("julio0001","123456")
                .clicarMe()
                .clicarAbaMoreDataAboutYou()
                .deletarTodosContatos();
    }

    @Test
    public void testAcessarRedesSociais(){

        new HomePage(navegador)
                .irParaHome()
                .acessarRedesSociais();
    }

    @After
    public void tearDown () {
        navegador.quit();
    }
}

