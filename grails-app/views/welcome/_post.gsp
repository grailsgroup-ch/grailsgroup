<div class="post-entry">
	<div class="small"><g:formatDate format="dd.MM.yyyy" date="${post.lastUpdated }"/></div>
	<h2>${post.title }</h2>
	<div class="small">von ${post.user?.username }</div>
	<div class="inhalt">${post.content }</div>
	<g:if test="${post.images}">
		<div class="pikachoose">
			<ul class="${post.images.size()>1?'bildGallery':''} jcarousel-skin-pika">
				<g:each in="${post.images}" var="image">
					<li><ggs:img image="${image}" title="${image.alias}" alt="${image.alias}"/></li>
				</g:each>
			</ul>
		</div>
	</g:if>
</div>