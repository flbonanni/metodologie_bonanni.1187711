import java.text.*;
import java.util.*;

/**
 * 
 * @author Flavia Bonanni
 */

public class RegistratoreDiCassa
{
    double totale;
    double prezzo;
    double pagato;
    double resto;
    double i = 1;

    /**
     * 
     * @param prezzoArticolo
     * @return subtotale da pagare
     */
    public double subtotale(double prezzoArticolo)
    {
        prezzo += prezzoArticolo;
        System.out.println("L'articolo n° "+i+" costa €"+prezzoArticolo+". Il tuo nuovo subtotale è €"+prezzo+".");
        i++;
        return prezzo;
    }

    /**
     * 
     * @param pagato
     */
    public void pagamento(double pagato)
    {
        this.pagato = pagato;
        System.out.println("Hai pagato €"+pagato+".");
    }

    /**
     * 
     * @return resto
     */
    public double restituzione()
    {
        resto = pagato - prezzo;
        NumberFormat nf = NumberFormat.getNumberInstance(Locale.US);
        DecimalFormat df = (DecimalFormat)nf;
        System.out.println("Il tuo resto è €"+df.format(resto)+".");
        return resto;
    }

    public static void main(String[] args)
    {
        RegistratoreDiCassa RDC = new RegistratoreDiCassa();
        RDC.subtotale(4.5);
        RDC.subtotale(8.3);
        RDC.subtotale(3.2);
        RDC.pagamento(20.9);
        RDC.restituzione();
    }
}
