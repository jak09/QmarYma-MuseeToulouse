package musee


import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class MuseeController {

    def museesAffiches
    def museesPreferes = new ArrayList<Musee>()

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond new ArrayList<Musee>(), model: [museeInstanceCount: 0]
    }

    def show(Musee museeInstance) {
        respond museeInstance
    }

    def create() {
        respond new Musee(params)
    }

    def afficheRender() {
        render(view: 'index',
                model:[museeInstanceList: museesAffiches,
                       museeInstanceCount: museesAffiches.size(),
                       museePrefereInstanceList: museesPreferes,
                       museePrefereInstanceCount: museesPreferes.size()
                ])
    }

    def doSearchMusee() {
        museesAffiches = RechercheMuseeService.rechercheMuseeAvec(
                params.extraitNom, params.codePostal, params.extraitRue);

        println("liste des musees preferes:")
        for (Musee m: museesPreferes)
            println(m);
        if (museesPreferes.size()>=2)
            println(museesPreferes.get(0).equals(museesPreferes.get(1)))

        afficheRender()
    }

    def supprimerMuseePrefere() {
        String valeur = params._action_supprimerMuseePrefere
        valeur = (valeur-'Supprimer (')-')'
        int i = Integer.parseInt(valeur)

        Musee museeAsupp = museesPreferes.remove(i);
        AjoutMuseePrefereService.
                supprimerMuseePrefere(museeAsupp)
        afficheRender()
    }

    def ajouterMuseePrefere() {
        String valeur = params._action_ajouterMuseePrefere
        valeur = (valeur-'Ajouter (')-')'
        int i = Integer.parseInt(valeur)

        museesPreferes.add(AjoutMuseePrefereService.
                insererMuseePrefere(museesAffiches.get(i)))
        museesPreferes.sort {Musee param1, Musee param2 ->
            param1.nom.compareToIgnoreCase(param2.nom)}
        afficheRender()
    }

    def effectuerDemandeVisite() {

    }

    @Transactional
    def save(Musee museeInstance) {

        if (museeInstance == null) {
            notFound()
            return
        }

        if (museeInstance.hasErrors()) {
            respond museeInstance.errors, view: 'create'
            return
        }

        museeInstance.save flush: true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'musee.label', default: 'Musee'), museeInstance.id])
                redirect museeInstance
            }
            '*' { respond museeInstance, [status: CREATED] }
        }
    }

    def edit(Musee museeInstance) {
        respond museeInstance
    }

    @Transactional
    def update(Musee museeInstance) {
        if (museeInstance == null) {
            notFound()
            return
        }

        if (museeInstance.hasErrors()) {
            respond museeInstance.errors, view: 'edit'
            return
        }

        museeInstance.save flush: true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Musee.label', default: 'Musee'), museeInstance.id])
                redirect museeInstance
            }
            '*' { respond museeInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Musee museeInstance) {

        if (museeInstance == null) {
            notFound()
            return
        }

        museeInstance.delete flush: true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Musee.label', default: 'Musee'), museeInstance.id])
                redirect action: "index", method: "GET"
            }
            '*' { render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'musee.label', default: 'Musee'), params.id])
                redirect action: "index", method: "GET"
            }
            '*' { render status: NOT_FOUND }
        }
    }
}
