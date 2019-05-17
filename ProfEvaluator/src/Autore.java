import java.util.*;

public class Autore implements Comparable
{
    private String nome;
    private String cognome;

    public String getNome() { return nome; }
    public String getCognome() { return cognome; }

    public Autore(String nome, String cognome)
    {
        this.nome = nome;
        this.cognome = cognome;
    }

    @Override
    public String toString()
    {
        return nome+" "+cognome;
    }

    @Override
    public boolean equals(Object o)
    {
        if (o == null) return false;
        if (nome == ((Autore)o).getNome() && cognome == ((Autore)o).getCognome()) return true;
        else return false;
    }

    @Override
    public int hashCode() { return Objects.hash(nome, cognome);
    }

    @Override
    public int compareTo(Object o)
    {
        if (equals(o)) return 0; // se sono uguali
        if (this.getNome().compareTo(((Autore)o).getNome()) <= -1) { return -1; } // se il primo nome è minore del secondo
        else if (this.getNome().compareTo(((Autore)o).getNome()) >= 1) return 1; // se il primo nome è maggiore del secondo
        else // se i nomi sono uguali
        {
            if (this.getCognome().compareTo(((Autore)o).getCognome()) <= -1) return -1; // se il primo cognome è minore del secondo
            else return 1; // se il primo cognome è maggiore del secondo
        }
    }
}
