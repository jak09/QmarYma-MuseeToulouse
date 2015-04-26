
<%@ page import="musee.DemandeVisite" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'demandeVisite.label', default: 'DemandeVisite')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-demandeVisite" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-demandeVisite" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>


			<fieldset class="form">
				<div class="encart">
					<table>
						<tr>
							<td>Mes mus&eacute;es pr&eacute;fer&eacute;s:</td>
						</tr>
						<g:each in="${museePrefereInstanceList}" status="i" var="museePrefereInstance">
							<tr>
								<td name="attributSupprimer" value="$i">
									<label>${fieldValue(bean: museePrefereInstance, field: "nom")}</label>
								</td>
							</tr>
						</g:each>
					</table>
				</div>
			</fieldset>



			<g:form>
				<fieldset class="form">
					<div class="fieldcontain">
						<table>
							<tr>
								<td><label>Date de d&eacute;but:</label></td>
								<td><g:select name="dateDebutDay" from="${1..31}"/></td>
								<td><g:select name="dateDebutMois" from="${1..12}"/></td>
								<td><g:select name="dateDebutAnnee" from="${2015..2055}"/></td>
							</tr>
							<tr>
								<td><label>Date de fin:</label></td>
								<td><g:select name="dateFinDay" from="${1..31}"/></td>
								<td><g:select name="dateFinMois" from="${1..12}"/></td>
								<td><g:select name="dateFinAnnee" from="${2015..2055}"/></td>
							</tr>
							<tr>
								<td><label for="nombrePersonnes">Nombre de personnes pr&eacute;sentes: (max: 6)</label></td>
								<td><g:select name="nombrePersonnes" from="${1..6}"/></td>
							</tr>
							<tr>
								<td><label></label></td>
								<td><g:actionSubmit class="MuseeController" action="doDemandeVisite" value="Valider"/></td>
							</tr>
						</table>
						<label style="width: 100%; text-align: left">${messageErreur}</label>
					</div>
				</fieldset>
			</g:form>



			<div class="pagination">
				<g:paginate total="${demandeVisiteInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
