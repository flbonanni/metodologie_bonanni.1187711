/**
 * 
 * @author Flavia Bonanni
 */

public class Cane extends Mammifero implements Salta, Corre, FedeleA, Domestico
{
    public Cane()
    {
        setNumeroDiZampe(4);
        setVerso("Bau");
    }
    
    public void salta() { System.out.println("Il "+this.getClass().getName()+" salta."); }

    public void corre() { System.out.println("Il "+this.getClass().getName()+" corre."); }

    public void fedeleA(Uomo u) { System.out.println("Questo "+this.getClass().getName()+" è fedele a un "+u.getClass().getName()+"."); }

    public void domestico() { System.out.println("Il "+this.getClass().getName()+" è domestico."); }
}
