import java.util.*;

/**
 * 
 * @author Flavia Bonanni
 */

public class CV
{
    Autore autore;
    Set<Pubblicazione> collezioneDiPubblicazioni = new HashSet<>();

    public CV(Autore autore) { this.autore = autore; }

    public Set<Pubblicazione> getPubblicazioni() { return collezioneDiPubblicazioni; }

    public void aggiungiPubblicazione(Pubblicazione p) { collezioneDiPubblicazioni.add(p); }

    public Set<Autore> getAutori()
    {
        Set<Autore> collaboratori = new HashSet<>();
        collezioneDiPubblicazioni.forEach(p -> { for (Autore a : p.getAutori()) { collaboratori.add(a); } });
        collaboratori.remove(autore);
        return collaboratori;
    }

    public Set<Autore> getAutoriOrdinatiSenzaComparator()
    {
        Set<Autore> collaboratoriOrdinati = new TreeSet<>();
        collezioneDiPubblicazioni.forEach(p -> { for (Autore a : p.getAutori()) { collaboratoriOrdinati.add(a); } });
        collaboratoriOrdinati.remove(autore);
        return collaboratoriOrdinati;
    }

    public Set<Autore> getAutoriOrdinati(Comparator comp)
    {
        Set<Autore> collaboratoriOrdinati = new TreeSet<>(comp);
        collezioneDiPubblicazioni.forEach(p -> { for (Autore a : p.getAutori()) { collaboratoriOrdinati.add(a); } });
        collaboratoriOrdinati.remove(autore);
        return collaboratoriOrdinati;
    }

    public Set<Autore> getAutoriOrdinati()
    {
        return getAutoriOrdinatiSenzaComparator();
    }
}
