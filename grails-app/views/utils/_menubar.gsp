<div class="container">
	<div class="navbar">
	  <div class="navbar-inner">
	    <div class="container">
	      <button type="button" class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
	        <span class="icon-bar"></span>
	        <span class="icon-bar"></span>
	        <span class="icon-bar"></span>
	      </button>
	      <g:link controller="welcome" class="brand">
	          grails group switzerland
	      </g:link>
	      <div class="nav-collapse collapse">
	        <ul class="nav">
	          <li class="${controllerName=='welcome'?'active':'' }"><g:link controller="welcome"><g:message code="menu.home"/></g:link></li>
	          <li class="${controllerName=='projects'?'active':'' }"><g:link controller="projects"><g:message code="menu.projects"/></g:link></li>
	          <li class="${controllerName=='courses'?'active':'' }"><g:link controller="courses"><g:message code="menu.courses"/></g:link></li>
	          <li class="${controllerName=='about'?'active':'' }"><g:link controller="about"><g:message code="menu.aboutus"/></g:link></li>
	          <sec:ifLoggedIn>
			        <li><g:link controller="dashboard"><sec:loggedInUserInfo field="username"/></g:link></li> 
			        <li><g:link controller="logout" ><g:message code="default.logout"/></g:link></li>
			  </sec:ifLoggedIn>
	          <sec:ifNotLoggedIn>
	            <li><g:link controller="login" ><g:message code="default.login"/></g:link></li>
	          </sec:ifNotLoggedIn>
	        </ul>
	      </div><!--/.nav-collapse -->
	    </div>
	  </div>
	</div>
</div>