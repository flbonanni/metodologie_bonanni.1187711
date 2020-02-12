package it.uniroma1.fabbricasemanticaJSweet.userpage;

import static def.dom.Globals.console;
import static def.jquery.Globals.$;

import def.dom.HTMLDivElement;
import def.dom.HTMLFormElement;
import def.dom.HTMLInputElement;
import def.dom.HTMLLabelElement;
import it.uniroma1.fabbricasemanticaJSweet.builder.HTMLAnchorElementBuilder;
import it.uniroma1.fabbricasemanticaJSweet.builder.HTMLLabelElementBuilder;
import def.dom.HTMLAnchorElement;

/**
 * Classe che genera la pagina di login
 * @author Flavia Bonanni
 */
public class Login extends AuthPage
{	
	public static final String SERVLET_URL = "login.jsp";
	
	/**
	 * Metodo che genera il form del login
	 * @return form
	 */
	public HTMLFormElement addForm()
	{
		HTMLFormElement form = createForm(SERVLET_URL);

		HTMLInputElement email = createEmail();

		HTMLInputElement password = createPassword();
		
		HTMLInputElement submit = createSubmit("Login");
		
		console.log("Creating signup link");
		HTMLAnchorElement signup = new HTMLAnchorElementBuilder()
				.setText("Signup")
				.setName("signup")
				.setHref("signup.html")
				.build();
		
		$(signup).css("float", "right");
		
		console.log("Creating title");
		HTMLLabelElement title = new HTMLLabelElementBuilder()
				.setClassName("form-control-plaintext")
				.setTextContent("LOGIN")
				.build();
		title.setAttribute("style", "font-weight:bold");
		
		console.log("Formatting the email field");
		HTMLDivElement divEmail = divGenerator("form-group");

		HTMLLabelElement labelForEmail = new HTMLLabelElementBuilder()
				.setTextContent("email:")
				.build();
		$(divEmail).append(labelForEmail);
		$(divEmail).append(email);
		
		console.log("Formatting the password field");
		HTMLDivElement divPassword = divGenerator("form-group");
		
		HTMLLabelElement labelForPassword = new HTMLLabelElementBuilder()
				.setTextContent("password:")
				.build();
		$(divPassword).append(labelForPassword);
		$(divPassword).append(password);
		
		console.log("Formatting the button");
		HTMLDivElement divButtons = divGenerator("form-group");
		
		$(divButtons).append(submit, signup);
				
		console.log("Adding to form");
		$(form).css("margin", "0% 1.5%");
		$(form).append(title);
		$(form).append(divEmail);
		$(form).append(divPassword);
		$(form).append(divButtons);
		console.log("Adding to body");
		
		return form;
	}
	
	public static void main(String[] args) 
	{
		Login LoginPage = new Login();
		$("body").append(LoginPage.addForm());
		LoginPage.createArrayForValidation(LoginPage.getForm());
	}
}
