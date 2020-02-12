package it.uniroma1.fabbricasemanticaJSweet.game;

import static def.dom.Globals.console;

import def.dom.HTMLAnchorElement;
import def.dom.HTMLDivElement;
import def.dom.HTMLFormElement;
import def.dom.HTMLInputElement;
import def.dom.HTMLLabelElement;
import def.dom.HTMLTextAreaElement;
import it.uniroma1.fabbricasemanticaJSweet.builder.HTMLAnchorElementBuilder;
import it.uniroma1.fabbricasemanticaJSweet.builder.HTMLDivElementBuilder;
import it.uniroma1.fabbricasemanticaJSweet.builder.HTMLFormElementBuilder;
import it.uniroma1.fabbricasemanticaJSweet.builder.HTMLInputElementBuilder;
import it.uniroma1.fabbricasemanticaJSweet.builder.HTMLLabelElementBuilder;
import it.uniroma1.fabbricasemanticaJSweet.builder.HTMLTextAreaElementBuilder;

/**
 * Superclasse per tutti i task
 * @author Flavia Bonanni
 */
public abstract class Annotation 
{
	/**
	 * Metodo per creare i form
	 * @param SERVLET_URL indirizzo a cui inviare i dati
	 * @return form
	 */
	public HTMLFormElement createForm(String SERVLET_URL)
	{
		console.log("Creating form");
		HTMLFormElement form = new HTMLFormElementBuilder()
				.setAction(SERVLET_URL)
				.setMethod()
				.build();
		return form;
	}
	
	/**
	 * Metodo per creare label
	 * @return label
	 */
	public HTMLLabelElement createDescription()
	{
		console.log("creating desct");
		HTMLLabelElement description = new HTMLLabelElementBuilder()
				.setClassName("form-control-plaintext")
				.build();
		return description;
	}
	
	/**
	 * Metodo per creare l'istruzione per l'utente
	 * @param textContent istruzione
	 * @return istruzione per l'utente
	 */
	public HTMLLabelElement createHint(String textContent)
	{
		console.log("creating hint");
		HTMLLabelElement hint = new HTMLLabelElementBuilder()
				.setClassName("form-control-hint")
				.setTextContent(textContent)
				.build();
		return hint;
	}
	
	/**
	 * Metodo per creare la Word
	 * @return word
	 */
	public HTMLLabelElement createWord()
	{
		console.log("creating word");
		HTMLLabelElement word = new HTMLLabelElementBuilder()
				.setClassName("form-control-word")
				.build();
		return word;
	}
	
	/**
	 * Metodo per creare un'etichetta per slider
	 * @param textContent testo dell'etichetta
	 * @return etichetta per slider
	 */
	public HTMLLabelElement createRangeLabel(String textContent)
	{
		console.log("creating label");
		HTMLLabelElement rangeLabel = new HTMLLabelElementBuilder()
				.setClassName("form-control-rangelabel")
				.setTextContent(textContent)
				.build();
		return rangeLabel;
	}
	
	/**
	 * Metodo per creare un'etichetta per un bottone radio
	 * @param textContent testo dell'etichetta
	 * @return etichetta per un bottone radio
	 */
	public HTMLLabelElement createRadioLabel(String textContent)
	{
		HTMLLabelElement radioLabel = new HTMLLabelElementBuilder()
				.setClassName("form-control-radio")
				.setTextContent(textContent)
				.build();
		return radioLabel;
	}
	
	/**
	 * Metodo per creare un esempio d'uso di una Word
	 * @return esempio 
	 */
	public HTMLLabelElement createExample()
	{
		HTMLLabelElement example = new HTMLLabelElementBuilder()
				.setClassName("form-control-example")
				.build();
		return example;
	}
	
	/**
	 * Metodo per creare un textarea
	 * @param placeholder per la textarea
	 * @return textarea
	 */
	public HTMLTextAreaElement createTextarea(String placeholder)
	{
		console.log("creating translation");
		HTMLTextAreaElement translation = new HTMLTextAreaElementBuilder()
				.setClassName("form-control")
				.setName("translation")
				.setPlaceholder(placeholder)
				.build();
		return translation;
	}
	
	/**
	 * Metodo per creare bottone di submit
	 * @return bottone di submit
	 */
	public HTMLInputElement createSubmit()
	{
		console.log("creating submit button");
		HTMLInputElement submit = new HTMLInputElementBuilder()
				.setType("submit")
				.setName("submit_button")
				.setClassName("btn btn-primary")
				.setValue("Next")
				.build();
		return submit;
	}
	
	/**
	 * Metodo per creare un bottone di skip
	 * @return bottone di skip
	 */
	public HTMLInputElement createSkip()
	{
		console.log("creating skip button");
		HTMLInputElement skip = new HTMLInputElementBuilder()
			.setType("submit")
			.setName("skip_button")
			.setClassName("btn btn-primary")
			.setValue("Skip")
			.build();
		return skip;
	}
	
	/**
	 * Metodo per creare un bottone radio
	 * @return bottone radio
	 */
	public HTMLInputElement createRadio()
	{
		HTMLInputElement radio = new HTMLInputElementBuilder()
				.setType("radio")
				.setName("radio")
				.setClassName("form-control-radio-button")
				.build();
		return radio;
	}
	
	/**
	 * Metodo per creare uno slider
	 * @return slider
	 */
	public HTMLInputElement createRange()
	{
		console.log("creating range");
		HTMLInputElement range = new HTMLInputElementBuilder()
				.setClassName("form-control-range")
				.setType("range")
				.build();
		return range;
	}
	
	/**
	 * Metodo per creare link alla home
	 * @return link alla home
	 */
	public HTMLAnchorElement createHomeLink()
	{
		console.log("Creating home link");
		HTMLAnchorElement home = new HTMLAnchorElementBuilder()
				.setText("home")
				.setName("home")
				.setHref("home.html")
				.build();
		return home;
	}
	
	/**
	 * Metodo per creare link di logout
	 * @return link di logout
	 */
	public HTMLAnchorElement createLogoutLink()
	{
		console.log("Creating logout link");
		HTMLAnchorElement logout = new HTMLAnchorElementBuilder()
				.setText("logout")
				.setName("logout")
				.setHref("logout.jsp")
				.build();
		return logout;
	}
	
	/**
	 * metodo per creare div
	 * @param className del div
	 * @return div
	 */
	public HTMLDivElement divGenerator(String className)
	{
		HTMLDivElement div = new HTMLDivElementBuilder()
				.setClassName(className)
				.build();
		return div;
	}
}
