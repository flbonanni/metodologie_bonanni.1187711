/**
 * 
 * @author Flavia Bonanni
 */

public class VersaDenaro extends Operazione
{
    ContoBancario conto;
    double quantita;
    double totale;

    /**
     * 
     * @param conto
     * @param quantita
     */
    public VersaDenaro(ContoBancario conto, double quantita)
    {
        this.conto = conto;
        this.quantita = quantita;
        totale = conto.getDisponibilita()+quantita;
    }

    public void esegui()
    {
        conto.setDisponibilita(totale);
        conto.aggiungiAElenco("Sono stati versati sul conto €"+quantita+".");
        conto.aggiungiAElencoOp(this);
    }
}
