/* Generated from Java with JSweet 2.3.0-SNAPSHOT - http://www.jsweet.org */
var it;
(function (it) {
    var uniroma1;
    (function (uniroma1) {
        var fabbricasemanticaJSweet;
        (function (fabbricasemanticaJSweet) {
            var userpage;
            (function (userpage) {
                /**
                 * Classe che genera l'homepage
                 * @author Flavia Bonanni
                 * @class
                 * @extends it.uniroma1.fabbricasemanticaJSweet.userpage.AuthPage
                 */
                class Home extends it.uniroma1.fabbricasemanticaJSweet.userpage.AuthPage {
                    static main(args) {
                        let home = new Home();
                        console.log("Adding image");
                        let startButton = new it.uniroma1.fabbricasemanticaJSweet.builder.HTMLImageElementBuilder().setSrc(Home.pathToButton).setHeight(700).setWidth(1518).build();
                        console.log("Creating link to task");
                        let toTask = new it.uniroma1.fabbricasemanticaJSweet.builder.HTMLAnchorElementBuilder().setName("toTask").setHref(Home.TASK_URL).build();
                        console.log("Creating link to logout");
                        let logout = new it.uniroma1.fabbricasemanticaJSweet.builder.HTMLAnchorElementBuilder().setText("Logout").setName("Logout").setHref(Home.SERVLET_URL).build();
                        console.log("Creating divs");
                        let divImage = home.divGenerator("image");
                        $(toTask).append(startButton);
                        $(divImage).append(toTask);
                        let divLogout = home.divGenerator("link");
                        $(divLogout).append(logout);
                        $("body").append(divImage, divLogout);
                    }
                }
                Home.TASK_URL = "example.jsp";
                Home.SERVLET_URL = "logout.jsp";
                Home.pathToButton = "images/button.jpg";
                userpage.Home = Home;
                Home["__class"] = "it.uniroma1.fabbricasemanticaJSweet.userpage.Home";
            })(userpage = fabbricasemanticaJSweet.userpage || (fabbricasemanticaJSweet.userpage = {}));
        })(fabbricasemanticaJSweet = uniroma1.fabbricasemanticaJSweet || (uniroma1.fabbricasemanticaJSweet = {}));
    })(uniroma1 = it.uniroma1 || (it.uniroma1 = {}));
})(it || (it = {}));
it.uniroma1.fabbricasemanticaJSweet.userpage.Home.main(null);
