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

    static mapping = {
        adresse fetch: 'join'
    }

    static hasMany = [
            visites: DemandeVisite// DemandeVisiteMusee
    ]

    @Override
    String toString() {
        nom
    }
}
