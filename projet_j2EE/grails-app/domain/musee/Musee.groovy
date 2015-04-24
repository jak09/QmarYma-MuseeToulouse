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
            musee: Musee
    ]

    static mapping = {
        adresse fetch: 'join'
    }

}
