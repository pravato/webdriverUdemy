package pages;

import org.junit.Rule;
import org.junit.rules.TestName;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import suporte.Generator;
import suporte.Screenshot;

public class HomePage extends BasePage {
    public HomePage(WebDriver navegador) {
        super(navegador);
    }

    @Rule //para poder usar o nome do método no print
    public TestName test = new TestName();

    public HomePage acessarTwitter(){
        navegador.findElement(By.xpath("/html/body/footer/div[1]/div/div[2]/ul/li[1]/a")).click();

        return this;
    }

    public HomePage acessarLinkedin(){
        navegador.findElement(By.xpath("/html/body/footer/div[1]/div/div[2]/ul/li[2]/a")).click();

        return this;
    }

    public HomePage acessarMedium(){
        navegador.findElement(By.xpath("/html/body/footer/div[1]/div/div[2]/ul/li[3]/a")).click();

        return this;
    }

    public HomePage retornarPagina(){
        navegador.navigate().back();

        return this;
    }

    public HomePage acessarRedesSociais(){
        acessarTwitter();
        tirarPrint();
        retornarPagina();
        acessarMedium();
        tirarPrint();
        retornarPagina();
        acessarLinkedin();
        tirarPrint();
        retornarPagina();

        return this;
    }
}
