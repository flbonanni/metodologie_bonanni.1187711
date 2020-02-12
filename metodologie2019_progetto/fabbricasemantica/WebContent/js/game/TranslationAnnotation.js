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
                 * Classe che genera la pagina per TranslationAnnotation
                 * @author Flavia Bonanni
                 * @class
                 * @extends it.uniroma1.fabbricasemanticaJSweet.game.Annotation
                 */
                class TranslationAnnotation extends it.uniroma1.fabbricasemanticaJSweet.game.Annotation {
                    static main(args) {
                        let TA = new TranslationAnnotation();
                        let form = TA.createForm(TranslationAnnotation.SERVLET_URL);
                        let description = TA.createDescription();
                        $(description).css("font-weight", "bold");
                        let hint = TA.createHint("Data la seguente parola e definizione in inglese, fornire una traduzione nella tua lingua madre.");
                        let word = TA.createWord();
                        let translation = TA.createTextarea("Scrivi la tua traduzione qui...");
                        let submit = TA.createSubmit();
                        let skip = TA.createSkip();
                        let home = TA.createHomeLink();
                        let logout = TA.createLogoutLink();
                        $(skip).css("float");
                        $.getJSON(TranslationAnnotation.REST_URL, "task=TRANSLATION_ANNOTATION", ((description, word) => {
                            return (result, a, ctx) => {
                                let json = result;
                                let sWord = (json["word"]);
                                let sDescription = (json["description"]);
                                $(word).text(sWord);
                                $(description).text(sDescription);
                                return null;
                            };
                        })(description, word));
                        let divHint = TA.divGenerator("form-group");
                        $(divHint).append(hint);
                        let divWord = TA.divGenerator("form-group");
                        $(divWord).append(word);
                        let divDescription = TA.divGenerator("form-group");
                        $(divDescription).append(description);
                        let divTranslation = TA.divGenerator("");
                        let label = new it.uniroma1.fabbricasemanticaJSweet.builder.HTMLLabelElementBuilder().build();
                        $(divTranslation).append(label);
                        $(divTranslation).append(translation);
                        let divButtons = TA.divGenerator("form-group-bottom");
                        $(divButtons).append(submit, skip);
                        let divLinks = TA.divGenerator("links");
                        $(divLinks).append(home, logout);
                        $(form).css("margin", "0% 1.5%");
                        console.log("adding to form");
                        $(form).append(divHint, divWord);
                        $(form).append(divDescription);
                        $(form).append(divTranslation);
                        $(form).append(divButtons);
                        console.log("adding to body");
                        $("body").append(form, divLinks);
                    }
                }
                TranslationAnnotation.SERVLET_URL = "example.jsp";
                TranslationAnnotation.REST_URL = "nextExample.jsp";
                game.TranslationAnnotation = TranslationAnnotation;
                TranslationAnnotation["__class"] = "it.uniroma1.fabbricasemanticaJSweet.game.TranslationAnnotation";
            })(game = fabbricasemanticaJSweet.game || (fabbricasemanticaJSweet.game = {}));
        })(fabbricasemanticaJSweet = uniroma1.fabbricasemanticaJSweet || (uniroma1.fabbricasemanticaJSweet = {}));
    })(uniroma1 = it.uniroma1 || (it.uniroma1 = {}));
})(it || (it = {}));
it.uniroma1.fabbricasemanticaJSweet.game.TranslationAnnotation.main(null);
