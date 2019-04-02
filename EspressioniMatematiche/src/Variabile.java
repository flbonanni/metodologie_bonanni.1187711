/**
 * 
 * @author Flavia Bonanni
 */

public class Variabile extends Espressione
{
    private String nome;

    public Variabile(String nome, double valore)
    {
        setValore(valore);
        this.nome = nome;
    }
}
