
<%@ page import="musee.Musee" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'musee.label', default: 'Musee')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-musee" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-musee" class="content scaffold-list" role="main">
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
						<br/>
						<label for="extraitRue">
							Nom rue musee contient:
						</label>
						<g:textField name="extraitRue"/>
						<br/>
						<label for="codePostal">
							Code Postal:
						</label>
						<g:select name="codePostal" from="${["31000", "31500"]}"/>
						<br/>
						<label> </label><g:actionSubmit action="doSearchMusee" value="Rechercher"/>
					</div>
				</fieldset>

				<fieldset class="form">
					<div class="fieldcontain">
						<table>
							<tr>
								<td>Mes mus&eacute;es pr&eacute;fer&eacute;s:</td>
							</tr>
							<g:each in="${museePrefereInstanceList}" status="i" var="museePrefereInstance">
								<tr>
									<td>${fieldValue(bean: museePrefereInstance, field: "nom")}</td>
								</tr>
							</g:each>
						</table>
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

						<g:sortableColumn property="ajoutFavori" title="Ajouter &agrave; mes mus&eacute;es favoris"/>
					
					</tr>
				</thead>
				<tbody>
				<g:form><g:each in="${museeInstanceList}" status="i" var="museeInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">

						<td><g:link action="show" id="${museeInstance.id}">${fieldValue(bean: museeInstance, field: "nom")}</g:link></td>

						<td>${fieldValue(bean: museeInstance, field: "telephone")}</td>

						<td>${fieldValue(bean: museeInstance, field: "adresse")}</td>

						<td>${fieldValue(bean: museeInstance, field: "accesMetro")}</td>

						<td>${fieldValue(bean: museeInstance, field: "accesBus")}</td>

						<td>${fieldValue(bean: museeInstance, field: "horairesOuverture")}</td>

						<td>${fieldValue(bean: museeInstance, field: "gestionnaire")}</td>
						
						<td>
							<g:actionSubmit action="ajouterMuseePrefere$i"  value="Ajouter"
											disabled="${museePrefereInstanceList.contains(museeInstance)}"/>
						</td>
					
					</tr>
				</g:each></g:form>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${museeInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
