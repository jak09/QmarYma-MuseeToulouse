
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
                    </div>
                    <div>
                        <g:actionSubmit action="doSearchMusee" value="Rechercher"/>
                    </div>
                </fieldset>
            </g:form>





			<table>
			<thead>
					<tr>
					
						<g:sortableColumn property="codePostal" title="${message(code: 'rechercheMusee.codePostal.label', default: 'Code Postal')}" />
					
						<g:sortableColumn property="extraitNom" title="${message(code: 'rechercheMusee.extraitNom.label', default: 'Nom')}" />
					
						<g:sortableColumn property="extraitRue" title="${message(code: 'rechercheMusee.extraitRue.label', default: 'Rue')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${rechercheMuseeInstanceList}" status="i" var="rechercheMuseeInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">

						<td><g:link action="show" id="${rechercheMuseeInstance.id}">${fieldValue(bean: rechercheMuseeInstance, field: "adresse.codePostal")}</g:link></td>

						<td>${fieldValue(bean: rechercheMuseeInstance, field: "nom")}</td>
					
						<td>${fieldValue(bean: rechercheMuseeInstance, field: "adresse.rue")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${rechercheMuseeInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
