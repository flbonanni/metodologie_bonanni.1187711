package it.uniroma1.fabbricasemanticaJSweet.userpage;

import static def.dom.Globals.console;
import static def.dom.Globals.document;
import static def.dom.Globals.window;

import def.dom.Element;
import def.dom.Event;
import def.dom.HTMLDivElement;
import def.dom.HTMLElement;
import def.dom.HTMLFormElement;
import def.dom.HTMLInputElement;
import def.dom.Node;
import def.js.Array;
import def.js.TypeError;
import it.uniroma1.fabbricasemanticaJSweet.builder.HTMLDivElementBuilder;
import it.uniroma1.fabbricasemanticaJSweet.builder.HTMLFormElementBuilder;
import it.uniroma1.fabbricasemanticaJSweet.builder.HTMLInputElementBuilder;

/**
 * Superclasse delle pagine per l'autenticazione e la home
 * @author Flavia Bonanni
 */
public abstract class AuthPage 
{
	/**
	 * Metodo generico per creare un form
	 * @param SERVLET_URL indirizzo a cui mandare i dati del form
	 * @return form
	 */
	public HTMLFormElement createForm(String SERVLET_URL)
	{
		console.log("Creating form");
		HTMLFormElement form = new HTMLFormElementBuilder()
			.setAction(SERVLET_URL)
			.setMethod()
			.build();
		console.log("Form Done");
		return form;
	}

	/**
	 * Metodo per creare il campo email
	 * @return campo email
	 */
	public HTMLInputElement createEmail()
	{
		console.log("Creating email field"); 
		HTMLInputElement email = new HTMLInputElementBuilder()
			.setName("email")
			.setClassName("form-control")
			.setType("email")
			.setPlaceholder("xxxx@email.com")
			.setRequired(true)
			.build();
		return email;
	}
	
	/**
	 * Metodo per creare il campo password
	 * @return campo password
	 */
	public HTMLInputElement createPassword()
	{
		console.log("Creating password field");
		HTMLInputElement password = new HTMLInputElementBuilder()
			.setName("password")
			.setClassName("form-control")
			.setPlaceholder("********")
			.setRequired(true)
			.setType("password")
			.build();
		return password;
	}
	
	/**
	 * Metodo per creare il bottone di Submit
	 * @param value valore del bottone
	 * @return bottone di Submit
	 */
	public HTMLInputElement createSubmit(String value)
	{
		console.log("Creating submit button");
		HTMLInputElement submit = new HTMLInputElementBuilder()
				.setType("submit")
				.setName("submit-button")
				.setClassName("btn btn-primary")
				.setValue(value)
				.build();
		return submit;
	}
	
	private HTMLFormElement form;
	
	/**
	 * Metodo per controllare se i dati inseriti sono validi
	 * @param f form da controllare
	 */
	public void createArrayForValidation(HTMLFormElement f)
	{
		this.form = f;
		form = (HTMLFormElement) document.querySelector("form");
		form.onsubmit = this::onSubmit;
		
		console.log("creando array di elementi...");
		Array<Element> inputs = Array.from(form.querySelectorAll(".form-control"));
		for (Node element : inputs) 
		{
			addHitListener((HTMLElement) element);
		}
		console.log("array creato.");
		
		try
		{
			form.querySelector("#reset").addEventListener("click", (event) -> {
				form.reset();
				for (Element element : inputs) {
					element.classList.remove("hit");
				}
			});
		}
		catch (TypeError e)
		{
			console.log("in attesa del form...");
		}
	}
	
	/**
	 * Metodo che controlla i cambiamenti avvenuti su un certo elemento
	 * @param element da controllare
	 */
	private void addHitListener(HTMLElement element) 
	{
		element.addEventListener("keyup", (evt) -> {
			console.log("typing...");
			element.classList.add("hit");
		});
	}
	
	/**
	 * Metodo che si attiva quando l'utente clicca submit sul form e ne restituisce la validità
	 * @param event che attiva il controllo
	 * @return booleano per form valido/non valido
	 */
	private Boolean onSubmit(Event event) 
	{
		event.stopPropagation();
		console.log("form is valid");
		document.getElementById("form").classList.add("invisible");

		window.scroll(0, 0);

		document.getElementById("email").textContent = getInput("email").value;
		document.getElementById("password").textContent = getInput("password").value;

		return false;
	}
	
	/**
	 * Getter per il form
	 * @return form
	 */
	public HTMLFormElement getForm() { return form; }
	
	/**
	 * Getter per l'input
	 * @param name dell'input
	 * @return input
	 */
	private HTMLInputElement getInput(String name) 
	{
		return (HTMLInputElement) document.querySelector("[name='" + name + "']");
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
