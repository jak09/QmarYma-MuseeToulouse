package musee



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class RechercheMuseeController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond RechercheMusee.list(params), model:[rechercheMuseeInstanceCount: RechercheMusee.count()]
    }

    def show(RechercheMusee rechercheMuseeInstance) {
        respond rechercheMuseeInstance
    }

    def create() {
        respond new RechercheMusee(params)
    }

    def doSearchMusee() {
        def musees = RechercheMuseeService.rechercheMuseeAvec(
                params.extraitNom, params.codePostal, params.extraitRue);
        render(view: 'index',
                model:[rechercheMuseeInstanceList: musees,
                       rechercheMuseeInstanceCount: musees.size()])
    }

    @Transactional
    def save(RechercheMusee rechercheMuseeInstance) {
        if (rechercheMuseeInstance == null) {
            notFound()
            return
        }

        if (rechercheMuseeInstance.hasErrors()) {
            respond rechercheMuseeInstance.errors, view:'create'
            return
        }

        rechercheMuseeInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'rechercheMusee.label', default: 'RechercheMusee'), rechercheMuseeInstance.id])
                redirect rechercheMuseeInstance
            }
            '*' { respond rechercheMuseeInstance, [status: CREATED] }
        }
    }

    def edit(RechercheMusee rechercheMuseeInstance) {
        respond rechercheMuseeInstance
    }

    @Transactional
    def update(RechercheMusee rechercheMuseeInstance) {
        if (rechercheMuseeInstance == null) {
            notFound()
            return
        }

        if (rechercheMuseeInstance.hasErrors()) {
            respond rechercheMuseeInstance.errors, view:'edit'
            return
        }

        rechercheMuseeInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'RechercheMusee.label', default: 'RechercheMusee'), rechercheMuseeInstance.id])
                redirect rechercheMuseeInstance
            }
            '*'{ respond rechercheMuseeInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(RechercheMusee rechercheMuseeInstance) {

        if (rechercheMuseeInstance == null) {
            notFound()
            return
        }

        rechercheMuseeInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'RechercheMusee.label', default: 'RechercheMusee'), rechercheMuseeInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'rechercheMusee.label', default: 'RechercheMusee'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
