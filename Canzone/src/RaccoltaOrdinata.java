import java.util.*;

/**
 * 
 * @author Flavia Bonanni
 */

public class RaccoltaOrdinata
{
    /** Si implementi quindi la classe PDF8.RaccoltaOrdinata che utilizza TreeSet per mantenere un ordine sulle canzoni. */

    private TreeSet<Canzone> raccoltaDiCanzoni;

    public RaccoltaOrdinata(TreeSet<Canzone> raccoltaDiCanzoni) { this.raccoltaDiCanzoni = raccoltaDiCanzoni; }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        int numerazione = 0;
        for (Canzone c : raccoltaDiCanzoni) { sb.append((++numerazione)+". "+c.getNome()+" by "+c.getAutore()+"; "+'\n'); }
        sb.setLength(sb.length()-3);
        sb.append(".");
        System.out.println(sb);
        return sb.toString();
    }

    public static void main(String[] args)
    {
        TreeSet<Canzone> album = new TreeSet();
        album.add(new Canzone("Hit me baby one more time", "Britney Spears"));
        album.add(new Canzone("Toxic", "Britney Spears"));
        album.add(new Canzone("Sometimes", "Britney Spears"));
        album.add(new Canzone("Toxicity", "System of a Down"));
        album.add(new Canzone("Hit me baby one more time", "Britney Spears"));

        RaccoltaOrdinata raccoltaPerAuto = new RaccoltaOrdinata(album);

        raccoltaPerAuto.toString();
    }
}