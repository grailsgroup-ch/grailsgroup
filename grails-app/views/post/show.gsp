
<%@ page import="ch.grailsgroup.Post" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'post.label', default: 'Post')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-post" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-post" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list post">
			
				<g:if test="${postInstance?.title}">
				<li class="fieldcontain">
					<span id="title-label" class="property-label"><g:message code="post.title.label" default="Title" /></span>
					
						
							<span class="property-value" aria-labelledby="title-label"><g:fieldValue bean="${postInstance}" field="title"/></span>
						
				</li>
				</g:if>
			
				<g:if test="${postInstance?.user}">
				<li class="fieldcontain">
					<span id="user-label" class="property-label"><g:message code="post.user.label" default="User" /></span>
					
						
							<span class="property-value" aria-labelledby="user-label"><g:link controller="user" action="show" id="${postInstance?.user?.id}">${postInstance?.user?.encodeAsHTML()}</g:link></span>
						
				</li>
				</g:if>
			
				<g:if test="${postInstance?.content}">
				<li class="fieldcontain">
					<span id="content-label" class="property-label"><g:message code="post.content.label" default="Content" /></span>
					
						<span class="property-value" aria-labelledby="content-label">${postInstance.content.decodeHTML()}</span>
					
				</li>
				</g:if>
			
				<g:if test="${postInstance?.alias}">
				<li class="fieldcontain">
					<span id="alias-label" class="property-label"><g:message code="post.alias.label" default="Alias" /></span>
					
						
							<span class="property-value" aria-labelledby="alias-label"><g:fieldValue bean="${postInstance}" field="alias"/></span>
						
				</li>
				</g:if>
			
				<g:if test="${postInstance?.active}">
				<li class="fieldcontain">
					<span id="active-label" class="property-label"><g:message code="post.active.label" default="Active" /></span>
					
						
							<span class="property-value" aria-labelledby="active-label"><g:formatBoolean boolean="${postInstance?.active}" /></span>
						
				</li>
				</g:if>
			
				<g:if test="${postInstance?.comments}">
				<li class="fieldcontain">
					<span id="comments-label" class="property-label"><g:message code="post.comments.label" default="Comments" /></span>
					
						
							<g:each in="${postInstance.comments}" var="c">
							<span class="property-value" aria-labelledby="comments-label"><g:link controller="comment" action="show" id="${c.id}">${c?.encodeAsHTML()}</g:link></span>
							</g:each>
						
				</li>
				</g:if>
			
				<g:if test="${postInstance?.dateCreated}">
				<li class="fieldcontain">
					<span id="dateCreated-label" class="property-label"><g:message code="post.dateCreated.label" default="Date Created" /></span>
					
						
							<span class="property-value" aria-labelledby="dateCreated-label"><g:formatDate date="${postInstance?.dateCreated}" /></span>
						
				</li>
				</g:if>
			
				<g:if test="${postInstance?.images}">
				<li class="fieldcontain">
					<span id="images-label" class="property-label"><g:message code="post.images.label" default="Images" /></span>
					
						
							<g:each in="${postInstance.images}" var="i">
								<span class="property-value" aria-labelledby="images-label">
								<ggs:img image="${i}" alt="hug was here?"/>
							</g:each>
						
				</li>
				</g:if>
			
				<g:if test="${postInstance?.lastUpdated}">
				<li class="fieldcontain">
					<span id="lastUpdated-label" class="property-label"><g:message code="post.lastUpdated.label" default="Last Updated" /></span>
					
						
							<span class="property-value" aria-labelledby="lastUpdated-label"><g:formatDate date="${postInstance?.lastUpdated}" /></span>
						
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${postInstance?.id}" />
					<g:link class="edit" action="edit" id="${postInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
