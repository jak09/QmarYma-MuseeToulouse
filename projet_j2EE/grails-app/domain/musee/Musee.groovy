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
            visites: DemandeVisite
    ]

    static belongsTo = [
            gestionnaire: Gestionnaire
    ]

    @Override
    String toString() {
        nom
    }

    @Override
    boolean equals(Object o) {
        return o instanceof Musee ? ((Musee)o).nom.equals(nom) : false
    }
}
