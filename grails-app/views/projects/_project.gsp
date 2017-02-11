<div class="post-entry project-entry clearfix">
    <h1>${project?.name }</h1>
    <g:if test="${project?.image}">
        <div class="pull-left">
        <g:if test="${project?.linkURL && project?.linkText && project?.linkTitle}">
            <a href="${project?.linkURL}" title="${project?.linkTitle}" target="_blank"><ggs:img image="${project?.image}" title="${project?.description}" alt="${project.name}"/></a>
        </g:if>
        <g:else>
            <ggs:img image="${project?.image}" title="${project?.description}" alt="${project.name}"/>
        </g:else>
        </div>
    </g:if>
    <div class="inhalt">
        ${project?.description.replaceAll('\n','<br/>') }
        <g:if test="${project?.linkURL && project?.linkText && project?.linkTitle}">
            <br/><br/>
            <a href="${project?.linkURL}" title="${project?.linkTitle}" target="_blank">${project?.linkText}</a>
        </g:if>
    </div>
</div>