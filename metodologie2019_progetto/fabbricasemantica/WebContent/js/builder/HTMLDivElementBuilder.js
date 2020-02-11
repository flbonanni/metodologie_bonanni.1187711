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
                 * Builder per gli elementi di tipo div
                 * @author Flavia Bonanni
                 * @class
                 * @extends it.uniroma1.fabbricasemanticaJSweet.builder.HTMLElementBuilder
                 */
                class HTMLDivElementBuilder extends it.uniroma1.fabbricasemanticaJSweet.builder.HTMLElementBuilder {
                    constructor() {
                        super();
                        if (this.className === undefined)
                            this.className = null;
                    }
                    /**
                     * Aggiunge il tipo di classname per l'elemento div
                     * @param {string} c classname
                     * @return {it.uniroma1.fabbricasemanticaJSweet.builder.HTMLDivElementBuilder} l'elemento div
                     */
                    setClassName(c) {
                        this.className = c;
                        return this;
                    }
                    /**
                     *
                     * @return {HTMLDivElement}
                     */
                    build() {
                        let formElement = document.createElement("div");
                        if (this.className != null)
                            formElement.className = this.className;
                        return formElement;
                    }
                }
                builder.HTMLDivElementBuilder = HTMLDivElementBuilder;
                HTMLDivElementBuilder["__class"] = "it.uniroma1.fabbricasemanticaJSweet.builder.HTMLDivElementBuilder";
            })(builder = fabbricasemanticaJSweet.builder || (fabbricasemanticaJSweet.builder = {}));
        })(fabbricasemanticaJSweet = uniroma1.fabbricasemanticaJSweet || (uniroma1.fabbricasemanticaJSweet = {}));
    })(uniroma1 = it.uniroma1 || (it.uniroma1 = {}));
})(it || (it = {}));
