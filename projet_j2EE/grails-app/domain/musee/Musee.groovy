package musee

class Musee {

    String nom
    String horairesOuverture
    String telephone
    String accesMetro
    String accesBus
    Adresse adresse

    static constraints = {
    }

    static belongsTo = [
            gestionnaire: Gestionnaire
    ]

    static mapping = {
        adresse fetch: 'join'
    }

    @Override
    String toString() {
        nom
    }
}
