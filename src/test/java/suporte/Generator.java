package suporte;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

//Classe para pegar a data/hora no formato yyyyMMddhhmmss para ser incluído no nome do print
public class Generator {
    public static String dataHoraParaArquivo(){
        Timestamp ts = new Timestamp(System.currentTimeMillis());
        return new SimpleDateFormat("yyyyMMddhhmmss").format(ts);
    }
}
