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
                 * Builder per gli elementi di tipo textarea
                 * @author Flavia Bonanni
                 * @class
                 * @extends it.uniroma1.fabbricasemanticaJSweet.builder.HTMLElementBuilder
                 */
                class HTMLTextAreaElementBuilder extends it.uniroma1.fabbricasemanticaJSweet.builder.HTMLElementBuilder {
                    constructor() {
                        super();
                        if (this.className === undefined)
                            this.className = null;
                        if (this.name === undefined)
                            this.name = null;
                        if (this.placeholder === undefined)
                            this.placeholder = null;
                    }
                    /**
                     * Aggiunge il classname per l'elemento textarea
                     * @param {string} c classname
                     * @return {it.uniroma1.fabbricasemanticaJSweet.builder.HTMLTextAreaElementBuilder} l'elemento textarea
                     */
                    setClassName(c) {
                        this.className = c;
                        return this;
                    }
                    /**
                     * Aggiungere il nome dell'elemento textarea
                     * @param {string} n nome da aggiungere
                     * @return {it.uniroma1.fabbricasemanticaJSweet.builder.HTMLTextAreaElementBuilder} l'elemento textarea
                     */
                    setName(n) {
                        this.name = n;
                        return this;
                    }
                    /**
                     * Aggiunge il placeholder dell'elemento textarea
                     * @param {string} p placeholder
                     * @return {it.uniroma1.fabbricasemanticaJSweet.builder.HTMLTextAreaElementBuilder} l'elemento textarea
                     */
                    setPlaceholder(p) {
                        this.placeholder = p;
                        return this;
                    }
                    /**
                     *
                     * @return {HTMLTextAreaElement}
                     */
                    build() {
                        let formElement = document.createElement("textarea");
                        if (this.className != null)
                            formElement.className = this.className;
                        if (this.name != null)
                            formElement.name = this.name;
                        if (this.placeholder != null)
                            formElement.placeholder = this.placeholder;
                        return formElement;
                    }
                }
                builder.HTMLTextAreaElementBuilder = HTMLTextAreaElementBuilder;
                HTMLTextAreaElementBuilder["__class"] = "it.uniroma1.fabbricasemanticaJSweet.builder.HTMLTextAreaElementBuilder";
            })(builder = fabbricasemanticaJSweet.builder || (fabbricasemanticaJSweet.builder = {}));
        })(fabbricasemanticaJSweet = uniroma1.fabbricasemanticaJSweet || (uniroma1.fabbricasemanticaJSweet = {}));
    })(uniroma1 = it.uniroma1 || (it.uniroma1 = {}));
})(it || (it = {}));
