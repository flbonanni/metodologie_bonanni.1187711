/**
 * Cella di un labirinto
 * 
 * @author Flavia Bonanni
 */

abstract public class Cella
{
    boolean visited;

    public void setVisited(boolean b) { visited = b; }

    public boolean getVisited() { return visited; }
}
