/**
 * 
 * @author Flavia Bonanni
 */

public class Gatto extends Felino implements Domestico
{
    public Gatto()
    {
        setVerso("Miao");
        setTaglia(Taglia.PICCOLA);
    }
    
    public void domestico() { System.out.println("Il "+this.getClass().getName()+" è domestico."); }

    public void salta() { System.out.println("Il "+this.getClass().getName()+" salta."); }

    public void corre() { System.out.println("Il "+this.getClass().getName()+" corre."); }

    public void faLeFusa() { System.out.println("Il "+this.getClass().getName()+" fa le fusa."); }
}