package suporte;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Web {
    public static WebDriver createChrome(){
        //Abrindo o navegador
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\mpravato\\drivers\\chromedriver.exe"); //Chamando o browser
        WebDriver navegador = new ChromeDriver(); //Instanciando o browser
        navegador.manage().window().maximize(); //Maximizando o browser
        navegador.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); //Criando um timeout de 5 segundos a cada ação, para evitar quebras

        //Navegando para a página do Taskit
        navegador.get("http://www.juliodelima.com.br/taskit");

        return navegador;
    }

    //public static WebDriver createBrowserStack(){ necessário refazer esta parte com a conta

    }
}
