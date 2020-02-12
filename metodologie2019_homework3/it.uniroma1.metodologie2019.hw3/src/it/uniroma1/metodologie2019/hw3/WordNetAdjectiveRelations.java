package it.uniroma1.metodologie2019.hw3;

import java.util.HashMap;
import java.util.Map;

/**
 *  Relazioni tra Synset - aggettivi
 * 
 * @author Flavia Bonanni
 */
public enum WordNetAdjectiveRelations implements WordNetRelation
{
	ANTONYM ("!"),
	HYPERNYM ("@"),
	SIMILAR_TO("&"),
	PARTICIPLE_OF_VERB("<"),
	PERTAINYM("\\"),
	ATTRIBUTE("="),
	ALSO_SEE("^"),
	DOMAIN_OF_SYNSET_TOPIC (";c"),
	DOMAIN_OF_SYNSET_REGION (";r"),
	DOMAIN_OF_SYNSET_USAGE (";u");
	
	private final String symbol; 
	private static final Map<String, WordNetAdjectiveRelations> map = new HashMap<>(values().length, 1);
	static 
	{
		for (WordNetAdjectiveRelations c : values())
			map.put(c.symbol, c);
	}
	
	/**
	 * Relazione tra synset
	 * 
	 * @param symbol della relazione
	 */
	WordNetAdjectiveRelations(String symbol) { this.symbol = symbol; }
	
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
