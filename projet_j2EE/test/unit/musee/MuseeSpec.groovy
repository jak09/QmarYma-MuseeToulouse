package musee

import grails.test.mixin.TestFor
import spock.lang.Specification
import spock.lang.Unroll

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Musee)
class MuseeSpec extends Specification {

    @Unroll
    void "test la validite d'un musee valide"(String nom, String horaire, String tel, String metro, String bus, Adresse adresse) {

        given: "un musee initialise correctement"
        Musee musee = new Musee(nom: nom, horairesOuverture: horaire,
                telephone: tel, accesMetro: metro, accesBus: bus, adresse: adresse)

        expect: "le musee est valide"
        musee.validate() == true

        and: "il s'affiche bien"
        musee.toString().equals(nom)

        and: "il est bien agal a"
        musee.equals(new Musee(nom: nom, horairesOuverture: "", telephone: "", accesMetro: "", accesBus: "", adresse: null))

        and: "il est different de"
        !musee.equals(nom)

        where:
        nom      |  horaire   |   tel           |    metro   |   bus   |  adresse
        "Musee"  |   "16h"    |   "0568364513"  |    "A"     |    "17" |   new Adresse(numero: 2, rue: "a", codePostal: "31500", ville: "TOULOUSE")
        "Musee"  |   null     |   null          |    null    |    null |   null
        "Musee"  |    ""      |    ""           |     ""     |    ""   |   null

    }

    @Unroll
    void "test l'invalidite d'un musee invalide"(
            String nom, String horaire, String tel, String metro, String bus, Adresse adresse) {

        given: "un musee initialise incorrectement"
        Musee musee = new Musee(nom: nom, horairesOuverture: horaire,
                telephone: tel, accesMetro: metro, accesBus: bus, adresse: adresse)

        expect: "le musee est invalide"
        musee.validate() == false

        where:
        nom      |  horaire   |   tel   |    metro   |   bus   |  adresse
        ""       |     ""     |    ""   |    ""      |    ""   |     null
        null     |     ""     |    ""   |     ""     |    ""   |    null

    }
}
