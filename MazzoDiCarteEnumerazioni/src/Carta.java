/**
 * 
 * @author Flavia Bonanni
 */

public class Carta
{
	protected enum SemeCarta 
	{ 
		CUORI,
	    QUADRI,
	    FIORI,
	    PICCHE; 
	}
	
	protected enum ValoreCarta
	{
	    ASSO (1),
	    DUE (2),
	    TRE (3),
	    QUATTRO (4),
	    CINQUE (5),
	    SEI (6),
	    SETTE (7),
	    OTTO (8),
	    NOVE (9),
	    DIECI (10),
	    JACK (11),
	    DONNA (12),
	    RE (13);

	    private int valoreCarta;

	    ValoreCarta(int value)
	    {
	        this.valoreCarta = value;
	    }
	}
	
    private SemeCarta seme;
    private ValoreCarta valore;

    public Carta(SemeCarta seme, ValoreCarta valore)
    {
        this.seme = seme;
        this.valore = valore;
    }

    public SemeCarta getSemeCarta()
    {
        return seme;
    }

    public ValoreCarta getValoreCarta()
    {
        return valore;
    }

    public String toString()
    {
        String stringaCarta = "";

        stringaCarta = getValoreCarta() + " di " + getSemeCarta();
        System.out.println(stringaCarta);
        return stringaCarta;
    }
}