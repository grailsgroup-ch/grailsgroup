<%@page import="ch.grailsgroup.Anmeldungen" %>

<div class="post-entry">
	<div class="small"><g:formatDate format="dd.MM.yyyy" date="${post.lastUpdated }"/></div>
	<h2>${post.toString() }</h2>
	<div class="inhalt clearfix">
	   <g:message code="groupsession.next" args="[post.groupsessionDate.format('dd.MM.yyyy'), post.groupsessionDate.format('HH:mm'), post.location]" />
	   <g:if test="${post.locationGoogleUrl }">
	       <div class="map-container">
    	       ${post.locationGoogleUrl }
	       </div>
	   </g:if>
		<br/><br/>
		${post.remark}
		<g:if test="${post.getLectures().size()  > 0}">
			<br/>
			<g:message code="groupsession.lectures" />
			<ul class="list-group">
				<g:each in="${post.getLectures()}" var="lecture">
						<li class="list-group-item">
						    <strong title="${lecture.summary}" class="list-group-item-heading">${lecture.toString()}</strong>
	                        <p class="list-group-item-text">${lecture.summary}</p>
	                        <g:if test="${lecture.document}">
			                    <g:link controller="image" title="${lecture.summary}" action="${lecture.document.filename}">&gt;&gt;&nbsp;&nbsp;${lecture.topic}</g:link></li>
			                </g:if>
						</li>
				</g:each>
			</ul>
		</g:if>
	</div>
	<sec:ifLoggedIn>
		<g:set value="${Anmeldungen.findByGroupsessionAndUser(post, user)}" var="anmeldung"/>
		<hr/>
		<h2>Ab hier nur für eingeloggte Benutzer sichtbar!</h2>
		<br/>
		<g:if test="${Anmeldungen.findByGroupsession(post)}">
			<b>Angemeldet:</b>
			<br/>
			<ul>
				<g:each in="${post.getAnmeldungen() }" var="user">
					<li>${user.username}</li>
				</g:each>
			</ul>
			<br/>
			<b>Abgemeldet:</b>
			<br/>
			<ul>
				<g:each in="${post.getAnmeldungen(false) }" var="user">
					<li>${user.username}</li>
				</g:each>
			</ul>
		</g:if>
		<g:else>
		  <b>Wir haben noch keine An- und Abmeldungen. Also hopp! <g:link controller="groupsession" action="anmelden"  params="${[postId:post.id, usrId:user.id, anmelden:true]}">Anmelden!</g:link></b>
		</g:else>
		<br/>
		<g:if test="${post.groupsessionDate > new Date() }">
			<g:if test="${anmeldung}">
				<g:if test="${anmeldung.angemeldet}">
					Du bist angemeldet.<br/>
					<g:link controller="groupsession" action="anmelden" params="${[postId:post.id, usrId:user.id, anmelden:false]}">Doch abmelden</g:link>
				</g:if>
				<g:else>
					Du hast Dich abgemeldet.<br/>
					<g:link controller="groupsession" action="anmelden" params="${[postId:post.id, usrId:user.id, anmelden:true]}">Doch anmelden</g:link>
				</g:else>
			</g:if>
			<g:else>
				<g:link controller="groupsession" action="anmelden"  params="${[postId:post.id, usrId:user.id, anmelden:true]}">Ich melde mich an</g:link><br/>
				<g:link controller="groupsession" action="anmelden"  params="${[postId:post.id, usrId:user.id, anmelden:false]}">Ich melde mich ab</g:link><br/>
			</g:else>
		</g:if>
	</sec:ifLoggedIn>
</div>