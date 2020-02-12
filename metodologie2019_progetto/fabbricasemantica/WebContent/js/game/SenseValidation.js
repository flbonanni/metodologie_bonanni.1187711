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
                 * Classe che genera la pagina per SenseValidation
                 * @author Flavia Bonanni
                 * @class
                 * @extends it.uniroma1.fabbricasemanticaJSweet.game.Annotation
                 */
                class SenseValidation extends it.uniroma1.fabbricasemanticaJSweet.game.Annotation {
                    static main(args) {
                        let SV = new SenseValidation();
                        let form = SV.createForm(SenseValidation.SERVLET_URL);
                        let hint = SV.createHint("Is this the correct sense of the word used in the following sentence?");
                        let word = SV.createWord();
                        let description = SV.createDescription();
                        let example = SV.createExample();
                        let radio1 = SV.createRadio();
                        let radio1label = SV.createRadioLabel("YES");
                        let radio2 = SV.createRadio();
                        let radio2label = SV.createRadioLabel("NO");
                        let submit = SV.createSubmit();
                        let skip = SV.createSkip();
                        let home = SV.createHomeLink();
                        let logout = SV.createLogoutLink();
                        $.getJSON(SenseValidation.REST_URL, "task=SENSE_VALIDATION", ((description, word, example) => {
                            return (result, a, ctx) => {
                                let json = result;
                                let sWord = (json["word"]);
                                let sDescription = (json["description"]);
                                let sExample = (json["example"]);
                                $(word).text(sWord);
                                $(description).text(sDescription);
                                $(example).text(sExample);
                                return null;
                            };
                        })(description, word, example));
                        let divHint = SV.divGenerator("form-group");
                        $(divHint).append(hint);
                        let divWord = SV.divGenerator("form-group");
                        $(divWord).append(word);
                        let divDescription = SV.divGenerator("form-group");
                        $(divDescription).append(description);
                        let divExample = SV.divGenerator("form-group");
                        $(divExample).append(example);
                        let divRadio1 = SV.divGenerator("form.radio1");
                        $(divRadio1).append(radio1, radio1label);
                        let divRadio2 = SV.divGenerator("form.radio2");
                        $(divRadio2).append(radio2, radio2label);
                        let divButtons = SV.divGenerator("form-group-bottom");
                        $(divButtons).append(submit, skip);
                        let divLinks = SV.divGenerator("links");
                        $(divLinks).append(home, logout);
                        $(form).css("margin", "0% 1.5%");
                        console.log("adding to form");
                        $(form).append(divHint, divWord);
                        $(form).append(divDescription, divExample);
                        $(form).append(divRadio1, divRadio2);
                        $(form).append(divButtons);
                        console.log("adding to body");
                        $("body").append(form, divLinks);
                    }
                }
                SenseValidation.SERVLET_URL = "example.jsp";
                SenseValidation.REST_URL = "nextExample.jsp";
                game.SenseValidation = SenseValidation;
                SenseValidation["__class"] = "it.uniroma1.fabbricasemanticaJSweet.game.SenseValidation";
            })(game = fabbricasemanticaJSweet.game || (fabbricasemanticaJSweet.game = {}));
        })(fabbricasemanticaJSweet = uniroma1.fabbricasemanticaJSweet || (uniroma1.fabbricasemanticaJSweet = {}));
    })(uniroma1 = it.uniroma1 || (it.uniroma1 = {}));
})(it || (it = {}));
it.uniroma1.fabbricasemanticaJSweet.game.SenseValidation.main(null);
