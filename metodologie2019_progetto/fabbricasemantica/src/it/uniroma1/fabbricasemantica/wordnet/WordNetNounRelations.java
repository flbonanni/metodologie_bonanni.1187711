package it.uniroma1.fabbricasemantica.wordnet;

import java.util.HashMap;
import java.util.Map;

/**
 * Relazioni tra Synset - sostantivi
 * 
 * @author Flavia Bonanni
 */
public enum WordNetNounRelations implements WordNetRelation
{
	ANTONYM ("!"),
	HYPERNYM ("@"),
	INSTANCE_HYPERNYM ("@i"),
	HYPONYM ("~"),
	INSTANCE_HYPONYM ("~i"),
	MEMBER_HOLONYM ("#m"),
	SUBSTANCE_HOLONYM ("#s"),
	PART_HOLONYM ("#p"),
	MEMBER_MERONYM ("%m"),
	SUBSTANCE_MERONYM ("%s"),
	PART_MERONYM ("%p"),
	ATTRIBUTE ("="),
	DERIVATIONALLY_RELATED_FROM ("+"), 
	DOMAIN_OF_SYNSET_TOPIC (";c"),
	MEMBER_OF_THIS_DOMAIN_TOPIC ("-c"),
	DOMAIN_OF_SYNSET_REGION (";r"),
	MEMBER_OF_THIS_DOMAIN_REGION ("-r"),
	DOMAIN_OF_SYNSET_USAGE (";u"),
	MEMBER_OF_THIS_DOMAIN_USAGE ("-u");
	
	private final String symbol; 
	private static final Map<String, WordNetNounRelations> map = new HashMap<>(values().length, 1);
	static 
	{
		for (WordNetNounRelations c : values())
			map.put(c.symbol, c);
	}
	
	/**
	 * Relazione tra synset
	 * 
	 * @param symbol della relazione
	 */
	WordNetNounRelations(String symbol) { this.symbol = symbol; }
	
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
