package musee

import grails.test.mixin.TestFor
import spock.lang.Specification
import spock.lang.Unroll

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(DemandeVisite)
class DemandeVisiteSpec extends Specification {

    @Unroll
    void "test la validite d'une demandeVisite valide"(int code, Date dateDebut, Date dateFin, int nbPersonnes, String statut) {

        given: "une demandeVisite initialise correctement"
        DemandeVisite demandeVisite = new DemandeVisite(code: code, dateDebutPeriode: dateDebut, dateFinPeriode: dateFin,
                nbPersonnes: nbPersonnes, statut: statut)

        expect: "la demandeVisite est valide"
        demandeVisite.validate() == true

        where:
        code  |  dateDebut   |   dateFin   |  nbPersonnes   |   statut
        12    |  null        |    null     |    4           |   null
        12    |  new Date()  | new Date()  |   5            |    ""
        12    |  new Date()  | new Date()  |   5            |    "en traitement"

    }

    @Unroll
    void "test l'invalidite d'une demandeVisite non valide"(int code, Date dateDebut, Date dateFin, int nbPersonnes, String statut) {

        given: "une demandeVisite initialise non correctement"
        DemandeVisite demandeVisite = new DemandeVisite(code: code, dateDebutPeriode: dateDebut, dateFinPeriode: dateFin,
                nbPersonnes: nbPersonnes, statut: statut)

        expect: "la demandeVisite est invalide"
        demandeVisite.validate() == false

        where:
        code  |  dateDebut   |   dateFin   |  nbPersonnes   |   statut
        12    |  new Date()  |  new Date() |    0           |   "en traitement"
        12    |  new Date()  | new Date()  |     10         |    "en traitement"

    }
}
