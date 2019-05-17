import java.util.Objects;

/**
 * 
 * @author Flavia Bonanni
 */

public class Canzone implements Comparable
{
    private String nome;
    private String autore;

    public Canzone(String nome, String autore)
    {
        this.nome = nome;
        this.autore = autore;
    }

    public String getNome() { return nome; }
    public String getAutore() { return autore; }

    @Override
    public boolean equals(Object o)
    {
        if (o == null) return false;
        if (getClass() != o.getClass()) return false;
        Canzone c = (Canzone)o;
        return nome == c.nome && autore == c.autore;
    }

    @Override
    public int hashCode() { return Objects.hash(nome, autore);
    }

    @Override
    public String toString() { return nome+" by "+autore; }

    @Override
    public int compareTo(Object o)
    {
        if (equals(o)) { return 0; }
        else
        {
            int k = 0;
            /**
             *  scorri il nome finché non trovi due caratteri discordanti
             *  se li trovi, comparali
             */
            int min = nome.length() < ((Canzone)o).getNome().length() ? nome.length() : ((Canzone)o).getNome().length();
            while (nome.charAt(k) == ((Canzone)o).getNome().charAt(k) && k < min-1) k++;
            if (nome.charAt(k) > ((Canzone)o).getNome().charAt(k)) return 1;
            else if (nome.charAt(k) < ((Canzone)o).getNome().charAt(k)) return -1;
            /**
             * se invece i nomi sono uguali
             * scorri l'autore finché non trovi due caratteri discordanti
             * se li trovi, comparali
             */
            else
            {
                int l = 0;
                min = autore.length() < ((Canzone)o).getAutore().length() ? autore.length() : ((Canzone)o).getAutore().length();
                while (autore.charAt(l) == ((Canzone)o).getAutore().charAt(l) && l < min-1) l++;
                if (autore.charAt(l) > ((Canzone)o).getAutore().charAt(l)) return 1;
                else if (autore.charAt(l) < ((Canzone)o).getAutore().charAt(l)) return -1;
                else return 0;
            }
        }
    }
}
