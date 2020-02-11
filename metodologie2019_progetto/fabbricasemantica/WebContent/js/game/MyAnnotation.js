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
                 * Classe che genera la pagina per MyAnnotation
                 * @author Flavia Bonanni
                 * @class
                 * @extends it.uniroma1.fabbricasemanticaJSweet.game.Annotation
                 */
                class MyAnnotation extends it.uniroma1.fabbricasemanticaJSweet.game.Annotation {
                    static main(args) {
                        let MA = new MyAnnotation();
                        let form = MA.createForm(MyAnnotation.SERVLET_URL);
                        let hint = MA.createHint("The following description of the word is a translation from another language. Rate this translation:");
                        let word = MA.createWord();
                        let description = MA.createDescription();
                        let rangeLabel1 = MA.createRangeLabel("Comprehensibility");
                        let range1 = MA.createRange();
                        let rangeLabel2 = MA.createRangeLabel("Grammatical precision");
                        let range2 = MA.createRange();
                        let rangeLabel3 = MA.createRangeLabel("Naturalness");
                        let range3 = MA.createRange();
                        let rangeLabel4 = MA.createRangeLabel("Authenticity");
                        let range4 = MA.createRange();
                        let submit = MA.createSubmit();
                        let skip = MA.createSkip();
                        let home = MA.createHomeLink();
                        let logout = MA.createLogoutLink();
                        $.getJSON(MyAnnotation.REST_URL, "task=MY_ANNOTATION", ((description, word) => {
                            return (result, a, ctx) => {
                                let json = result;
                                let sWord = (json["word"]);
                                let sDescription = (json["description"]);
                                $(word).text(sWord);
                                $(description).text(sDescription);
                                return null;
                            };
                        })(description, word));
                        let divHint = MA.divGenerator("form-group");
                        $(divHint).append(hint);
                        let divWord = MA.divGenerator("form-group");
                        $(divWord).append(word);
                        let divDescription = MA.divGenerator("form-group");
                        $(divDescription).append(description);
                        let divRange = MA.divGenerator("form-group");
                        $(divRange).append(rangeLabel1, range1, "<br />", rangeLabel2, range2, "<br />", rangeLabel3, range3, "<br />", rangeLabel4, range4);
                        let divButtons = MA.divGenerator("form-group-bottom");
                        $(divButtons).append(submit, skip);
                        let divLinks = MA.divGenerator("links");
                        $(divLinks).append(home, logout);
                        $(form).css("margin", "0% 1.5%");
                        console.log("adding to form");
                        $(form).append(divHint, divWord);
                        $(form).append(divDescription);
                        $(form).append(divRange);
                        $(form).append(divButtons);
                        console.log("adding to body");
                        $("body").append(form, divLinks);
                    }
                }
                MyAnnotation.SERVLET_URL = "example.jsp";
                MyAnnotation.REST_URL = "nextExample.jsp";
                game.MyAnnotation = MyAnnotation;
                MyAnnotation["__class"] = "it.uniroma1.fabbricasemanticaJSweet.game.MyAnnotation";
            })(game = fabbricasemanticaJSweet.game || (fabbricasemanticaJSweet.game = {}));
        })(fabbricasemanticaJSweet = uniroma1.fabbricasemanticaJSweet || (uniroma1.fabbricasemanticaJSweet = {}));
    })(uniroma1 = it.uniroma1 || (it.uniroma1 = {}));
})(it || (it = {}));
it.uniroma1.fabbricasemanticaJSweet.game.MyAnnotation.main(null);
