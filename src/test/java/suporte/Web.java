package suporte;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.ie.InternetExplorerDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class Web {
    public static WebDriver createBrowser(){
        String driverPath = "C:\\drivers\\"; //Pasta onde estão localizados os drivers

        //Chrome
        System.setProperty("webdriver.chrome.driver", driverPath+"chromedriver.exe"); //Chamando o Chrome
        WebDriver navegador = new ChromeDriver(); //Instanciando o Chrome

        //Firefox
        //System.setProperty("webdriver.gecko.driver", driverPath+"geckodriver.exe"); //Chamando o Firefox
        //WebDriver navegador = new FirefoxDriver(); //Instanciando o Firefox

        //IE
        //System.setProperty("webdriver.ie.driver", driverPath+"IEDriverServer.exe"); //Chamando o IE
        //WebDriver navegador = new InternetExplorerDriver(); //Instanciando o IE

        navegador.manage().window().maximize(); //Maximizando o browser
        navegador.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); //Criando um timeout de 5 segundos a cada ação, para evitar quebras

        //Definindo a página  que será aberta: Taskit
        String url = "http://www.juliodelima.com.br/taskit";

        //Navegador acessa a página definida acima
        navegador.get(url);

        return navegador;
    }

}
