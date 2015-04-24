package musee

class Musee {

    String nom
    String horaireOuverture
    String telephone
    String accesMetro
    String accesBus
    Adresse adresse

    static constraints = {
    }

    static belongsTo = [
            gestionnaire: Gestionnaire
    ]
}
