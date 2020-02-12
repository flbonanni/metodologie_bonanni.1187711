/* Generated from Java with JSweet 2.3.0-SNAPSHOT - http://www.jsweet.org */
var it;
(function (it) {
    var uniroma1;
    (function (uniroma1) {
        var fabbricasemanticaJSweet;
        (function (fabbricasemanticaJSweet) {
            var userpage;
            (function (userpage) {
                /**
                 * Classe che genera la pagina di signup
                 * @author Flavia Bonanni
                 * @class
                 * @extends it.uniroma1.fabbricasemanticaJSweet.userpage.AuthPage
                 */
                class SignUp extends it.uniroma1.fabbricasemanticaJSweet.userpage.AuthPage {
                    /**
                     * Metodo che genera il form del login
                     * @return {HTMLFormElement} form
                     */
                    addForm() {
                        let form = this.createForm(SignUp.SERVLET_URL);
                        let email = this.createEmail();
                        let password = this.createPassword();
                        console.log("Creating repeat password field");
                        let repeatPassword = new it.uniroma1.fabbricasemanticaJSweet.builder.HTMLInputElementBuilder().setName("repeatPassword").setClassName("form-control").setPlaceholder("*******").setRequired(true).setType("password").build();
                        console.log("Creating checkboxes");
                        let selectIT = new it.uniroma1.fabbricasemanticaJSweet.builder.HTMLInputElementBuilder().setName("selectlang").setClassName("form-control-box").setRequired(false).setType("checkbox").setValue("IT").build();
                        let selectEN = new it.uniroma1.fabbricasemanticaJSweet.builder.HTMLInputElementBuilder().setName("selectlang").setClassName("form-control-box").setRequired(false).setType("checkbox").setValue("EN").build();
                        let submit = this.createSubmit("Signup");
                        console.log("creating login link");
                        let login = new it.uniroma1.fabbricasemanticaJSweet.builder.HTMLAnchorElementBuilder().setText("Login").setName("login").setHref("login.html").build();
                        console.log("Creating extra language field");
                        let extra1 = new it.uniroma1.fabbricasemanticaJSweet.builder.HTMLInputElementBuilder().setName("extra1").setClassName("form-control").setPlaceholder("other language #1").build();
                        console.log("Creating language level 1");
                        let A1_1 = new it.uniroma1.fabbricasemanticaJSweet.builder.HTMLOptionElementBuilder().setText("A1").build();
                        let A2_1 = new it.uniroma1.fabbricasemanticaJSweet.builder.HTMLOptionElementBuilder().setText("A2").build();
                        let B1_1 = new it.uniroma1.fabbricasemanticaJSweet.builder.HTMLOptionElementBuilder().setText("B1").build();
                        let B2_1 = new it.uniroma1.fabbricasemanticaJSweet.builder.HTMLOptionElementBuilder().setText("B2").build();
                        let C1_1 = new it.uniroma1.fabbricasemanticaJSweet.builder.HTMLOptionElementBuilder().setText("C1").build();
                        let C2_1 = new it.uniroma1.fabbricasemanticaJSweet.builder.HTMLOptionElementBuilder().setText("C2").build();
                        let level1 = document.createElement("select");
                        level1.add(A1_1);
                        level1.add(A2_1);
                        level1.add(B1_1);
                        level1.add(B2_1);
                        level1.add(C1_1);
                        level1.add(C2_1);
                        console.log("Creating extra language field");
                        let extra2 = new it.uniroma1.fabbricasemanticaJSweet.builder.HTMLInputElementBuilder().setName("extra2").setClassName("form-control").setPlaceholder("other language #2").build();
                        console.log("Creating language level 2");
                        let A1_2 = new it.uniroma1.fabbricasemanticaJSweet.builder.HTMLOptionElementBuilder().setText("A1").build();
                        let A2_2 = new it.uniroma1.fabbricasemanticaJSweet.builder.HTMLOptionElementBuilder().setText("A2").build();
                        let B1_2 = new it.uniroma1.fabbricasemanticaJSweet.builder.HTMLOptionElementBuilder().setText("B1").build();
                        let B2_2 = new it.uniroma1.fabbricasemanticaJSweet.builder.HTMLOptionElementBuilder().setText("B2").build();
                        let C1_2 = new it.uniroma1.fabbricasemanticaJSweet.builder.HTMLOptionElementBuilder().setText("C1").build();
                        let C2_2 = new it.uniroma1.fabbricasemanticaJSweet.builder.HTMLOptionElementBuilder().setText("C2").build();
                        let level2 = document.createElement("select");
                        level2.add(A1_2);
                        level2.add(A2_2);
                        level2.add(B1_2);
                        level2.add(B2_2);
                        level2.add(C1_2);
                        level2.add(C2_2);
                        console.log("Creating extra language field");
                        let extra3 = new it.uniroma1.fabbricasemanticaJSweet.builder.HTMLInputElementBuilder().setName("extra3").setClassName("form-control").setPlaceholder("other language #3").build();
                        console.log("Creating language level 2");
                        let A1_3 = new it.uniroma1.fabbricasemanticaJSweet.builder.HTMLOptionElementBuilder().setText("A1").build();
                        let A2_3 = new it.uniroma1.fabbricasemanticaJSweet.builder.HTMLOptionElementBuilder().setText("A2").build();
                        let B1_3 = new it.uniroma1.fabbricasemanticaJSweet.builder.HTMLOptionElementBuilder().setText("B1").build();
                        let B2_3 = new it.uniroma1.fabbricasemanticaJSweet.builder.HTMLOptionElementBuilder().setText("B2").build();
                        let C1_3 = new it.uniroma1.fabbricasemanticaJSweet.builder.HTMLOptionElementBuilder().setText("C1").build();
                        let C2_3 = new it.uniroma1.fabbricasemanticaJSweet.builder.HTMLOptionElementBuilder().setText("C2").build();
                        let level3 = document.createElement("select");
                        level3.add(A1_3);
                        level3.add(A2_3);
                        level3.add(B1_3);
                        level3.add(B2_3);
                        level3.add(C1_3);
                        level3.add(C2_3);
                        $(login).css("float", "right");
                        console.log("Creating title");
                        let title = new it.uniroma1.fabbricasemanticaJSweet.builder.HTMLLabelElementBuilder().setClassName("form-control-plaintext").setTextContent("SIGNUP").build();
                        title.setAttribute("style", "font-weight:bold");
                        console.log("Formatting the email field");
                        let divEmail = this.divGenerator("form-group");
                        let labelForEmail = new it.uniroma1.fabbricasemanticaJSweet.builder.HTMLLabelElementBuilder().setTextContent("email:").build();
                        $(divEmail).append(labelForEmail);
                        $(divEmail).append(email);
                        console.log("Formatting the password field");
                        let divPassword = this.divGenerator("form-group");
                        let labelForPassword = new it.uniroma1.fabbricasemanticaJSweet.builder.HTMLLabelElementBuilder().setTextContent("password:").build();
                        $(divPassword).append(labelForPassword);
                        $(divPassword).append(password);
                        console.log("Formatting the repeat password field");
                        let divRepeatPassword = this.divGenerator("form-group");
                        let labelForRepeatPassword = new it.uniroma1.fabbricasemanticaJSweet.builder.HTMLLabelElementBuilder().setTextContent("repeat password:").build();
                        $(divRepeatPassword).append(labelForRepeatPassword);
                        $(divRepeatPassword).append(repeatPassword);
                        console.log("Formatting checkboxes");
                        let divCheckbox = this.divGenerator("form-group");
                        let labelForCheckbox = new it.uniroma1.fabbricasemanticaJSweet.builder.HTMLLabelElementBuilder().setTextContent("madrelingue:").build();
                        let divTwoChecks = this.divGenerator("form-checkboxes");
                        let labelIT = new it.uniroma1.fabbricasemanticaJSweet.builder.HTMLLabelElementBuilder().setTextContent("IT").build();
                        let labelEN = new it.uniroma1.fabbricasemanticaJSweet.builder.HTMLLabelElementBuilder().setTextContent("EN").build();
                        $(divTwoChecks).append(selectIT, labelIT, "<br />", selectEN, labelEN);
                        $(divCheckbox).append(labelForCheckbox);
                        $(divCheckbox).append(divTwoChecks);
                        console.log("Formatting extra languages");
                        let divExtraLanguages = this.divGenerator("form-group");
                        let labelForExtraLanguages = new it.uniroma1.fabbricasemanticaJSweet.builder.HTMLLabelElementBuilder().setTextContent("altre lingue parlate:").build();
                        $(divExtraLanguages).append(labelForExtraLanguages, extra1, level1, extra2, level2, extra3, level3);
                        console.log("Formatting the button");
                        let divButtons = this.divGenerator("form-group");
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
                    static main(args) {
                        let SignUpPage = new SignUp();
                        $("body").append(SignUpPage.addForm());
                        SignUpPage.createArrayForValidation(SignUpPage.getForm());
                    }
                }
                SignUp.SERVLET_URL = "signup.jsp";
                userpage.SignUp = SignUp;
                SignUp["__class"] = "it.uniroma1.fabbricasemanticaJSweet.userpage.SignUp";
            })(userpage = fabbricasemanticaJSweet.userpage || (fabbricasemanticaJSweet.userpage = {}));
        })(fabbricasemanticaJSweet = uniroma1.fabbricasemanticaJSweet || (uniroma1.fabbricasemanticaJSweet = {}));
    })(uniroma1 = it.uniroma1 || (it.uniroma1 = {}));
})(it || (it = {}));
it.uniroma1.fabbricasemanticaJSweet.userpage.SignUp.main(null);
