/**
 * 
 * @author Flavia Bonanni
 */

public class TestAnimale
{
    public static void main(String[] args)
    {
        Animale[] zoo = new Animale[8];
        zoo[0] = new Gatto();
        zoo[1] = new Tigre();
        zoo[2] = new Chihuahua();
        zoo[3] = new Beagle();
        zoo[4] = new Terranova();
        zoo[5] = new Corvo();
        zoo[6] = new Passero();
        zoo[7] = new Millepiedi();
        for (int i = 0; i < zoo.length; i++)
        {
            System.out.print("L'animale "+zoo[i].getClass().getSimpleName()+" fa ");
            zoo[i].emettiVerso();
            System.out.println(", ha "+zoo[i].getNumeroDiZampe()+" zampe ed è di taglia "+zoo[i].getTaglia()+".");
        }
    }
}
