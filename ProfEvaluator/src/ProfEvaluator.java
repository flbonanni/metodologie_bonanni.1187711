import java.util.Comparator;
import java.util.Set;

/**
 * 
 * @author Flavia Bonanni
 */

public class ProfEvaluator
{
    CV cv;

    public ProfEvaluator(CV cv) { this.cv = cv; }

     public int getHIndex()
     {
         int HIndex = 0;
         Set<Pubblicazione> collezioneDiPubblicazioni = cv.getPubblicazioni();
         // non uso una lambda perché ho bisogno di variabili d'appoggio
         for (Pubblicazione p : collezioneDiPubblicazioni)
         {
             int N = p.getCitazioni();
             int M = 0;
             for (Pubblicazione s : collezioneDiPubblicazioni) { if (s.getCitazioni() >= N) M++; }
             if (M >= N && M >= HIndex) HIndex = N;
         }
         return HIndex;
     }

    public static void main(String[] args)
    {
        CV cv = new CV(new Autore("pinco", "pallo"));
        cv.aggiungiPubblicazione(new Pubblicazione("pub1", 10, new Autore("pinco", "pallo"), new Autore("mario", "rossi")));
        cv.aggiungiPubblicazione(new Pubblicazione("pub2", 7, new Autore("pinco", "pallo"), new Autore("giuseppe", "verdi")));
        cv.aggiungiPubblicazione(new Pubblicazione("pub3", 5, new Autore("maria", "rapallo"), new Autore("pinco", "pallo")));
        cv.aggiungiPubblicazione(new Pubblicazione("pub4", 4, new Autore("mario", "verdi"), new Autore("pinco", "pallo")));
        cv.aggiungiPubblicazione(new Pubblicazione("pub5", 3, new Autore("pinco", "pallo"), new Autore("signor", "anderson")));
        cv.aggiungiPubblicazione(new Pubblicazione("pub3", 3, new Autore("maria", "rapallo"), new Autore("pinco", "pallo")));

        ProfEvaluator eval = new ProfEvaluator(cv);
        System.out.println(eval.getHIndex());
        System.out.println(cv.getAutoriOrdinati());
        System.out.println(cv.getAutoriOrdinati(Comparator.comparing(Autore::getNome).thenComparing(Autore::getCognome)));
    }
}
