<%@ page import="biblioj2.Livre" %>



<div class="fieldcontain ${hasErrors(bean: livreInstance, field: 'titre', 'error')} required">
	<label for="titre">
		<g:message code="livre.titre.label" default="Titre" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="titre" required="" value="${livreInstance?.titre}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: livreInstance, field: 'nombreExemplaires', 'error')} required">
	<label for="nombreExemplaires">
		<g:message code="livre.nombreExemplaires.label" default="Nombre Exemplaires" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="nombreExemplaires" type="number" min="0" value="${livreInstance.nombreExemplaires}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: livreInstance, field: 'nombreExemplairesDisponibles', 'error')} required">
	<label for="nombreExemplairesDisponibles">
		<g:message code="livre.nombreExemplairesDisponibles.label" default="Nombre Exemplaires Disponibles" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="nombreExemplairesDisponibles" type="number" min="0" value="${livreInstance.nombreExemplairesDisponibles}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: livreInstance, field: 'type', 'error')} ">
	<label for="type">
		<g:message code="livre.type.label" default="Type" />
		
	</label>
	<g:select id="type" name="type.id" from="${biblioj2.TypeDocument.list()}" optionKey="id" value="${livreInstance?.type?.id}" class="many-to-one" noSelection="['null': '']"/>
</div>

<div class="fieldcontain ${hasErrors(bean: livreInstance, field: 'auteurs', 'error')} ">
	<label for="auteurs">
		<g:message code="livre.auteurs.label" default="Auteurs" />
		
	</label>
	
</div>

<div class="fieldcontain ${hasErrors(bean: livreInstance, field: 'reservations', 'error')} ">
	<label for="reservations">
		<g:message code="livre.reservations.label" default="Reservations" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${livreInstance?.reservations?}" var="r">
    <li><g:link controller="livreReserve" action="show" id="${r.id}">${r?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="livreReserve" action="create" params="['livre.id': livreInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'livreReserve.label', default: 'LivreReserve')])}</g:link>
</li>
</ul>

</div>

