package musee

import grails.transaction.Transactional
@Transactional
class RechercheMuseeService {

    def serviceMethod() {

    }

    static List<Musee> rechercheMuseeAvec(
            String extraitNom, String codePostal, String extraitRue) {

        def criteria = Musee.createCriteria()
        List<Musee> resultat = criteria.list {
            if (extraitNom) {
                like 'nom', "%${extraitNom}%"
            }
            if (codePostal) {
                adresse {
                    like 'codePostal', codePostal
                }
            }
            if (extraitRue) {
                adresse {
                    like 'rue', "%${extraitRue}%"
                }
            }

            join 'adresse'
        }

        resultat
    }
}
