package biblioj2

class LivreService {

    def chercherLivre(String titreLivre, String nomAuteur, String typeDocument, def params){
		
		titreLivre = titreLivre ?: ""
		nomAuteur = nomAuteur ?: ""
		typeDocument = typeDocument ?: ""

		def criteria = Livre.createCriteria();
		def resultat = criteria{
			like "titre", "%"+titreLivre+"%"
			auteurs{
				like "nom", "%"+nomAuteur+"%"
			}
			type{
				like "intitule", "%"+typeDocument+"%"
			}
		}
		
		List listLivre = resultat[(params)]

		[livreInstanceList: listLivre, livreInstanceTotal: resultat.size()];
    }
}
