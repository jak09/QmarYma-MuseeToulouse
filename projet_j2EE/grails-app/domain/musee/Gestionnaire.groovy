package musee

class Gestionnaire {

    String nom

    static constraints = {
    }

    static hasMany = [
            musees: Musee
    ]
}
