package musee



import spock.lang.*

/**
 *
 */
class RechercheMuseeServiceIntegrationTestSpec extends Specification {

    void "test recherche musee"() {

        Musee museeATrouver = BaseDeDonnees.m3

        given:"extrait du nom"
        String extraitNom = "JACOBINS"

        and: "un extrait de rue"
        String extraitRue = "RUE"

        and: "un code postal"
        String codePostal = "31000"

        when: "on tente de recherche le(s) musee(s) correspondant"
        List<Musee> resultMusee = RechercheMuseeService.rechercheMuseeAvec(extraitNom, codePostal, extraitRue)

        then: "on a trouve un seul resultat"
        resultMusee.size() == 1

        and: "cest le musee a trouver"
        resultMusee.get(0).equals(museeATrouver)

        and:"le musee résultant n'a pas d'erreur"
        !resultMusee.get(0).hasErrors()

        and:"le musee résultant a un id"
        resultMusee.get(0).id

        and:"le musee est bien present en base"
        Musee.findById(resultMusee.get(0).id) != null

        and: "le nom du musee resultant contient bien lextrait du nom"
        resultMusee.get(0).nom.contains(extraitNom) == true

        and: "la rue du musee resultant contient bien lextrait de la rue"
        resultMusee.get(0).adresse.rue.contains(extraitRue) == true

        and: "le code Postal du musee resultant est bien identique a celui entre en parametre"
        resultMusee.get(0).adresse.codePostal.equals(codePostal)
    }
}
