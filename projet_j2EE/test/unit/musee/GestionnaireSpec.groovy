package musee

import grails.test.mixin.TestFor
import spock.lang.Specification
import spock.lang.Unroll

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Gestionnaire)
class GestionnaireSpec extends Specification {

    @Unroll
    void "test la validite d'un gestionnaire valide"() {

        given: "un gestionnaire initialise correctement"
        Gestionnaire gestionnaire = new Gestionnaire(nom: "unGestionnaire")

        expect: "le gestionnaire est valide"
        gestionnaire.validate() == true

        and: "le gestionnaire s'affiche bien"
        gestionnaire.toString().equals("unGestionnaire")

    }

    @Unroll
    void "test l'invalidite d'un gestionnaire invalide"(String nom, def _) {

        given: "un gestionnaire initialise de maniere non valide"
        Gestionnaire gestionnaire = new Gestionnaire(nom: nom)

        expect: "le gestionnaire est invalide"
        gestionnaire.validate() == false

        where:
        nom  | _
        ""   | _
        null | _

    }
}
