package musee

class DemandeVisite {

    int code
    Date dateDebutPeriode
    Date dateFinPeriode
    int nbPersonnes
    String statut

    static constraints = {
        nbPersonnes min: 1, max: 6
        statut nullable: true
    }

    static belongsTo = [
            musee: Musee
    ]
}
