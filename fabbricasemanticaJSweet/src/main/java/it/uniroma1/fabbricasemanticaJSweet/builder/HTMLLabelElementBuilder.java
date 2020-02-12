package it.uniroma1.fabbricasemanticaJSweet.builder;

import static def.dom.Globals.document;

import def.dom.HTMLLabelElement;
import jsweet.util.StringTypes;

/**
 * Builder per gli elementi di tipo etichetta
 * @author Flavia Bonanni
 */
public class HTMLLabelElementBuilder extends HTMLElementBuilder
{
	private String className;
	private String textContent;
		
	// costruttore con visibilità di package
	public HTMLLabelElementBuilder() {}
		
	/**
	 * Aggiunge il classname per l'elemento etichetta
	 * @param c classname
	 * @return l'elemento etichetta
	 */
	public HTMLLabelElementBuilder setClassName(String c)
	{
		className = c;
		return this;
	}
	
	/**
	 * Aggiunge il testo dell'elemento etichetta
	 * @param t testo da aggiungere
	 * @return l'elemento etichetta
	 */
	public HTMLLabelElementBuilder setTextContent(String t)
	{
		textContent = t;
		return this;
	}

	@Override
	public HTMLLabelElement build()
	{
		HTMLLabelElement formElement = document.createElement(StringTypes.label);
		if (className != null) formElement.className = this.className;
		if (textContent != null) formElement.textContent = this.textContent;

		return formElement;
	}
}