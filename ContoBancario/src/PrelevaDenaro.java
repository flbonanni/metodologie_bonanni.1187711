/**
 * 
 * @author Flavia Bonanni
 */

public class PrelevaDenaro extends Operazione
{
    ContoBancario conto;
    double quantita;
    double totale;

    /**
     * 
     * @param conto
     * @param quantita
     */
    public PrelevaDenaro(ContoBancario conto, double quantita)
    {
        this.conto = conto;
        this.quantita = quantita;
        totale = conto.getDisponibilita()-quantita;
    }

    public void esegui()
    {
        conto.setDisponibilita(totale);
        conto.aggiungiAElencoOp(this);
        conto.aggiungiAElenco("Sono stati prelevati dal conto €"+quantita+".");
    }
}