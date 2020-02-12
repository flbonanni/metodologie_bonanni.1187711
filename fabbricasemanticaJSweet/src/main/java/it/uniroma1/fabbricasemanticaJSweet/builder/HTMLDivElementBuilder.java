package it.uniroma1.fabbricasemanticaJSweet.builder;

import static def.dom.Globals.document;

import def.dom.HTMLDivElement;
import jsweet.util.StringTypes;

/**
 * Builder per gli elementi di tipo div
 * @author Flavia Bonanni
 */
public class HTMLDivElementBuilder extends HTMLElementBuilder
{
	private String className;
		
	// costruttore con visibilità di package
	public HTMLDivElementBuilder() {}
	
	/**
	 * Aggiunge il tipo di classname per l'elemento div
	 * @param c classname
	 * @return l'elemento div
	 */
	public HTMLDivElementBuilder setClassName(String c)
	{
		className = c;
		return this;
	}

	@Override
	public HTMLDivElement build()
	{
		HTMLDivElement formElement = document.createElement(StringTypes.div);
		if (className != null) formElement.className = this.className;
		return formElement;
	}
}