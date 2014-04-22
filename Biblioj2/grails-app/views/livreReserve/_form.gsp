<%@ page import="biblioj2.LivreReserve" %>



<div class="fieldcontain ${hasErrors(bean: livreReserveInstance, field: 'quantite', 'error')} required">
	<label for="quantite">
		<g:message code="livreReserve.quantite.label" default="Quantite" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="quantite" type="number" min="1" value="${livreReserveInstance.quantite}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: livreReserveInstance, field: 'livre', 'error')} required">
	<label for="livre">
		<g:message code="livreReserve.livre.label" default="Livre" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="livre" name="livre.id" from="${biblioj2.Livre.list()}" optionKey="id" required="" value="${livreReserveInstance?.livre?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: livreReserveInstance, field: 'reservation', 'error')} required">
	<label for="reservation">
		<g:message code="livreReserve.reservation.label" default="Reservation" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="reservation" name="reservation.id" from="${biblioj2.Reservation.list()}" optionKey="id" required="" value="${livreReserveInstance?.reservation?.id}" class="many-to-one"/>
</div>

