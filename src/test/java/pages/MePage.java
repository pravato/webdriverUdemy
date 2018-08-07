package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MePage extends BasePage {

    public MePage(WebDriver navegador) {

        super(navegador);
    }
    public MePage clicarAbaMoreDataAboutYou (){
        navegador.findElement(By.linkText("MORE DATA ABOUT YOU")).click();

        return this;
    }

    public AddContactPage clicarBotaoAddMoreDataAboutYou(){
        navegador.findElement(By.xpath("//*[@id=\"moredata\"]/div[2]/button")).click();

        return new AddContactPage (navegador);

    }

    public MePage clicarBotaoDeletar(){
        navegador.findElement(By.xpath("//*[@id=\"moredata\"]/div[1]/ul/li[1]/a/i")).click();

        return this;
    }

    public MePage confirmarJavascript(){
        navegador.switchTo().alert().accept();

        return this;
    }

    public MePage aguardarMensagem(){
        WebElement mensagemPop = navegador.findElement(By.id("toast-container"));
        String mensagem = mensagemPop.getText();
        WebDriverWait aguardar = new WebDriverWait(navegador,10);
        aguardar.until(ExpectedConditions.stalenessOf(mensagemPop));

        return this;
    }

    //Método Funcional para sempre deletar o primeiro contato
    public MePage deletarContato(){
        clicarBotaoDeletar();
        confirmarJavascript();
        aguardarMensagem();

        return this;
    }

    //Método para deletar todos os contatos, sempre que a DIV estiver visível
    public MePage deletarTodosContatos(){
        boolean divContatos = navegador.findElement(By.xpath("//*[@id=\"moredata\"]/div[1]/ul")).isDisplayed();
        while (true){
            try{
                deletarContato();
            } catch (Exception e){
                break;
            }
        }
        return this;
    }
}
