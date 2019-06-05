import java.util.Arrays;
import java.util.Comparator;

/**
 * ArrayFlessibile ha un tipo generico T il quale estende l'interfaccia comparabile su un qualche tipo ? che sia super di T o T stesso
 * ovvero si possono fare paragoni tra oggetti di tipo T o super di T, perché sono oggetti "COMPARABILI"
 * inoltre la classe ArrayFlessibile implementa l'interfaccia comparabile, quindi anche questi array sono comparabili
 * @param <T>
 */
public class ArrayFlessibile<T extends Comparable<? super T>> implements Comparable<ArrayFlessibile<T>>
{
    // Array di valori di tipo T
    private T[] valori;
    // Comparatore di Array o suoi superiori
    private Comparator<? super ArrayFlessibile<T>> comparator;

    //@SuppressWarnings("unchecked")
    /**
     * ORDINE_LESSICOGRAFICO è una costante definitiva di tipo comparator ed è un comparatore costruito in modo che:
     * avendo un'a e un b, si paragonano i due array di oggetti comparabili tramite il metodo compare, che confronta lessicograficamente due array
     * ORDINE_LESSICOGRAFICO_INVERSO è uguale all'inverso del risultato
     * e PER LUNGHEZZA ritorna un comparatore che confronta la lunghezza degli array
     */
    public static final Comparator<ArrayFlessibile<? extends Comparable<?>>>
            ORDINE_LESSICOGRAFICO = (a, b) -> Arrays.compare((Comparable[])a.valori, (Comparable[])b.valori),
            ORDINE_LESSICOGRAFICO_INVERSO = ORDINE_LESSICOGRAFICO.reversed(),
            PER_LUNGHEZZA = Comparator.comparing(a -> a.valori.length);

    /**
     * @param comparator prende in input un comparator sugli arrayflessibili
     * @param valori e un array di valori di T
     */
    public ArrayFlessibile(Comparator<? super ArrayFlessibile<T>> comparator, T... valori)
    {
        this.valori = valori;
        this.comparator = comparator;
    }

    /**
     * @param valori un array flessibile costruito con un array di dimensione variabile di robe T
     *               chiama l'altro costruttore, fornendogli in input un comparatore
     */
    public ArrayFlessibile(T... valori)
    {
        this(ORDINE_LESSICOGRAFICO, valori);
    }

    @Override
    /**
     * Compara a con l'arrayflessibile dato in input
     */
    public int compareTo(ArrayFlessibile<T> a)
    {
        return comparator.compare(this, a);
    }

    public static void main(String[] args)
    {
        ArrayFlessibile<String> a1 = new ArrayFlessibile<String>(PER_LUNGHEZZA, "c", "a", "bbb");
        System.out.println(a1.compareTo(new ArrayFlessibile<String>("aa", "aaaa", "aa")));
    }
}
