package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MePage extends BasePage {

    public MePage(WebDriver navegador) {

        super(navegador);
    }
    public MePage clicarAbaMoreDataAboutYou (){
        navegador.findElement(By.linkText("MORE DATA ABOUT YOU")).click();

        return this;
    }

    public AddContactPage clicarBotaoAddMoreDataAboutYou (){
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

    //Método Funcional para deletar o primeiro contato
    public MePage deletarContato(){
        clicarBotaoDeletar();
        confirmarJavascript();

        return this;
    }

    public MePage verificarSeExistemContatos(){
        boolean divContatos = navegador.findElement(By.xpath("//*[@id=\"moredata\"]/div[1]/ul")).isDisplayed();
        while (divContatos) {
                for (divContatos) {
                    deletarContato();
                }

        }

        return this;

    }
}
