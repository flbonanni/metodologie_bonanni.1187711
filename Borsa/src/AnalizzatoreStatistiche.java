import java.util.ArrayList;
import java.util.List;

public class AnalizzatoreStatistiche extends Analizzatore
{
   private List<Transazione> transazioni = new ArrayList<Transazione>();

   /*
    * analizza aggiunge la transazione all'elenco delle transazioni
    */
   @Override
   public void analizza(Transazione t)
   {
      transazioni.add(t);
      System.out.println(this);
   }

   /*
    * il suo toString riporta la media delle transazioni
    */
   @Override
   public String toString()
   {
      double importo = 0.0;
      for (Transazione t : transazioni) importo += t.getImporto();
      return "IMPORTO MEDIO DELLE TRANSAZIONI = "+importo/transazioni.size();
   }
}