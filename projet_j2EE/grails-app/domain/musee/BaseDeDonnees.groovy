package musee

class BaseDeDonnees {

    static Gestionnaire g1
    static Gestionnaire g2

    static Musee m1
    static Musee m2
    static Musee m3

    static constraints = {
    }

    static void insererGestionnaires() {
        g1 = new Gestionnaire(nom: "Mairie de Toulouse - DGA Culture")
        g2 = new Gestionnaire(nom: "Association")
        g1.save()
        g2.save()
    }

    static void insererMusees() {
        m1 = new Musee(
                nom:"ARCHIVES MUNICIPALES TOULOUSE",
                horairesOuverture: "Ouvert du lundi au vendredi de 9h à 17h. " +
                        "Fermeture de 12h à 13h30 pendant toutes les vacances scolaires. " +
                        "Fermeture annuelle la dernière quinzaine de juillet.",
                telephone: "05 61 61 63 33",
                accesMetro: "Roseraie (A)",
                accesBus: "36, 38",
                adresse: new Adresse(
                        numero:2,
                        rue:"RUE DES ARCHIVES",
                        codePostal: 31500,
                        ville:"TOULOUSE"))
        m2 = new Musee(
                nom:"CMAV - CENTRE MERIDIONAL DE L'ARCHITECTURE DE LA VILLE",
                horairesOuverture: "Ouvert du mardi au samedi de 13h à 19h " +
                        "fermé les dimanches, jours fériés et du 1er au 15 ",
                telephone: "05 61 23 30 49",
                accesMetro: "Capitole (A), Jean Jaurès (B)",
                accesBus: "ncv, 2, 10, 12, 14, 38, 78 et 80",
                adresse: new Adresse(
                        numero:5,
                        rue:"RUE SAINT PANTALEON",
                        codePostal: 31000,
                        ville:"TOULOUSE"))
        m3 = new Musee(
                nom:"ENSEMBLE CONVENTUEL DES JACOBINS",
                horairesOuverture: "Ouvert tous les jours de 9h à 19h.",
                telephone: "05 61 22 21 92",
                accesMetro: "Esquirol, Capitole (A)",
                accesBus: "NCV, 2, 10, 12, 14, 38, 78, 80",
                adresse: new Adresse(
                        numero:69,
                        rue:"RUE PARGAMINIERES",
                        codePostal: 31000,
                        ville:"TOULOUSE"))

        /*m1.save()
        m2.save()
        m3.save()*/

    }

    static void insererMuseesToGestionnaires() {
        g1.addToMusees(m1)
        g1.addToMusees(m3)
        g2.addToMusees(m2)
    }
}
