package biblioj2

class ToolsTagLib {

	def panier = { attrs, body ->
		
		Reservation maReservation = (Reservation) attrs.maReservation
		
		out << "<ul>"
		out << "<li>"
		
		if(maReservation == null || maReservation.livresReserves == null) {
			out << "<a href='http://localhost:8080/BiblioJ/reservation/showCurrentReservation'>Mon Panier <br/> Total : <i>vide</i></a>"
		} else {
			out << "<a href='http://localhost:8080/BiblioJ/reservation/showCurrentReservation'>Mon Panier</a>"
			out << "<ul>"
		for(livre in maReservation.livresReserves) {
			out << "<li>"
			out << livre
			out << "</li>"
		}
			out << "<br/> Total : <i>" + maReservation.livresReserves.size() + " produits</>"
			out << "</ul>"
		}
		
			out << "</li>"
			out << "</ul>"
		
		}
	
}
