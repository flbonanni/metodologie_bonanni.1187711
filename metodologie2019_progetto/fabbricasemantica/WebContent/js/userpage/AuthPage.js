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
                 * Superclasse delle pagine per l'autenticazione e la home
                 * @author Flavia Bonanni
                 * @class
                 */
                class AuthPage {
                    constructor() {
                        if (this.form === undefined)
                            this.form = null;
                    }
                    /**
                     * Metodo generico per creare un form
                     * @param {string} SERVLET_URL indirizzo a cui mandare i dati del form
                     * @return {HTMLFormElement} form
                     */
                    createForm(SERVLET_URL) {
                        console.log("Creating form");
                        let form = new it.uniroma1.fabbricasemanticaJSweet.builder.HTMLFormElementBuilder().setAction(SERVLET_URL).setMethod().build();
                        console.log("Form Done");
                        return form;
                    }
                    /**
                     * Metodo per creare il campo email
                     * @return {HTMLInputElement} campo email
                     */
                    createEmail() {
                        console.log("Creating email field");
                        let email = new it.uniroma1.fabbricasemanticaJSweet.builder.HTMLInputElementBuilder().setName("email").setClassName("form-control").setType("email").setPlaceholder("xxxx@email.com").setRequired(true).build();
                        return email;
                    }
                    /**
                     * Metodo per creare il campo password
                     * @return {HTMLInputElement} campo password
                     */
                    createPassword() {
                        console.log("Creating password field");
                        let password = new it.uniroma1.fabbricasemanticaJSweet.builder.HTMLInputElementBuilder().setName("password").setClassName("form-control").setPlaceholder("********").setRequired(true).setType("password").build();
                        return password;
                    }
                    /**
                     * Metodo per creare il bottone di Submit
                     * @param {string} value valore del bottone
                     * @return {HTMLInputElement} bottone di Submit
                     */
                    createSubmit(value) {
                        console.log("Creating submit button");
                        let submit = new it.uniroma1.fabbricasemanticaJSweet.builder.HTMLInputElementBuilder().setType("submit").setName("submit-button").setClassName("btn btn-primary").setValue(value).build();
                        return submit;
                    }
                    /**
                     * Metodo per controllare se i dati inseriti sono validi
                     * @param {HTMLFormElement} f form da controllare
                     */
                    createArrayForValidation(f) {
                        this.form = f;
                        this.form = document.querySelector("form");
                        this.form.onsubmit = (event) => { return this.onSubmit(event); };
                        console.log("creando array di elementi...");
                        let inputs = Array.from(this.form.querySelectorAll(".form-control"));
                        for (let index121 = 0; index121 < inputs.length; index121++) {
                            let element = inputs[index121];
                            {
                                this.addHitListener(element);
                            }
                        }
                        console.log("array creato.");
                        try {
                            this.form.querySelector("#reset").addEventListener("click", ((inputs) => {
                                return (event) => {
                                    this.form.reset();
                                    for (let index122 = 0; index122 < inputs.length; index122++) {
                                        let element = inputs[index122];
                                        {
                                            element.classList.remove("hit");
                                        }
                                    }
                                };
                            })(inputs));
                        }
                        catch (e) {
                            console.log("in attesa del form...");
                        }
                        ;
                    }
                    /**
                     * Metodo che controlla i cambiamenti avvenuti su un certo elemento
                     * @param {HTMLElement} element da controllare
                     * @private
                     */
                    /*private*/ addHitListener(element) {
                        element.addEventListener("keyup", (evt) => {
                            console.log("typing...");
                            element.classList.add("hit");
                        });
                    }
                    /**
                     * Metodo che si attiva quando l'utente clicca submit sul form e ne restituisce la validit�
                     * @param {Event} event che attiva il controllo
                     * @return {boolean} booleano per form valido/non valido
                     * @private
                     */
                    /*private*/ onSubmit(event) {
                        event.stopPropagation();
                        console.log("form is valid");
                        document.getElementById("form").classList.add("invisible");
                        window.scroll(0, 0);
                        document.getElementById("email").textContent = this.getInput("email").value;
                        document.getElementById("password").textContent = this.getInput("password").value;
                        return false;
                    }
                    /**
                     * Getter per il form
                     * @return {HTMLFormElement} form
                     */
                    getForm() {
                        return this.form;
                    }
                    /**
                     * Getter per l'input
                     * @param {string} name dell'input
                     * @return {HTMLInputElement} input
                     * @private
                     */
                    /*private*/ getInput(name) {
                        return document.querySelector("[name=\'" + name + "\']");
                    }
                    /**
                     * metodo per creare div
                     * @param {string} className del div
                     * @return {HTMLDivElement} div
                     */
                    divGenerator(className) {
                        let div = new it.uniroma1.fabbricasemanticaJSweet.builder.HTMLDivElementBuilder().setClassName(className).build();
                        return div;
                    }
                }
                userpage.AuthPage = AuthPage;
                AuthPage["__class"] = "it.uniroma1.fabbricasemanticaJSweet.userpage.AuthPage";
            })(userpage = fabbricasemanticaJSweet.userpage || (fabbricasemanticaJSweet.userpage = {}));
        })(fabbricasemanticaJSweet = uniroma1.fabbricasemanticaJSweet || (uniroma1.fabbricasemanticaJSweet = {}));
    })(uniroma1 = it.uniroma1 || (it.uniroma1 = {}));
})(it || (it = {}));
