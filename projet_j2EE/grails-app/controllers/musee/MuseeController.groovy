package musee

import java.text.SimpleDateFormat

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class MuseeController {

    def museesAffiches = new ArrayList<Musee>()
    def museesPreferes = new ArrayList<Musee>()

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        afficheRender()
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

    def afficheRenderDemandeVisite(String msgErreur) {
        render(view: './../demandeVisite/index', model: [
                museePrefereInstanceList: museesPreferes,
                museePrefereInstanceCount: museesPreferes.size(),
                messageErreur: msgErreur
        ])
    }

    def doSearchMusee() {
        museesAffiches = RechercheMuseeService.rechercheMuseeAvec(
                params.extraitNom, params.codePostal, params.extraitRue);
        afficheRender()
    }

    def supprimerMuseePrefere() {
        int i = Integer.parseInt(params.id-"num")
        Musee museeAsupprimer = museesPreferes.get(i)

        if (museesPreferes.contains(museeAsupprimer)) {
            museesPreferes.remove(museeAsupprimer)
            AjoutMuseePrefereService.
                    supprimerMuseePrefere(museeAsupprimer)
        }
        afficheRender()
    }

    def ajouterMuseePrefere() {
        int i = Integer.parseInt(params.id-"num")
        Musee museeAajouter = museesAffiches.get(i);
        if (!museesPreferes.contains(museeAajouter)) {
            museesPreferes.add(AjoutMuseePrefereService.
                    insererMuseePrefere(museeAajouter))
            museesPreferes.sort { Musee param1, Musee param2 ->
                param1.nom.compareToIgnoreCase(param2.nom)
            }
        }
        afficheRender()
    }

    def effectuerDemandeVisite() {
        afficheRenderDemandeVisite("")
    }

    def doDemandeVisite() {
        Date dateDebut = isValid(
                params.dateDebutDay+"/"+params.dateDebutMois+"/"+params.dateDebutAnnee)
        Date dateFin = isValid(
                params.dateFinDay+"/"+params.dateFinMois+"/"+params.dateFinAnnee)
        int nbPersonnes = params.nombrePersonnes
        if (dateDebut && dateFin && dateFin.after(dateDebut) && dateDebut.after(new Date())) {
            //VALIDE
            int code = DemandeVisiteService.faireUneDemande(dateDebut, dateFin, nbPersonnes)
            afficheRenderDemandeVisite("Votre demande [numero:"+code+"] " +
                    "a bien ete enregistree et sera traitee " +
                    "prochainement.")
        } else if (dateDebut && dateFin) {
            afficheRenderDemandeVisite("Dates incoherentes")
        } else {
            afficheRenderDemandeVisite("Date(s) invalide(s)")
        }
    }

    public Date isValid(String strdate) {
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        try {
            df.setLenient(false);
            Date date = df.parse(strdate);
            return date;
        } catch (Exception ex) {
            return null;
        }
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
