package biblioj2

class LivreReserve {
	
	Livre livre
	Reservation reservation
	int quantite
	
	static constraints = {
		quantite(min: 1)
	}
	
	String toString() {
		"${livre} : ${quantite}"
	}

}
