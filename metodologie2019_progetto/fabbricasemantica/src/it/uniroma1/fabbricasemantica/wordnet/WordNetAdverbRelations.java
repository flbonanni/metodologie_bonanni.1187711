package it.uniroma1.fabbricasemantica.wordnet;

import java.util.HashMap;
import java.util.Map;

/**
 * Relazioni tra Synset - avverbi
 * 
 * @author Flavia Bonanni
 */
public enum WordNetAdverbRelations implements WordNetRelation
{
	ANTONYM ("!"),
	DERIVED_FROM_ADJECTIVE ("\\"),
	DOMAIN_OF_SYNSET_TOPIC (";c"),
	DOMAIN_OF_SYNSET_REGION (";r"),
	DOMAIN_OF_SYNSET_USAGE (";u");
	
	private final String symbol; 
	private static final Map<String, WordNetAdverbRelations> map = new HashMap<>(values().length, 1);
	static 
	{
		for (WordNetAdverbRelations c : values())
			map.put(c.symbol, c);
	}
	
	/**
	 * Relazione tra synset
	 * 
	 * @param symbol della relazione
	 */
	WordNetAdverbRelations(String symbol) { this.symbol = symbol; }
	
	/**
	 * Ritorna il symbol di una relazione
	 * 
	 * @return symbol di una relazione
	 */
	public String getSymbol() { return symbol; }

	/**
	 * Trova una relazione a partire dal simbolo
	 * 
	 * @param name simbolo
	 * @return relazione
	 */
	public static WordNetRelation find(String name) 
	{
		return WordNetRelation.find(name, map);
	}
}
