import biblioj2.Auteur
import biblioj2.Livre
import biblioj2.TypeDocument

class BootStrap {

    def init = { servletContext ->
		if (!Livre.count()){
			def nouveaute = new TypeDocument(intitule:"Nouveauté").save(failOnError: true)
			def ado = new TypeDocument(intitule:"Livre ado").save(failOnError: true)
			def adulte = new TypeDocument(intitule:"Livre adulte").save(failOnError: true)
			
			def vigan = new Auteur(nom:"Vigan", prenom:"Delphine de").save(failOnError: true)
			def collins = new Auteur(nom: "Collins", prenom:"Suzanne").save(failOnError: true)
			def stockett = new Auteur(nom:"Stockett", prenom:"Kathryn").save(failOnError: true)
			def carrere = new Auteur(nom:"Carrère", prenom:"Emmanuel").save(failOnError: true)
			def murakami = new Auteur(nom:"Murakami", prenom:"Haruki").save(failOnError: true)
			def delacourt = new Auteur(nom:"Delacourt", prenom:"Grégoire").save(failOnError: true)
			def larsson = new Auteur(nom:"Larsson", prenom:"Stieg").save(failOnError: true)
			def ferrari = new Auteur(nom:"Ferrari", prenom:"Jérôme").save(failOnError: true)
			def pennac = new Auteur(nom:"Pennac", prenom:"Daniel").save(failOnError: true)
			def dicker = new Auteur(nom:"Dicker", prenom:"Jo�l").save(failOnError: true)
			def jonasson = new Auteur(nom:"Jonasson", prenom:"Jonas").save(failOnError: true)
			
			new Livre(titre:"Rien ne s'oppose à la nuit : roman", auteurs:vigan, type:nouveaute, nombreExemplairesDisponibles: 5, nombreExemplaires:5).save(failOnError: true)
			new Livre(titre:"Hunger games [Texte imprimé]", auteurs:collins, type:ado, nombreExemplairesDisponibles: 5, nombreExemplaires:5).save(failOnError: true)
			new Livre(titre:"La couleur des sentiments", auteurs:stockett, type:nouveaute, nombreExemplairesDisponibles: 5, nombreExemplaires:5).save(failOnError: true)
			new Livre(titre:"L'embrasement", auteurs:collins, type:ado, nombreExemplairesDisponibles: 5, nombreExemplaires:5).save(failOnError: true)
			new Livre(titre:"Limonov", auteurs:carrere, type:nouveaute, nombreExemplairesDisponibles: 5, nombreExemplaires:5).save(failOnError: true)
			new Livre(titre:"1Q84. 1. Avril-juin", auteurs:murakami, type:nouveaute, nombreExemplairesDisponibles: 5, nombreExemplaires:5).save(failOnError: true)
			new Livre(titre:"1Q84. 3. Octobre-décembre", auteurs:murakami, type:nouveaute, nombreExemplairesDisponibles: 5, nombreExemplaires:5).save(failOnError: true)
			new Livre(titre:"La révolte", auteurs:collins, type:ado, nombreExemplairesDisponibles: 5, nombreExemplaires:5).save(failOnError: true)
			new Livre(titre:"La liste de mes envies", auteurs:delacourt, type:adulte, nombreExemplairesDisponibles: 5, nombreExemplaires:5).save(failOnError: true)
			new Livre(titre:"1Q84. 2. Juillet-septembre", auteurs:murakami, type:nouveaute, nombreExemplairesDisponibles: 5, nombreExemplaires:5).save(failOnError: true)
			new Livre(titre:"La reine dans le palais des courants d'air [Texte imprimé]", auteurs:larsson, type:adulte, nombreExemplairesDisponibles: 5, nombreExemplaires:5).save(failOnError: true)
			new Livre(titre:"Le sermon sur la chute de Rome", auteurs:ferrari, nombreExemplairesDisponibles: 5, nombreExemplaires:5).save(failOnError: true)
			new Livre(titre:"Journal d'un corps", auteurs:pennac, nombreExemplairesDisponibles: 5, nombreExemplaires:5).save(failOnError: true)
			new Livre(titre:"La vérité sur l'affaire Harry Quebert : roman", auteurs:dicker, type:adulte, nombreExemplairesDisponibles: 5, nombreExemplaires:5).save(failOnError: true)
			new Livre(titre:"Le vieux qui ne voulait pas fêter son anniversaire : roman", auteurs:jonasson, type:nouveaute, nombreExemplairesDisponibles: 5, nombreExemplaires:5).save(failOnError: true)
			
		}
    }
    def destroy = {
    }
}
