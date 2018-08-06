package tests;

import org.easetech.easytest.annotation.DataLoader;
import org.easetech.easytest.annotation.Param;
import org.easetech.easytest.runner.DataDrivenTestRunner;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import suporte.Generator;
import suporte.Screenshot;
import suporte.Web;

import static org.junit.Assert.assertEquals;


@RunWith(DataDrivenTestRunner.class) //DDT
@DataLoader(filePaths = "InformacoesUsuarioTest.csv") //Para usar no DDT

public class InformacoesUsuarioTest {
    private WebDriver navegador; //Declaração para funcionar em todas as @s

    @Rule //para poder usar o nome do método no print
    public TestName test = new TestName();

    @Before //Executar antes do @Test
    public void setUp() {
        navegador = Web.createChrome();

        //Clicar no link que possui o texto "Sign in"
        navegador.findElement(By.linkText("Sign in")).click();

        //Identificando o formulário de Login
        WebElement formularioSignInBox = navegador.findElement(By.id("signinbox"));

        //Digitar no campo com name "login" que está dentro do formulário de id "signinbox" o texto "julio0001"
        formularioSignInBox.findElement(By.name("login")).sendKeys("julio0001");

        //Digitar no campo com name "password" que está dentro do formulário de id "signinbox" o texto "123456"
        formularioSignInBox.findElement(By.name("password")).sendKeys("123456");

        //Clicar no link com o texto "SIGN IN"
        navegador.findElement(By.linkText("SIGN IN")).click();

        //Clicar em um link que possui a class "me"
        navegador.findElement(By.className("me")).click();

        //Clicar em um link que possui o texto "MORE DATA ABOUT YOU"
        navegador.findElement(By.linkText("MORE DATA ABOUT YOU")).click();
    }

    //@Test
    public void testAdicionarUmaInformacaoAdicionalDoUsuario(@Param(name="tipo")String tipo, @Param(name="contato")String contato, @Param(name="mensagem")String mensagemEsperada) {

        //Clicar no botão através do seu xpath //button[@data-target="addmoredata"]
        //navegador.findElement(By.xpath("//button[@data-target=\"addmoredata\"]")).click(); //Ensinado pelo Júlio de Lima
        navegador.findElement(By.xpath("//*[@id=\"moredata\"]/div[2]/button")).click(); //xpath obtido pelo F12 > Selecionar Elemento > Copiar

        //Identificar a popup onde está o formulário de id addmoredata
        WebElement popupAddMoreData = navegador.findElement(By.id("addmoredata"));

        //Na combo de name "type" escolher a opção conforme o CSV
        WebElement campoType = popupAddMoreData.findElement(By.name("type"));
        new Select(campoType).selectByVisibleText(tipo); //será preenchido com o parâmetro tipo conforme o DDT

        //No campo de name "contact" digitar conforme o CSV
        popupAddMoreData.findElement(By.name("contact")).sendKeys(contato); //será preenchido com o parâmetro tipo conforme o DDT

        //Clicar no link de text "SAVE" que está no popup
        popupAddMoreData.findElement(By.linkText("SAVE")).click();

        //Na mensagem de id "toast-container" validar que o texto é "Your contact has been added!"
        WebElement mensagemPop = navegador.findElement(By.id("toast-container")); //Capturar o toast da mensagem
        String mensagem = mensagemPop.getText(); //Atribuir o texto à variável
        assertEquals(mensagemEsperada, mensagem); //Validar o conteúdo da mensagem que está no CSV vs. variável onde o texto foi carregado
    }

   // @Test
    public void removerUmContatoDeUmUsuario(){
        //Clicar no elemento pelo seu xpath //span[text()='+551199991111']/following-sibling::a
        navegador.findElement(By.xpath("//span[text()='+551199991111']/following-sibling::a")).click();

        //Confirmar a janela javascript
        navegador.switchTo().alert().accept();

        //Validar que a mensagem apresentada foi "Rest in peace, dear phone!"
        WebElement mensagemPop = navegador.findElement(By.id("toast-container")); //Capturar o toast da mensagem
        String mensagem = mensagemPop.getText(); //Atribuir o texto à variável
        assertEquals("Rest in peace, dear phone!", mensagem); //Validar o conteúdo da mensagem vs. variável

        String screenshotArquivo = "C:\\Users\\Mário\\print\\" + Generator.dataHoraParaArquivo() + test.getMethodName() + ".png";
        Screenshot.tirar(navegador, screenshotArquivo);

        //Aguardar até 10 segundos para que a janela desapareça
        WebDriverWait aguardar = new WebDriverWait(navegador,10);
        aguardar.until(ExpectedConditions.stalenessOf(mensagemPop)); //Irá aguardar até que o elemento 'mensagemPop' desapareça

        //Clicar no link com o texto "logout"
        navegador.findElement(By.linkText("Logout")).click();
    }

    @After
    public void tearDown(){
        //Fechar o navegador
        navegador.quit();
    }
}