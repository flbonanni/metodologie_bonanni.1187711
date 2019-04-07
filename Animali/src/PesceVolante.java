/**
 * 
 * @author Flavia Bonanni
 */

public class PesceVolante extends Pesce implements Vola
{
    public void vola() { System.out.println("Il "+this.getClass().getName()+" vola."); }

    public void nuota() { System.out.println("Il "+this.getClass().getName()+" nuota."); }
}
