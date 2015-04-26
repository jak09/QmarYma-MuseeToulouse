package musee

class Gestionnaire {

    String nom

    static constraints = {
        nom blank: false
    }

    static hasMany = [
            musees: Musee
    ]

    @Override
    String toString() {
        nom
    }
}
