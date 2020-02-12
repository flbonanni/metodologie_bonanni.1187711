/* Generated from Java with JSweet 2.3.0-SNAPSHOT - http://www.jsweet.org */
var it;
(function (it) {
    var uniroma1;
    (function (uniroma1) {
        var fabbricasemanticaJSweet;
        (function (fabbricasemanticaJSweet) {
            var game;
            (function (game) {
                /**
                 * Superclasse per tutti i task
                 * @author Flavia Bonanni
                 * @class
                 */
                class Annotation {
                    /**
                     * Metodo per creare i form
                     * @param {string} SERVLET_URL indirizzo a cui inviare i dati
                     * @return {HTMLFormElement} form
                     */
                    createForm(SERVLET_URL) {
                        console.log("Creating form");
                        let form = new it.uniroma1.fabbricasemanticaJSweet.builder.HTMLFormElementBuilder().setAction(SERVLET_URL).setMethod().build();
                        return form;
                    }
                    /**
                     * Metodo per creare label
                     * @return {HTMLLabelElement} label
                     */
                    createDescription() {
                        console.log("creating desct");
                        let description = new it.uniroma1.fabbricasemanticaJSweet.builder.HTMLLabelElementBuilder().setClassName("form-control-plaintext").build();
                        return description;
                    }
                    /**
                     * Metodo per creare l'istruzione per l'utente
                     * @param {string} textContent istruzione
                     * @return {HTMLLabelElement} istruzione per l'utente
                     */
                    createHint(textContent) {
                        console.log("creating hint");
                        let hint = new it.uniroma1.fabbricasemanticaJSweet.builder.HTMLLabelElementBuilder().setClassName("form-control-hint").setTextContent(textContent).build();
                        return hint;
                    }
                    /**
                     * Metodo per creare la Word
                     * @return {HTMLLabelElement} word
                     */
                    createWord() {
                        console.log("creating word");
                        let word = new it.uniroma1.fabbricasemanticaJSweet.builder.HTMLLabelElementBuilder().setClassName("form-control-word").build();
                        return word;
                    }
                    /**
                     * Metodo per creare un'etichetta per slider
                     * @param {string} textContent testo dell'etichetta
                     * @return {HTMLLabelElement} etichetta per slider
                     */
                    createRangeLabel(textContent) {
                        console.log("creating label");
                        let rangeLabel = new it.uniroma1.fabbricasemanticaJSweet.builder.HTMLLabelElementBuilder().setClassName("form-control-rangelabel").setTextContent(textContent).build();
                        return rangeLabel;
                    }
                    /**
                     * Metodo per creare un'etichetta per un bottone radio
                     * @param {string} textContent testo dell'etichetta
                     * @return {HTMLLabelElement} etichetta per un bottone radio
                     */
                    createRadioLabel(textContent) {
                        let radioLabel = new it.uniroma1.fabbricasemanticaJSweet.builder.HTMLLabelElementBuilder().setClassName("form-control-radio").setTextContent(textContent).build();
                        return radioLabel;
                    }
                    /**
                     * Metodo per creare un esempio d'uso di una Word
                     * @return {HTMLLabelElement} esempio
                     */
                    createExample() {
                        let example = new it.uniroma1.fabbricasemanticaJSweet.builder.HTMLLabelElementBuilder().setClassName("form-control-example").build();
                        return example;
                    }
                    /**
                     * Metodo per creare un textarea
                     * @param {string} placeholder per la textarea
                     * @return {HTMLTextAreaElement} textarea
                     */
                    createTextarea(placeholder) {
                        console.log("creating translation");
                        let translation = new it.uniroma1.fabbricasemanticaJSweet.builder.HTMLTextAreaElementBuilder().setClassName("form-control").setName("translation").setPlaceholder(placeholder).build();
                        return translation;
                    }
                    /**
                     * Metodo per creare bottone di submit
                     * @return {HTMLInputElement} bottone di submit
                     */
                    createSubmit() {
                        console.log("creating submit button");
                        let submit = new it.uniroma1.fabbricasemanticaJSweet.builder.HTMLInputElementBuilder().setType("submit").setName("submit_button").setClassName("btn btn-primary").setValue("Next").build();
                        return submit;
                    }
                    /**
                     * Metodo per creare un bottone di skip
                     * @return {HTMLInputElement} bottone di skip
                     */
                    createSkip() {
                        console.log("creating skip button");
                        let skip = new it.uniroma1.fabbricasemanticaJSweet.builder.HTMLInputElementBuilder().setType("submit").setName("skip_button").setClassName("btn btn-primary").setValue("Skip").build();
                        return skip;
                    }
                    /**
                     * Metodo per creare un bottone radio
                     * @return {HTMLInputElement} bottone radio
                     */
                    createRadio() {
                        let radio = new it.uniroma1.fabbricasemanticaJSweet.builder.HTMLInputElementBuilder().setType("radio").setName("radio").setClassName("form-control-radio-button").build();
                        return radio;
                    }
                    /**
                     * Metodo per creare uno slider
                     * @return {HTMLInputElement} slider
                     */
                    createRange() {
                        console.log("creating range");
                        let range = new it.uniroma1.fabbricasemanticaJSweet.builder.HTMLInputElementBuilder().setClassName("form-control-range").setType("range").build();
                        return range;
                    }
                    /**
                     * Metodo per creare link alla home
                     * @return {HTMLAnchorElement} link alla home
                     */
                    createHomeLink() {
                        console.log("Creating home link");
                        let home = new it.uniroma1.fabbricasemanticaJSweet.builder.HTMLAnchorElementBuilder().setText("home").setName("home").setHref("home.html").build();
                        return home;
                    }
                    /**
                     * Metodo per creare link di logout
                     * @return {HTMLAnchorElement} link di logout
                     */
                    createLogoutLink() {
                        console.log("Creating logout link");
                        let logout = new it.uniroma1.fabbricasemanticaJSweet.builder.HTMLAnchorElementBuilder().setText("logout").setName("logout").setHref("logout.jsp").build();
                        return logout;
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
                game.Annotation = Annotation;
                Annotation["__class"] = "it.uniroma1.fabbricasemanticaJSweet.game.Annotation";
            })(game = fabbricasemanticaJSweet.game || (fabbricasemanticaJSweet.game = {}));
        })(fabbricasemanticaJSweet = uniroma1.fabbricasemanticaJSweet || (uniroma1.fabbricasemanticaJSweet = {}));
    })(uniroma1 = it.uniroma1 || (it.uniroma1 = {}));
})(it || (it = {}));
