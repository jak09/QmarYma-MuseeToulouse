package musee

class DemandeVisite {

    int code
    Date dateDebutPeriode
    Date dateFinPeriode
    int nbPersonnes
    String statut

    static constraints = {
        statut nullable: true
    }

    static belongsTo = [
            musee: Musee
    ]
}
