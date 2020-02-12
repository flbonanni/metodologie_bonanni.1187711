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
                 * Builder per gli elementi di tipo immagine
                 * @author Flavia Bonanni
                 * @class
                 * @extends it.uniroma1.fabbricasemanticaJSweet.builder.HTMLElementBuilder
                 */
                class HTMLImageElementBuilder extends it.uniroma1.fabbricasemanticaJSweet.builder.HTMLElementBuilder {
                    constructor() {
                        super();
                        if (this.src === undefined)
                            this.src = null;
                        if (this.height === undefined)
                            this.height = 0;
                        if (this.width === undefined)
                            this.width = 0;
                    }
                    /**
                     * Aggiunge la fonte per l'elemento immagine
                     * @param {string} s fonte
                     * @return {it.uniroma1.fabbricasemanticaJSweet.builder.HTMLImageElementBuilder} l'elemento immagine
                     */
                    setSrc(s) {
                        this.src = s;
                        return this;
                    }
                    /**
                     * Imposta l'altezza per l'elemento immagine
                     * @param {number} h altezza
                     * @return {it.uniroma1.fabbricasemanticaJSweet.builder.HTMLImageElementBuilder} l'elemento immagine
                     */
                    setHeight(h) {
                        this.height = h;
                        return this;
                    }
                    /**
                     * Imposta l'ampiezza per l'elemento immagine
                     * @param {number} w ampiezza
                     * @return {it.uniroma1.fabbricasemanticaJSweet.builder.HTMLImageElementBuilder} l'elemento immagine
                     */
                    setWidth(w) {
                        this.width = w;
                        return this;
                    }
                    /**
                     *
                     * @return {HTMLImageElement}
                     */
                    build() {
                        let imageElement = document.createElement("img");
                        if (this.src != null)
                            imageElement.src = this.src;
                        if (this.height !== 0)
                            imageElement.height = this.height;
                        if (this.width !== 0)
                            imageElement.width = this.width;
                        return imageElement;
                    }
                }
                builder.HTMLImageElementBuilder = HTMLImageElementBuilder;
                HTMLImageElementBuilder["__class"] = "it.uniroma1.fabbricasemanticaJSweet.builder.HTMLImageElementBuilder";
            })(builder = fabbricasemanticaJSweet.builder || (fabbricasemanticaJSweet.builder = {}));
        })(fabbricasemanticaJSweet = uniroma1.fabbricasemanticaJSweet || (uniroma1.fabbricasemanticaJSweet = {}));
    })(uniroma1 = it.uniroma1 || (it.uniroma1 = {}));
})(it || (it = {}));
