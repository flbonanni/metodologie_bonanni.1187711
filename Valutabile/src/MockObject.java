/**
 * Oggetto dummy
 * 
 * @author Flavia Bonanni
 */

public class MockObject implements Valutabile
{
    private boolean b = valuta();

    public boolean getB() { return b; }

    @Override
    public boolean valuta() { return (Math.random() < 0.5 ? true : false); }
}
