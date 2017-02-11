
<%@ page import="ch.grailsgroup.Post" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'post.label', default: 'Post')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-post" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-post" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="title" title="${message(code: 'post.title.label', default: 'Title')}" />
					
						<th><g:message code="post.user.label" default="User" /></th>
					
						<g:sortableColumn property="content" title="${message(code: 'post.content.label', default: 'Content')}" />
					
						<g:sortableColumn property="alias" title="${message(code: 'post.alias.label', default: 'Alias')}" />
					
						<g:sortableColumn property="active" title="${message(code: 'post.active.label', default: 'Active')}" />
					
						<g:sortableColumn property="dateCreated" title="${message(code: 'post.dateCreated.label', default: 'Date Created')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${postInstanceList}" status="i" var="postInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${postInstance.id}">${fieldValue(bean: postInstance, field: "title")}</g:link></td>
					
						<td>${fieldValue(bean: postInstance, field: "user")}</td>
					
						<td>${fieldValue(bean: postInstance, field: "content")}</td>
					
						<td>${fieldValue(bean: postInstance, field: "alias")}</td>
					
						<td><g:formatBoolean boolean="${postInstance.active}" /></td>
					
						<td><g:formatDate date="${postInstance.dateCreated}" /></td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${postInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
