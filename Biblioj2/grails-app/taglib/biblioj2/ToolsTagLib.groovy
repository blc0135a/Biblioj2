package biblioj2

class ToolsTagLib {

	def panier = { attrs, body ->
		
		Reservation maReservation = (Reservation) attrs.maReservation
		
		out << "<ul>"
		out << "<li>"
		
		if(maReservation == null || maReservation.livresReserves == null) {
			out << "Mon Panier <br/> Total : <i>vide</i>"
		} else {
			out << "Mon Panier <ul>"
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
