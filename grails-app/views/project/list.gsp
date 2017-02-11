
<%@ page import="ch.grailsgroup.Project" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'project.label', default: 'Project')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-project" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-project" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="name" title="${message(code: 'project.name.label', default: 'Name')}" />
					
						<g:sortableColumn property="alias" title="${message(code: 'project.alias.label', default: 'Alias')}" />
					
						<g:sortableColumn property="description" title="${message(code: 'project.description.label', default: 'Description')}" />
					
						<th><g:message code="project.image.label" default="Image" /></th>
					
						<g:sortableColumn property="ordering" title="${message(code: 'project.ordering.label', default: 'Ordering')}" />
					
						<g:sortableColumn property="linkURL" title="${message(code: 'project.linkURL.label', default: 'Link URL')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${projectInstanceList}" status="i" var="projectInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="edit" id="${projectInstance.id}">${fieldValue(bean: projectInstance, field: "name")}</g:link></td>
					
						<td>${fieldValue(bean: projectInstance, field: "alias")}</td>
					
						<td>${fieldValue(bean: projectInstance, field: "description")}</td>
					
						<td>${fieldValue(bean: projectInstance, field: "image")}</td>
					
						<td>${fieldValue(bean: projectInstance, field: "ordering")}</td>
					
						<td>${fieldValue(bean: projectInstance, field: "linkURL")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${projectInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
