package biblioj2

class TypeDocument {
	String intitule

    static constraints = {
		intitule (blank : false)
	}

	String toString() {
		"${intitule}";
	}
}
