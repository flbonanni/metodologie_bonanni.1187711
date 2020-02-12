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
                 * Classe che genera la pagina per WordAnnotation
                 * @author Flavia Bonanni
                 * @class
                 * @extends it.uniroma1.fabbricasemanticaJSweet.game.Annotation
                 */
                class WordAnnotation extends it.uniroma1.fabbricasemanticaJSweet.game.Annotation {
                    static main(args) {
                        let WA = new WordAnnotation();
                        let form = WA.createForm(WordAnnotation.SERVLET_URL);
                        console.log("creating desct");
                        let description = new it.uniroma1.fabbricasemanticaJSweet.builder.HTMLLabelElementBuilder().setClassName("form-control-description").build();
                        let hint = WA.createHint("Data la seguente definizione, provare a indovinare il termine definito.");
                        let translation = WA.createTextarea("Scrivi la tua risposta qui...");
                        let submit = WA.createSubmit();
                        let skip = WA.createSkip();
                        let home = WA.createHomeLink();
                        let logout = WA.createLogoutLink();
                        $(skip).css("float");
                        $.getJSON(WordAnnotation.REST_URL, "task=WORD_ANNOTATION", ((description) => {
                            return (result, a, ctx) => {
                                let json = result;
                                let sDescription = (json["description"]);
                                $(description).text(sDescription);
                                return null;
                            };
                        })(description));
                        let divHint = WA.divGenerator("form-group");
                        $(divHint).append(hint);
                        let divDescription = WA.divGenerator("form-group");
                        $(divDescription).append(description);
                        let divTranslation = WA.divGenerator("");
                        let label = new it.uniroma1.fabbricasemanticaJSweet.builder.HTMLLabelElementBuilder().build();
                        $(divTranslation).append(label);
                        $(divTranslation).append(translation);
                        let divButtons = WA.divGenerator("form-group-bottom");
                        $(divButtons).append(submit, skip);
                        let divLinks = WA.divGenerator("links");
                        $(divLinks).append(home, logout);
                        $(form).css("margin", "0% 1.5%");
                        console.log("adding to form");
                        $(form).append(divHint);
                        $(form).append(divDescription);
                        $(form).append(divTranslation);
                        $(form).append(divButtons);
                        console.log("adding to body");
                        $("body").append(form, divLinks);
                    }
                }
                WordAnnotation.SERVLET_URL = "example.jsp";
                WordAnnotation.REST_URL = "nextExample.jsp";
                game.WordAnnotation = WordAnnotation;
                WordAnnotation["__class"] = "it.uniroma1.fabbricasemanticaJSweet.game.WordAnnotation";
            })(game = fabbricasemanticaJSweet.game || (fabbricasemanticaJSweet.game = {}));
        })(fabbricasemanticaJSweet = uniroma1.fabbricasemanticaJSweet || (uniroma1.fabbricasemanticaJSweet = {}));
    })(uniroma1 = it.uniroma1 || (it.uniroma1 = {}));
})(it || (it = {}));
it.uniroma1.fabbricasemanticaJSweet.game.WordAnnotation.main(null);
