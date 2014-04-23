package biblioj2

class Reservation {
	String code
	Date dateReservation
	
	static hasMany = [livresReserves : Livre]
	
	static constraints = {
		code(blank:false, unique:true)
		dateReservation(blank:false)
	}
	
	String toString(){
		"${code}";
	}
	
	static mapping = {
		livresReserves fetch : 'join'
	}
	
	boolean ajouterExemplaireLivre(Long id) {
		//Si le livre n'existe pas dans la base de données -> STOP
		if(Livre.findById(id) == null) {
			return false
		}
		
		if(this.livresReserves == null) { //Si le "panier" est vide -> le créer et ajouter un exemplaire du livre
			this.livresReserves = new HashSet();
			Livre livreAjoute = Livre.findById(id);
			this.livresReserves.add(livreAjoute)
		} else {
			boolean livreExistant = false
			for(livre in livresReserves) {
				// Si le livre est déjà dans le panier
				if(livre.id == id && !livreExistant) {
					return false
				}
			}
			if(!livreExistant) {
				Livre livreAjoute = Livre.findById(id);
				this.livresReserves.add(livreAjoute)
			}
		}
			return true
		}
}
