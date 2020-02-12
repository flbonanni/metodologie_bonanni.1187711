package it.uniroma1.fabbricasemanticaJSweet.builder;

import static def.dom.Globals.document;

import def.dom.HTMLInputElement;
import jsweet.util.StringTypes;

/**
 * Builder per gli elementi di tipo input
 * @author Flavia Bonanni
 */
public class HTMLInputElementBuilder extends HTMLElementBuilder
{
	private String name;
	private String className;
	private String placeholder;
	private boolean required;
	private String type;
	private String value;
		
	public HTMLInputElementBuilder() {}
	
	/**
	 * Aggiunge il nome per l'elemento input
	 * @param n nome da aggiungere
	 * @return l'elemento input
	 */
	public HTMLInputElementBuilder setName(String n)
	{
		name = n;
		return this;
	}
	
	/**
	 * Aggiunge la classname per l'elemento input
	 * @param c classname
	 * @return l'elemento input
	 */
	public HTMLInputElementBuilder setClassName(String c)
	{
		className = c;
		return this;
	}
	
	/**
	 * Aggiunge il placeholder per l'elemento input
	 * @param p placeholder
	 * @return l'elemento input
	 */
	public HTMLInputElementBuilder setPlaceholder(String p)
	{
		placeholder = p;
		return this;
	}
	
	/**
	 * Setta se l'elemento è obbligatorio
	 * @param r booleano che indica se il campo è obbligatorio
	 * @return l'elemento input
	 */
	public HTMLInputElementBuilder setRequired(boolean r)
	{
		required = r;
		return this;
	}
	
	/**
	 * Aggiunge il type per l'elemento input
	 * @param t type
	 * @return l'elemento input
	 */
	public HTMLInputElementBuilder setType(String t)
	{
		type = t;
		return this;
	}
	
	/**
	 * Aggiunge il valore per l'elemento input
	 * @param v valore
	 * @return l'elemento input
	 */
	public HTMLInputElementBuilder setValue(String v)
	{
		value = v;
		return this;
	}

	@Override
	public HTMLInputElement build()
	{
		HTMLInputElement inputElement = document.createElement(StringTypes.input);
		if (name != null) inputElement.name = this.name;
		if (className != null) inputElement.className = this.className;
		if (placeholder != null) inputElement.placeholder = this.placeholder;
		inputElement.required = required;
		if (type != null) inputElement.type = this.type;
		if (value != null) inputElement.value = this.value;
		return inputElement;
	}
}