package musee

import grails.transaction.Transactional

@Transactional
class DemandeVisiteService {

    def serviceMethod() {

    }

    static int faireUneDemande(Date dateDebut, Date dateFin, int nbPers) {
        DemandeVisite demandeVisite = new DemandeVisite(
                code: DemandeVisite.list().size(), dateDebutPeriode: dateDebut,
                dateFinPeriode: dateFin, nbPersonnes: nbPers, statut: null)
        DemandeVisiteMusee demandeVisiteMusee =
                new DemandeVisiteMusee(dateDemande: new Date())

        for (MuseePrefere m: MuseePrefere.list()) {
            m.museePrefere.addToVisites(demandeVisite)
            //demandeVisite.addToMusees(m.museePrefere)
            demandeVisiteMusee.demandeVisite = demandeVisite
            demandeVisiteMusee.musee = m.museePrefere
        }

        /*demandeVisite.save(flush: true)
        demandeVisiteMusee.save(flush: true)*/
        demandeVisite.code
    }
}
