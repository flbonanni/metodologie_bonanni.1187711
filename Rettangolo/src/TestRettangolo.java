/**
 * 
 * @author Flavia Bonanni
 */

public class TestRettangolo
{
    public static void main(String[] args)
    {
        Rettangolo RetTest = new Rettangolo(0, 0, 10, 20);
        RetTest.toString();
        RetTest.trasla(10, -5);
        RetTest.toString();
        Colore nuovoColore = new Colore(150, 150, 150);
        RetTest.colora(nuovoColore);
        RetTest.colora(Colore.BIANCO);
    }
}