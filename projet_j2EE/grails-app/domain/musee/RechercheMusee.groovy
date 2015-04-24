package musee

class RechercheMusee {

    String extraitNom
    String codePostal
    String extraitRue

    static constraints = {
        extraitNom nullable: true
        codePostal inList: ["31000", "31500"]
        extraitRue nullable: true
    }
}
