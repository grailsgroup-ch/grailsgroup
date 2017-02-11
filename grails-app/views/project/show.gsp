
<%@ page import="ch.grailsgroup.Project" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'project.label', default: 'Project')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-project" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-project" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list project">
			
				<g:if test="${projectInstance?.name}">
				<li class="fieldcontain">
					<span id="name-label" class="property-label"><g:message code="project.name.label" default="Name" /></span>
					
						<span class="property-value" aria-labelledby="name-label"><g:fieldValue bean="${projectInstance}" field="name"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${projectInstance?.alias}">
				<li class="fieldcontain">
					<span id="alias-label" class="property-label"><g:message code="project.alias.label" default="Alias" /></span>
					
						<span class="property-value" aria-labelledby="alias-label"><g:fieldValue bean="${projectInstance}" field="alias"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${projectInstance?.description}">
				<li class="fieldcontain">
					<span id="description-label" class="property-label"><g:message code="project.description.label" default="Description" /></span>
					
						<span class="property-value" aria-labelledby="description-label"><g:fieldValue bean="${projectInstance}" field="description"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${projectInstance?.image}">
				<li class="fieldcontain">
					<span id="image-label" class="property-label"><g:message code="project.image.label" default="Image" /></span>
					
						<span class="property-value" aria-labelledby="image-label"><g:link controller="image" action="show" id="${projectInstance?.image?.id}">${projectInstance?.image?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${projectInstance?.ordering}">
				<li class="fieldcontain">
					<span id="ordering-label" class="property-label"><g:message code="project.ordering.label" default="Ordering" /></span>
					
						<span class="property-value" aria-labelledby="ordering-label"><g:fieldValue bean="${projectInstance}" field="ordering"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${projectInstance?.linkURL}">
				<li class="fieldcontain">
					<span id="linkURL-label" class="property-label"><g:message code="project.linkURL.label" default="Link URL" /></span>
					
						<span class="property-value" aria-labelledby="linkURL-label"><g:fieldValue bean="${projectInstance}" field="linkURL"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${projectInstance?.linkText}">
				<li class="fieldcontain">
					<span id="linkText-label" class="property-label"><g:message code="project.linkText.label" default="Link Text" /></span>
					
						<span class="property-value" aria-labelledby="linkText-label"><g:fieldValue bean="${projectInstance}" field="linkText"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${projectInstance?.linkTitle}">
				<li class="fieldcontain">
					<span id="linkTitle-label" class="property-label"><g:message code="project.linkTitle.label" default="Link Title" /></span>
					
						<span class="property-value" aria-labelledby="linkTitle-label"><g:fieldValue bean="${projectInstance}" field="linkTitle"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${projectInstance?.dateCreated}">
				<li class="fieldcontain">
					<span id="dateCreated-label" class="property-label"><g:message code="project.dateCreated.label" default="Date Created" /></span>
					
						<span class="property-value" aria-labelledby="dateCreated-label"><g:formatDate date="${projectInstance?.dateCreated}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${projectInstance?.lastUpdated}">
				<li class="fieldcontain">
					<span id="lastUpdated-label" class="property-label"><g:message code="project.lastUpdated.label" default="Last Updated" /></span>
					
						<span class="property-value" aria-labelledby="lastUpdated-label"><g:formatDate date="${projectInstance?.lastUpdated}" /></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${projectInstance?.id}" />
					<g:link class="edit" action="edit" id="${projectInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
