package it.uniroma1.fabbricasemantica.wordnet;

import java.util.HashMap;
import java.util.Map;

/**
 * Relazioni tra Synset - verbi
 * 
 * @author Flavia Bonanni
 */
public enum WordNetVerbRelations implements WordNetRelation
{
	ANTONYM ("!"),
	HYPERNYM ("@"),
	HYPONYM ("~"),
	ENTAILMENT("*"),
	CAUSE(">"), 
	ALSO_SEE("^"), 
	VERB_GROUP("$"), 
	DERIVATIONALLY_RELATED_FROM ("+"), 
	DOMAIN_OF_SYNSET_TOPIC (";c"),
	DOMAIN_OF_SYNSET_REGION (";r"),
	DOMAIN_OF_SYNSET_USAGE (";u");
	
	private final String symbol; 
	private static final Map<String, WordNetVerbRelations> map = new HashMap<>(values().length, 1);
	static 
	{
		for (WordNetVerbRelations c : values())
			map.put(c.symbol, c);
	}
	
	/**
	 * Relazione tra synset
	 * 
	 * @param symbol della relazione
	 */
	WordNetVerbRelations(String symbol) { this.symbol = symbol; }
	
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
