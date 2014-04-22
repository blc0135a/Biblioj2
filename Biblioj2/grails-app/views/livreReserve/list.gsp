
<%@ page import="biblioj2.LivreReserve" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'livreReserve.label', default: 'LivreReserve')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-livreReserve" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-livreReserve" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="quantite" title="${message(code: 'livreReserve.quantite.label', default: 'Quantite')}" />
					
						<th><g:message code="livreReserve.livre.label" default="Livre" /></th>
					
						<th><g:message code="livreReserve.reservation.label" default="Reservation" /></th>
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${livreReserveInstanceList}" status="i" var="livreReserveInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${livreReserveInstance.id}">${fieldValue(bean: livreReserveInstance, field: "quantite")}</g:link></td>
					
						<td>${fieldValue(bean: livreReserveInstance, field: "livre")}</td>
					
						<td>${fieldValue(bean: livreReserveInstance, field: "reservation")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${livreReserveInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
