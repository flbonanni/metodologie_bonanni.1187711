package it.uniroma1.fabbricasemanticaJSweet.builder;

import def.dom.HTMLElement;

/**
 * Builder per tutti gli elementi HTML
 * @author Flavia Bonanni
 */
public abstract class HTMLElementBuilder 
{
	/**
	 * Metodo build generico
	 * @return l'elemento da costruirsi
	 */
	abstract public HTMLElement build();
}
