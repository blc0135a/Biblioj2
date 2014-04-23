package biblioj2

class Auteur {

	String nom
	String prenom

	static hasMany = [livres : Livre]
	
	static belongsTo = [Livre]

    static constraints = {
		nom (blank : false)
		prenom (blank : false)
	}
	
	String toString() {
		"${prenom} ${nom}";
	}	
}
