package it.uniroma1.fabbricasemanticaJSweet.builder;

import static def.dom.Globals.document;

import def.dom.HTMLTextAreaElement;
import jsweet.util.StringTypes;

/**
 * Builder per gli elementi di tipo textarea
 * @author Flavia Bonanni
 */
public class HTMLTextAreaElementBuilder extends HTMLElementBuilder
{
	private String className;
	private String name;
	private String placeholder;
		
	// costruttore con visibilità di package
	public HTMLTextAreaElementBuilder() {}
	
	/**
	 * Aggiunge il classname per l'elemento textarea
	 * @param c classname
	 * @return l'elemento textarea
	 */
	public HTMLTextAreaElementBuilder setClassName(String c)
	{
		className = c;
		return this;
	}
	
	/**
	 * Aggiungere il nome dell'elemento textarea
	 * @param n nome da aggiungere
	 * @return l'elemento textarea
	 */
	public HTMLTextAreaElementBuilder setName(String n)
	{
		name = n;
		return this;
	}
	
	/**
	 * Aggiunge il placeholder dell'elemento textarea
	 * @param p placeholder
	 * @return l'elemento textarea
	 */
	public HTMLTextAreaElementBuilder setPlaceholder(String p)
	{
		placeholder = p;
		return this;
	}

	@Override
	public HTMLTextAreaElement build()
	{
		HTMLTextAreaElement formElement = document.createElement(StringTypes.textarea);
		if (className != null) formElement.className = this.className;
		if (name != null) formElement.name = this.name;
		if (placeholder != null) formElement.placeholder = this.placeholder;
		return formElement;
	}
}