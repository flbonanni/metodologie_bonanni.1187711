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
                 * Classe che genera la pagina di login
                 * @author Flavia Bonanni
                 * @class
                 * @extends it.uniroma1.fabbricasemanticaJSweet.userpage.AuthPage
                 */
                class Login extends it.uniroma1.fabbricasemanticaJSweet.userpage.AuthPage {
                    /**
                     * Metodo che genera il form del login
                     * @return {HTMLFormElement} form
                     */
                    addForm() {
                        let form = this.createForm(Login.SERVLET_URL);
                        let email = this.createEmail();
                        let password = this.createPassword();
                        let submit = this.createSubmit("Login");
                        console.log("Creating signup link");
                        let signup = new it.uniroma1.fabbricasemanticaJSweet.builder.HTMLAnchorElementBuilder().setText("Signup").setName("signup").setHref("signup.html").build();
                        $(signup).css("float", "right");
                        console.log("Creating title");
                        let title = new it.uniroma1.fabbricasemanticaJSweet.builder.HTMLLabelElementBuilder().setClassName("form-control-plaintext").setTextContent("LOGIN").build();
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
                        console.log("Formatting the button");
                        let divButtons = this.divGenerator("form-group");
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
                    static main(args) {
                        let LoginPage = new Login();
                        $("body").append(LoginPage.addForm());
                        LoginPage.createArrayForValidation(LoginPage.getForm());
                    }
                }
                Login.SERVLET_URL = "login.jsp";
                userpage.Login = Login;
                Login["__class"] = "it.uniroma1.fabbricasemanticaJSweet.userpage.Login";
            })(userpage = fabbricasemanticaJSweet.userpage || (fabbricasemanticaJSweet.userpage = {}));
        })(fabbricasemanticaJSweet = uniroma1.fabbricasemanticaJSweet || (uniroma1.fabbricasemanticaJSweet = {}));
    })(uniroma1 = it.uniroma1 || (it.uniroma1 = {}));
})(it || (it = {}));
it.uniroma1.fabbricasemanticaJSweet.userpage.Login.main(null);
