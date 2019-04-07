/**
 * 
 * @author Flavia Bonanni
 */

public class Brano
{
    private String canzone;
    private String cantante;

    public Brano(String canzone, String cantante)
    {
        this.canzone = canzone;
        this.cantante = cantante;
    }

    @Override
    public String toString()
    {
        String a = "Currently playing: "+canzone+" by "+cantante+".";
        System.out.println(a);
        return a;
    }
}