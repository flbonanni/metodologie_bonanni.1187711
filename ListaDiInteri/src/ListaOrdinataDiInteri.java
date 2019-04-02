/**
 * 
 * @author Flavia Bonanni
 */

public class ListaOrdinataDiInteri extends ListaDiInteri
{
    int[] array;
    int lunghezza;

    /**
     * 
     * @param array
     */
    public ListaOrdinataDiInteri(int[] array)
    {
        super(array);
        this.array = array;
        lunghezza = array.length;
    }

    public void aggiungi(int daAgg)
    {
        if (daAgg >= array[lunghezza-1]) super.aggiungi(daAgg);
    }

    public void aggiungiQui(int daAgg, int posizione)
    {
        if (posizione-1 >= 0 && posizione+1 < lunghezza) if (daAgg >= array[posizione-1] && daAgg <= array[posizione+1]) super.aggiungiQui(daAgg, posizione);
        if (posizione == 0) if (daAgg <= array[0]) super.aggiungiQui(daAgg, posizione);
        if (posizione == lunghezza-1) aggiungi(daAgg);
    }

    public void aggiungiGiusto(int daAgg)
    {
        int qui = 0;
        for (int i = 0; i < lunghezza; i++)
        {
            if (daAgg < array[i])
            {
                qui = i;
                break;
            }
        }
        aggiungiQui(daAgg, qui);
    }

    public static void main(String[] args)
    {
        ListaOrdinataDiInteri listaOrdinata = new ListaOrdinataDiInteri(new int[] {1, 2, 4, 5});
        listaOrdinata.aggiungi(6);
        listaOrdinata.aggiungi(3);
        listaOrdinata.aggiungiQui(3, 2);
        listaOrdinata.aggiungiQui(7, 0);
        listaOrdinata.aggiungiGiusto(3);
        listaOrdinata.aggiungiGiusto(0);
    }
}
