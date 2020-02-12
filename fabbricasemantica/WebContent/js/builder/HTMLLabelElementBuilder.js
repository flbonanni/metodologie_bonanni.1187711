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
                 * Builder per gli elementi di tipo etichetta
                 * @author Flavia Bonanni
                 * @class
                 * @extends it.uniroma1.fabbricasemanticaJSweet.builder.HTMLElementBuilder
                 */
                class HTMLLabelElementBuilder extends it.uniroma1.fabbricasemanticaJSweet.builder.HTMLElementBuilder {
                    constructor() {
                        super();
                        if (this.className === undefined)
                            this.className = null;
                        if (this.textContent === undefined)
                            this.textContent = null;
                    }
                    /**
                     * Aggiunge il classname per l'elemento etichetta
                     * @param {string} c classname
                     * @return {it.uniroma1.fabbricasemanticaJSweet.builder.HTMLLabelElementBuilder} l'elemento etichetta
                     */
                    setClassName(c) {
                        this.className = c;
                        return this;
                    }
                    /**
                     * Aggiunge il testo dell'elemento etichetta
                     * @param {string} t testo da aggiungere
                     * @return {it.uniroma1.fabbricasemanticaJSweet.builder.HTMLLabelElementBuilder} l'elemento etichetta
                     */
                    setTextContent(t) {
                        this.textContent = t;
                        return this;
                    }
                    /**
                     *
                     * @return {HTMLLabelElement}
                     */
                    build() {
                        let formElement = document.createElement("label");
                        if (this.className != null)
                            formElement.className = this.className;
                        if (this.textContent != null)
                            formElement.textContent = this.textContent;
                        return formElement;
                    }
                }
                builder.HTMLLabelElementBuilder = HTMLLabelElementBuilder;
                HTMLLabelElementBuilder["__class"] = "it.uniroma1.fabbricasemanticaJSweet.builder.HTMLLabelElementBuilder";
            })(builder = fabbricasemanticaJSweet.builder || (fabbricasemanticaJSweet.builder = {}));
        })(fabbricasemanticaJSweet = uniroma1.fabbricasemanticaJSweet || (uniroma1.fabbricasemanticaJSweet = {}));
    })(uniroma1 = it.uniroma1 || (it.uniroma1 = {}));
})(it || (it = {}));
