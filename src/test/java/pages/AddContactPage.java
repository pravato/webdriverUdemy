package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class AddContactPage extends BasePage{
    public AddContactPage(WebDriver navegador) {
        super(navegador);
    }

    public void escolherTipoDeContato(String tipo) {
        WebElement campoType = navegador.findElement(By.id("addmoredata")).findElement(By.name("type"));
        new Select(campoType).selectByVisibleText(tipo);

    }

    public void digitarContato(String contato) {
        navegador.findElement(By.id("addmoredata")).findElement(By.name("contact")).sendKeys(contato);

    }

    public void clicarSalvar(){
        navegador.findElement(By.id("addmoredata")).findElement(By.linkText("SAVE")).click();

        new MePage(navegador);
    }

    public MePage adicionarContato(String tipo, String contato){
        escolherTipoDeContato(tipo);
        digitarContato(contato);
        clicarSalvar();

        return new MePage(navegador);
    }
}
