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
	
	boolean ajouterLivre(Long id) {
		if(this.livresReserves == null) { //Si le "panier" est vide -> le créer et ajouter un exemplaire du livre
			this.livresReserves = new HashSet();
			Livre livreAjoute = Livre.findById(id);
			this.livresReserves.add(livreAjoute)
		} else {
			for(livre in livresReserves) {
				if(livre.id == id) {
					return false
				}
			}	
		}
		Livre livreAjoute = Livre.findById(id);
		this.livresReserves.add(livreAjoute)
		return true
	}
	
	boolean supprimerLivre(Long id){
		if(this.livresReserves == null) { //Si le "panier" est vide -> STOP
			return false
		} else {
			for(livre in livresReserves) {
				// Si le livre est dans le panier
				if(livre.id == id ) {
					this.livresReserves.remove(livre)
					return true
				}
			}
		}
		return false
	}
}
