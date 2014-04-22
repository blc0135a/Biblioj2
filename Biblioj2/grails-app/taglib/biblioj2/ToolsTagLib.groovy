package biblioj2

class ToolsTagLib {

	def panier = { attrs, body ->
		
		Reservation maReservation = (Reservation) attrs.maReservation
		
		out << '<ul class="perso_nav">'
		out << '<li class="perso_nav-item">'
		
		if(maReservation == null || maReservation.livresReserves == null) {
			out << "<a href='http://localhost:8080/BiblioJ/reservation/showCurrentReservation'> Panier <br/> Total : 0 livre</a>"
		} else {
			out << "<a class=\"perso_icone\" href=\"http://localhost:8080/BiblioJ/reservation/showCurrentReservation\"><img src=\"${resource(dir: 'images', file: 'cartBig.png')}\" alt=\"Panier\" height=\"37\"/><br/> Total : " + maReservation.livresReserves.size() + " livres</a>"
			out << '<ul class="perso_nav perso_sub-nav">'
		for(livre in maReservation.livresReserves) {
			out << '<li class="perso_sub-nav-item"><a href="http://localhost:8080/BiblioJ/reservation/showCurrentReservation">' + livre.livre.titre + ' (x' + livre.quantite + ')</a></li>'
		}
			out << '</ul>'
		}
		
			out << '</li>'
			out << '</ul>'
		
		}
	
}
