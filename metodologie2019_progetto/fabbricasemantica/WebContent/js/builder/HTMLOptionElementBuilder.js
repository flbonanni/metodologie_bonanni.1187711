/* Generated from Java with JSweet 2.3.0-SNAPSHOT - http://www.jsweet.org */
var it;
(function (it) {
    var uniroma1;
    (function (uniroma1) {
        var fabbricasemanticaJSweet;
        (function (fabbricasemanticaJSweet) {
            var builder;
            (function (builder) {
                /**
                 * Builder per gli elementi di tipo option
                 * @author Flavia Bonanni
                 * @class
                 * @extends it.uniroma1.fabbricasemanticaJSweet.builder.HTMLElementBuilder
                 */
                class HTMLOptionElementBuilder extends it.uniroma1.fabbricasemanticaJSweet.builder.HTMLElementBuilder {
                    constructor() {
                        super();
                        if (this.text === undefined)
                            this.text = null;
                    }
                    /**
                     * Aggiunge il testo dell'elemento option
                     * @param {string} t testo da aggiungere
                     * @return {it.uniroma1.fabbricasemanticaJSweet.builder.HTMLOptionElementBuilder} l'elemento option
                     */
                    setText(t) {
                        this.text = t;
                        return this;
                    }
                    /**
                     *
                     * @return {HTMLOptionElement}
                     */
                    build() {
                        let formElement = document.createElement("option");
                        if (this.text != null)
                            formElement.text = this.text;
                        return formElement;
                    }
                }
                builder.HTMLOptionElementBuilder = HTMLOptionElementBuilder;
                HTMLOptionElementBuilder["__class"] = "it.uniroma1.fabbricasemanticaJSweet.builder.HTMLOptionElementBuilder";
            })(builder = fabbricasemanticaJSweet.builder || (fabbricasemanticaJSweet.builder = {}));
        })(fabbricasemanticaJSweet = uniroma1.fabbricasemanticaJSweet || (uniroma1.fabbricasemanticaJSweet = {}));
    })(uniroma1 = it.uniroma1 || (it.uniroma1 = {}));
})(it || (it = {}));
