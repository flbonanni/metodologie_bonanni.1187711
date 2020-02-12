public class AnalizzatoreTrend extends Analizzatore
{
   private Transazione ultimaTransazione;
   private double trendImporto;

   /*
    * il suo analizza inizializza un campo trendImporto
    * se non c'è un'ultima transazione trendImporto è l'importo della transazione
    * altrimenti trendImporto è l'importo della tansazione tranne l'importo dell'ultima transazione
    * 
    * poi, registra la transazione come ultima transazione
    */
   @Override
   public void analizza(Transazione t)
   {
      if (ultimaTransazione == null) trendImporto = t.getImporto();
      else trendImporto = t.getImporto()-ultimaTransazione.getImporto();

      ultimaTransazione = t;
      System.out.println(this);
   }

   @Override
   public String toString()
   {
      return "TREND = "+trendImporto;
   }
}