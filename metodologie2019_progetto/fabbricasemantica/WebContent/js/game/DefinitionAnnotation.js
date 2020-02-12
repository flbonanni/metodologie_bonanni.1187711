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
                 * Classe che genera la pagina per DefinitionAnnotation
                 * @author Flavia Bonanni
                 * @class
                 * @extends it.uniroma1.fabbricasemanticaJSweet.game.Annotation
                 */
                class DefinitionAnnotation extends it.uniroma1.fabbricasemanticaJSweet.game.Annotation {
                    static main(args) {
                        let DA = new DefinitionAnnotation();
                        let form = DA.createForm(DefinitionAnnotation.SERVLET_URL);
                        let description = DA.createDescription();
                        $(description).css("font-weight", "bold");
                        let hint = DA.createHint("Data la parola e il suo iperonimo, fornire una definizione nella tua lingua.");
                        let word = DA.createWord();
                        let translation = DA.createTextarea("Scrivi la tua traduzione qui...");
                        let submit = DA.createSubmit();
                        let skip = DA.createSkip();
                        let home = DA.createHomeLink();
                        let logout = DA.createLogoutLink();
                        $(skip).css("float");
                        $.getJSON(DefinitionAnnotation.REST_URL, "task=DEFINITION_ANNOTATION", ((description, word) => {
                            return (result, a, ctx) => {
                                let json = result;
                                let sWord = (json["word"]);
                                let sHypernym = (json["hypernym"]);
                                $(word).text(sWord);
                                $(description).text(sHypernym);
                                return null;
                            };
                        })(description, word));
                        let divHint = DA.divGenerator("form-group");
                        $(divHint).append(hint);
                        let divWord = DA.divGenerator("form-group");
                        $(divWord).append(word);
                        let divDescription = DA.divGenerator("form-group");
                        $(divDescription).append(description);
                        let divTranslation = DA.divGenerator("");
                        let label = new it.uniroma1.fabbricasemanticaJSweet.builder.HTMLLabelElementBuilder().build();
                        $(divTranslation).append(label);
                        $(divTranslation).append(translation);
                        let divButtons = DA.divGenerator("form-group-bottom");
                        $(divButtons).append(submit, skip);
                        let divLinks = DA.divGenerator("links");
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
                DefinitionAnnotation.SERVLET_URL = "example.jsp";
                DefinitionAnnotation.REST_URL = "nextExample.jsp";
                game.DefinitionAnnotation = DefinitionAnnotation;
                DefinitionAnnotation["__class"] = "it.uniroma1.fabbricasemanticaJSweet.game.DefinitionAnnotation";
            })(game = fabbricasemanticaJSweet.game || (fabbricasemanticaJSweet.game = {}));
        })(fabbricasemanticaJSweet = uniroma1.fabbricasemanticaJSweet || (uniroma1.fabbricasemanticaJSweet = {}));
    })(uniroma1 = it.uniroma1 || (it.uniroma1 = {}));
})(it || (it = {}));
it.uniroma1.fabbricasemanticaJSweet.game.DefinitionAnnotation.main(null);
