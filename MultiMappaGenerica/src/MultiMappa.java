import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Predicate;

/**
 * Mappa che ammette più valori a fronte di una chiave 
 * @author Flavia Bonanni
 * @param <T>
 * @param <S>
 */

public class MultiMappa <T extends Comparable, S> implements Iterable<MultiMappa<T,S>.Elemento>
{
    private Map<T, ArrayList<S>> mappaGenerica = new HashMap<>();

    /**
     * put(k, v) che associa il valore alla chiave specificata
     * @param k chiave
     * @param v valore
     */
    public void put(T k, S v)
    {
        ArrayList<S> arrayDiK = new ArrayList<>();
        if (mappaGenerica.get(k) != null) arrayDiK = mappaGenerica.get(k);
        arrayDiK.add(v);
        mappaGenerica.put(k, arrayDiK);
    }

    /**
     * get(k) che restituisce l'insieme dei valori associati alla chiave
     * @param k chiave
     * @return valori
     */
    public ArrayList<S> get(T k)
    {
        return mappaGenerica.get(k);
    }
    
    /**
     * get(k, p) come sopra ma restituisce solo i valori che soddisfano il predicato p
     * @param k chiave
     * @param p predicato
     * @return valori
     */
    public ArrayList<S> get(T k, Predicate p)
    {
        ArrayList<S> pAbiding = new ArrayList<>();
        for(Elemento e : this)
        {
            if (e.k.equals(k))
            {
                for (S s : e.v)
                {
                    if (p.test(s))
                    {
                        pAbiding.add(s);
                    }
                }
            }
        }
        return pAbiding;
    }

    /**
     * values() che restituisce l'elenco (con duplicati) dei valori contenuti nella multimappa
     * @return elenco di valori
     */
    public List<S> values()
    {
        List<S> valori = new ArrayList<>();

        for (ArrayList<S> valore : mappaGenerica.values())
        {
            valori.addAll(valore);
        }
        return valori;
    }

    /**
     * valueSet() che restituisce l'insieme dei valori contenuti nella multimappa
     * @return valori
     */
    public Set<S> valueSet()
    {
        Set<S> valori = new HashSet<>();

        for (ArrayList<S> valore : mappaGenerica.values())
        {
            valori.addAll(valore);
        }
        return valori;
    }

    /**
     * transformToMultiMappa che restuisce una multimappa in cui le coppie (k, v) sono trasformate in (k, z) 
     * secondo una funzione (k, v) -> z (z può essere di tipo diverso rispetto a quello di v)
     * @param b bifunzione
     * @return multimappa
     */
    public Map TransformToMultiMappa(BiFunction b)
    {
        for (Map.Entry<T, ArrayList<S>> entry : mappaGenerica.entrySet())
        {
            ArrayList<S> inList = entry.getValue();
            ArrayList<S> outList = new ArrayList<>();
            for (S s : inList)
            {
                Object a = b.apply(entry.getKey(), s);
                S c = (S) a;
                outList.add(c);
            }
            entry.setValue(outList);
        }
        return mappaGenerica;
    }

    /**
     * mapEach che sostituisce ciascun valore v con un valore dello stesso tipo secondo una funzione (k, v) -> v'
     * @param b bifunzione
     * @return mappa modificata
     */
    public Map mapEach(BiFunction b)
    {
        return TransformToMultiMappa(b);
    }

    @Override
    public String toString()
    {
        return mappaGenerica.toString();
    }

    /**
     * la classe è iterabile sulle coppie (k, v) mediante una classe interna Elemento
     */
    class Elemento
    {
        private T k;
        private ArrayList<S> v;

        public Elemento(T k, ArrayList<S> v)
        {
            this.k = k;
            this.v = v;
        }
    }

    @Override
    public Iterator<MultiMappa<T,S>.Elemento> iterator()
    {
        List<Elemento> mappaDiElementi = new ArrayList<>();

        for (Map.Entry<T, ArrayList<S>> entry : mappaGenerica.entrySet())
        {
            T key = entry.getKey();
            ArrayList<S> value = entry.getValue();
            mappaDiElementi.add(new Elemento(key, value));
        }
        return mappaDiElementi.iterator();
    }

    public static void main(String[] args)
    {
        MultiMappa mm = new MultiMappa();
        mm.put(1988, "Flavia");
        mm.put(1988, "Flavia");
        mm.put(1988, "Giulia M.");
        mm.put(1987, "Daniele");
        mm.put(1984, "Giulia P.");
        mm.put(1988, "Deborah");
        /* System.out.println(mm);
        System.out.println("1988 = "+mm.get(1988));
        Predicate<String> predicate = s -> s.charAt(5) == 'a';
        System.out.println(mm.get(1988, predicate));
        Predicate<String> predicate2 = s -> s.charAt(0) == 'F';
        System.out.println(mm.get(1988, predicate2));
        System.out.println(mm.values());
        System.out.println(mm.valueSet());
        BiFunction<Integer, String, Integer> transform = (x, y) -> y.length();
        System.out.println(mm.TransformToMultiMappa(transform)); */
        BiFunction<Integer, String, String> upperCase = (x, y) -> y.toUpperCase();
        System.out.println(mm.TransformToMultiMappa(upperCase));
    }
}
