/**
 * 
 * @author Flavia Bonanni
 */

public class SvuotaConto extends Operazione
{
    ContoBancario conto;

    public SvuotaConto(ContoBancario conto)
    {
        this.conto = conto;
    }

    public void esegui()
    {
        conto.setDisponibilita(0);
        conto.aggiungiAElenco("Il conto è stato svuotato.");
        conto.aggiungiAElencoOp(this);
    }
}
