
<%@ page import="musee.RechercheMusee" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'rechercheMusee.label', default: 'RechercheMusee')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-rechercheMusee" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-rechercheMusee" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>



            <g:form>
                <fieldset class="form">
                    <div class="fieldcontain">
                        <label for="extraitNom">
                            Nom musee contient:
                        </label>
                        <g:textField name="extraitNom"/>
                        <label for="codePostal">
                            Code Postal:
                        </label>
                        <g:select name="codePostal" from="${["31000", "31500"]}"/>
                        <label for="extraitRue">
                            Nom rue musee contient:
                        </label>
                        <g:textField name="extraitRue"/>
						<g:actionSubmit action="doSearchMusee" value="Rechercher"/>
                    </div>
                </fieldset>
            </g:form>





			<table>
			<thead>
					<tr>

						<g:sortableColumn property="extraitNom" title="Nom" />

						<g:sortableColumn property="telephone" title="Telephone" />
					
						<g:sortableColumn property="adresse" title="Adresse" />

						<g:sortableColumn property="accesMetro" title="Acces Metro"/>

						<g:sortableColumn property="accesBus" title="Acces Bus"/>

						<g:sortableColumn property="horairesOuverture" title="Horaires" />

						<g:sortableColumn property="gestionnaire" title="Gestionnaire"/>
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${rechercheMuseeInstanceList}" status="i" var="rechercheMuseeInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">

						<td><g:link action="show" id="${rechercheMuseeInstance.id}">${fieldValue(bean: rechercheMuseeInstance, field: "nom")}</g:link></td>

						<td>${fieldValue(bean: rechercheMuseeInstance, field: "telephone")}</td>

						<td>${fieldValue(bean: rechercheMuseeInstance, field: "adresse")}</td>

						<td>${fieldValue(bean: rechercheMuseeInstance, field: "accesMetro")}</td>

						<td>${fieldValue(bean: rechercheMuseeInstance, field: "accesBus")}</td>

						<td>${fieldValue(bean: rechercheMuseeInstance, field: "horairesOuverture")}</td>

						<td>${fieldValue(bean: rechercheMuseeInstance, field: "gestionnaire")}</td>

					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate next="Suivant" prev="Precedent" maxsteps="1"
							total="${rechercheMuseeInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
