package musee

class Adresse {

    int numero
    String rue
    String codePostal
    String ville

    static constraints = {
    }

    static belongsTo = [
            musee: Musee
    ]

    @Override
    String toString() {
        numero + " " + rue + " " + codePostal + " " + ville
    }
}
