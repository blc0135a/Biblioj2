<%@ page import="biblioj2.Auteur" %>



<div class="fieldcontain ${hasErrors(bean: auteurInstance, field: 'nom', 'error')} required">
	<label for="nom">
		<g:message code="auteur.nom.label" default="Nom" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="nom" required="" value="${auteurInstance?.nom}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: auteurInstance, field: 'prenom', 'error')} ">
	<label for="prenom">
		<g:message code="auteur.prenom.label" default="Prenom" />
		
	</label>
	<g:textField name="prenom" value="${auteurInstance?.prenom}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: auteurInstance, field: 'livres', 'error')} ">
	<label for="livres">
		<g:message code="auteur.livres.label" default="Livres" />
		
	</label>
	<g:select name="livres" from="${biblioj2.Livre.list()}" multiple="multiple" optionKey="id" size="5" value="${auteurInstance?.livres*.id}" class="many-to-many"/>
</div>

