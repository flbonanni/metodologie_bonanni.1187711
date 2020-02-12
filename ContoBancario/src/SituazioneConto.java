/**
 * 
 * @author Flavia Bonanni
 */

public class SituazioneConto extends Operazione
{
    ContoBancario conto;

    public SituazioneConto(ContoBancario conto)
    {
        this.conto = conto;
    }

    public void esegui()
    {
        System.out.println("Il saldo corrente è di €"+conto.getDisponibilita()+".");
    }
}
