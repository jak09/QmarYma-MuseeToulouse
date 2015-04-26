package musee

class Adresse {

    int numero
    String rue
    String codePostal
    String ville

    static constraints = {
        numero min: 1
        rue blank: false
        ville blank: false
        codePostal blank: false, matches: "[0-9][0-9][0-9][0-9][0-9]"
    }

    @Override
    String toString() {
        numero + " " + rue + " " + codePostal + " " + ville
    }

}
