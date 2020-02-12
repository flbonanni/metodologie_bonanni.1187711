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
                 * Builder per gli elementi di tipo input
                 * @author Flavia Bonanni
                 * @class
                 * @extends it.uniroma1.fabbricasemanticaJSweet.builder.HTMLElementBuilder
                 */
                class HTMLInputElementBuilder extends it.uniroma1.fabbricasemanticaJSweet.builder.HTMLElementBuilder {
                    constructor() {
                        super();
                        if (this.name === undefined)
                            this.name = null;
                        if (this.className === undefined)
                            this.className = null;
                        if (this.placeholder === undefined)
                            this.placeholder = null;
                        if (this.required === undefined)
                            this.required = false;
                        if (this.type === undefined)
                            this.type = null;
                        if (this.value === undefined)
                            this.value = null;
                    }
                    /**
                     * Aggiunge il nome per l'elemento input
                     * @param {string} n nome da aggiungere
                     * @return {it.uniroma1.fabbricasemanticaJSweet.builder.HTMLInputElementBuilder} l'elemento input
                     */
                    setName(n) {
                        this.name = n;
                        return this;
                    }
                    /**
                     * Aggiunge la classname per l'elemento input
                     * @param {string} c classname
                     * @return {it.uniroma1.fabbricasemanticaJSweet.builder.HTMLInputElementBuilder} l'elemento input
                     */
                    setClassName(c) {
                        this.className = c;
                        return this;
                    }
                    /**
                     * Aggiunge il placeholder per l'elemento input
                     * @param {string} p placeholder
                     * @return {it.uniroma1.fabbricasemanticaJSweet.builder.HTMLInputElementBuilder} l'elemento input
                     */
                    setPlaceholder(p) {
                        this.placeholder = p;
                        return this;
                    }
                    /**
                     * Setta se l'elemento � obbligatorio
                     * @param {boolean} r booleano che indica se il campo � obbligatorio
                     * @return {it.uniroma1.fabbricasemanticaJSweet.builder.HTMLInputElementBuilder} l'elemento input
                     */
                    setRequired(r) {
                        this.required = r;
                        return this;
                    }
                    /**
                     * Aggiunge il type per l'elemento input
                     * @param {string} t type
                     * @return {it.uniroma1.fabbricasemanticaJSweet.builder.HTMLInputElementBuilder} l'elemento input
                     */
                    setType(t) {
                        this.type = t;
                        return this;
                    }
                    /**
                     * Aggiunge il valore per l'elemento input
                     * @param {string} v valore
                     * @return {it.uniroma1.fabbricasemanticaJSweet.builder.HTMLInputElementBuilder} l'elemento input
                     */
                    setValue(v) {
                        this.value = v;
                        return this;
                    }
                    /**
                     *
                     * @return {HTMLInputElement}
                     */
                    build() {
                        let inputElement = document.createElement("input");
                        if (this.name != null)
                            inputElement.name = this.name;
                        if (this.className != null)
                            inputElement.className = this.className;
                        if (this.placeholder != null)
                            inputElement.placeholder = this.placeholder;
                        if (this.required !== false)
                            inputElement.required = this.required;
                        if (this.type != null)
                            inputElement.type = this.type;
                        if (this.value != null)
                            inputElement.value = this.value;
                        return inputElement;
                    }
                }
                builder.HTMLInputElementBuilder = HTMLInputElementBuilder;
                HTMLInputElementBuilder["__class"] = "it.uniroma1.fabbricasemanticaJSweet.builder.HTMLInputElementBuilder";
            })(builder = fabbricasemanticaJSweet.builder || (fabbricasemanticaJSweet.builder = {}));
        })(fabbricasemanticaJSweet = uniroma1.fabbricasemanticaJSweet || (uniroma1.fabbricasemanticaJSweet = {}));
    })(uniroma1 = it.uniroma1 || (it.uniroma1 = {}));
})(it || (it = {}));
