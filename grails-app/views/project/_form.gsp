<%@ page import="ch.grailsgroup.Project" %>



<div class="fieldcontain ${hasErrors(bean: projectInstance, field: 'name', 'error')} ">
	<label for="name">
		<g:message code="project.name.label" default="Name" />
		
	</label>
	<g:textField name="name" value="${projectInstance?.name}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: projectInstance, field: 'alias', 'error')} required">
	<label for="alias">
		<g:message code="project.alias.label" default="Alias" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="alias" required="" value="${projectInstance?.alias}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: projectInstance, field: 'description', 'error')} ">
	<label for="description">
		<g:message code="project.description.label" default="Description" />
		
	</label>
	<g:textArea name="description" value="${projectInstance?.description}" rows="5" cols="40" />
</div>

<div class="fieldcontain ${hasErrors(bean: projectInstance, field: 'image', 'error')} ">
	<label for="image">
		<g:message code="project.image.label" default="Image" />
		
	</label>
	<g:select id="image" name="image.id" from="${ch.grailsgroup.Image.list()}" optionKey="id" value="${projectInstance?.image?.id}" class="many-to-one" noSelection="['null': '']"/>
</div>

<div class="fieldcontain ${hasErrors(bean: projectInstance, field: 'ordering', 'error')} ">
	<label for="ordering">
		<g:message code="project.ordering.label" default="Ordering" />
		
	</label>
	<g:field type="number" name="ordering" value="${fieldValue(bean: projectInstance, field: 'ordering')}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: projectInstance, field: 'linkURL', 'error')} ">
	<label for="linkURL">
		<g:message code="project.linkURL.label" default="Link URL" />
		
	</label>
	<g:textField name="linkURL" value="${projectInstance?.linkURL}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: projectInstance, field: 'linkText', 'error')} ">
	<label for="linkText">
		<g:message code="project.linkText.label" default="Link Text" />
		
	</label>
	<g:textField name="linkText" value="${projectInstance?.linkText}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: projectInstance, field: 'linkTitle', 'error')} ">
	<label for="linkTitle">
		<g:message code="project.linkTitle.label" default="Link Title" />
		
	</label>
	<g:textField name="linkTitle" value="${projectInstance?.linkTitle}"/>
</div>

