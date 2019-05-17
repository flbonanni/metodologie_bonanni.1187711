import java.util.Objects;

/**
 * Modella una pubblicazione mediante titolo, numero di citazioni ed elenco degli autori
 *  
 * @author Flavia Bonanni
 */

public class Pubblicazione
{
    private String titolo;
    private int citazioni;
    private Autore[] autori;

    public Autore[] getAutori() { return autori; }
    public int getCitazioni() { return citazioni; }
    public String getTitolo() { return titolo; }

    public Pubblicazione(String titolo, int citazioni, Autore... autori)
    {
        this.titolo = titolo;
        this.citazioni = citazioni;
        this.autori = autori;
    }

    @Override
    public int hashCode() { return Objects.hash(titolo, citazioni, autori); }

    @Override
    public boolean equals(Object o)
    {
        if (o == null) return false;
        if (getClass() != o.getClass()) return false;
        Pubblicazione p = (Pubblicazione)o;
        return titolo == p.titolo && citazioni == p.citazioni && autori == p.autori;
    }
}
