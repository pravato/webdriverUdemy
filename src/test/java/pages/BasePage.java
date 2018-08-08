package pages;

import org.junit.Rule;
import org.junit.rules.TestName;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import suporte.Generator;
import suporte.Screenshot;

public class BasePage {
    protected WebDriver navegador;

    public BasePage (WebDriver navegador){
        this.navegador = navegador;
    }

    public String capturarTextoToast(){
       return navegador.findElement(By.id("toast-container")).getText();

    }

    public HomePage irParaHome(){
        navegador.findElement(By.xpath("/html/body/nav/div/div/a[1]")).click();

        return new HomePage(navegador);
    }

    public BasePage tirarPrint(){
        String screenshotArquivo = "C:\\Users\\mpravato\\print\\" + Generator.dataHoraParaArquivo() + ".png";
        Screenshot.tirar(navegador, screenshotArquivo);

        return this;
    }
}
