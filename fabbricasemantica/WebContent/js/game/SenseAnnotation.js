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
                 * Classe che genera la pagina per SenseAnnotation
                 * @author Flavia Bonanni
                 * @class
                 * @extends it.uniroma1.fabbricasemanticaJSweet.game.Annotation
                 */
                class SenseAnnotation extends it.uniroma1.fabbricasemanticaJSweet.game.Annotation {
                    static main(args) {
                        let SA = new SenseAnnotation();
                        let form = SA.createForm(SenseAnnotation.SERVLET_URL);
                        let hint = SA.createHint("Select the correct meaning of the word in the following sentence:");
                        let word = SA.createWord();
                        let description = SA.createDescription();
                        let radio1 = SA.createRadio();
                        let radio1label = SA.createRadioLabel("");
                        let radio2 = SA.createRadio();
                        let radio2label = SA.createRadioLabel("");
                        let radio3 = SA.createRadio();
                        let radio3label = SA.createRadioLabel("");
                        let radio4 = SA.createRadio();
                        let radio4label = SA.createRadioLabel("");
                        let submit = SA.createSubmit();
                        let skip = SA.createSkip();
                        let home = SA.createHomeLink();
                        let logout = SA.createLogoutLink();
                        $.getJSON(SenseAnnotation.REST_URL, "task=SENSE_ANNOTATION", ((radio3label, description, radio2label, radio4label, radio1label, word) => {
                            return (result, a, ctx) => {
                                let json = result;
                                let sWord = (json["word"]);
                                let sDescription = (json["description"]);
                                let sRadios = (json["senses"]);
                                $(word).text(sWord);
                                $(description).text(sDescription);
                                $(radio1label).text(sRadios[0]);
                                $(radio2label).text(sRadios[1]);
                                $(radio3label).text(sRadios[2]);
                                $(radio4label).text(sRadios[3]);
                                return null;
                            };
                        })(radio3label, description, radio2label, radio4label, radio1label, word));
                        let divHint = SA.divGenerator("form-group");
                        $(divHint).append(hint);
                        let divWord = SA.divGenerator("form-group");
                        $(divWord).append(word);
                        let divDescription = SA.divGenerator("form-group");
                        $(divDescription).append(description);
                        let divRadio1 = SA.divGenerator("form.radio1");
                        $(divRadio1).append(radio1, radio1label);
                        let divRadio2 = SA.divGenerator("form.radio2");
                        $(divRadio2).append(radio2, radio2label);
                        let divRadio3 = SA.divGenerator("form.radio3");
                        $(divRadio3).append(radio3, radio3label);
                        let divRadio4 = SA.divGenerator("form.radio4");
                        $(divRadio4).append(radio4, radio4label);
                        let divButtons = SA.divGenerator("form-group-bottom");
                        $(divButtons).append(submit, skip);
                        let divLinks = SA.divGenerator("links");
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
                SenseAnnotation.SERVLET_URL = "example.jsp";
                SenseAnnotation.REST_URL = "nextExample.jsp";
                game.SenseAnnotation = SenseAnnotation;
                SenseAnnotation["__class"] = "it.uniroma1.fabbricasemanticaJSweet.game.SenseAnnotation";
            })(game = fabbricasemanticaJSweet.game || (fabbricasemanticaJSweet.game = {}));
        })(fabbricasemanticaJSweet = uniroma1.fabbricasemanticaJSweet || (uniroma1.fabbricasemanticaJSweet = {}));
    })(uniroma1 = it.uniroma1 || (it.uniroma1 = {}));
})(it || (it = {}));
it.uniroma1.fabbricasemanticaJSweet.game.SenseAnnotation.main(null);
