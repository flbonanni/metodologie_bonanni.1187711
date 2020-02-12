/**
 * 
 * @author Flavia Bonanni
 */

public class EspressioneComposta extends Espressione
{
    public EspressioneComposta(Espressione e1, String operatore, Espressione e2)
    {
        switch(operatore)
        {
            case "+":
                setValore(e1.getValore()+e2.getValore());
                break;
            case "-":
                setValore(e1.getValore()-e2.getValore());
                break;
            case "*":
                setValore(e1.getValore()*e2.getValore());
                break;
            case "/":
                setValore(e1.getValore()/e2.getValore());
                break;
            case "%":
                setValore(e1.getValore()%e2.getValore());
                break;
        }
    }

    public EspressioneComposta(String operatore, Espressione e1)
    {
        setValore(-(e1.getValore()));
    }
}
