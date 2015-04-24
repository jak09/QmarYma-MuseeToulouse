
<%@ page import="musee.RechercheMusee" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'rechercheMusee.label', default: 'RechercheMusee')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-rechercheMusee" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-rechercheMusee" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list rechercheMusee">
			
				<g:if test="${rechercheMuseeInstance?.codePostal}">
				<li class="fieldcontain">
					<span id="codePostal-label" class="property-label"><g:message code="rechercheMusee.codePostal.label" default="Code Postal" /></span>
					
						<span class="property-value" aria-labelledby="codePostal-label"><g:fieldValue bean="${rechercheMuseeInstance}" field="codePostal"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${rechercheMuseeInstance?.extraitNom}">
				<li class="fieldcontain">
					<span id="extraitNom-label" class="property-label"><g:message code="rechercheMusee.extraitNom.label" default="Extrait Nom" /></span>
					
						<span class="property-value" aria-labelledby="extraitNom-label"><g:fieldValue bean="${rechercheMuseeInstance}" field="extraitNom"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${rechercheMuseeInstance?.extraitRue}">
				<li class="fieldcontain">
					<span id="extraitRue-label" class="property-label"><g:message code="rechercheMusee.extraitRue.label" default="Extrait Rue" /></span>
					
						<span class="property-value" aria-labelledby="extraitRue-label"><g:fieldValue bean="${rechercheMuseeInstance}" field="extraitRue"/></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form url="[resource:rechercheMuseeInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit" action="edit" resource="${rechercheMuseeInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
