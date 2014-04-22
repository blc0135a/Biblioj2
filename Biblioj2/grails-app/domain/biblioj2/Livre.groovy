package biblioj2

class Livre {
	String titre
	int nombreExemplaires
	int nombreExemplairesDisponibles
	TypeDocument type
	static hasMany = [auteurs: Auteur, 
					reservations : LivreReserve]
	
	static belongsTo = Auteur
	
	static constraints = {
		titre(blank:false)
		nombreExemplaires(min : 0)
		nombreExemplairesDisponibles(min : 0)
		type(nullable:true)

	}
	
	String toString(){
		"${titre}";
	}
	
	static mapping = {
		auteurs fetch : 'join'
	}
}
