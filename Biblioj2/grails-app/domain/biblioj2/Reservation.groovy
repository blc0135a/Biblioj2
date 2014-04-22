package biblioj2

class Reservation {
	String code
	Date dateReservation
	
	static hasMany = [livresReserves : LivreReserve]
	
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
			this.livresReserves.add(new LivreReserve(livre : Livre.findById(id), reservation : this, quantite : 1))
		} else {
			boolean livreExistant = false
			for(livre in livresReserves) {
				if(livre.livre.id == id && !livrexistant) {
					livre.quantite = livre.quantite + 1
					livreExistant = true
					break
				}
			}
			if(!livreExistant) {
				this.livresReserves.add(new LivreReserve(livre : Livre.findById(id), reservation : this, quantite : 1))
			}
		}
			return true
		}
}
