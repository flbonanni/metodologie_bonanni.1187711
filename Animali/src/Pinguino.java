/**
 * 
 * @author Flavia Bonanni
 */

public class Pinguino extends Uccello implements Nuota
{
    public void vola() throws PinguinoSchiantatoException { throw new PinguinoSchiantatoException(); }

    @Override
    public void becca() { System.out.println("Il '"+this.getClass().getName()+" becca."); }

    public void nuota() { System.out.println("Il "+this.getClass().getName()+" nuota."); }
}
