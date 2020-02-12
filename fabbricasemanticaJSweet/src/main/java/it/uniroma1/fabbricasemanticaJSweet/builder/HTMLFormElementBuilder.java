package it.uniroma1.fabbricasemanticaJSweet.builder;

import static def.dom.Globals.document;

import def.dom.HTMLFormElement;
import jsweet.util.StringTypes;

/**
 * Builder per gli elementi di tipo form
 * @author Flavia Bonanni
 */
public class HTMLFormElementBuilder extends HTMLElementBuilder
{
	private String action;
	private String method;
		
	// costruttore con visibilità di package
	public HTMLFormElementBuilder() {}
		
	/**
	 * Aggiunge il tipo di azione per l'elemento form
	 * @param a azione da eseguire
	 * @return l'elemento form
	 */
	public HTMLFormElementBuilder setAction(String a)
	{
		action = a;
		return this;
	}
	
	/**
	 * Aggiunge il metodo per l'elemento form
	 * @return l'elemento form
	 */
	public HTMLFormElementBuilder setMethod()
	{
		method = "POST";
		return this;
	}

	@Override
	public HTMLFormElement build()
	{
		HTMLFormElement formElement = document.createElement(StringTypes.form);
		if (action != null) formElement.action = this.action;
		if (method != null) formElement.method = this.method;

		return formElement;
	}
}