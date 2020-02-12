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
                 * Classe che genera la pagina per TranslationValidation
                 * @author Flavia Bonanni
                 * @class
                 * @extends it.uniroma1.fabbricasemanticaJSweet.game.Annotation
                 */
                class TranslationValidation extends it.uniroma1.fabbricasemanticaJSweet.game.Annotation {
                    static main(args) {
                        let TV = new TranslationValidation();
                        let form = TV.createForm(TranslationValidation.SERVLET_URL);
                        let hint = TV.createHint("Select the correct translation of the following word:");
                        let word = TV.createWord();
                        let description = TV.createDescription();
                        let radio1 = TV.createRadio();
                        let radio1label = TV.createRadioLabel("");
                        let radio2 = TV.createRadio();
                        let radio2label = TV.createRadioLabel("");
                        let radio3 = TV.createRadio();
                        let radio3label = TV.createRadioLabel("");
                        let radio4 = TV.createRadio();
                        let radio4label = TV.createRadioLabel("");
                        let submit = TV.createSubmit();
                        let skip = TV.createSkip();
                        let home = TV.createHomeLink();
                        let logout = TV.createLogoutLink();
                        $.getJSON(TranslationValidation.REST_URL, "task=TRANSLATION_VALIDATION", ((radio3label, description, radio2label, radio4label, radio1label, word) => {
                            return (result, a, ctx) => {
                                let json = result;
                                let sWord = (json["word"]);
                                let sDescription = (json["description"]);
                                let sRadios = (json["translations"]);
                                $(word).text(sWord);
                                $(description).text(sDescription);
                                $(radio1label).text(sRadios[0]);
                                $(radio2label).text(sRadios[1]);
                                $(radio3label).text(sRadios[2]);
                                $(radio4label).text(sRadios[3]);
                                return null;
                            };
                        })(radio3label, description, radio2label, radio4label, radio1label, word));
                        let divHint = TV.divGenerator("form-group");
                        $(divHint).append(hint);
                        let divWord = TV.divGenerator("form-group");
                        $(divWord).append(word);
                        let divDescription = TV.divGenerator("form-group");
                        $(divDescription).append(description);
                        let divRadio1 = TV.divGenerator("form.radio1");
                        $(divRadio1).append(radio1, radio1label);
                        let divRadio2 = TV.divGenerator("form.radio2");
                        $(divRadio2).append(radio2, radio2label);
                        let divRadio3 = TV.divGenerator("form.radio3");
                        $(divRadio3).append(radio3, radio3label);
                        let divRadio4 = TV.divGenerator("form.radio4");
                        $(divRadio4).append(radio4, radio4label);
                        let divButtons = TV.divGenerator("form-group-bottom");
                        $(divButtons).append(submit, skip);
                        let divLinks = TV.divGenerator("links");
                        $(divLinks).append(home, logout);
                        $(form).css("margin", "0% 1.5%");
                        console.log("adding to form");
                        $(form).append(divHint, divWord);
                        $(form).append(divDescription);
                        $(form).append(divRadio1, divRadio2, divRadio3, divRadio4);
                        $(form).append(divButtons);
                        console.log("adding to body");
                        $("body").append(form, divLinks);
                    }
                }
                TranslationValidation.SERVLET_URL = "example.jsp";
                TranslationValidation.REST_URL = "nextExample.jsp";
                game.TranslationValidation = TranslationValidation;
                TranslationValidation["__class"] = "it.uniroma1.fabbricasemanticaJSweet.game.TranslationValidation";
            })(game = fabbricasemanticaJSweet.game || (fabbricasemanticaJSweet.game = {}));
        })(fabbricasemanticaJSweet = uniroma1.fabbricasemanticaJSweet || (uniroma1.fabbricasemanticaJSweet = {}));
    })(uniroma1 = it.uniroma1 || (it.uniroma1 = {}));
})(it || (it = {}));
it.uniroma1.fabbricasemanticaJSweet.game.TranslationValidation.main(null);
