
<%@ page import="biblioj2.LivreReserve" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'livreReserve.label', default: 'LivreReserve')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-livreReserve" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-livreReserve" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list livreReserve">
			
				<g:if test="${livreReserveInstance?.quantite}">
				<li class="fieldcontain">
					<span id="quantite-label" class="property-label"><g:message code="livreReserve.quantite.label" default="Quantite" /></span>
					
						<span class="property-value" aria-labelledby="quantite-label"><g:fieldValue bean="${livreReserveInstance}" field="quantite"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${livreReserveInstance?.livre}">
				<li class="fieldcontain">
					<span id="livre-label" class="property-label"><g:message code="livreReserve.livre.label" default="Livre" /></span>
					
						<span class="property-value" aria-labelledby="livre-label"><g:link controller="livre" action="show" id="${livreReserveInstance?.livre?.id}">${livreReserveInstance?.livre?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${livreReserveInstance?.reservation}">
				<li class="fieldcontain">
					<span id="reservation-label" class="property-label"><g:message code="livreReserve.reservation.label" default="Reservation" /></span>
					
						<span class="property-value" aria-labelledby="reservation-label"><g:link controller="reservation" action="show" id="${livreReserveInstance?.reservation?.id}">${livreReserveInstance?.reservation?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${livreReserveInstance?.id}" />
					<g:link class="edit" action="edit" id="${livreReserveInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
