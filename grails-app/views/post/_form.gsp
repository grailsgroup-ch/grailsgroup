<%@ page import="ch.grailsgroup.Post" %>



<div class="fieldcontain ${hasErrors(bean: postInstance, field: 'title', 'error')} ">
	<label for="title">
		<g:message code="post.title.label" default="Title" />
		
	</label>
	<g:textField name="title" maxlength="250" value="${postInstance?.title}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: postInstance, field: 'user', 'error')} required">
	<label for="user">
		<g:message code="post.user.label" default="User" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="user" name="user.id" from="${ch.grailsgroup.User.list()}" optionKey="id" required="" value="${postInstance?.user?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: postInstance, field: 'content', 'error')} ">
	<label for="content">
		<g:message code="post.content.label" default="Content" />
		
	</label>
	<ckeditor:editor name="content" height="400px" width="80%" toolbar="Basic"> ${postInstance?.content}</ckeditor:editor>
</div>

<div class="fieldcontain ${hasErrors(bean: postInstance, field: 'alias', 'error')} ">
	<label for="alias">
		<g:message code="post.alias.label" default="Alias" />
		
	</label>
	<g:textField name="alias" maxlength="250" value="${postInstance?.alias}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: postInstance, field: 'active', 'error')} ">
	<label for="active">
		<g:message code="post.active.label" default="Active" />
		
	</label>
	<g:checkBox name="active" value="${postInstance?.active}" />
</div>

<div class="fieldcontain ${hasErrors(bean: postInstance, field: 'comments', 'error')} ">
	<label for="comments">
		<g:message code="post.comments.label" default="Comments" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${postInstance?.comments?}" var="c">
    <li><g:link controller="comment" action="show" id="${c.id}">${c?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="comment" action="create" params="['post.id': postInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'comment.label', default: 'Comment')])}</g:link>
</li>
</ul>

</div>

<div class="fieldcontain ${hasErrors(bean: postInstance, field: 'images', 'error')} ">
	<label for="images">
		<g:message code="post.images.label" default="Images" />
		
	</label>
	<g:link controller="imageManagement" action="create" params="['post.id': postInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'image.label', default: 'Image')])}</g:link>
	<g:select name="images" from="${ch.grailsgroup.Image.list()}" multiple="multiple" optionKey="id" size="5" value="${postInstance?.images*.id}" class="many-to-many"/>
</div>

