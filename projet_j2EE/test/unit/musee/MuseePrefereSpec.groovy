package musee

import grails.test.mixin.TestFor
import spock.lang.Specification
import spock.lang.Unroll

/**
 * Created by Quentin on 26/04/2015.
 */
@TestFor (MuseePrefere)
class MuseePrefereSpec extends Specification {

    @Unroll
    void "test la validite d'un musee preferee valide"(Musee musee, def _) {

        given: "un musee prefere initialise de maniere valide"
        MuseePrefere museePrefere = new MuseePrefere(museePrefere: musee)

        expect: "le musee prefere est valide"
        museePrefere.validate() == true

        where:
        musee                                                                                                      | _
        new Musee(nom: "Musee", horairesOuverture: "", telephone: "", accesMetro: "", accesBus: "", adresse: null) | _

    }

    @Unroll
    void "test l'invalidite d'un musee preferee invalide"(Musee musee, def _) {

        given: "un musee prefere initialise de maniere invalide"
        MuseePrefere museePrefere = new MuseePrefere(museePrefere: musee)

        expect: "le musee prefere est invalide"
        museePrefere.validate() == false

        where:
        musee  | _
        null   | _

    }

}
