package it.uniroma1.fabbricasemanticaJSweet.builder;

import static def.dom.Globals.document;

import def.dom.HTMLOptionElement;
import jsweet.util.StringTypes;

/**
 * Builder per gli elementi di tipo option
 * @author Flavia Bonanni
 */
public class HTMLOptionElementBuilder extends HTMLElementBuilder
{
	private String text;
		
	// costruttore con visibilità di package
	public HTMLOptionElementBuilder() {}
		
	/**
	 * Aggiunge il testo dell'elemento option
	 * @param t testo da aggiungere
	 * @return l'elemento option
	 */
	public HTMLOptionElementBuilder setText(String t)
	{
		text = t;
		return this;
	}
	
	@Override
	public HTMLOptionElement build()
	{
		HTMLOptionElement formElement = document.createElement(StringTypes.option);
		if (text != null) formElement.text = this.text;
		return formElement;
	}
}