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
                 * Builder per gli elementi di tipo link
                 * @author Flavia Bonanni
                 * @class
                 * @extends it.uniroma1.fabbricasemanticaJSweet.builder.HTMLElementBuilder
                 */
                class HTMLAnchorElementBuilder extends it.uniroma1.fabbricasemanticaJSweet.builder.HTMLElementBuilder {
                    constructor() {
                        super();
                        if (this.text === undefined)
                            this.text = null;
                        if (this.name === undefined)
                            this.name = null;
                        if (this.href === undefined)
                            this.href = null;
                    }
                    /**
                     * Aggiunge il testo del link
                     * @param {string} t testo da aggiungere
                     * @return {it.uniroma1.fabbricasemanticaJSweet.builder.HTMLAnchorElementBuilder} l'elemento link
                     */
                    setText(t) {
                        this.text = t;
                        return this;
                    }
                    /**
                     * Aggiunge il nome del link
                     * @param {string} n nome da aggiungere
                     * @return {it.uniroma1.fabbricasemanticaJSweet.builder.HTMLAnchorElementBuilder} l'elemento link
                     */
                    setName(n) {
                        this.name = n;
                        return this;
                    }
                    /**
                     * Aggiunge l'indirizzo del link
                     * @param {string} h indirizzo da aggiungere
                     * @return {it.uniroma1.fabbricasemanticaJSweet.builder.HTMLAnchorElementBuilder} l'elemento link
                     */
                    setHref(h) {
                        this.href = h;
                        return this;
                    }
                    /**
                     *
                     * @return {HTMLAnchorElement}
                     */
                    build() {
                        let formElement = document.createElement("a");
                        if (this.text != null)
                            formElement.text = this.text;
                        if (this.name != null)
                            formElement.name = this.name;
                        if (this.href != null)
                            formElement.href = this.href;
                        return formElement;
                    }
                }
                builder.HTMLAnchorElementBuilder = HTMLAnchorElementBuilder;
                HTMLAnchorElementBuilder["__class"] = "it.uniroma1.fabbricasemanticaJSweet.builder.HTMLAnchorElementBuilder";
            })(builder = fabbricasemanticaJSweet.builder || (fabbricasemanticaJSweet.builder = {}));
        })(fabbricasemanticaJSweet = uniroma1.fabbricasemanticaJSweet || (uniroma1.fabbricasemanticaJSweet = {}));
    })(uniroma1 = it.uniroma1 || (it.uniroma1 = {}));
})(it || (it = {}));
