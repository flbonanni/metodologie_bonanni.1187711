/**
 * 
 * @author Flavia Bonanni
 */

public abstract class Felino extends Mammifero implements Salta, Corre, FaLeFusa
{
    public Felino() { setNumeroDiZampe(4); }
    
    @Override
    public abstract void salta();

    @Override
    public abstract void corre();

    @Override
    public abstract void faLeFusa();
}
    
