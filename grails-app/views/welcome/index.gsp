<!doctype html>
<html>
	<head>
		<meta name="layout" content="main"/>
		<title>grailsgroup Switzerland: Welcome</title>
		<script language="javascript">
			$(document).ready(
				function (){
					$(".bildGallery").PikaChoose({carousel:true,carouselOptions:{wrap:'circular'}});
				});
		</script>
	</head>
	<body>
	        <div class="hero-unit">
		        <div id="grailsLogo" role="banner">
		            <g:link controller="welcome">
		                <img src="${resource(dir: 'images', file: 'logo.png')}" alt="Grails Group Switzerland"/>
		            </g:link>
		        </div>
		        
	        </div>
			
			<div id="posts">
				<g:each in="${posts}" var="post">
				    <div class="row-fluid">
						<g:if test="${post instanceof ch.grailsgroup.Post}">
							<g:render template="post" model="${[post:post]}" />
						</g:if>
						<g:if test="${post instanceof ch.grailsgroup.Groupsession}">
							<g:render template="groupsession" model="${[post:post]}" />
						</g:if>
					</div>
				</g:each>
			</div>
	</body>
</html>
