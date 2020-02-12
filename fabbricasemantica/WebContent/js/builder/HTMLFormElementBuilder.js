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
                 * Builder per gli elementi di tipo form
                 * @author Flavia Bonanni
                 * @class
                 * @extends it.uniroma1.fabbricasemanticaJSweet.builder.HTMLElementBuilder
                 */
                class HTMLFormElementBuilder extends it.uniroma1.fabbricasemanticaJSweet.builder.HTMLElementBuilder {
                    constructor() {
                        super();
                        if (this.action === undefined)
                            this.action = null;
                        if (this.method === undefined)
                            this.method = null;
                    }
                    /**
                     * Aggiunge il tipo di azione per l'elemento form
                     * @param {string} a azione da eseguire
                     * @return {it.uniroma1.fabbricasemanticaJSweet.builder.HTMLFormElementBuilder} l'elemento form
                     */
                    setAction(a) {
                        this.action = a;
                        return this;
                    }
                    /**
                     * Aggiunge il metodo per l'elemento form
                     * @return {it.uniroma1.fabbricasemanticaJSweet.builder.HTMLFormElementBuilder} l'elemento form
                     */
                    setMethod() {
                        this.method = "POST";
                        return this;
                    }
                    /**
                     *
                     * @return {HTMLFormElement}
                     */
                    build() {
                        let formElement = document.createElement("form");
                        if (this.action != null)
                            formElement.action = this.action;
                        if (this.method != null)
                            formElement.method = this.method;
                        return formElement;
                    }
                }
                builder.HTMLFormElementBuilder = HTMLFormElementBuilder;
                HTMLFormElementBuilder["__class"] = "it.uniroma1.fabbricasemanticaJSweet.builder.HTMLFormElementBuilder";
            })(builder = fabbricasemanticaJSweet.builder || (fabbricasemanticaJSweet.builder = {}));
        })(fabbricasemanticaJSweet = uniroma1.fabbricasemanticaJSweet || (uniroma1.fabbricasemanticaJSweet = {}));
    })(uniroma1 = it.uniroma1 || (it.uniroma1 = {}));
})(it || (it = {}));
