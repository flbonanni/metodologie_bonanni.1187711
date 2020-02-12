package it.uniroma1.metodologie2019.hw3;

import java.util.Map;

/**
 * Rappresentazione di relazione (generica) tra Synset
 * 
 * @author Flavia Bonanni
 */

public interface WordNetRelation 
{
	/**
	 * Trova la relazione a partire dal simbolo
	 * 
	 * @param name simbolo della relazione da cercare
	 * @param map ambito nel quale cercare la relazione
	 * @return relazione
	 */
	public static WordNetRelation find(String name, Map<String, ? extends WordNetRelation> map) 
	{
		WordNetRelation result = map.get(name);
		if (result == null) { return null; }
		return result;
	}
	
	/**
	 * Ritorna il simbolo
	 * 
	 * @return simbolo
	 */
	abstract public String getSymbol();
}
