package it.uniroma1.fabbricasemanticaJSweet.userpage;

import static def.dom.Globals.console;
import static def.dom.Globals.document;
import static def.jquery.Globals.$;

import def.dom.HTMLOptionElement;
import def.dom.HTMLDivElement;
import def.dom.HTMLFormElement;
import def.dom.HTMLInputElement;
import def.dom.HTMLLabelElement;
import def.dom.HTMLSelectElement;
import it.uniroma1.fabbricasemanticaJSweet.builder.HTMLAnchorElementBuilder;
import it.uniroma1.fabbricasemanticaJSweet.builder.HTMLInputElementBuilder;
import it.uniroma1.fabbricasemanticaJSweet.builder.HTMLLabelElementBuilder;
import it.uniroma1.fabbricasemanticaJSweet.builder.HTMLOptionElementBuilder;
import jsweet.util.StringTypes;
import def.dom.HTMLAnchorElement;

/**
 * Classe che genera la pagina di signup
 * @author Flavia Bonanni
 */
public class SignUp extends AuthPage
{
	public static final String SERVLET_URL = "signup.jsp";

	/**
	 * Metodo che genera il form del login
	 * @return form
	 */
	public HTMLFormElement addForm()
	{
		HTMLFormElement form = createForm(SERVLET_URL);

		HTMLInputElement email = createEmail();

		HTMLInputElement password = createPassword();
		
		console.log("Creating repeat password field");
		HTMLInputElement repeatPassword = new HTMLInputElementBuilder()
				.setName("repeatPassword")
				.setClassName("form-control")
				.setPlaceholder("*******")
				.setRequired(true)
				.setType("password")
				.build();
		
		console.log("Creating checkboxes");
		HTMLInputElement selectIT = new HTMLInputElementBuilder()
				.setName("selectlang")
				.setClassName("form-control-box")
				.setRequired(false)
				.setType("checkbox")
				.setValue("IT")
				.build();

		HTMLInputElement selectEN = new HTMLInputElementBuilder()
				.setName("selectlang")
				.setClassName("form-control-box")
				.setRequired(false)
				.setType("checkbox")
				.setValue("EN")
				.build();
		
		HTMLInputElement submit = createSubmit("Signup");
		
		console.log("creating login link");
		HTMLAnchorElement login = new HTMLAnchorElementBuilder()
				.setText("Login")
				.setName("login")
				.setHref("login.html")
				.build();
		
		console.log("Creating extra language field");
		HTMLInputElement extra1 = new HTMLInputElementBuilder()
				.setName("extra1")
				.setClassName("form-control")
				.setPlaceholder("other language #1")
				.build();
		
		console.log("Creating language level 1");
		HTMLOptionElement A1_1 = new HTMLOptionElementBuilder()
				.setText("A1")
				.build();
		HTMLOptionElement A2_1 = new HTMLOptionElementBuilder()
				.setText("A2")
				.build();
		HTMLOptionElement B1_1 = new HTMLOptionElementBuilder()
				.setText("B1")
				.build();
		HTMLOptionElement B2_1 = new HTMLOptionElementBuilder()
				.setText("B2")
				.build();
		HTMLOptionElement C1_1 = new HTMLOptionElementBuilder()
				.setText("C1")
				.build();
		HTMLOptionElement C2_1 = new HTMLOptionElementBuilder()
				.setText("C2")
				.build();
		
		HTMLSelectElement level1 = document.createElement(StringTypes.select);
		level1.add(A1_1);
		level1.add(A2_1);
		level1.add(B1_1);
		level1.add(B2_1);
		level1.add(C1_1);
		level1.add(C2_1);
		
		console.log("Creating extra language field");
		HTMLInputElement extra2 = new HTMLInputElementBuilder()
				.setName("extra2")
				.setClassName("form-control")
				.setPlaceholder("other language #2")
				.build();
		
		console.log("Creating language level 2");
		HTMLOptionElement A1_2 = new HTMLOptionElementBuilder()
				.setText("A1")
				.build();
		HTMLOptionElement A2_2 = new HTMLOptionElementBuilder()
				.setText("A2")
				.build();
		HTMLOptionElement B1_2 = new HTMLOptionElementBuilder()
				.setText("B1")
				.build();
		HTMLOptionElement B2_2 = new HTMLOptionElementBuilder()
				.setText("B2")
				.build();
		HTMLOptionElement C1_2 = new HTMLOptionElementBuilder()
				.setText("C1")
				.build();
		HTMLOptionElement C2_2 = new HTMLOptionElementBuilder()
				.setText("C2")
				.build();
		
		HTMLSelectElement level2 = document.createElement(StringTypes.select);
		level2.add(A1_2);
		level2.add(A2_2);
		level2.add(B1_2);
		level2.add(B2_2);
		level2.add(C1_2);
		level2.add(C2_2); 
		
		console.log("Creating extra language field");
		HTMLInputElement extra3 = new HTMLInputElementBuilder()
				.setName("extra3")
				.setClassName("form-control")
				.setPlaceholder("other language #3")
				.build();
		
		console.log("Creating language level 2");
		HTMLOptionElement A1_3 = new HTMLOptionElementBuilder()
				.setText("A1")
				.build();
		HTMLOptionElement A2_3 = new HTMLOptionElementBuilder()
				.setText("A2")
				.build();
		HTMLOptionElement B1_3 = new HTMLOptionElementBuilder()
				.setText("B1")
				.build();
		HTMLOptionElement B2_3 = new HTMLOptionElementBuilder()
				.setText("B2")
				.build();
		HTMLOptionElement C1_3 = new HTMLOptionElementBuilder()
				.setText("C1")
				.build();
		HTMLOptionElement C2_3 = new HTMLOptionElementBuilder()
				.setText("C2")
				.build();
		
		HTMLSelectElement level3 = document.createElement(StringTypes.select);
		level3.add(A1_3);
		level3.add(A2_3);
		level3.add(B1_3);
		level3.add(B2_3);
		level3.add(C1_3);
		level3.add(C2_3); 
		
		$(login).css("float", "right");
		
		console.log("Creating title");
		HTMLLabelElement title = new HTMLLabelElementBuilder()
				.setClassName("form-control-plaintext")
				.setTextContent("SIGNUP")
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
		
		console.log("Formatting the repeat password field");
		HTMLDivElement divRepeatPassword = divGenerator("form-group");
		
		HTMLLabelElement labelForRepeatPassword = new HTMLLabelElementBuilder()
				.setTextContent("repeat password:")
				.build();
		$(divRepeatPassword).append(labelForRepeatPassword);
		$(divRepeatPassword).append(repeatPassword);
		
		console.log("Formatting checkboxes");
		HTMLDivElement divCheckbox = divGenerator("form-group");
		
		HTMLLabelElement labelForCheckbox = new HTMLLabelElementBuilder()
				.setTextContent("madrelingue:")
				.build();
		HTMLDivElement divTwoChecks = divGenerator("form-checkboxes");
		
		HTMLLabelElement labelIT =  new HTMLLabelElementBuilder()
				.setTextContent("IT")
				.build();
		HTMLLabelElement labelEN =  new HTMLLabelElementBuilder()
				.setTextContent("EN")
				.build();
		$(divTwoChecks).append(selectIT, labelIT, "<br />", selectEN, labelEN);
		$(divCheckbox).append(labelForCheckbox);
		$(divCheckbox).append(divTwoChecks);
		
		console.log("Formatting extra languages");
		HTMLDivElement divExtraLanguages = divGenerator("form-group");
		
		HTMLLabelElement labelForExtraLanguages = new HTMLLabelElementBuilder()
				.setTextContent("altre lingue parlate:")
				.build();
		$(divExtraLanguages).append(labelForExtraLanguages, extra1, level1, extra2, level2, extra3, level3);
							
		console.log("Formatting the button");
		HTMLDivElement divButtons = divGenerator("form-group");
		
		$(divButtons).append(submit, login);
		
		console.log("Adding to form");
		$(form).css("margin", "0% 1.5%");
		$(form).append(title);
		$(form).append(divEmail);
		$(form).append(divPassword);
		$(form).append(divRepeatPassword);
		$(form).append(divCheckbox);
		$(form).append(divExtraLanguages);
		$(form).append(divButtons);
		console.log("Adding to body");
		
		return form;
	}
	
	public static void main(String[] args) 
	{
		SignUp SignUpPage = new SignUp();
		$("body").append(SignUpPage.addForm());
		SignUpPage.createArrayForValidation(SignUpPage.getForm());
	}
}
