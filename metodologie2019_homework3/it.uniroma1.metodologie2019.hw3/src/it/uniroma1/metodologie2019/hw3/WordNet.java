package it.uniroma1.metodologie2019.hw3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Istanza di una versione di WordNet
 * 
 * @author Flavia Bonanni
 */
public class WordNet implements Iterable<Synset>
{
	public static Map<String, WordNet> versions = new HashMap<>();
	private String path;
	private String ver;
	protected Map<String, Synset> synsetNetwork = new TreeMap<>();
	
	/**
	 * Istanza di WordNet
	 * 
	 * @param ver versione di WordNet
	 */
	private WordNet(String ver)
	{
		this.ver = ver;
		StringBuilder sb = new StringBuilder();
		sb.append("wordnet-releases\\releases\\WordNet-").append(ver).append("\\dict");
		path = (sb.toString());
		new Loader(path, this); 
	}

	/**
	 * Restituisce la versione di WordNet richiesta
	 * 
	 * @param ver versione di WordNet desiderata
	 * @return istanza di WordNet
	 */
	public static WordNet getInstance(String ver)
	{
		if (!versions.containsKey(ver)) versions.put(ver, new WordNet(ver));
		if (Loader.versionNotFound) return null;
		return versions.get(ver);
	}
	
	@Override
	public Iterator<Synset> iterator() 
	{
		return new Iterator<Synset>()
		{
			private int k;
			Iterator<Map.Entry<String,Synset>> iter = synsetNetwork.entrySet().iterator();
			
			@Override
			public boolean hasNext() { return k < synsetNetwork.size(); }

			@Override
			public Synset next()
			{ 
				Map.Entry<String,Synset> entry = iter.next(); 
				return entry.getValue(); 
			}
		};
	}
	
	/**
	 * Costruzione di uno stream di Synset
	 * 
	 * @return uno stream della TreeMap che contiene tutti i synset
	 */
	public Stream<Synset> stream()
	{
		List<Synset> lista = new ArrayList<Synset>(synsetNetwork.values());
		return lista.parallelStream();
	}
	
	/**
	 * Trova i Synset che contengono una determinata parola, filtrando i risultati in base alla POS
	 * 
	 * @param word parola da cercare
	 * @param pos part of speech della parola
	 * @return Synset che contengono la parola
	 */
	public List<Synset> getSynsets(String word, POS pos)
	{
		return
		getSynsets(word).parallelStream()
		.filter(s -> s.getPOS() == pos)
		.collect(Collectors.toList()); 
	}
	
	/**
	 * Trova i Synset che contengono una determinata parola
	 * 
	 * @param word parola da cercare
	 * @return Synset che contengono la parola
	 */
	public List<Synset> getSynsets(String word)
	{
		return 
		this.stream()
		.filter(s -> s.getSynonyms().indexOf(word) != -1)
		.collect(Collectors.toList());  
	}
	
	/**
	 * Trova un synset a partire dall'ID
	 * 
	 * @param ID del synset da cercare
	 * @return Synset che ha quell'ID
	 */
	public Synset getSynsetFromID(String ID)
	{
		Synset syn =
		this.stream()
		.filter(s -> s.getID().equals(ID))
		.collect(toSingleton()); 
		
		return (syn != null) ? syn : null; 
	}
	
	/**
	 * Ritorna solo il primo oggetto di un Collector
	 * 
	 * @param <T> tipo di Collector
	 * @return solo il primo oggetto
	 */
	public static <T> Collector<T, ?, T> toSingleton() 
	{
	    return Collectors.collectingAndThen(
	            Collectors.toList(),
	            list -> 
	            {
	                if (list.size() != 1) return null;
	                return list.get(0);
	            }
	    );
	}

	/**
	 * Ritorna i synset correlati al Synset dato in input
	 * 
	 * @param s Synset di cui cercare le relazioni
	 * @param wnr tipo di relazione
	 * @return Synset correlati
	 */
	public List<Synset> getRelatedSynsets(Synset s, WordNetRelation wnr)
	{
		List<Synset> relatedSynsets = new ArrayList<>();
		
		s.getPointers().forEach((k, v) -> 
		{
			if (k.equals(wnr)) relatedSynsets.addAll(v);
		});
		
		return relatedSynsets;
	}
	
	/**
	 * Ritorna i Synset correlati al Synset dato in input
	 * 
	 * @param s Synset di cui cercare le relazioni
	 * @param str tipo di relazione
	 * @return Synset correlati
	 */
	public List<Synset> getRelatedSynsets(Synset s, String str)
	{ 
		Map<WordNetRelation, List<Synset>> p = s.getPointers();
		WordNetRelation wnr = null;
		for (Entry<WordNetRelation, List<Synset>> entry : p.entrySet())
		{
			if (entry.getKey().getSymbol().equals(str)) wnr = entry.getKey();
		}
		return getRelatedSynsets(s, wnr);
	}
	
	// GETTERS
	/**
	 * Ritorna la versione attualmente in uso di WordNet
	 * 
	 * @return versione di WordNet
	 */
	public String getVersion() { return ver; }
	
	/**
	 * Ritorna una rete di Synset, ID/Synset
	 * 
	 * @return rete dei Synset
	 */
	public Map<String, Synset> getSynsetNetwork() { return synsetNetwork; }
	
	/**
	 * Aggiunge un Synset alla rete dei synset
	 * 
	 * @param s Synset da aggiungere alla rete dei synset
	 */
	public void addToSynsetNetwork(Synset s) { synsetNetwork.put(s.getID(), s); }
}
