import java.util.*;

/**
 * 
 * @author Flavia Bonanni
 */

public class Multimappa
{
    /**creare una multimappa (ovvero una mappa che permette, a fronte della stessa chiave, di memorizzare più valori) espondendo i metodi:
     - get e put
        - si faccia uso dei metodi più avanzati disponibili in Java 8 (ad es. getOrDefault o merge)
     - keySet e values (quest'ultimo restituisce l'elenco di tutti i valori presenti nella mappa, anche con ripetizione)
     - una versione di values che restituisce una lista di elementi ordinata secondo una comparazione ad hoc
     - valueSet che restituisce l'insieme di tutti i valori contenuti nella multimappa */

    Map<String, List<Integer>> compleanni = new HashMap<>();

    public void put(String nome, List<Integer> data) { compleanni.merge(nome, data,(v1,v2)-> v2); }

    public List<Integer> get(String nome) { return compleanni.getOrDefault(nome, null); }

    /**
     *  insieme di chiavi
     *  @return solo i nomi
     */
    public Set<String> keySet()
    {
        HashSet<String> soloNomi = new HashSet<>();
        compleanni.forEach((k,v)-> soloNomi.add(k));
        System.out.println(soloNomi);
        return soloNomi;
    }

    /**
     * insieme di valori anche con ripetizione
     * @return solo le date
     */
    public List<List<Integer>> values()
    {
        List<List<Integer>> soloDate = new ArrayList<>();
        compleanni.forEach((k,v)-> soloDate.add(v));
        System.out.println(soloDate);
        return soloDate;
    }

    /**
     * insieme di valori senza ripetizioni e ordinato
     * @return insieme di valori
     */
    public List<List<Integer>> organizedValues()
    {
        List<List<Integer>> soloDate = new ArrayList<>();
        compleanni.forEach((k,v)-> soloDate.add(v));
        TreeSet<List<Integer>> dateAdAlbero = new TreeSet<>(new ComparatoreAdHoc());
        dateAdAlbero.addAll(soloDate);

        System.out.println(dateAdAlbero);
        return soloDate;
    }

    public class ComparatoreAdHoc implements Comparator<List<Integer>>
    {
        @Override
        public int compare(List<Integer> o1, List<Integer> o2)
        {
            if (o1.get(0).compareTo((o2).get(0)) != 0) return o1.get(0).compareTo((o2).get(0));
            else if (o1.get(1).compareTo((o2).get(1)) != 0) return o1.get(1).compareTo((o2).get(1));
            else return o1.get(2).compareTo((o2).get(2));
        }
    }

    /**
     *  insieme di valori senza ripetizione
     * @return solo date
     */
    public Set valueSet()
    {
        Set<List<Integer>> soloDate = new HashSet<>();
        compleanni.forEach((k,v)-> soloDate.add(v));
        System.out.println(soloDate);
        return soloDate;
    }

    public void print() { System.out.println(compleanni.entrySet()); }

    public static void main(String[] args)
    {
        Multimappa mp = new Multimappa();
        mp.put("Arianna", Arrays.asList(1988, 10, 23));
        mp.put("Flavia", Arrays.asList(1988, 10, 23));
        mp.put("Emanuela", Arrays.asList(1959, 12, 04));
        mp.put("Giovanni", Arrays.asList(1957, 02, 19));
        mp.put("Livio", Arrays.asList(1993, 07, 26));
        System.out.print("Stampa dell'elenco completo: ");
        mp.print();
        System.out.print("Stampa dei soli nomi: ");
        mp.keySet();
        System.out.print("Stampa dei soli valori: ");
        mp.values();
        System.out.print("Stampa dei soli valori ordinati e senza ripetizioni: ");
        mp.organizedValues();
        System.out.print("Stampa dei soli valori senza ripetizioni: ");
        mp.valueSet();
    }


}
