package it.uniroma1.fabbricasemanticaJSweet.builder;

import static def.dom.Globals.document;

import def.dom.HTMLAnchorElement;
import jsweet.util.StringTypes;

/**
 * Builder per gli elementi di tipo link
 * @author Flavia Bonanni
 */
public class HTMLAnchorElementBuilder extends HTMLElementBuilder
{
	private String text;
	private String name;
	private String href;
	
	// costruttore con visibilità di package
	public HTMLAnchorElementBuilder() {}
	
	/**
	 * Aggiunge il testo del link
	 * @param t testo da aggiungere
	 * @return l'elemento link
	 */
	public HTMLAnchorElementBuilder setText(String t)
	{
		text = t;
		return this;
	}
	
	/**
	 * Aggiunge il nome del link
	 * @param n nome da aggiungere
	 * @return l'elemento link
	 */
	public HTMLAnchorElementBuilder setName(String n)
	{
		name = n;
		return this;
	}
	
	/**
	 * Aggiunge l'indirizzo del link
	 * @param h indirizzo da aggiungere
	 * @return l'elemento link
	 */
	public HTMLAnchorElementBuilder setHref(String h)
	{
		href = h;
		return this;
	}

	@Override
	public HTMLAnchorElement build()
	{
		HTMLAnchorElement formElement = document.createElement(StringTypes.a);
		if (text != null) formElement.text = this.text;
		if (name != null) formElement.name = this.name;
		if (href != null) formElement.href = this.href;
		return formElement;
	}
}