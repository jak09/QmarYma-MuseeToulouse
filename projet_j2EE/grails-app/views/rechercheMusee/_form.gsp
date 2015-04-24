<%@ page import="musee.RechercheMusee" %>



<div class="fieldcontain ${hasErrors(bean: rechercheMuseeInstance, field: 'codePostal', 'error')} required">
	<label for="codePostal">
		<g:message code="rechercheMusee.codePostal.label" default="Code Postal" />
		<span class="required-indicator">*</span>
	</label>
	<g:select name="codePostal" from="${rechercheMuseeInstance.constraints.codePostal.inList}" required="" value="${fieldValue(bean: rechercheMuseeInstance, field: 'codePostal')}" valueMessagePrefix="rechercheMusee.codePostal"/>

</div>

<div class="fieldcontain ${hasErrors(bean: rechercheMuseeInstance, field: 'extraitNom', 'error')} required">
	<label for="extraitNom">
		<g:message code="rechercheMusee.extraitNom.label" default="Extrait Nom" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="extraitNom" required="" value="${rechercheMuseeInstance?.extraitNom}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: rechercheMuseeInstance, field: 'extraitRue', 'error')} required">
	<label for="extraitRue">
		<g:message code="rechercheMusee.extraitRue.label" default="Extrait Rue" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="extraitRue" required="" value="${rechercheMuseeInstance?.extraitRue}"/>

</div>

