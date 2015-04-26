package musee

import grails.test.mixin.TestFor
import spock.lang.Specification
import spock.lang.Unroll

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Adresse)
class AdresseSpec extends Specification {

    @Unroll
    void "test la validite d'une adresse valide"(int numero, String rue, String codePostal, String ville) {

        given: "une adresse initialise correctement"
        Adresse adresse = new Adresse(numero: numero, rue: rue, codePostal: codePostal, ville: ville)

        expect: "l'adresse est valide"
        adresse.validate() == true

        and: "l'adresse s'affiche bien"
        adresse.toString().equals(numero + " " + rue + " " + codePostal + " " + ville)

        where:
        numero    |       rue       | codePostal |    ville
          1       | "rue gambetta"  |   "31500"  | "TOULOUSE"

    }

    @Unroll
    void "test l'invalidite d'une adresse invalide"(int numero, String rue, String codePostal, String ville) {

        given: "une adresse initialise de maniere non valide"
        Adresse adresse = new Adresse(numero: numero, rue: rue, codePostal: codePostal, ville: ville)

        expect: "l'utilisateur est invalide"
        adresse.validate() == false

        where:
        numero    |       rue       | codePostal   |    ville
            -1    | "rue gambetta"  |   "31000"    | "TOULOUSE"
             1    |       null      |    "31000"   | "TOULOUSE"
             1    |        ""       |    "31000"   | "TOULOUSE"
             1    | "rue gambetta"  |      null    | "TOULOUSE"
             1    | "rue gambetta"  |       ""     | "TOULOUSE"
             1    | "rue gambetta"  |   "3100033"  | "TOULOUSE"
             1    | "rue gambetta"  |    "31Hbf"   | "TOULOUSE"
             1    | "rue gambetta"  |       ""     |    null
             1    | "rue gambetta"  |       ""     |     ""
    }

}
