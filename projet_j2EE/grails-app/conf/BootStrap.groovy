import musee.BaseDeDonnees

class BootStrap {

    def init = { servletContext ->
        BaseDeDonnees.insererMusees()
        BaseDeDonnees.insererGestionnaires()
        BaseDeDonnees.insererMuseesToGestionnaires()
    }
    def destroy = {
    }
}
