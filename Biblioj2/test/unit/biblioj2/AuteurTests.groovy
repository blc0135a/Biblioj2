package biblioj2



import grails.test.mixin.*
import org.junit.*

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Auteur)
class AuteurTests {

    void testConstraints() {
        Auteur auteur = new Auteur(nom:"Tata", prenom:"Toto")
        assertTrue auteur.validate()
        
        Auteur auteur2 = new Auteur(nom:"", prenom:"Toto")
        assertFalse auteur2.validate()
        
        Auteur auteur3 = new Auteur(nom:"Tata", prenom:"")
        assertFalse auteur3.validate()
		
		Auteur auteur4 = new Auteur(nom:"Tata")
		assertFalse auteur4.validate()
		
		Auteur auteur5 = new Auteur()
		assertFalse auteur5.validate()
		
    }
    
    void testToString() {
        Auteur auteur = new Auteur(nom:"Tata", prenom:"Toto")
        assertEquals("Toto Tata", auteur.toString())
    }
}
