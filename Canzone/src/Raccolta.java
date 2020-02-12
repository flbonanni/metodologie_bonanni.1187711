import java.util.*;

/**
 * 
 * @author Flavia Bonanni
 */

public class Raccolta
{
    private HashSet<Canzone> raccoltaDiCanzoni;

    public Raccolta(HashSet<Canzone> raccoltaDiCanzoni)
    {
        this.raccoltaDiCanzoni = raccoltaDiCanzoni;
    }

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
        HashSet<Canzone> album = new HashSet<>();
        album.add(new Canzone("Hit me baby one more time", "Britney Spears"));
        album.add(new Canzone("Toxic", "Britney Spears"));
        album.add(new Canzone("Hit me baby one more time", "Britney Spears"));

        Raccolta raccoltaPerAuto = new Raccolta(album);

        raccoltaPerAuto.toString();
    }
}