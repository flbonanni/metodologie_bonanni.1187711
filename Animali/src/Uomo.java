/**
 * 
 * @author Flavia Bonanni
 */

public class Uomo implements Vola, Nuota, Salta, Corre, Pensa
{
    public void vola() { System.out.println("L'"+this.getClass().getName()+" vola... o una sorta almeno."); }

    public void nuota() { System.out.println("L'"+this.getClass().getName()+" nuota."); }

    public void salta() { System.out.println("L'"+this.getClass().getName()+" salta."); }

    public void corre() { System.out.println("L'"+this.getClass().getName()+" corre."); }

    public void pensa() { System.out.println("L'"+this.getClass().getName()+" pensa."); }
}
