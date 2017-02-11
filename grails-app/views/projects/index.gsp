<!doctype html>
<html>
	<head>
		<meta name="layout" content="main"/>
		<title>grailsgroup Switzerland: <g:message code="menu.projects"/></title>
	</head>
	<body>
	        <div class="hero-unit">
		        <h1>Projekte</h1>
		        <p>Die Mitglieder der grailsgroup Switzerland sind erfahrene grails Programmierer. Hier findest du einen Auszug aus Projekten und Produkten, welche von den Mitgliedern mit grails entwickelt wurden.</p>
	        </div>
			
			<div id="posts">
				<g:each in="${projects}" var="project">
				    <div class="row-fluid">
						<g:render template="project" model="[project:project]" />
					</div>
				</g:each>
			</div>
	</body>
</html>
