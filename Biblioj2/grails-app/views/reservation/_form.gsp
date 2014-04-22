<%@ page import="biblioj2.Reservation" %>



<div class="fieldcontain ${hasErrors(bean: reservationInstance, field: 'code', 'error')} required">
	<label for="code">
		<g:message code="reservation.code.label" default="Code" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="code" required="" value="${reservationInstance?.code}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: reservationInstance, field: 'dateReservation', 'error')} required">
	<label for="dateReservation">
		<g:message code="reservation.dateReservation.label" default="Date Reservation" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="dateReservation" precision="day"  value="${reservationInstance?.dateReservation}"  />
</div>

<div class="fieldcontain ${hasErrors(bean: reservationInstance, field: 'livresReserves', 'error')} ">
	<label for="livresReserves">
		<g:message code="reservation.livresReserves.label" default="Livres Reserves" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${reservationInstance?.livresReserves?}" var="l">
    <li><g:link controller="livreReserve" action="show" id="${l.id}">${l?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="livreReserve" action="create" params="['reservation.id': reservationInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'livreReserve.label', default: 'LivreReserve')])}</g:link>
</li>
</ul>

</div>

