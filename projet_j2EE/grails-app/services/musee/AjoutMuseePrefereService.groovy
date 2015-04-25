package musee

import grails.transaction.Transactional

@Transactional
class AjoutMuseePrefereService {

    def serviceMethod() {

    }

    static Musee insererMuseePrefere(Musee m) {
        if (!MuseePrefere.list().contains(m))
            new MuseePrefere(museePrefere: m).save(flush: true)
        m
    }

    static void supprimerMuseePrefere(Musee m) {
        if (MuseePrefere.list().contains(m))
            m.delete(flush: true)
    }

}
