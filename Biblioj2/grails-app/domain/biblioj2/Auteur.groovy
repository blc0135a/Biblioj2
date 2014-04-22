package biblioj2

class Auteur {

	String nom
	String prenom

	static hasMany = [livres : Livre]

    static constraints = {
		nom (blank : false)
		prenom (nullable : true, blank : false)
	}
	
	String toString() {
		"${prenom} ${nom}";
	}	
}
